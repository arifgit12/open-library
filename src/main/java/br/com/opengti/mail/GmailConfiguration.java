package br.com.opengti.mail;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class GmailConfiguration implements EmailConfiguration {

	public Authenticator getAuth() {
		Authenticator auth = new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(EMAIL,
						SENHA); // Senha do gmail
			}
		};
		
		return auth;
	}

	public Properties getConfiguration() {
		Properties prop = System.getProperties();
		prop.put("mail.smtp.host"                  , "smtp.gmail.com");
		prop.put("mail.smtp.auth"                  , "true");
		prop.put("mail.debug"                      , "true");
		prop.put("mail.smtp.debug"                 , "true");
		prop.put("mail.mime.charset"               , "ISO-8859-1");
		prop.put("mail.smtp.port"                  , "465");
		prop.put("mail.smtp.starttls.enable"       , "true");
		prop.put("mail.smtp.socketFactory.port"    , "465");
		prop.put("mail.smtp.socketFactory.fallback", "false");
		prop.put("mail.smtp.socketFactory.class"   , "javax.net.ssl.SSLSocketFactory");
		return prop;
	}

}