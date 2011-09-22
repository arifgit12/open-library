  package br.com.opengti.library.view.page.pub;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.CheckBox;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.PropertyModel;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import br.com.opengti.library.domain.entity.Book;
import br.com.opengti.library.infra.dao.BookDAO;
import br.com.opengti.library.infra.dao.PersonDAO;
import br.com.opengti.library.infra.dao.impl.BookDAOImpl;
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
	
	@Getter @Setter
	List<Book> listBooks = new ArrayList<Book>();
	

    public BooksPage() {

    	listBooks = (List<Book>) em.get().createNamedQuery("getListBooks").getResultList();

    	add(new ListView("listview", listBooks) {
    	    protected void populateItem(final ListItem item) {
    	        Book book = (Book) item.getModelObject();
    	        item.add(new Label("nome", book.getNome()));
    	        item.add(new Label("editora", book.getEditora()));
    	        item.add(new Link("add", item.getModel())
				{
					@Override
					public void onClick()
					{
						new ViewBook(item.getId());
					}
				});

    	    }
    	});
    	



    }

}
