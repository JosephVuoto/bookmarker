package com.xieyangzhe.bookmarker.pojo;

/**
 * table name:  tag
 * author name: joseph
 * create time: 2019/12/15 21:30:50
 */
public class Tag {

    private int tagId;
    private String name;
    private int user;

    public int getTagId() {
        return tagId;
    }

    public void setTagId(int tagId) {
        this.tagId = tagId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }
}

