package com.project.xxx.core.dao;

import com.project.xxx.core.models.Manager;

public interface ManagerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Manager record);

    int insertSelective(Manager record);

    Manager selectByPrimaryKey(Integer id);
    
    Manager selectByBeanKey(Manager manager);

    int updateByPrimaryKeySelective(Manager record);

    int updateByPrimaryKey(Manager record);
}