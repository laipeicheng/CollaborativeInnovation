package com.zhc.core.service;

import java.io.Serializable;
import java.util.List;

public interface BaseService<T> {
	List<T> list(Class<T> cls);
	void delete(T entity);
	void saveOrUpdate(T entity);
	T get(Class<T> cls, Serializable id);
}
