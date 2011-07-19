package br.com.opengti.library.domain.entity;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

import lombok.Getter;


@Entity
@Audited
public class Feedback {
	
	
	@Id
	@GeneratedValue
	@Getter
	private Long id;
	

}
