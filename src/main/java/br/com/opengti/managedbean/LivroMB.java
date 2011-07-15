package br.com.opengti.managedbean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.richfaces.event.UploadEvent;
import org.richfaces.model.UploadItem;

import br.com.opengti.domain.BookImage;
import br.com.opengti.domain.Book;
import br.com.opengti.service.LivroService;
import br.com.opengti.service.impl.LivroServiceImpl;

public class LivroMB {

	private Book livro = new Book();
	private BookImage bookImage = new BookImage();
	private LivroService livroService = new LivroServiceImpl();
	private List<Book> listaLivros;

	
	public String save() {	
		livro.setBookImage(bookImage);
		String result = livroService.saveBook(livro);
		
		if(result.equals("saveSuccess")){
			
			bookImage = new BookImage();
			livro = new Book();
			
			FacesMessage message = new FacesMessage("Livro adicionado com sucesso!");
			FacesContext.getCurrentInstance().addMessage("Livro adicionado com sucesso!", message);
			
		}else{

			FacesMessage message = new FacesMessage("Ocorreu um erro ao tentar cadastrar o Livro!");
			FacesContext.getCurrentInstance().addMessage("Ocorreu um erro ao tentar cadastrar o Livro!", message);
		}
		
		return null;
	}

	public void uploadFile(UploadEvent event) {

		UploadItem item = event.getUploadItem();

		bookImage.setData(item.getData());
		bookImage.setLength(item.getData().length);
		bookImage.setName(item.getFileName());
		bookImage.setMime(item.getContentType());

	}

	public final Book getLivro() {
		return livro;
	}

	public final void setLivro(Book livro) {
		this.livro = livro;
	}

}
