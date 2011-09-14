package br.com.opengti.library.config.module;

import javax.servlet.ServletContext;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;

import org.apache.shiro.guice.web.ShiroWebModule;


import br.com.opengti.library.config.security.JpaRealm;

/**
 * 
 * Apache Shiro Guice Module
 * @author Gabriel Cardelli
 *
 */
@Log4j
public class ShiroSecurityModule extends ShiroWebModule {

	public ShiroSecurityModule(ServletContext servletContext) {
		super(servletContext);

	}

	@Override
	protected void configureShiroWeb() {
		bindRealm().to(JpaRealm.class);
	}

}
