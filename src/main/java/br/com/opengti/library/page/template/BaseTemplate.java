package br.com.opengti.library.page.template;

import javax.persistence.EntityManager;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;

import br.com.opengti.library.page.pub.HomePage;
import br.com.opengti.library.page.pub.LoginPage;

import com.google.inject.Inject;
import com.google.inject.Provider;

public class BaseTemplate extends WebPage {

	private static final long serialVersionUID = 1L;

	@Inject
	private Provider<EntityManager> em;
	

    public BaseTemplate(final PageParameters parameters) {
     
    	  add(new BookmarkablePageLink("linkHomePage", HomePage.class));
    	  add(new BookmarkablePageLink("linkBooksPage", HomePage.class));
    	  add(new BookmarkablePageLink("linkLoginPage", LoginPage.class));
       
    }

	public void setEm(Provider<EntityManager> em) {
		this.em = em;
	}


    

	

	
    
}