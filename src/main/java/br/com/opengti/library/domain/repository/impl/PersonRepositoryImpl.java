package br.com.opengti.library.domain.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import br.com.opengti.library.domain.entity.Person;
import br.com.opengti.library.domain.repository.PersonRepository;
import br.com.opengti.library.infra.dao.PersonDAO;

import com.google.inject.Inject;
import com.google.inject.Provider;

@Log4j
public class PersonRepositoryImpl implements PersonRepository{

	@Inject @Setter
	private PersonDAO personDAO;
	
	@Inject @Setter
	private Provider<EntityManager> entityManagerProvider;
	
	public void savePerson(Person person) {
		
		
	}
	
	public Person getPersonByEmailAndPassword(String email, String password){
		Query query = entityManagerProvider.get().createNamedQuery("getPersonByEmailAndPassword");
		query.setParameter(1, email);
		query.setParameter(2, password);
		
		return (Person) query.getSingleResult();
	}

}
