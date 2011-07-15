package br.com.opengti.managedbean;

import java.util.ArrayList;
import java.util.List;

import lombok.Setter;
import lombok.extern.java.Log;
import br.com.opengti.domain.Book;
import br.com.opengti.service.LivroService;

import com.google.inject.Inject;

@Log
public class IndexMB {

	private List<Book> destaques;
	
	@Inject
	private LivroService livroService;
	
	
	public IndexMB() {
		log.info("Criando ManagedBean Novo");
		

		
	}
	


	public final List<Book> getDestaques() {
		log.info("Reading Destaques");
		destaques = livroService.listBook(10);
		if (destaques == null){
			log.info("Destaques == null");
			return new ArrayList();
		}
		
		return destaques;
	}

	public final void setDestaques(List<Book> destaques) {
		this.destaques = destaques;
	}

	public void setLivroService(LivroService livroService) {
		log.info("Teste Inject");
		this.livroService = livroService;
	}


	
	
}
