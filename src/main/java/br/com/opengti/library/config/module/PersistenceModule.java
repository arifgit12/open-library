package br.com.opengti.library.config.module;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
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
@Log4j
public class PersistenceModule extends ServletModule {
	
	public void configureServlets() {
		
		 // JPA Config
		
		 install(new JpaPersistModule("bibliotecaUnit"));	
		 
		 filter("/*").through(PersistFilter.class);
		
		 // DAO Binding

		 bind(PersonDAO.class).to(PersonDAOImpl.class);
		 
		  // Repository Binding

		 bind(PersonRepository.class).to(PersonRepositoryImpl.class);
		 
		 
	};
	
}
