package br.com.opengti.library.domain.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Transient;

import org.hibernate.envers.Audited;


import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Entity
@Audited

@NamedQueries({
	@NamedQuery(name="getListBooks",query="SELECT b FROM Book b"),
})
@Log4j
public class Book implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -964964141691412690L;


	@Id
	@GeneratedValue
	@Getter
	private Integer id;
	
	@Getter 
	@Setter
	private String nome;
	
	@Getter 
	@Setter
	private String editora;
	
	@Getter 
	@Setter
	private String autor;
	
	@Getter 
	@Setter
	private Long isbn;
	
	@Getter 
	@Setter
	private String origem;
	
	@Getter 
	@Setter
	private Integer ano;
	
	@Getter 
	@Setter
	private String edicao;
	
	@Getter 
	@Setter
	private Integer nroPaginas;
	
	@Getter
	@Setter
	private Integer qtdDispLocacao;
	
	@Getter
	@Setter
	private String imagePath;
	
	@Getter 
	@Setter
	private String comentarios;

	@Transient
	@Getter 
	@Setter
	private BookImage bookImage;
	

	
}
