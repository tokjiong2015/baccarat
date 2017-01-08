package du.tech.baccarat.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

public interface GenericDAO<T> {
	
	public void save(T obj);
	
	public void update(T obj);
	
	public void delete(T obj);
	
	public T findById(Serializable id);
	
	public List<T> findAll();
	
	public List<T> findByNamedQuery(String queryName, Object...value);
	
	public List<T> findByCriteria(DetachedCriteria detachedCriteria);
	
}
