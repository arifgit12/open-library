package br.com.opengti.service.impl;

import lombok.Setter;
import br.com.opengti.domain.Pessoa;
import br.com.opengti.service.PessoaService;
import br.com.opengti.store.PessoaStore;

public class PessoaServiceImpl implements PessoaService {

	@Setter
	private PessoaStore pessoaStore;
	
	public void persist(Pessoa aluno) {
		pessoaStore.persist(aluno);
		
	}

	public void save(Pessoa aluno) {
		// TODO Auto-generated method stub
		
	}

	public Pessoa getPessoaByLoginAndSenha(String login, String senha) {
		// TODO Auto-generated method stub
		return null;
	}



}
