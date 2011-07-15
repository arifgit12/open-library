package br.com.opengti.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import org.hibernate.validator.NotNull;


@Entity 
@Table

public class Customer extends Person {
	
	@Column(unique=true)@NotNull @Getter @Setter private Long matricula;
	
	
	@NotNull @Getter @Setter private Integer periodo;


}
