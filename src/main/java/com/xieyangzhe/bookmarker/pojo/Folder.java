package com.xieyangzhe.bookmarker.pojo;

import com.google.gson.Gson;

/**
 * table name:  folder
 * author name: joseph
 * create time: 2019/12/15 21:30:50
 */
public class Folder {

    private int folderId;
    private String name;
    private int user;
    private String path;

    public int getFolderId() {
        return folderId;
    }

    public void setFolderId(int folderId) {
        this.folderId = folderId;
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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}

