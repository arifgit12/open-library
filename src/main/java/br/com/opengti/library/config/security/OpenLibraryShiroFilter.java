package br.com.opengti.library.config.security;

import lombok.extern.java.Log;


import org.apache.shiro.web.mgt.WebSecurityManager;
import org.apache.shiro.web.servlet.AbstractShiroFilter;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
@Log
public class OpenLibraryShiroFilter extends AbstractShiroFilter {

	@Inject
	public OpenLibraryShiroFilter(WebSecurityManager securityManager) {
		log.info("WebSecurityManager: " + securityManager);
		setSecurityManager(securityManager);
	}
}