package br.com.opengti.library.config.module;

import java.util.HashMap;
import java.util.Map;

import lombok.extern.java.Log;

import org.apache.wicket.protocol.http.WicketFilter;

import br.com.opengti.library.config.filter.WicketGuiceFilter;

import com.google.inject.servlet.ServletModule;

/**
 * Módulo para integração do Wicket com o Google Guice.
 * 
 * @author Rodrigo Mibielli.
 * 
 */
@Log
public class WicketModule extends ServletModule {

	protected void configureServlets() {

		// Wicket Config

		Map<String, String> params = new HashMap<String, String>();
		params.put(WicketFilter.FILTER_MAPPING_PARAM, "/*");
		filter("/*").through(WicketGuiceFilter.class, params);

	}

}
