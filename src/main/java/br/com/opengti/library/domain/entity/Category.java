package br.com.opengti.library.domain.entity;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.hibernate.envers.Audited;


import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Entity
@Audited
@Log4j
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
