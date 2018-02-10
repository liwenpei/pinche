package com.project.xxx.core.dao;

import java.util.List;

import com.project.xxx.core.models.Passenger;

public interface PassengerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Passenger record);

    int insertSelective(Passenger record);

    Passenger selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Passenger record);

    int updateByPrimaryKey(Passenger record);
    
    List<Passenger> selectAllData();
}