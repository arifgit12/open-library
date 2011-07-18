package br.com.opengti.library.page.pub;

import javax.persistence.EntityManager;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.PropertyModel;

import br.com.opengti.library.page.template.BaseTemplate;

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
	
    public LoginPage() {
    
    	
    	PropertyModel<String> loginModel = new PropertyModel<String>(this, "login");
    	PropertyModel<String> passwordModel = new PropertyModel<String>(this, "password");
        

    	Form<?> form = new Form<Object>("loginForm"){
        	protected void onSubmit() {
        		
        		super.onSubmit();
        		
        		log.info("EntityManagerProvider: " + em);
        		log.info("Login: " + login + " " + "Password: " + password);
        		
        		
        		
        	
        		  Factory factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        		  
        		
        		  SecurityUtils.setSecurityManager((SecurityManager) factory.getInstance());
        		  Subject currentUser = SecurityUtils.getSubject();

        		  // teste utilizando sessions
        		  // gerenciamento de sessao
        		  // caso o shiro estiver rodando em um contexto web, o session recuperado sera um httpsession.
        		  Session session = currentUser.getSession();
        		  session.setAttribute("key", "value");
        		  String value = (String) session.getAttribute("ksey");
        		  if (value != null && value.equals("value")) {
        		   System.out.println("Session key:" + value);
        		  }
        		  
        		  // verificando se o usuario esta autenticado
        		
        		   // se nao estiver entao inicia o login
        		   UsernamePasswordToken token = new UsernamePasswordToken("tofux", "pfffmmmm");
        		   token.setRememberMe(true);
        		   
        		  
        		    ////////////////////////////////////////////////////////////////////////////////////////////////
        		    // é aqui que toda o processo de autenticacao e utilizacao do realm personalizado entra em acao.
        		    currentUser.login(token);
        		    System.out.println(currentUser.getPrincipal());
        		
        	}
        };
        
        
        form.add(new TextField<String>("login",loginModel));
        form.add(new TextField<String>("password",passwordModel));


        add(form);
        
      
    }
    
}
