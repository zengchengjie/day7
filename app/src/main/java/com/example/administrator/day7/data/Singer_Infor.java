package com.example.administrator.day7.data;

/**
 * Created by Administrator on 2016/7/10.
 */
public class Singer_Infor {
    int id;
    String song_name;
    String song_icon_url;
    String song_url;

    public Singer_Infor(String song_name, String song_icon_url, String song_url) {
        super();
//        this.song_name = song_neme;
        this.song_name = song_name;
        this.song_icon_url = song_icon_url;
        this.song_url = song_url;
    }

    public int getId() {
        return id;
    }

    public String getSong_neme() {
        return song_name;
    }

    public String getSong_icon_url() {
        return song_icon_url;
    }

    public String getSong_url() {
        return song_url;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setSong_neme(String song_name) {
        this.song_name = song_name;
    }

    public void setSong_icon_url(String song_icon_url) {
        this.song_icon_url = song_icon_url;
    }

    public void setSong_url(String song_url) {
        this.song_url = song_url;
    }

    @Override
    public String toString() {
        return "Singer [id=" + id + ", song_neme=" + song_name + ", song_icon_url="
                + song_icon_url + ", song_url=" + song_url + "]";
    }
}
