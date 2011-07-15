package br.com.opengti.service;

import java.util.List;

import br.com.opengti.domain.Livro;

public interface LivroService {

	public String saveBook(Livro livro);

	public List<Livro>listBook(Integer nroDestaques);

}
