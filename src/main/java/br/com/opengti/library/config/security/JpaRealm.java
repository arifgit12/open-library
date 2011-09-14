package br.com.opengti.library.config.security;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import lombok.Setter;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;

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

/**
 * 
 * @author Gabriel Cardelli
 *
 */
@Log4j
@Singleton
public class JpaRealm extends AuthorizingRealm {

	@Inject @Setter
	private Provider<EntityManager> em;
	
	protected SimpleAccount getAccount(String email,char[] password) {
		
		Query query = em.get().createNamedQuery("getPersonByEmailAndPassword");
		query.setParameter(1, email);
		query.setParameter(2,new String(password));
		
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
