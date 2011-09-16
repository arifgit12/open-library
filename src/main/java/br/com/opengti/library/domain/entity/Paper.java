package br.com.opengti.library.domain.entity;



import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

import org.hibernate.envers.Audited;

@Entity
@Audited
@Log4j
public class Paper {

	@Id
	@GeneratedValue
	@Getter
	@Setter
	private Integer id;
	
	@Getter
	@Setter
	private String nome;
	
	@ManyToMany
	@Getter
	@Setter
	private List<Role> roles;
	
	@Transient
	public Set<String> getRolesName() {
		
		Set<String> rolesName = new HashSet<String>();
		
		for(Role role : roles ){
			rolesName.add(role.getName());
		}
		
		return rolesName;
	}



}
