package br.com.opengti.managedbean;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import br.com.opengti.domain.Curso;
import br.com.opengti.store.CursoStore;

/**
 * 
 * @author Gabriel Cardelli
 * @since  Jun 30, 2011 4:54:22 PM 
 *
 */
public class CursoMB {
	
	/*
	 * 
	 * View Objects / Params
	 * 
	 */
	
	private Curso curso;
	
	/*
	 * 
	 * Services
	 * 
	 */
	
	/*
	 * 
	 * Stores
	 * 
	 */
	
	private CursoStore cursoStore;
	
	/*
	 * 
	 * Construtor
	 * 
	 */	
	
	/*
	 * 
	 * Action Methods
	 * 
	 */
	
	public void novo(ActionEvent event){
		cursoStore.persist(curso);
		curso = new Curso();
		FacesMessage message = new FacesMessage("Curso adicionado com sucesso!");
		FacesContext.getCurrentInstance().addMessage("Curso adicionado com sucesso!", message);
	}
	
	/*
	 * 
	 * Gets and Sets
	 * 
	 */
	
	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	
	
}
