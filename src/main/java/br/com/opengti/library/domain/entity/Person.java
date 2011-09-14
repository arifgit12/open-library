package br.com.opengti.library.domain.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.UniqueConstraint;

import org.hibernate.envers.Audited;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import br.com.caelum.stella.bean.validation.CPF;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Entity
@Audited
@Inheritance(strategy=InheritanceType.JOINED)
@NamedQueries({
	@NamedQuery(name="getPersonByEmailAndPassword",query="SELECT person FROM Person person WHERE email = ?1 and password = ?2")
})
@Log4j
public class Person {

	@Id @GeneratedValue @Getter
	private Integer id;
	
	@Getter @Setter @NotEmpty 
	private String name;
	
	@Getter @Setter @NotEmpty
	private String password;
	
	@Getter @Setter @NotEmpty @Email @Column(unique=true)
	private String email;
	
	@Getter @Setter @ManyToMany
	private List<Paper> papers;
	
	@Getter @Setter @CPF 
	private String cpf;
	
	
	
	

}
