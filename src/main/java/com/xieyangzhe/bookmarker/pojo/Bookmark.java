package com.xieyangzhe.bookmarker.pojo;

import java.util.Date;

/**
 * table name:  bookmark
 * author name: joseph
 * create time: 2019/12/15 21:30:51
 */
public class Bookmark {

    private int bookmarkId;
    private String url;
    private String title;
    private String comment;
    private Date time;
    private int user;
    private Folder location;

    public int getBookmarkId() {
        return bookmarkId;
    }

    public void setBookmarkId(int bookmarkId) {
        this.bookmarkId = bookmarkId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public Folder getLocation() {
        return location;
    }

    public void setLocation(Folder location) {
        this.location = location;
    }
}

