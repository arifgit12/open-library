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
    	
    	Label messageLabel = new Label("message","");
    	
    	Form<?> form = new Form<Object>("loginForm"){
        
			private static final long serialVersionUID = 1L;

			protected void onSubmit() {
        		super.onSubmit();
        		
        		try{
        			userAuth(login, password);
        			setResponsePage(getApplication().getHomePage());
        		}catch(Exception e){
        			remove("message");
        			add(new Label("message","Dados Inv�lidos"));
        		}	
        		
			}
        };
        
        form.add(messageLabel);
        form.add(new TextField<String>("login",loginModel));
        form.add(new TextField<String>("password",passwordModel));

        add(form);
 

    }
	
	
    @Transactional
	public void userAuth(String username,String password){
		
    	Subject subject = SecurityUtils.getSubject();
		
    	UsernamePasswordToken token = new UsernamePasswordToken(login, password);
		
    	token.setRememberMe(true);
					
		subject.login(token);
		    
	}    
    
}
