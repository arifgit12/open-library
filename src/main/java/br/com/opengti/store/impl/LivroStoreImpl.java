package br.com.opengti.store.impl;

import java.util.List;
import java.util.Map;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import br.com.opengti.domain.Livro;
import br.com.opengti.store.LivroStore;

/**
 * 
 * @author Gabriel Cardelli
 * @since  Jun 30, 2011 3:58:08 PM 
 *
 */
public class LivroStoreImpl extends HibernateDaoSupport implements LivroStore{


	public void persist(Livro t) {
		// TODO Auto-generated method stub
		
	}

	public Livro get(Object primaryKey) {
		// TODO Auto-generated method stub
		return null;
	}


	public Livro get(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Livro> list() {
		return getSession().createCriteria(Livro.class).list();
	}


	public List<Livro> list(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return null;
	}


	public Livro merge(Livro t) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
