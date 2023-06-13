package com.jumpserver.sdk.httpclient.response;

import com.jumpserver.sdk.common.ActionResponse;
import com.jumpserver.sdk.exceptions.ClientResponseException;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/***
 * 对各类状态码进行处理
 * */
public class HttpEntityHandler {

    private static final Logger LOG = LoggerFactory.getLogger(HttpEntityHandler.class);

    @SuppressWarnings("unchecked")
    public static <T> List<T> handleList(HttpResponse response, Class<T> returnType) {
        try {
            if (response.getStatus() >= 400) {
                throw new ClientResponseException(response.getStatusMessage());
            }
            return response.readEntityList(returnType);
        } finally {
            closeQuietly(response);
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> T handle(HttpResponse response, Class<T> returnType) {
        try {
            String text = "";
            if (response.getStatus() >= 400) {
                try {
                    InputStream inputStream = response.getInputStream();
                    text = IOUtils.toString(inputStream, "UTF-8");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                throw new ClientResponseException(response.getStatusMessage() + " " + text);
            }
            if (returnType == Void.class) {
                return null;
            }

            if (returnType == ActionResponse.class) {
                return (T) ActionResponse.actionSuccess(response.getStatus());
            }
            return response.readEntity(returnType);
        } finally {
            closeQuietly(response);
        }
    }

    public static void closeQuietly(HttpResponse response) {
        try {
            response.close();
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
        }
    }

}
