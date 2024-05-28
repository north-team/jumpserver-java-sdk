package com.jumpserver.sdk.model.account;

import java.util.List;

/**
 * @author liuhaohao
 */
public class PageResponse {

    private int count;

    private String next;

    private String previous;

    private List<AssetAccount> results;

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

    public List<AssetAccount> getResults() {
        return results;
    }

    public void setResults(List<AssetAccount> results) {
        this.results = results;
    }
}
