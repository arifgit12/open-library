  package br.com.opengti.library.view.page.pub;

import javax.persistence.EntityManager;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import br.com.opengti.library.view.page.template.DefaultTemplate;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * 
 * 
 *
 */
@Log4j
public class BooksPage extends DefaultTemplate {

	private static final long serialVersionUID = 1L;

	@Inject @Setter
	private Provider<EntityManager> em;
	

    public BooksPage() {
      

    }

}
