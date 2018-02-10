package com.project.xxx.core.impl; 
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.project.xxx.core.IPublishService;
import com.project.xxx.core.dao.PublishMapper;
import com.project.xxx.core.models.Publish;  
  
@Service("publishService")
@Component
public class PublishServiceImpl implements IPublishService {  
    @Resource  
    private PublishMapper publishMapper;

	public List<Publish> selectAllData() {
		return this.publishMapper.selectAllData();
	}
	
	public Publish selectByPrimaryKey(Integer id) {
		return this.publishMapper.selectByPrimaryKey(id);
	}
} 