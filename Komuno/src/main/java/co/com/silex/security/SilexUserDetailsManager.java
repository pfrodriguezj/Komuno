package co.com.silex.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import co.com.silex.model.entity.Role;
import co.com.silex.model.entity.User;
import co.com.silex.model.repositories.UserRepository;

public class SilexUserDetailsManager implements UserDetailsService{

	@Autowired
	UserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		
		User user = userRepo.findOneByUsername(username);
		SilexUserDetails silexUser = new SilexUserDetails();

		silexUser.setAccountNonExpired(true);
		silexUser.setAccountNonLocked(true);
		silexUser.setCredentialsNonExpired(true);
		silexUser.setEnabled(true);
		silexUser.setUsername(username);
		silexUser.setPassword(user.getPassword());
		silexUser.setAuthorities(getGrantedAuthorities(user.getRoles()));
		silexUser.setEmail(user.getEmail());
		silexUser.setNombres(user.getName());
		silexUser.setCredentialsExpirationDate(user.getCredentialsExpirationDate());
		
		Date today = new Date();
		if(silexUser.getCredentialsExpirationDate()!=null && today.after(silexUser.getCredentialsExpirationDate()) || today.equals(silexUser.getCredentialsExpirationDate())){
			silexUser.setCredentialsNonExpired(false);
		}
		else {
			silexUser.setCredentialsNonExpired(true);
		}
		
		return silexUser;
	}
	
	/**
	 * Convierte los roles de un usuario Silex a authorities de Spring
	 * @param usuarioRoles
	 * @return
	 */
	private Collection<GrantedAuthority> getGrantedAuthorities(Collection<Role> roles) {

		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (Role role : roles) {
				SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getRole());
				authorities.add(grantedAuthority);
		}
			
		return authorities;
	}


}
