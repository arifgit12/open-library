package br.com.opengti.library.config.module;

import lombok.extern.java.Log;

import org.apache.wicket.protocol.http.WebApplication;

import br.com.opengti.library.config.provider.OpenLibraryApplicationProvider;

import com.google.inject.servlet.ServletModule;

@Log
public class ApplicationModule extends ServletModule{

	@Override
	protected void configureServlets() {
		
// Application Config
		
		bind(WebApplication.class).toProvider(OpenLibraryApplicationProvider.class);

	}
	
}
