package br.com.opengti.library.domain;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

import lombok.Getter;
import lombok.Setter;

@Entity
@Audited
public class Paper {

	@Id
	@GeneratedValue
	@Getter
	@Setter
	private Integer id;
	
	@Getter
	@Setter
	private String nome;
	


}
