package br.com.opengti.library.config.security;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import lombok.Setter;
import lombok.extern.java.Log;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAccount;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import br.com.opengti.library.domain.entity.Person;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;

@Log
@Singleton
public class OpenLibraryCustomRealm extends AuthorizingRealm {

	@Inject @Setter
	private Provider<EntityManager> em;
	
	protected SimpleAccount getAccount(String email,char[] password) {
		log.info("Provider<EntityManager> : " + em);
		log.info("EntityManager : " + em.get());
		
		Query query = em.get().createNamedQuery("getPersonByEmailAndPassword");
		query.setParameter("email", email);
		query.setParameter("password", password);
		
		Person person = (Person) query.getSingleResult();
		SimpleAccount account = new SimpleAccount(person.getEmail(),person.getPassword(), getName());
		return account;
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		String email = (String) getAvailablePrincipal(principalCollection);
		return getAccount(email,null);
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		return getAccount(upToken.getUsername(),upToken.getPassword());
	}

}
