package br.com.opengti.library.view.page.pub;

import javax.persistence.EntityManager;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.apache.shiro.web.mgt.WebSecurityManager;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.PropertyModel;

import br.com.opengti.library.view.page.template.BaseTemplate;

import com.google.inject.Inject;
import com.google.inject.Provider;

@Log
public class LoginPage extends BaseTemplate {

	private static final long serialVersionUID = 1L;

	@Inject @Setter
	private Provider<EntityManager> em;
	
	@Getter @Setter
	private String login = "";
	
	@Getter @Setter
	private String password = "";
	
	@Inject @Setter
	WebSecurityManager securityManager;
	
    public LoginPage() {
    
    	
    	PropertyModel<String> loginModel = new PropertyModel<String>(this, "login");
    	PropertyModel<String> passwordModel = new PropertyModel<String>(this, "password");
        

    	Form<?> form = new Form<Object>("loginForm"){
        	protected void onSubmit() {
        		
        		super.onSubmit();
        		
        		log.info("EntityManagerProvider: " + em);
        		log.info("Login: " + login + " " + "Password: " + password);
        		
        		
        		
        		Subject subject = SecurityUtils.getSubject();
        		UsernamePasswordToken token = new UsernamePasswordToken(login, password);
        		token.setRememberMe(true);
        		try {
        		    subject.login(token);
        		} catch (AuthenticationException ae) {
        		    // handle failed logins here ... see the docs for more exceptions
        		}

        		
        	}
        };
        
        
        form.add(new TextField<String>("login",loginModel));
        form.add(new TextField<String>("password",passwordModel));


        add(form);
        
      
    }
    
}
