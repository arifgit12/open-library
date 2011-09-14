package br.com.opengti.library.domain.entity;



import javax.persistence.Entity;

import javax.persistence.Table;

import lombok.extern.log4j.Log4j;

import org.hibernate.envers.Audited;



@Entity
@Audited
@Log4j
public class Librarian extends Person {
	
	

}
