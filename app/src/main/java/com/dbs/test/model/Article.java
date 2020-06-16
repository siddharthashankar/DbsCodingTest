package com.dbs.test.model;

public class Article {
    private int id;
    private String title;
    private Integer last_update;
    private String short_description;
    private String avatar;

    public Article(int id, String title, Integer last_update, String short_description, String avatar) {
        this.id = id;
        this.title = title;
        this.last_update = last_update;
        this.short_description = short_description;
        this.avatar = avatar;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getLast_update() {
        return last_update;
    }

    public void setLast_update(Integer last_update) {
        this.last_update = last_update;
    }

    public String getShort_description() {
        return short_description;
    }

    public void setShort_description(String short_description) {
        this.short_description = short_description;
    }

    public String getAvatar() {
        return avatar;
    }
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

}
