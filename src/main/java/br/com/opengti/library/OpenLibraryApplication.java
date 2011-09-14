package br.com.opengti.library;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;

import org.apache.wicket.Page;
import org.apache.wicket.guice.GuiceComponentInjector;
import org.apache.wicket.protocol.http.WebApplication;

import br.com.opengti.library.view.page.pub.HomePage;

import com.google.inject.Injector;

/**
 * 
 * Classe Responsável pela inicialização da aplicação
 * 
 * @author Gabriel Cardelli
 * 
 */
@Log4j
public class OpenLibraryApplication extends WebApplication {

	private transient Injector injector;

	public OpenLibraryApplication(Injector injector) {
		this.injector = injector;
	}

	@Override
	protected void init() {
		addComponentInstantiationListener(new GuiceComponentInjector(this,
				injector));
	}

	@Override
	public Class<? extends Page> getHomePage() {
		return HomePage.class;
	}
	
}
