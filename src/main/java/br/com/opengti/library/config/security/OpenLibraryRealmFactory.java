package br.com.opengti.library.config.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import lombok.extern.java.Log;

import org.apache.shiro.realm.Realm;
import org.apache.shiro.realm.RealmFactory;

import br.com.opengti.library.config.module.ShiroSecurityModule;

import com.google.inject.Guice;
import com.google.inject.Injector;

@Log
public class OpenLibraryRealmFactory  implements RealmFactory  {

	public Collection<Realm> getRealms() {
		log.info("Iniciando Método");
		List<Realm> realms = new ArrayList<Realm>();
		
		Injector injector = Guice.createInjector(ShiroSecurityModule.guiceFilterModule());
		
		OpenLibraryCustomRealm realm = injector.getInstance( OpenLibraryCustomRealm.class );
		
		realms.add( realm );
		log.info("Retornando Realms");
		return realms;
	}

}
