package br.com.opengti.store.impl;

import java.util.List;
import java.util.Map;

import br.com.opengti.domain.Person;
import br.com.opengti.store.PessoaStore;

/**
 * 
 * @author Gabriel Cardelli
 * @since Jun 30, 2011 3:57:22 PM
 * 
 */
public class PessoaStoreImpl implements PessoaStore {


	public void persist(Person t) {
		// TODO Auto-generated method stub

	}


	public Person get(Object primaryKey) {
		// TODO Auto-generated method stub
		return null;
	}


	public Person get(Map<String, Object> params) {
		

//	Criteria c = getSession().createCriteria(br.com.opengti.domain.Pessoa.class);
//		
//		if (params.get("login") != null){
//			c.add(Restrictions.eq("login", params.get("login")));
//		}
//		
//		if (params.get("senha") != null){
//			c.add(Restrictions.eq("senha", params.get("senha")));
//		}
//
//		try{
//			Pessoa pessoa = (Pessoa) c.uniqueResult();
//			return pessoa;
//		}catch(Exception e){
//			return null;
//		}
		
		return null;
		
	}


	public List<Person> list() {
		// TODO Auto-generated method stub
		return null;
	}


	public List<Person> list(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return null;
	}


	public Person merge(Person t) {
		// TODO Auto-generated method stub
		return null;
	}

	// public Pessoa openSession(String login, String senha){

	//

	// }

	// public void save(Pessoa pessoa){
	//
	// Session s = SessionFactory.getSession();
	//
	// if(pessoa instanceof Aluno){
	// Aluno aluno = (Aluno) pessoa;
	// s.save(aluno);
	// }else if (pessoa instanceof Funcionario){
	// Funcionario aluno = (Funcionario) pessoa;

	// s.save(aluno);
	// }

	// s.beginTransaction();
	// s.getTransaction().commit();

	// }

	

}
