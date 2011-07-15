package br.com.opengti.store;



import br.com.opengti.domain.Curso;

/**
 * 
 * @author Gabriel Cardelli
 * @since  Jun 30, 2011 3:36:22 PM 
 *
 */
public interface CursoStore extends Store<Curso> {

	
	public Curso getCurso(String nome);
	
}
