package br.com.opengti.service;

import java.util.List;

import br.com.opengti.domain.Book;

public interface LivroService {

	public String saveBook(Book livro);

	public List<Book>listBook(Integer nroDestaques);

}
