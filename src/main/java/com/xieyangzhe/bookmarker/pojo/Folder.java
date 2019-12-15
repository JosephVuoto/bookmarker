package com.xieyangzhe.bookmarker.pojo;

/**
 * table name:  folder
 * author name: joseph
 * create time: 2019/12/15 21:30:50
 */
public class Folder {

    private int folderId;
    private String name;
    private int parent;
    private int user;

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

    public int getParent() {
        return parent;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }
}

