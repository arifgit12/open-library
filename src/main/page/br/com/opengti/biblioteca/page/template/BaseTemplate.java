package br.com.opengti.biblioteca.page.template;

import javax.persistence.EntityManager;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;

import com.google.inject.Inject;
import com.google.inject.Provider;

public class BaseTemplate extends WebPage {

	private static final long serialVersionUID = 1L;

	@Inject
	private Provider<EntityManager> em;
	

    public BaseTemplate(final PageParameters parameters) {
     
      
       
    }

	public void setEm(Provider<EntityManager> em) {
		this.em = em;
	}


    

	

	
    
}
