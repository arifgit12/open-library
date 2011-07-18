package br.com.opengti.library.config.module;

import java.util.HashMap;
import java.util.Map;

import lombok.extern.java.Log;

import org.apache.shiro.realm.Realm;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.mgt.WebSecurityManager;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.protocol.http.WicketFilter;

import br.com.opengti.library.config.filter.WicketGuiceFilter;
import br.com.opengti.library.config.provider.OpenLibraryApplicationProvider;
import br.com.opengti.library.config.security.OpenLibraryCustomRealm;
import br.com.opengti.library.config.security.OpenLibraryShiroFilter;

import com.google.inject.Provides;
import com.google.inject.persist.PersistFilter;
import com.google.inject.persist.jpa.JpaPersistModule;
import com.google.inject.servlet.ServletModule;

/**
 * Módulo para integração do Wicket com o Google Guice.
 * @author Rodrigo Mibielli.
 *
 */
@Log
public class OpenLibraryWicketModule extends ServletModule {

	protected void configureServlets() {
		
		// Application Config
		
		bind(WebApplication.class).toProvider(OpenLibraryApplicationProvider.class);
		 
		// Jpa Config
		
		 install(new JpaPersistModule("bibliotecaUnit"));	
		 filter("/*").through(PersistFilter.class);
		 
		 
		// Wicket Config
		
		Map<String, String> params = new HashMap<String, String>();    
		params.put(WicketFilter.FILTER_MAPPING_PARAM, "/*");  
	    filter("/*").through(WicketGuiceFilter.class, params);  	
	    
	    
	    // Shiro Config
      
	    bind(Realm.class).to(OpenLibraryCustomRealm.class);
	    filter("/*").through(OpenLibraryShiroFilter.class);
	    
	    
	}
	
	@Provides
	public WebSecurityManager provideWebSecurityManager(Realm realm) {
		log.info("Realm: " + realm);
		return new DefaultWebSecurityManager(realm);
	}

}
