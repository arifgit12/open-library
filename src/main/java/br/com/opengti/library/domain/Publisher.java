package br.com.opengti.library.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;

import org.hibernate.envers.Audited;

import lombok.Getter;
import lombok.Setter;

@Entity
@Audited
@Inheritance(strategy=InheritanceType.JOINED)
public class Publisher {

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
