package br.com.opengti.service;

import br.com.opengti.domain.Pessoa;

public interface PessoaService {

	public void save(Pessoa aluno);

	public Pessoa getPessoaByLoginAndSenha(String login, String senha);
	
}
