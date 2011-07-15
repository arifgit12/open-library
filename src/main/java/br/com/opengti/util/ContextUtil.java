package br.com.opengti.util;

import java.io.File;
import java.lang.reflect.Method;
import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;


public class ContextUtil {
	
	public static String getRealPath(String folder){
		
		FacesContext faces = FacesContext.getCurrentInstance();
		ServletContext sc = (ServletContext)faces.getExternalContext()
				.getContext();
		String realpath = sc.getRealPath(File.separator + folder);
		
		return realpath;
		
	}
	

	
	public static FacesMessage createMessage(String message){
		return new FacesMessage(message);
	}
	
	public static FacesMessage createErrorMessage(Throwable message){
		return new FacesMessage("Ocorreu um erro interno no Servidor: " + message.getMessage());
	}
	
}
