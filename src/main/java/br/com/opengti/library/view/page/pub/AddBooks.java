  package br.com.opengti.library.view.page.pub;


import javax.persistence.EntityManager;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.PropertyModel;

import com.google.inject.Inject;
import com.google.inject.Provider;


import br.com.opengti.library.domain.entity.Book;
import br.com.opengti.library.infra.dao.impl.BookDAOImpl;
import br.com.opengti.library.view.page.template.DefaultTemplate;


/**
 * 
 * 
 *
 */

@Log4j
public class AddBooks extends DefaultTemplate {

	private static final long serialVersionUID = 1L;
	
	@Setter @Getter 
	private Integer ano;
	@Setter @Getter 
	private String  autor;
	@Setter @Getter 
	private String comentarios;
	@Setter @Getter 
	private String edicao;
	@Setter @Getter 
	private String  editora;
	@Setter @Getter 
	private Long isbn;
	@Setter @Getter 
	private String nome;
	@Setter @Getter 
	private Integer nroPaginas;
	@Setter @Getter 
	private String origem;
	@Setter @Getter 
	private Integer qtdDispLocacao;
	
	@Inject @Getter @Setter
	private Book book;
	
	@Inject @Setter
	private Provider<EntityManager> em;
	
	@Inject @Getter @Setter
	private BookDAOImpl bookDAO;
		

    public AddBooks() {
    	
        
    	PropertyModel<Integer> anoModel = new PropertyModel<Integer>(this, "ano");
    	PropertyModel<String> autorModel = new PropertyModel<String>(this, "autor");
    	PropertyModel<String> comentariosModel = new PropertyModel<String>(this, "comentarios");
    	PropertyModel<String> edicaoModel = new PropertyModel<String>(this, "edicao");
    	PropertyModel<String> editoraModel = new PropertyModel<String>(this, "editora");
    	PropertyModel<Long> isbnModel = new PropertyModel<Long>(this, "isbn");
    	PropertyModel<String> nomeModel = new PropertyModel<String>(this, "nome");
    	PropertyModel<Integer> nroPaginasModel = new PropertyModel<Integer>(this, "nroPaginas");
    	PropertyModel<String> origemModel = new PropertyModel<String>(this, "origem");
    	PropertyModel<Integer> qtdDispLocacaoModel = new PropertyModel<Integer>(this, "qtdDispLocacao");
    	
    	Label messageLabel = new Label("message","");

    	Form<?> form = new Form<Object>("addform"){
            
			private static final long serialVersionUID = 3L;

			protected void onSubmit() {
        		super.onSubmit();
        		
        		try{
        			book.setAno(ano);
        			book.setAutor(autor);
        			book.setComentarios(comentarios);
        			book.setEdicao(edicao);
        			book.setEditora(editora);
        			book.setIsbn(isbn);
        			book.setNome(nome);
        			book.setNroPaginas(nroPaginas);
        			book.setOrigem(origem);
        			book.setQtdDispLocacao(qtdDispLocacao);
        			bookDAO.save(book);
        			
        			remove("message");
        			add(new Label("message","Livro Adicionado com sucesso"));
        		}catch(Exception e){
        			remove("message");
        			add(new Label("message","Dados Inválidos"));
        		}	
        		
			}
        };
        
        form.add(messageLabel);
        form.add(new TextField<Integer>("ano",anoModel ));
        form.add(new TextField<String>("autor",autorModel ));
        form.add(new TextField<String>("comentarios",comentariosModel ));
        form.add(new TextField<String>("edicao",edicaoModel ));
        form.add(new TextField<String>("editora",editoraModel ));
        form.add(new TextField<Long>("isbn",isbnModel ));
        form.add(new TextField<String>("nome",nomeModel ));
        form.add(new TextField<Integer>("nroPaginas",nroPaginasModel ));
        form.add(new TextField<String>("origem",origemModel ));
        form.add(new TextField<Integer>("qtdDispLocacao",qtdDispLocacaoModel ));
        
        add(form);

    }

	
    
}
