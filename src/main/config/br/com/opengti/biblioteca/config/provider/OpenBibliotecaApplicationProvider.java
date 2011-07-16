package br.com.opengti.biblioteca.config.provider;

import org.apache.wicket.protocol.http.WebApplication;

import br.com.opengti.biblioteca.OpenBibliotecaApplication;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Provider;

public class OpenBibliotecaApplicationProvider implements Provider<WebApplication> {
	 
	 private final Injector injector;

	 @Inject
	 public OpenBibliotecaApplicationProvider(Injector injector) {
	  this.injector = injector;  
	 }
	 
	 public WebApplication get() {
	  OpenBibliotecaApplication app = new OpenBibliotecaApplication(injector);  
	  return app;
	 }
	}
