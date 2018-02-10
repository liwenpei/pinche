package com.project.xxx.core.impl; 
import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.project.xxx.core.IManagerService;
import com.project.xxx.core.dao.ManagerMapper;
import com.project.xxx.core.models.Manager;
import com.project.xxx.core.models.Passenger;  
  
@Service("managerService")
@Component
public class ManagerServiceImpl implements IManagerService {  
    @Resource  
    private ManagerMapper managerMapper;

	public Manager getManager(String userName, String password) {
		Manager manager = new Manager();
		manager.setUserName(userName);
		manager.setPassword(password);
		return this.managerMapper.selectByBeanKey(manager);
	}  
} 