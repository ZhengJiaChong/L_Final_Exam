package com.example.hp.l_final_exam1.bean;

/**
 * Created by HP on 2018/6/12.
 */

public class Video {
    private int id;
    private String name,url,videoThumbUrl;
    public Video(int id, String name, String url,String videoThumbUrl) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.videoThumbUrl=videoThumbUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getVideoThumbUrl() {
        return videoThumbUrl;
    }

    public void setVideoThumbUrl(String videoThumbUrl) {
        this.videoThumbUrl = videoThumbUrl;
    }

    @Override
    public String toString() {
        return "Video{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", videoThumbUrl='" + videoThumbUrl + '\'' +
                '}';
    }
}
