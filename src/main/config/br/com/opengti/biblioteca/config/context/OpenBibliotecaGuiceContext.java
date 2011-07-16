package br.com.opengti.biblioteca.config.context;


import br.com.opengti.biblioteca.config.module.OpenBibliotecaWicketModule;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;

/**
 * 
 * Classe Reponsável pela inicialização dos módulos do Google Guice
 *
 */
public class OpenBibliotecaGuiceContext extends GuiceServletContextListener{

	@Override
	protected Injector getInjector() {
		return Guice.createInjector(new OpenBibliotecaWicketModule());
	}

}
