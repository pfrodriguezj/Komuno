package co.com.silex.model.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import co.com.silex.dto.UserDto;


@Entity
@Table(name = "user", schema="komuno")
public class User {

	@Id
	@Column(name = "id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "username", unique = true, nullable = false, length = 45)
	private String username;
	
	@Column(name = "password", nullable = false, length = 45)
	private String password;
	
	@Column(name = "name", nullable = false, length = 255)
	private String name;
	
	@Column(name = "email", nullable = false, length = 255)
	private String email;
	
	@Column(name = "enabled", nullable = false)
	private String enabled;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "inserted", nullable = true, length = 29)
	private Date inserted;
	
	@Column(name = "deleted", nullable = true)
	private Date deleted;
	
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = { @JoinColumn(name = "role_id") })
	private Set<Role> roles = new HashSet<Role>(0);
	
	@Column(name = "credentials_expiration_date", nullable = true)
	private Date credentialsExpirationDate;

	/*
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    private Set<RecoveryToken> recoveryTokens = new HashSet<RecoveryToken>(0);
	*/
    @Column(name = "failed_logins", nullable = false)
	private Integer failedLogins;

    /*
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "usuario", optional=true)
    private UsuarioDetalle usuarioDetalle;
    */
    public User(){
    	System.out.println();
    }
    
    public User(Long id, String username, String password, String name, String email, String enabled, Date inserted, Date deleted,
            Set<Role> roles, /*Set<RecoveryToken> recoveryTokens,*/ Integer failedLogins) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.name = name;
		this.email = email;
		//this.recoveryTokens = recoveryTokens;
		this.failedLogins = failedLogins;
		this.enabled = enabled;
		this.inserted = inserted;
		this.deleted = deleted;
		this.roles = roles;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEnabled() {
		return this.enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public Date getInserted() {
		return this.inserted;
	}

	public void setInserted(Date inserted) {
		this.inserted = inserted;
	}

	public Date getDeleted() {
		return this.deleted;
	}

	public void setDeleted(Date deleted) {
		this.deleted = deleted;
	}

	public Set<Role> getRoles() {
		return this.roles;
	}

	public void setRoles(
			Set<Role> roles) {
		this.roles = roles;
	}

	/*
	public Set<RecoveryToken> getRecoveryTokens() {
		return this.recoveryTokens;
	}

	public void setRecoveryTokens(
			Set<RecoveryToken> recoveryTokens) {
		this.recoveryTokens = recoveryTokens;
	}
	*/

    public Integer getFailedLogins() {
		return failedLogins;
	}

	public void setFailedLogins(Integer failedLogins) {
		this.failedLogins = failedLogins;
	}
	
	public Date getCredentialsExpirationDate() {
		return credentialsExpirationDate;
	}

	public void setCredentialsExpirationDate(Date credentialsExpirationDate) {
		this.credentialsExpirationDate = credentialsExpirationDate;
	}
	
	/*
	public UsuarioDetalle getUsuarioDetalle() {
		return usuarioDetalle;
	}

	public void setUsuarioDetalle(UsuarioDetalle usuarioDetalle) {
		this.usuarioDetalle = usuarioDetalle;
	}
	*/

	@Transient
	public boolean containsRole(String role){
		for (Role r : this.getRoles()){
			if (r.getRole().equals(role));
			return true;
		}
		return false;
		
	}

	@Transient
	public boolean containsAuthority(String authority){
		for (Authority r : this.getAuthorities()){
			if (r.getAuthority().equals(authority))
				return true;
		}
		return false;
	}
	
	@Transient
	public Set<Authority> getAuthorities(){
		Set<Authority> set = new HashSet<>();
		for (Role r : this.getRoles()){
			for (Authority authority : r.getAuthorities()) {
				if(!set.contains(authority)){
					set.add(authority);
				}
			}
		}
		return set;
	}
	
	public UserDto toDto() {
		UserDto dto = new UserDto();
		dto.setId(this.id);
		dto.setUsername(username);
		dto.setName(this.name);
		dto.setEmail(email);
		dto.setEnabled(enabled);
		return dto;
	}

}
