package br.com.opengti.library.config.module;

import java.util.HashMap;
import java.util.Map;

import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.protocol.http.WicketFilter;


import br.com.opengti.library.config.filter.WicketGuiceFilter;
import br.com.opengti.library.config.provider.OpenBibliotecaApplicationProvider;

import com.google.inject.persist.PersistFilter;
import com.google.inject.persist.jpa.JpaPersistModule;
import com.google.inject.servlet.ServletModule;

/**
 * Módulo para integração do Wicket com o Google Guice.
 * @author Rodrigo Mibielli.
 *
 */
public class OpenBibliotecaWicketModule extends ServletModule {

	/**
	 * @see com.google.inject.servlet.ServletModule#configureServlets()
	 */
	@Override
	protected void configureServlets() {
		 bind(WebApplication.class).toProvider(OpenBibliotecaApplicationProvider.class);
		 
		 install(new JpaPersistModule("bibliotecaUnit"));	
		 filter("/*").through(PersistFilter.class);
		 
		 
		// Integracao com wicket:
		
		Map<String, String> params = new HashMap<String, String>();    
		params.put(WicketFilter.FILTER_MAPPING_PARAM, "/*");  
	    filter("/*").through(WicketGuiceFilter.class, params);  		
	}

}
