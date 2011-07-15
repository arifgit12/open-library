package br.com.opengti.managedbean;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;
import br.com.opengti.domain.Livro;
import br.com.opengti.service.LivroService;
import br.com.opengti.util.ContextUtil;

@Log
public class IndexMB {

	private List<Livro> destaques;
	
	@Setter
	private LivroService livroService;
	
	
	public IndexMB() {
		log.info("Criando ManagedBean Novo");
		
		livroService = (LivroService) ContextUtil.getApplicationContext().getBean("livroService");
		destaques = loadDestaques(12);
	}
	
	private List<Livro> loadDestaques(Integer nroDestq){
		
		return livroService.listBook(nroDestq);
		
	}

	public final List<Livro> getDestaques() {
		log.info("Reading Destaques");
		
		if (destaques == null){
			log.info("Destaques == null");
			return new ArrayList();
		}
		
		return destaques;
	}

	public final void setDestaques(List<Livro> destaques) {
		this.destaques = destaques;
	}


}
