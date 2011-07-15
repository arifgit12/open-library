package br.com.opengti.converter;



import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;


import br.com.opengti.domain.Curso;
import br.com.opengti.store.CursoStore;

public class CursoConverter implements Converter {

	private CursoStore cursoStore;
	
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		
	
		Curso curso = cursoStore.getCurso(arg2);
		
	
		return curso;
	}

	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		if(arg2 != null){
			Curso curso = (Curso) arg2;
			return curso.getNome();
		}else{
			return null;
		}
	}

}
