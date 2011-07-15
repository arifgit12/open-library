package br.com.opengti.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import lombok.Setter;
import br.com.opengti.domain.Book;
import br.com.opengti.service.LivroService;
import br.com.opengti.store.LivroStore;
import br.com.opengti.util.ImageUtil;

public class LivroServiceImpl implements LivroService {
	
	private static Logger logger  = Logger.getLogger(LivroServiceImpl.class.getName());
	
	@Setter
	private LivroStore livroStore;
	
	public String saveBook(Book livro){
		
		try{
			livro.setImagePath(ImageUtil.saveImage(livro.getBookImage()));
			livroStore.persist(livro);
			
			return "saveSuccess";
			
		}catch(Exception e){
			e.printStackTrace();
			return "saveError";
			
		}
		
	}

	public List<Book> listBook(Integer nroDestaques) {
		
		logger.info("Variable LivroStore is null? " + livroStore);
		
		
		Map<String,Object> params = new HashMap<String,Object>();
		
		params.put("maxResult", nroDestaques);
		
		List<Book> result = livroStore.list(params);
		
		
		
		return result;
	}


}
