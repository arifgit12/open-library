package br.com.opengti.library.infra.dao;

import java.util.List;
import java.util.Map;

public interface GenericDAO<T> {

	public void save(T t);
	
	public T getObject (Map<String,Object> params);
	
	public List<T> getList(Map<String,Object> params);
	
	public T merge (T t);
	
}
