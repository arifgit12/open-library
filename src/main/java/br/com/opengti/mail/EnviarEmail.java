package br.com.opengti.mail;

import java.io.UnsupportedEncodingException;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import br.com.opengti.domain.Person;




public class EnviarEmail {
	
	private EmailConfiguration email;
	
	public void cadastroAluno(Person aluno) throws MessagingException, UnsupportedEncodingException{

			email = getConfiguration(aluno.getEmail());

		

			Session session = Session.getInstance(email.getConfiguration(), email.getAuth());
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress("gabrielcastilho.cardelli@gmail.com", "Gabriel Cardelli"));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(
					aluno.getEmail(), aluno.getName()));
			message.setSubject("Cadastro");
			message.setContent("Teste", "text/plain");
			Transport.send(message);
		
	    
	}
	
	public EmailConfiguration getConfiguration(String email){
		
		if(email.contains("gmail")){
			return new GmailConfiguration();
		}else if (email.contains("hotmail")){
			return null;
		}else{
			return null;
		}
		
	}
	
	

}
