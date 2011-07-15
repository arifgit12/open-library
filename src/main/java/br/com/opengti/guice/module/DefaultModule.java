package br.com.opengti.guice.module;

import br.com.opengti.service.CursoService;
import br.com.opengti.service.LivroService;
import br.com.opengti.service.PessoaService;
import br.com.opengti.service.impl.CursoServiceImpl;
import br.com.opengti.service.impl.LivroServiceImpl;
import br.com.opengti.service.impl.PessoaServiceImpl;
import br.com.opengti.store.CursoStore;
import br.com.opengti.store.LivroStore;
import br.com.opengti.store.PessoaStore;
import br.com.opengti.store.impl.CursoStoreImpl;
import br.com.opengti.store.impl.LivroStoreImpl;
import br.com.opengti.store.impl.PessoaStoreImpl;

import com.google.inject.Singleton;
import com.google.inject.persist.PersistFilter;
import com.google.inject.persist.jpa.JpaPersistModule;
import com.google.inject.servlet.ServletModule;

public class DefaultModule extends ServletModule {

protected void configureServlets() {
	
	install(new JpaPersistModule("openBibliotecaUnit"));
	
	filter("/*").through(PersistFilter.class);
	
	/*
	 * Store
	 */
	bind(LivroStore.class).to(LivroStoreImpl.class).in(Singleton.class);
	bind(CursoStore.class).to(CursoStoreImpl.class).in(Singleton.class);
	bind(PessoaStore.class).to(PessoaStoreImpl.class).in(Singleton.class);
	
	/*
	 * Services
	 */
	
	bind(LivroService.class).to(LivroServiceImpl.class).in(Singleton.class);
	bind(CursoService.class).to(CursoServiceImpl.class).in(Singleton.class);
	bind(PessoaService.class).to(PessoaServiceImpl.class).in(Singleton.class);
	
};
		
		
		
	

}
