package br.com.opengti.library.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import br.com.caelum.stella.bean.validation.CPF;
import lombok.Getter;
import lombok.Setter;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Person {

	@Id @GeneratedValue @Getter
	private Integer id;
	
	@Getter @Setter @NotEmpty 
	private String name;
	
	@Getter @Setter @NotEmpty
	private String username;
	
	@Getter @Setter @NotEmpty
	private String password;
	
	@Getter @Setter @NotEmpty @Email
	private String email;
	
	@Getter @Setter @ManyToMany
	private List<Paper> papers;
	
	@Getter @Setter @CPF
	private String cpf;
	
	
	
	

}
