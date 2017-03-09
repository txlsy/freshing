package com.mark.website.model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author mark on 2017/3/3.
 */
public class Flow {

    private int id;
    private String title;//物品标题
    private String url;//物品链接，如淘宝链接
    private String image;//物品缩略图
    private Date date;//登记时间

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
