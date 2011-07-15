package br.com.opengti.managedbean;

import java.util.logging.Logger;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.com.opengti.domain.Person;
import br.com.opengti.service.PessoaService;
import br.com.opengti.service.impl.LivroServiceImpl;
import br.com.opengti.util.ContextUtil;

/**
 * 
 * @author Gabriel Cardelli
 * @since  Jun 30, 2011 5:29:14 PM 
 *
 */
public class LoginMB {

	private static Logger logger  = Logger.getLogger(LoginMB.class.getName());
	
	/*
	 * Faces Objects
	 */

	private FacesContext facesContext;

	/*
	 * View Objects / Params
	 */

	private Person pessoa = new Person();
	private String login;
	private String senha;

	/*
	 * Services
	 */

	private PessoaService pessoaService;

	/*
	 * Construtor
	 */
	
	public LoginMB() {}

	/*
	 * Action Methods
	 */

	public String login() {
		
		logger.info("Login: " + login);
		logger.info("Senha: " + senha);

		Person aluno = (Person) pessoaService.getPessoaByLoginAndSenha(login,senha);

		if (aluno == null) {	
			facesContext.addMessage("Dados inválidos!",ContextUtil.createMessage("Dados Inválidos"));		
		} else {
			logger.info(aluno.getName() + " Logado");
			facesContext.getExternalContext().getSessionMap().put("user", aluno);
		}

		setLogin("");
		setSenha("");

		return "gotoIndex";
	}

	public String logout() {

		

		Person pessoa = (Person) facesContext.getExternalContext()
				.getSessionMap().get("user");

		logger.info(pessoa.getName() + " Deslogado");

		HttpSession session = (HttpSession) facesContext.getExternalContext()
				.getSession(false);
		session.invalidate();

		return "gotoIndex";

	}

	/*
	 * Gets and Sets
	 */

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
