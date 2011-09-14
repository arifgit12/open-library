  package br.com.opengti.library.view.page.pub;

import javax.persistence.EntityManager;

import lombok.extern.log4j.Log4j;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.basic.Label;

import br.com.opengti.library.view.page.template.DefaultTemplate;

import com.google.inject.Inject;
import com.google.inject.Provider;

@Log4j
public class HomePage extends DefaultTemplate {

	private static final long serialVersionUID = 1L;

	@Inject
	private Provider<EntityManager> em;
	

    public HomePage() {
      

    }

    
	public void setEm(Provider<EntityManager> em) {
		this.em = em;
	}


    

	

	
    
}
