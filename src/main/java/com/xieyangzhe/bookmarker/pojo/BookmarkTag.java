package com.xieyangzhe.bookmarker.pojo;

/**
 * table name:  bookmark_tag
 * author name: joseph
 * create time: 2019/12/15 21:30:51
 */
public class BookmarkTag {

    private int btId;
    private int bookmarkId;
    private int tagId;

    public int getBtId() {
        return btId;
    }

    public void setBtId(int btId) {
        this.btId = btId;
    }

    public int getBookmarkId() {
        return bookmarkId;
    }

    public void setBookmarkId(int bookmarkId) {
        this.bookmarkId = bookmarkId;
    }

    public int getTagId() {
        return tagId;
    }

    public void setTagId(int tagId) {
        this.tagId = tagId;
    }
}

