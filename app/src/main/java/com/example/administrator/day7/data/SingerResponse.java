package com.example.administrator.day7.data;

import java.util.List;

public class SingerResponse extends MyResponse {
    List<Singer> list;

    public SingerResponse(List<Singer> list) {
        super();
        this.list = list;
    }

    public SingerResponse() {
        super();
    }

    public List<Singer> getList() {
        return list;
    }

    public void setList(List<Singer> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "SingerResponse [list=" + list + "]";
    }
}
