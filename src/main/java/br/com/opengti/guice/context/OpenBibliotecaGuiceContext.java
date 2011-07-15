package br.com.opengti.guice.context;

import br.com.opengti.guice.module.DefaultModule;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;

public class OpenBibliotecaGuiceContext extends GuiceServletContextListener  {
	  @Override
	  protected Injector getInjector() {
	    return Guice.createInjector(new DefaultModule());
	  }
}


	
	