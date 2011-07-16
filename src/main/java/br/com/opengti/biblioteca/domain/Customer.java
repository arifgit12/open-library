package br.com.opengti.biblioteca.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


import org.hibernate.validator.constraints.NotEmpty;


@Entity 
@Table

public class Customer extends Person {
	
	@Column(unique=true) @NotEmpty @Getter @Setter 
	private Long matricula;
	
	
	@NotEmpty @Getter @Setter 
	private Integer periodo;


}
