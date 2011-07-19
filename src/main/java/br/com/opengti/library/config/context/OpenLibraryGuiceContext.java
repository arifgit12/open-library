package br.com.opengti.library.config.context;


import br.com.opengti.library.config.module.OpenLibraryShiroModule;
import br.com.opengti.library.config.module.OpenLibraryWicketModule;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;

/**
 * 
 * Classe Reponsável pela inicialização dos módulos do Google Guice
 *
 */
public class OpenLibraryGuiceContext extends GuiceServletContextListener{

	@Override
	protected Injector getInjector() {
		return Guice.createInjector(new OpenLibraryWicketModule());
	}

}
