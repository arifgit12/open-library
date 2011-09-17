package br.com.opengti.library.view.page.pub;

import javax.persistence.EntityManager;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.PropertyModel;


import br.com.opengti.library.config.security.JpaRealm;
import br.com.opengti.library.domain.repository.PersonRepository;
import br.com.opengti.library.view.page.template.DefaultTemplate;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.persist.Transactional;

@Log4j
public class LogoutPage extends DefaultTemplate {

	private static final long serialVersionUID = 1L;


    public LogoutPage() {
    
    	
    	SecurityUtils.getSubject().logout();
    	setResponsePage(getApplication().getHomePage());
 

    }
	
	
    
}
