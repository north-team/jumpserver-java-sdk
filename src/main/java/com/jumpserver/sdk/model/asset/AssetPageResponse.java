package com.jumpserver.sdk.model.asset;

import com.jumpserver.sdk.model.asset.v3.Asset;

import java.util.List;

public class AssetPageResponse {

    private int count;

    private String next;

    private String previous;

    private List<Asset> results;

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

    public List<Asset> getResults() {
        return results;
    }

    public void setResults(List<Asset> results) {
        this.results = results;
    }
}
