package br.com.opengti.library.domain.repository;

import br.com.opengti.library.domain.entity.Person;
import br.com.opengti.library.domain.repository.impl.PersonRepositoryImpl;

import com.google.inject.ImplementedBy;

@ImplementedBy(PersonRepositoryImpl.class)
public interface PersonRepository {

	
	public void savePerson(Person person);
	
	
}
