package br.com.opengti.library.infra.dao.impl;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import br.com.opengti.library.domain.entity.Person;
import br.com.opengti.library.infra.dao.PersonDAO;

import com.google.inject.Provider;

public class PersonDAOImpl implements PersonDAO{

	private Provider<EntityManager> entityManagerProvider;
	
	public void save(Person t) {
		entityManagerProvider.get().persist(t);
		
	}

	public Person getObject(Map<String, Object> params) {
		
		return null;
	}

	public List<Person> getList(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return null;
	}

	public Person merge(Person t) {
		return entityManagerProvider.get().merge(t);
		
	}

	
	
	
}
