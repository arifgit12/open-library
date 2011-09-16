package br.com.opengti.library.domain.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import br.com.caelum.stella.bean.validation.CPF;

import com.google.inject.Inject;
import com.google.inject.Provider;

@Entity
@Audited
@Inheritance(strategy=InheritanceType.JOINED)
@NamedQueries({
	@NamedQuery(name="getPersonByEmailAndPassword",query="SELECT person FROM Person person WHERE email = ?1 and password = ?2"),
	@NamedQuery(name="getRolesNameByPersonEmail",query="SELECT role.name FROM Person person, IN(person.paper.roles) role WHERE person.email = ?1"),
	@NamedQuery(name="getPersonByEmail",query="SELECT person FROM Person person WHERE email = ?1")
})
@Log4j
public class Person {

	@Transient @Inject @Setter
	private Provider<EntityManager> em;
	
	
	@Id @GeneratedValue @Getter
	private Integer id;
	
	@Getter @Setter @NotEmpty 
	private String name;
	
	@Getter @Setter @NotEmpty
	private String password;
	
	@Getter @Setter @NotEmpty @Email @Column(unique=true)
	private String email;
	
	@Getter @Setter @ManyToOne
	private Paper paper;
	
	@Getter @Setter @CPF 
	private String cpf;
	
	
	@Transient
	public Set<String> getRolesName(){
		return paper.getRolesName();	
	}
	
	
	
	

}
