package br.com.opengti.biblioteca;

import org.apache.wicket.Page;
import org.apache.wicket.guice.GuiceComponentInjector;
import org.apache.wicket.protocol.http.WebApplication;

import br.com.opengti.biblioteca.page.pub.HomePage;

import com.google.inject.Injector;

/**
 * 
 * Classe reponsável pela inicialização da Aplicação.
 * 
 */
public class OpenBibliotecaApplication extends WebApplication {  
	       
	     private transient Injector injector;  
	       
	     public OpenBibliotecaApplication(Injector injector) {  
	      this.injector = injector;    
	     }  
	       
	     @Override  
	    protected void init() {    
	     addComponentInstantiationListener(new GuiceComponentInjector(this, injector));  
	    }  
	     
	    @Override  
	    public Class<? extends Page> getHomePage() {  
	     return HomePage.class;  
	    }  
	   }  
