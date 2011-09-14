package br.com.opengti.library.config.module;

import java.util.HashMap;
import java.util.Map;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;

import org.apache.wicket.protocol.http.WicketFilter;

import br.com.opengti.library.config.filter.WicketGuiceFilter;

import com.google.inject.servlet.ServletModule;

/**
 * Módulo para integração do Wicket com o Google Guice.
 * 
 * @author Rodrigo Mibielli.
 * 
 */
@Log4j
public class WicketModule extends ServletModule {

	protected void configureServlets() {

		Map<String, String> params = new HashMap<String, String>();
		params.put(WicketFilter.FILTER_MAPPING_PARAM, "/*");
		filter("/*").through(WicketGuiceFilter.class, params);

	}

}
