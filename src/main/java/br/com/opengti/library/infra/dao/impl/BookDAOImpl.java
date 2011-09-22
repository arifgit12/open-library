package br.com.opengti.library.infra.dao.impl;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

import br.com.opengti.library.domain.entity.Book;
import br.com.opengti.library.domain.entity.Person;
import br.com.opengti.library.infra.dao.BookDAO;
import br.com.opengti.library.infra.dao.PersonDAO;

import com.google.inject.Inject;
import com.google.inject.Provider;

@Log4j
public class BookDAOImpl implements BookDAO{

	@Inject @Getter @Setter
	private Provider<EntityManager> entityManagerProvider;
	
	public void save(Book t) {
		entityManagerProvider.get().persist(t);
		
	}

	public Book getObject(Map<String, Object> params) {
		
		return null;
	}

	public List<Book> getList(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return null;
	}

	public Book merge(Book t) {
		return entityManagerProvider.get().merge(t);
	}

	public List<Book> getList(){
		Query query = entityManagerProvider.get().createNamedQuery("getListBooks");
		return (List<Book>) query.getResultList();
	}
	
	
	
}
