package br.com.opengti.mail;

import java.util.Properties;

import javax.mail.Authenticator;

public interface EmailConfiguration {
	
	public static final String EMAIL = "seuemail";
	public static final String SENHA = "suasenha";
	
	public Properties getConfiguration();
	
	public Authenticator getAuth();

}
