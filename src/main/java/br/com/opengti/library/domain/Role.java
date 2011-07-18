package br.com.opengti.library.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.envers.Audited;

import lombok.Getter;
import lombok.Setter;

@Entity
@Audited
public class Role {

	@Id
	@GeneratedValue
	@Getter 
	@Setter
	private Integer id;
	
	@Getter 
	@Setter
	private String nome;
	
	@Getter 
	@Setter
	private String descricao;

	
}
