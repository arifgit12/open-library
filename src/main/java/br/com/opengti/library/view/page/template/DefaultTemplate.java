package br.com.opengti.library.view.page.template;

import javax.persistence.EntityManager;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;

import br.com.opengti.library.view.page.pub.HomePage;
import br.com.opengti.library.view.page.pub.LoginPage;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * 
 * This class make principal public template.
 *
 */
@Log4j
public class DefaultTemplate extends WebPage {

	private static final long serialVersionUID = 1L;

	@Inject @Setter
	private Provider<EntityManager> em;
	

    public DefaultTemplate() {
     
    	
    	createMenu();
    	  
       
    }
    
    
    public void createMenu(){
    	add(new BookmarkablePageLink<Object>("linkHomePage", HomePage.class));
	  	add(new BookmarkablePageLink<Object>("linkBooksPage", HomePage.class));
	  	add(new BookmarkablePageLink<Object>("linkLoginPage", LoginPage.class));
    }


}
