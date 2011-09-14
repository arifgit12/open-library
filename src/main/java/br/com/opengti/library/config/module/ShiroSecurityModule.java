package br.com.opengti.library.config.module;

import javax.servlet.ServletContext;

import lombok.extern.java.Log;

import org.apache.shiro.guice.web.ShiroWebModule;


import br.com.opengti.library.config.security.OpenLibraryCustomRealm;


@Log
public class ShiroSecurityModule extends ShiroWebModule {

	public ShiroSecurityModule(ServletContext servletContext) {
		super(servletContext);

	}

	@Override
	protected void configureShiroWeb() {
		bindRealm().to(OpenLibraryCustomRealm.class);

	}

}
