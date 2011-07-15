package br.com.opengti.service;

import br.com.opengti.domain.Person;

public interface PessoaService {

	public void save(Person aluno);

	public Person getPessoaByLoginAndSenha(String login, String senha);
	
}
