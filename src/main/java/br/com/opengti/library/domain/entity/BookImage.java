package br.com.opengti.library.domain.entity;


import lombok.Getter;
import lombok.Setter;

public class BookImage {

	@Setter @Getter private Integer length;
	@Setter @Getter private byte[] data;
	@Setter @Getter private String name;
	@Setter @Getter private String mime;

}
