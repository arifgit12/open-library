package br.com.opengti.library.config.provider;

import lombok.extern.log4j.Log4j;

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
@Log4j
public class ApplicationProvider implements Provider<WebApplication> {
	 
	 private final Injector injector;

	 @Inject
	 public ApplicationProvider(Injector injector) {
	  this.injector = injector;  
	 }
	 
	 public WebApplication get() {
	  OpenLibraryApplication app = new OpenLibraryApplication(injector);  
	  return app;
	 }
	}
