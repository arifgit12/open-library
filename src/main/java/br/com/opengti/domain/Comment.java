package br.com.opengti.domain;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

import org.hibernate.validator.NotNull;

@Entity @Table
public class Comment {

	@Id @GeneratedValue @Getter @Setter private Integer id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@NotNull @Getter @Setter
	private Calendar dataPostagem;
	
}