package br.com.opengti.library.config.context;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.servlet.GuiceServletContextListener;

@Log4j
public class GuiceContext extends GuiceServletContextListener {

	public static final String KEY = Injector.class.getName();

	private ServletContext servletContext;

	private Injector injector;

	@Override
	public void contextInitialized(final ServletContextEvent servletContextEvent) {
		this.servletContext = servletContextEvent.getServletContext();
		super.contextInitialized(servletContextEvent);
	}

	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		servletContextEvent.getServletContext().removeAttribute(KEY);
	}

	@Override
	protected Injector getInjector() {

		if (injector == null) {

			String classesNames = servletContext.getInitParameter("modules");
			
			try {

				StringTokenizer st = new StringTokenizer(classesNames, "\n");
				List<Module> clist = new ArrayList<Module>(st.countTokens());

				while (st.hasMoreTokens()) {
					
					String clazzName = st.nextToken().trim();
					
					log.info("Carregando classe " + clazzName + " ... ");
					
					Class<?> module = (Class<?>) Thread.currentThread()
							.getContextClassLoader().loadClass(clazzName);

					try {
						Constructor<Module> c = (Constructor<Module>) module.getDeclaredConstructor(ServletContext.class);
						clist.add(c.newInstance(servletContext));

					} catch (Exception e) {

						clist.add((Module) module.getConstructor()
								.newInstance());
					}
				}

				injector = Guice.createInjector(clist);

			}

			catch (ClassNotFoundException e) {
				throw new RuntimeException(e);
			} catch (NoSuchMethodException e) {
				throw new RuntimeException(e);
			} catch (InvocationTargetException e) {
				throw new RuntimeException(e);
			} catch (IllegalAccessException e) {
				throw new RuntimeException(e);
			} catch (InstantiationException e) {
				throw new RuntimeException(e);
			}

		}

		return injector;
	}
}
