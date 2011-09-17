package br.com.opengti.library.view.page.template;

import javax.persistence.EntityManager;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

import org.apache.shiro.SecurityUtils;
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
    	
    	BookmarkablePageLink<Object> homeLink     = null;
    	BookmarkablePageLink<Object> booksLink     = null;
    	BookmarkablePageLink<Object> registerLink = null;
    	BookmarkablePageLink<Object> loginLink    = null;
    	BookmarkablePageLink<Object> logoutLink    = null;
    	
    	homeLink     = new BookmarkablePageLink<Object>("homeLink"    , HomePage.class);
    	booksLink     = new BookmarkablePageLink<Object>("booksLink"   , HomePage.class);
    	registerLink = new BookmarkablePageLink<Object>("registerLink", LoginPage.class);
    	loginLink    = new BookmarkablePageLink<Object>("loginLink"   , LoginPage.class);
    	loginLink    = new BookmarkablePageLink<Object>("logoutLink"   , LoginPage.class);
    	
    	if(SecurityUtils.getSubject().getPrincipal() != null){
    		loginLink.setVisible(false);
    		registerLink.setVisible(false);
    	}
    	
    	add(homeLink);
    	add(booksLink);
    	add(loginLink);
    	add(registerLink);
    	
    }

}
