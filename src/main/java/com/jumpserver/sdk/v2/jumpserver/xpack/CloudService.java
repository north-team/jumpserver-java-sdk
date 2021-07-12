package com.jumpserver.sdk.v2.jumpserver.xpack;

import com.jumpserver.sdk.v2.model.CloudInstance;
import com.jumpserver.sdk.v2.model.SyncInstanceTask;

import java.util.List;

public interface CloudService {
    /**
     * 获取同步任务列表
     * @return
     */
    List<SyncInstanceTask> cloudInstanceTasks();

    List<CloudInstance> instances(String taskId);
}
