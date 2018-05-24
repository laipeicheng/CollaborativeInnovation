package com.zhc.core.dao.impl;

import com.zhc.core.dao.BaseDao;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

@Repository("baseDao")
public class BaseDaoImpl<T> implements BaseDao<T> {

    public Logger log = LoggerFactory.getLogger("MainLogger");

    @Autowired
    @Qualifier("hibernateTemplate")
    public HibernateTemplate hibernateTemplate;

    @Override
    @Transactional(readOnly = true)
    public List<T> list(Class<T> cls) {
        String hql = "from " + cls.getSimpleName();
        return (List<T>) hibernateTemplate.find(hql);
    }

    @Override
    @Transactional
    public void delete(T entity) {
        hibernateTemplate.delete(entity);
    }

    @Override
    @Transactional
    public void saveOrUpdate(T entity) {
        hibernateTemplate.saveOrUpdate(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public T get(Class<T> cls, Serializable id) {
        return hibernateTemplate.get(cls, id);
    }

    @Override
    @Transactional(readOnly = true)
    public T load(Class<T> cls, Serializable id) {
        return hibernateTemplate.load(cls, id);
    }


    @Override
    @Transactional(readOnly = true)
    public List<T> findByPage(final String hql, final int page, final int pageSize, final Object... args) {

        return hibernateTemplate.execute(new HibernateCallback<List<T>>() {

            @Override
            public List<T> doInHibernate(Session session) throws HibernateException {
                Query<T> query = session.createQuery(hql);
                for (int i = 0; i < args.length; i++) {
                    query.setParameter(i, args[i]);
                }
                query.setFirstResult(page * pageSize);
                query.setMaxResults(pageSize);
                return query.list();
            }
        });
    }

    @Override
    @Transactional(readOnly = true)
    public int getPages(Class<T> cls, int pageSize) {
        String hql = "select count(*) from " + cls.getSimpleName();
        Iterator iterator = hibernateTemplate.find(hql).listIterator();
        long count = 0;
        if (iterator.hasNext()) {
            count = (Long) iterator.next();
        }
        int pages = (int) count / pageSize;
        if (count % pageSize != 0) {
            pages++;
        }
        return pages;
    }

    @Override
    @Transactional(readOnly = true)
    public List<T> listTop(Class<T> cls, int top){
        String hql = "from "+cls.getSimpleName();
        return findByPage(hql, 0, top);
    }
}
