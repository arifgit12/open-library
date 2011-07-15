package br.com.opengti.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import lombok.Getter;
import lombok.Setter;

import org.springframework.transaction.annotation.Transactional;

import br.com.opengti.domain.Aluno;
import br.com.opengti.domain.Curso;
import br.com.opengti.domain.Pessoa;
import br.com.opengti.mail.EnviarEmail;
import br.com.opengti.service.CursoService;
import br.com.opengti.service.PessoaService;
import br.com.opengti.util.ContextUtil;

/**
 * 
 * @author Gabriel Cardelli
 * @since  Jun 30, 2011 4:48:50 PM 
 *
 */
public class AlunoMB {
	
	/*
	 * Faces Objects
	 */

	private FacesContext facesContext;
	
	
	/*
	 * View Objects / Params
	 */
	
	@Getter 
	@Setter
	private Aluno aluno;
	
	
	
	/* 
	 * Services
	 */
	
	@Setter
	private PessoaService pessoaService;
	
	@Setter
	private CursoService cursoService;
	
	
	
	/*
	 * Construtor
	 */	
	
	public AlunoMB() {}
	
	
	
	/*
	 * Action Methods
	 */
	
	@Transactional
	public void save(ActionEvent event){
		try{
			pessoaService.save(aluno);
			facesContext.addMessage("sucesso", ContextUtil.createMessage("Cadastrado realizado com sucesso."));
			facesContext.addMessage("desbloquiar", ContextUtil.createMessage("Para desbloquiar sua conta veja o email que lhe foi enviado."));
			new EnviarEmail().cadastroAluno(aluno);
		}catch(Exception e){
	
			facesContext.addMessage("erro", ContextUtil.createErrorMessage(e));

		}
	}
	
	
	

	/*
	 * Gets and Sets
	 */
	
	public List<SelectItem> getCursos() {
		
		List<Curso> cursosTemp = cursoService.list();		
		List<SelectItem> cursos = new ArrayList<SelectItem>();	
		
		for(Curso curso : cursosTemp){		
			cursos.add(new SelectItem(curso));	
		}
		
		return cursos;
		
	}




}
