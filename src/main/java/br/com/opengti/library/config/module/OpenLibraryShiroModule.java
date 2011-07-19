package br.com.opengti.library.config.module;

import lombok.extern.java.Log;

import org.apache.shiro.realm.Realm;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.mgt.WebSecurityManager;

import br.com.opengti.library.config.security.OpenLibraryCustomRealm;
import br.com.opengti.library.config.security.OpenLibraryShiroFilter;

import com.google.inject.Provides;
import com.google.inject.servlet.ServletModule;

@Log
public class OpenLibraryShiroModule extends ServletModule{

	@Override
	protected void configureServlets() {
		   bind(Realm.class).to(OpenLibraryCustomRealm.class);
		   
		   filter("/*").through(OpenLibraryShiroFilter.class);
		       
		    
		}
		
		@Provides
		public WebSecurityManager provideWebSecurityManager(Realm realm) {
			log.info("Realm: " + realm);
			return new DefaultWebSecurityManager(realm);
		}
		
	

	
	
	
}
