package br.com.opengti.library.view.page.pub;

import javax.persistence.EntityManager;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.PropertyModel;


import br.com.opengti.library.config.security.OpenLibraryCustomRealm;
import br.com.opengti.library.domain.repository.PersonRepository;
import br.com.opengti.library.view.page.template.DefaultTemplate;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Provider;

@Log
public class LoginPage extends DefaultTemplate {

	private static final long serialVersionUID = 1L;

	@Inject @Setter
	private Provider<EntityManager> em;
	
	@Getter @Setter
	private String login = "";
	
	@Getter @Setter
	private String password = "";
	
	@Inject @Setter
	private PersonRepository personRepository;
	
    public LoginPage() {
    
    	
    	PropertyModel<String> loginModel = new PropertyModel<String>(this, "login");
    	PropertyModel<String> passwordModel = new PropertyModel<String>(this, "password");
        

    	Form<?> form = new Form<Object>("loginForm"){
        	protected void onSubmit() {
        		
        		super.onSubmit();

        		Subject subject = SecurityUtils.getSubject();
        		UsernamePasswordToken token = new UsernamePasswordToken(login, password);
        		token.setRememberMe(true);
        		
        		try {
        		    subject.login(token);
        		    System.out.println("SUBJECT: " +subject.getPrincipal());       		    
        		} catch (AuthenticationException ae) {
        		   ae.printStackTrace();
        		}

        		
        	}
        };
        
        
        form.add(new TextField<String>("login",loginModel));
        form.add(new TextField<String>("password",passwordModel));


        add(form);
        
      
    }

    
    
}
