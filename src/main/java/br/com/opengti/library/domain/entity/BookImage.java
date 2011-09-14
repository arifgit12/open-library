package br.com.opengti.library.domain.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
public class BookImage {

	@Setter @Getter private Integer length;
	@Setter @Getter private byte[] data;
	@Setter @Getter private String name;
	@Setter @Getter private String mime;

}
