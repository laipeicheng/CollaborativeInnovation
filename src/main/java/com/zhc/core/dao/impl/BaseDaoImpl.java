package com.zhc.core.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.zhc.core.dao.BaseDao;

@Repository("baseDao")
public class BaseDaoImpl<T> implements BaseDao<T> {
	
	@Autowired
	@Qualifier("hibernateTemplate")
	public HibernateTemplate hibernateTemplate;

	@Override
	@Transactional(readOnly=true)
	public List<T> list(Class<T> cls) {
		String hql = "from "+cls.getSimpleName();
		return (List<T>) hibernateTemplate.find(hql);
	}

	@Override
	@Transactional(readOnly=false)
	public void delete(T entity) {
		hibernateTemplate.delete(entity);
	}

	@Override
	@Transactional(readOnly=false)
	public void saveOrUpdate(T entity) {
		hibernateTemplate.saveOrUpdate(entity);
	}

	@Override
	@Transactional(readOnly=true)
	public T get(Class<T> cls, Serializable id) {
		return hibernateTemplate.get(cls, id);
	}

	@Override
	@Transactional(readOnly=true)
	public T load(Class<T> cls, Serializable id) {
		return hibernateTemplate.load(cls, id);
	}

}
