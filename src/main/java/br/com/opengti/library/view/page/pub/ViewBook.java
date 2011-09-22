  package br.com.opengti.library.view.page.pub;


import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.PropertyModel;

import com.google.inject.Inject;


import br.com.opengti.library.view.page.template.DefaultTemplate;


/**
 * 
 * 
 *
 */

@Log4j
public class ViewBook extends DefaultTemplate {

	private static final long serialVersionUID = 1L;
			

	public ViewBook(String id) {
		System.out.println("teste "+id);
	}

	
    
}
