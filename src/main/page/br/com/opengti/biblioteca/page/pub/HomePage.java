package br.com.opengti.biblioteca.page.pub;

import javax.persistence.EntityManager;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.basic.Label;

import br.com.opengti.biblioteca.page.template.BaseTemplate;

import com.google.inject.Inject;
import com.google.inject.Provider;

public class HomePage extends BaseTemplate {

	private static final long serialVersionUID = 1L;

	@Inject
	private Provider<EntityManager> em;
	

    public HomePage(final PageParameters parameters) {
        super(parameters);

    }

	public void setEm(Provider<EntityManager> em) {
		this.em = em;
	}


    

	

	
    
}
