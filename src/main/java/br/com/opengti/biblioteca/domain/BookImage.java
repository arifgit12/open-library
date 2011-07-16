package br.com.opengti.biblioteca.domain;


import lombok.Getter;
import lombok.Setter;

public class BookImage {

	@Setter @Getter private Integer length;
	@Setter @Getter private byte[] data;
	@Setter @Getter private String name;
	@Setter @Getter private String mime;

}
