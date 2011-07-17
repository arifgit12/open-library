package br.com.opengti.library.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table
public class Book {

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
