package br.com.opengti.library.config.provider;

import org.apache.wicket.protocol.http.WebApplication;

import br.com.opengti.library.OpenLibraryApplication;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Provider;

/**
 * 
 * Classe responsável pela integração do Wicket com Guice
 * - Nesta classe deixamos o guice tomar conta da instaciação do Wicket WebApplication
 * @author Gabriel Cardelli
 *
 */
public class OpenLibraryApplicationProvider implements Provider<WebApplication> {
	 
	 private final Injector injector;

	 @Inject
	 public OpenLibraryApplicationProvider(Injector injector) {
	  this.injector = injector;  
	 }
	 
	 public WebApplication get() {
	  OpenLibraryApplication app = new OpenLibraryApplication(injector);  
	  return app;
	 }
	}
