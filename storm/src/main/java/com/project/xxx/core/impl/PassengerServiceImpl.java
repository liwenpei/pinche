package com.project.xxx.core.impl; 
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.project.xxx.core.IPassengerService;
import com.project.xxx.core.dao.PassengerMapper;
import com.project.xxx.core.models.Passenger;  
  
@Service("passengerService")
@Component
public class PassengerServiceImpl implements IPassengerService {  
    @Resource  
    private PassengerMapper passengerMapper;

	public List<Passenger> selectAllData() {
		return this.passengerMapper.selectAllData();
	}  
} 