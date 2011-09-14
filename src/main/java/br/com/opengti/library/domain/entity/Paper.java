package br.com.opengti.library.domain.entity;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Entity
@Audited
@Log4j
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
