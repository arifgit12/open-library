package br.com.opengti.library.config.context;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.servlet.GuiceServletContextListener;

/**
 * 
 * Classe Reponsável pela inicialização dos módulos do Google Guice
 *
 */
public class OpenLibraryGuiceContext extends GuiceServletContextListener{


	    public static final String KEY = Injector.class.getName(); 

	    private static final Logger log = LoggerFactory.getLogger(GuiceServletContextListener.class);
	    
	    private ServletContext servletContext;
	    private Injector injector;
	    
	    /**
	     * Injeta os m&oacute;dulos quando o servidor for inicializado.
	     * @see javax.servlet.ServletContextListener#contextInitialized(javax.servlet.ServletContextEvent)
	     */
	    @Override
	    public void contextInitialized( final ServletContextEvent servletContextEvent ) {
	        this.servletContext = servletContextEvent.getServletContext();
	        super.contextInitialized( servletContextEvent );
	    }
	    
	    /**
	     * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.ServletContextEvent)
	     */
	    public void contextDestroyed(ServletContextEvent servletContextEvent) {
	    	servletContextEvent.getServletContext().removeAttribute(KEY);
	    } 

	    /*
	     * Cria, injeta os m&oacute;dulos passados no web.xml e retorna o injetor do Guice. 
	     */
		@Override
		protected Injector getInjector() {
			
	        if ( injector == null ) {
	        	
	            // ShiroAopModule is required to use @Requires* annotations
		        String classesNames = servletContext.getInitParameter("modules");
		        log.info("Injecting modules "+classesNames+" ... ");
		        
		        try {
		        	
		        	StringTokenizer st = new StringTokenizer(classesNames,"\n");
		        	List<Module> clist = new ArrayList<Module>( st.countTokens() );
		        	
		        	while (st.hasMoreTokens()) {
		        		String clazzName = st.nextToken().trim();
		        		log.info("Carregando classe "+clazzName+" ... ");
		        		Class<?> module = (Class<?>) Thread.currentThread().getContextClassLoader().loadClass(clazzName);
		
		        		// Verificamos se nao existe um parametro unico no construtor com ServletContext. Caso existir, instanciamos e passamos o servletcontext como parametro:
		        		try { 
		        				Constructor<Module> c = (Constructor<Module>) module.getDeclaredConstructor(ServletContext.class);
		        				clist.add( c.newInstance(servletContext) );
		        				
		        		} catch (Exception e) {
		        			
		        			clist.add( (Module)module.getConstructor().newInstance() );
		        		}
		        	} // while.
		        	
		        	
		            
		        	injector = Guice.createInjector( clist );
		        	
		        	
		        }
	    
		        catch (ClassNotFoundException e) { throw new RuntimeException(e); }
		        catch (NoSuchMethodException e) { throw new RuntimeException(e); }
		        catch (InvocationTargetException e) { throw new RuntimeException(e); }
		        catch (IllegalAccessException e) { throw new RuntimeException(e); }
		        catch (InstantiationException e) { throw new RuntimeException(e); }
		        
	        }
	        
	        return injector;
		}
	}


