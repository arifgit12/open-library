package br.com.opengti.library.config.module;

import lombok.extern.java.Log;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.mgt.WebSecurityManager;
import org.apache.wicket.protocol.http.WebApplication;

import br.com.opengti.library.config.provider.OpenLibraryApplicationProvider;

import com.google.inject.Provides;
import com.google.inject.servlet.ServletModule;

@Log
public class OpenLibraryModule extends ServletModule{

	@Override
	protected void configureServlets() {
		
// Application Config
		
		bind(WebApplication.class).toProvider(OpenLibraryApplicationProvider.class);
		 
		
		install(new WicketModule());
		install(new ShiroModule());
		install(new PersistenceModule());
	}
	
	
	
	@Provides
	public WebSecurityManager provideWebSecurityManager(Realm realm) {
		log.info("Realm: " + realm);
		
		WebSecurityManager manager = new DefaultWebSecurityManager(realm);
		
		SecurityUtils.setSecurityManager(manager);
		log.info(manager.isHttpSessionMode() + "");
		
		return manager;
	}
	
}
