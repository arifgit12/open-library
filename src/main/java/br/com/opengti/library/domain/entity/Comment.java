package br.com.opengti.library.domain.entity;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

import org.hibernate.envers.Audited;
import org.hibernate.validator.constraints.NotEmpty;



@Entity 
@Audited
@Log4j
public class Comment {

	@Id @GeneratedValue @Getter @Setter private Integer id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@NotEmpty @Getter @Setter
	private Calendar dataPostagem;
	
}
