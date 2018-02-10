package com.project.xxx.core.dao;

import java.util.List;

import com.project.xxx.core.models.Publish;

public interface PublishMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Publish record);

    int insertSelective(Publish record);

    Publish selectByPrimaryKey(Integer id);
    
    List<Publish> selectAllData();

    int updateByPrimaryKeySelective(Publish record);

    int updateByPrimaryKey(Publish record);
}