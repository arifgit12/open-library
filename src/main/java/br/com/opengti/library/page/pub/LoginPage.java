package br.com.opengti.library.page.pub;

import javax.persistence.EntityManager;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.basic.Label;

import br.com.opengti.library.page.template.BaseTemplate;

import com.google.inject.Inject;
import com.google.inject.Provider;

public class LoginPage extends BaseTemplate {

	private static final long serialVersionUID = 1L;

	@Inject
	private Provider<EntityManager> em;
	

    public LoginPage(final PageParameters parameters) {
        super(parameters);

    }

	public void setEm(Provider<EntityManager> em) {
		this.em = em;
	}


    

	

	
    
}
