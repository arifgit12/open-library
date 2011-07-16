package br.com.opengti.biblioteca.domain;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;


@Entity
@Table
public class Feedback {
	
	
	@Id
	@GeneratedValue
	@Getter
	private Long id;
	

}
