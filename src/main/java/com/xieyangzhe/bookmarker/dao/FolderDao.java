package com.xieyangzhe.bookmarker.dao;

import com.xieyangzhe.bookmarker.pojo.Folder;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Yangzhe Xie
 * @date 21/2/20
 */
@Mapper
public interface FolderDao {
    void insertFolder(Folder folder);

    List<Folder> selectFolderByUser(int userId);
}
