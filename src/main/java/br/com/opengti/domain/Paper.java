package br.com.opengti.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table
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
