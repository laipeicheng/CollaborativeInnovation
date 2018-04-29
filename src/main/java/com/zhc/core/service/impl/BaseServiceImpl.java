package com.zhc.core.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.zhc.core.dao.BaseDao;
import com.zhc.core.service.BaseService;

@Service("baseService")
public class BaseServiceImpl<T> implements BaseService<T> {
	
	@Autowired
	@Qualifier("baseDao")
	private BaseDao<T> baseDao;

	public List<T> list(Class<T> cls) {
		return baseDao.list(cls);
	}

	public void delete(T entity) {
		baseDao.delete(entity);
	}

	public void saveOrUpdate(T entity) {
		baseDao.saveOrUpdate(entity);
	}

	public T get(Class<T> cls, Serializable id) {
		return baseDao.get(cls, id);
	}

}
