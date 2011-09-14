package br.com.opengti.library.config.module;

import br.com.opengti.library.domain.repository.PersonRepository;
import br.com.opengti.library.domain.repository.impl.PersonRepositoryImpl;
import br.com.opengti.library.infra.dao.PersonDAO;
import br.com.opengti.library.infra.dao.impl.PersonDAOImpl;

import com.google.inject.persist.PersistFilter;
import com.google.inject.persist.jpa.JpaPersistModule;
import com.google.inject.servlet.ServletModule;


/**
 * 
 * Persistence Guice Module
 * @author Gabriel Cardelli
 *
 */
public class PersistenceModule extends ServletModule {
	
	public void configureServlets() {
		
		/*
		 * 
		 * JPA Config
		 * 
		 */
		
		 install(new JpaPersistModule("bibliotecaUnit"));	
		 filter("/*").through(PersistFilter.class);
		
		 /*
		  * 
		  * DAO Binding
		  * 
		  */
		 bind(PersonDAO.class).to(PersonDAOImpl.class);
		 
		 /*
		  * 
		  * Repository Binding
		  * 
		  */
		 bind(PersonRepository.class).to(PersonRepositoryImpl.class);
		 
		 
	};
	
}
