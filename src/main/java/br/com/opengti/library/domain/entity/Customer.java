package br.com.opengti.library.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j;


import org.hibernate.envers.Audited;
import org.hibernate.validator.constraints.NotEmpty;


@Entity 
@Audited
@Log4j
public class Customer extends Person {
	
	@Column(unique=true) @NotEmpty @Getter @Setter 
	private Long matricula;
	
	
	@NotEmpty @Getter @Setter 
	private Integer periodo;


}
