package br.com.opengti.library.view.page.template;

import javax.persistence.EntityManager;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

import org.apache.shiro.SecurityUtils;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;

import br.com.opengti.library.view.page.pub.AddBooks;
import br.com.opengti.library.view.page.pub.BooksPage;
import br.com.opengti.library.view.page.pub.HomePage;
import br.com.opengti.library.view.page.pub.LoginPage;
import br.com.opengti.library.view.page.pub.LogoutPage;

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
    	BookmarkablePageLink<Object> addbooksLink     = null;
    	BookmarkablePageLink<Object> booksLink     = null;
    	BookmarkablePageLink<Object> registerLink = null;
    	BookmarkablePageLink<Object> loginLink    = null;
    	BookmarkablePageLink<Object> logoutLink    = null;
    	
    	homeLink = new BookmarkablePageLink<Object>("homeLink"    , HomePage.class);
    	booksLink = new BookmarkablePageLink<Object>("booksLink"   , BooksPage.class);
    	addbooksLink = new BookmarkablePageLink<Object>("addbooksLink"   , AddBooks.class);
    	registerLink = new BookmarkablePageLink<Object>("registerLink", LoginPage.class);
    	loginLink = new BookmarkablePageLink<Object>("loginLink"   , LoginPage.class);
    	logoutLink = new BookmarkablePageLink<Object>("logoutLink"   , LogoutPage.class);
    	
    	if(SecurityUtils.getSubject().getPrincipal() != null){
    		loginLink.setVisible(false);
    		registerLink.setVisible(false);
    		logoutLink.setVisible(true);
    	}else{
    		logoutLink.setVisible(false);
    		loginLink.setVisible(true);
    		registerLink.setVisible(true);
    	}
    	
    	add(homeLink);
    	add(addbooksLink);
    	add(booksLink);
    	add(loginLink);
    	add(registerLink);
    	add(logoutLink);
    	
    }

}
