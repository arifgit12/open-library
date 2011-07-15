package br.com.opengti.store;

import java.util.List;
import java.util.Map;

import javax.persistence.NonUniqueResultException;

import org.hibernate.HibernateException;

/**
 * 
 * @author Gabriel Cardelli
 * @since  Jun 30, 2011 3:33:39 PM 
 *
 */
public interface Store<T> {

	/**
	 * 
	 * @param t
	 */
	public void persist(T t);
	
	/**
	 * 
	 * @param primaryKey
	 * @return
	 */
	public T get (Object primaryKey);
	
	/**
	 * 
	 * @param params
	 * @return
	 */
	public T get (Map<String,Object> params);
	
	/**
	 * 
	 * @return
	 */
	public List<T> list();
	
	/**
	 * 
	 * @param params
	 * @return
	 */
	public List<T> list(Map<String,Object> params);
	
	/**
	 * 
	 * @param t
	 * @return
	 */
	public T merge(T t);
	
}
