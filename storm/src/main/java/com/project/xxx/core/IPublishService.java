package com.project.xxx.core;

import java.util.List;

import com.project.xxx.core.models.Publish;

public interface IPublishService {
	public List<Publish> selectAllData();

	public Publish selectByPrimaryKey(Integer id);
}
