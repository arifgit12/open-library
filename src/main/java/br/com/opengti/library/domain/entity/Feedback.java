package br.com.opengti.library.domain.entity;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

import lombok.Getter;
import lombok.extern.log4j.Log4j;


@Entity
@Audited
@Log4j
public class Feedback {
	
	
	@Id
	@GeneratedValue
	@Getter
	private Long id;
	

}
