package com.mark.website.model;

import java.util.List;

/**
 * @author mark on 2017/3/8.
 */
public class PagedResult<T> {
    private List<T> list;
    private int pages;

    public PagedResult(){

    }

    public PagedResult(List<T> list, int pages){
        this.list = list;
        this.pages = pages;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
}
