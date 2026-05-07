package com.jumpserver.sdk.model.permission.v3;

import java.util.List;

/**
 * @author liuhaohao
 */
public class AssetsPermissionPageResponse {

    private int count;

    private String next;

    private String previous;

    private List<AssetsPermission> results;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public List<AssetsPermission> getResults() {
        return results;
    }

    public void setResults(List<AssetsPermission> results) {
        this.results = results;
    }
}
