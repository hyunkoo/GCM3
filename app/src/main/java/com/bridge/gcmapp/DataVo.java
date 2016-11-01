package com.bridge.gcmapp;

import java.io.Serializable;

/**
 * Created by sec on 2016-10-25.
 */
public class DataVo implements Serializable{

    private String title;
    private String contents;
    public  DataVo(){}
    public DataVo(String title, String contents) {
        super();
        this.title = title;
        this.contents = contents;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }
}
