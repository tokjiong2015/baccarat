package du.tech.baccarat.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import du.tech.baccarat.dao.GenericDAO;

public class GenericDAOImpl<T> extends HibernateDaoSupport implements GenericDAO<T> {

	private String className;
	
	public GenericDAOImpl(String className)
	{
		this.className=className;
	}
	
	@Override
	public void save(T obj) 
	{
		this.getHibernateTemplate().save(obj);
	}

	@Override
	public void update(T obj) 
	{
		this.getHibernateTemplate().update(obj);
	}

	@Override
	public void delete(T obj) 
	{
		this.getHibernateTemplate().delete(obj);
	}

	@Override
	public T findById(Serializable id) {
		Class clazz = null;
		try {
			clazz=Class.forName(className);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (T) this.getHibernateTemplate().get(clazz, id);
	}

	@Override
	public List<T> findAll() {
		return this.getHibernateTemplate().find("from "+className);
	}

	@Override
	public List<T> findByNamedQuery(String queryName, Object... value) {
		return this.getHibernateTemplate().findByNamedQuery(queryName, value);
	}

	@Override
	public List<T> findByCriteria(DetachedCriteria detachedCriteria) {
		return this.getHibernateTemplate().findByCriteria(detachedCriteria,0,1);
	}

	@Override
	public List<T> getCurrContentForPagination(DetachedCriteria detachedCriteria, int min, int max) {
		return this.getHibernateTemplate().findByCriteria(detachedCriteria, min, max);
	}

	@Override
	public void saveOrUpdate(String entityName,T obj) {
		this.getHibernateTemplate().saveOrUpdate(entityName,obj);
	}

	@Override
	public void saveOrUpdate(T obj) {
		this.getHibernateTemplate().saveOrUpdate(obj);
	}

}
