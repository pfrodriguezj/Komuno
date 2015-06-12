package co.com.silex.security;

import java.util.Collection;
import java.util.Date;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class SilexUserDetails implements UserDetails{
	
	/**
	 * Roles del usuario, requerido por spring. 
	 */
	private Collection<GrantedAuthority> grantedAuthorities;
	
	/**
	 * Password, requerido por spring
	 */
	private String password;
	
	/**
	 * Nombre de usuario, requerido por spring 
	 */
	private String username;
	
	/**
	 * Inidica si la cuenta está expirada, requerido por spring
	 */
	private boolean accountNonExpired;
	
	/**
	 * Indica si la cuenta no esta bloqueeada, requerido por spring
	 */
	private boolean accountNonLocked;
	
	/**
	 * Indica si el password esta expirado, requerido por spring
	 */
	private boolean credentialsNonExpired;
	
	/**
	 * Indica si el usuario está habilitado, requerido por spring
	 */
	private boolean enabled;

	/**
	 * Indica la fecha de expiracion del password del usuario. 
	 */
	private Date credentialsExpirationDate;
	
	/**
	 * LoginsFallidos.
	 */
	private Integer loginsFallidos;

	/**
	 * Email del usuario.
	 */
	private String email;
	
	/**
	 * Nombres de pila del usuario.
	 */
	private String nombres;

	/** 
	 * Devuelve los roles aosciados a este usuario.
	 * 
     * @see org.springframework.security.core.userdetails.UserDetails#getAuthorities()
     */
    @Override
    public Collection<GrantedAuthority> getAuthorities() {
    	return this.grantedAuthorities;
    }
    
    /**
     * Setea los roles asociados a este usuario.
     * @param grantedAuthorities
     */
    public void setAuthorities(Collection<GrantedAuthority> grantedAuthorities) {
    	this.grantedAuthorities = grantedAuthorities;
    }

	/**
	 * Obtiene el password del usuario. 
     * @see org.springframework.security.core.userdetails.UserDetails#getPassword()
     */
    @Override
    public String getPassword() {
	    return this.password;
    }
    
    /**
     * Setea el password del usuario.
     * @param password
     */
    public void setPassword(String password) {
	    this.password = password;
    }

	/**
	 * Obtiene el nombre de usuario
     * @see org.springframework.security.core.userdetails.UserDetails#getUsername()
     */
    @Override
    public String getUsername() {
	    return this.username;
    }
    
    /**
     * Setea el nombre de usuario.
     * @param username
     */
    public void setUsername(String username) {
	    this.username = username;
    }

    /**
     * Indica si la cuenta está expirada o no.
     * @see org.springframework.security.core.userdetails.UserDetails#isAccountNonExpired()
     */
    @Override
    public boolean isAccountNonExpired() {
	    return this.accountNonExpired;
    }
    
    /**
     * Setea si la cuenta esta expirada o no.
     * @param accountNonExpired
     */
    public void setAccountNonExpired(Boolean accountNonExpired) {
	    this.accountNonExpired = accountNonExpired;
    }

	/**
	 * Indica si la cuenta esta bloqueada o no.
     * @see org.springframework.security.core.userdetails.UserDetails#isAccountNonLocked()
     */
    @Override
    public boolean isAccountNonLocked() {
    	return this.accountNonLocked;
    }
    
    /**
     * Setea si la cuenta esta bloqueada o no.
     * @param accountNonLocked
     */
    public void setAccountNonLocked(Boolean accountNonLocked) {
	    this.accountNonLocked = accountNonLocked;
    }

	/**
	 * Indica si la contraseña esta bloqueada o no.
     * @see org.springframework.security.core.userdetails.UserDetails#isCredentialsNonExpired()
     */
    @Override
    public boolean isCredentialsNonExpired() {
    	return this.credentialsNonExpired;
    }
    
    /**
     * Setea si la contraseña esta bloqueada o no.
     * @param credentialsNonExpired
     */
    public void setCredentialsNonExpired(Boolean credentialsNonExpired) {
    	this.credentialsNonExpired = credentialsNonExpired;
    }

	public Date getCredentialsExpirationDate() {
		return credentialsExpirationDate;
	}

	public void setCredentialsExpirationDate(Date credentialsExpirationDate) {
		this.credentialsExpirationDate = credentialsExpirationDate;
	}

	/**
	 * Indica si el usuario esta bloqueado o no.
     * @see org.springframework.security.core.userdetails.UserDetails#isEnabled()
     */
    @Override
    public boolean isEnabled() {
	    return this.enabled;
    }
    
    /**
     * Setea si el usuario esta bloqueado o no.
     * @param enabled
     */
    public void setEnabled(Boolean enabled) {
	    this.enabled = enabled;
    }
    

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

}

