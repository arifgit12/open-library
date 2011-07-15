package br.com.opengti.store.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import br.com.opengti.domain.Curso;
import br.com.opengti.store.CursoStore;

/**
 * 
 * @author Gabriel Cardelli
 * @since  Jun 30, 2011 3:58:21 PM 
 *
 */
public class CursoStoreImpl extends HibernateDaoSupport implements CursoStore {

	
	public List<Curso> list() {
		Criteria c = getSession().createCriteria(Curso.class);
		return c.list();
	}
	
	public Curso getCurso(String nome){
		Criteria c = getSession().createCriteria(Curso.class);
		c.add(Restrictions.eq("nome", nome));
		return (Curso) c.uniqueResult();
	}
	

	public void persist(Curso t) {
		// TODO Auto-generated method stub
		
	}


	public Curso get(Object primaryKey) {
		// TODO Auto-generated method stub
		return null;
	}


	public Curso get(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Curso> list(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return null;
	}


	public Curso merge(Curso t) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
