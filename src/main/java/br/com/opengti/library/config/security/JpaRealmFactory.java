package br.com.opengti.library.config.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;

import org.apache.shiro.realm.Realm;
import org.apache.shiro.realm.RealmFactory;

import br.com.opengti.library.config.module.ShiroSecurityModule;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * 
 * @author Gabriel Cardelli
 *
 */
@Log4j
public class JpaRealmFactory  implements RealmFactory  {

	public Collection<Realm> getRealms() {
	
		List<Realm> realms = new ArrayList<Realm>();
		Injector injector = Guice.createInjector(ShiroSecurityModule.guiceFilterModule());
		JpaRealm realm = injector.getInstance( JpaRealm.class );	
		realms.add( realm );
		return realms;
		
	}

}
