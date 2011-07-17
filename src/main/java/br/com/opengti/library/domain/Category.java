package br.com.opengti.library.domain;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;


import lombok.Getter;
import lombok.Setter;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Category {

	@Id
	@GeneratedValue
	@Getter
	private Integer id;
	
	@Getter 
	@Setter
	private String nome;
	
	@Getter 
	@Setter
	private String login;
	
	@Getter 
	@Setter
	private String senha;
	
	@Getter 
	@Setter
	private String email;
	
	@Getter 
	@Setter
	private boolean admin;


}
