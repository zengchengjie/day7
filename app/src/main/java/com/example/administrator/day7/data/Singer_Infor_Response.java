package com.example.administrator.day7.data;

import java.util.List;

/**
 * Created by Administrator on 2016/7/10.
 */
public class Singer_Infor_Response extends MyResponse {
    List<Singer_Infor> list;

    public Singer_Infor_Response(List<Singer_Infor> list) {
        super();
        this.list = list;
    }

    public Singer_Infor_Response() {
        super();
    }

    public List<Singer_Infor> getList() {
        return list;
    }

    public void setList(List<Singer_Infor> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Singer_Infor_Response [list=" + list + "]";
    }
}
