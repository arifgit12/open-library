package br.com.opengti.library.config.module;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;

import org.apache.wicket.protocol.http.WebApplication;

import br.com.opengti.library.config.provider.ApplicationProvider;

import com.google.inject.servlet.ServletModule;

/**
 * 
 * Application Guice Module
 * @author Gabriel Cardelli
 *
 */
@Log4j
public class ApplicationModule extends ServletModule{

	@Override
	protected void configureServlets() {
		
		bind(WebApplication.class).toProvider(ApplicationProvider.class);

	}
	
}
