package co.com.silex.model.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
@Table(name = "role", schema="komuno")
public class Role {

	private Integer id;
	private Date inserted;
	private String deleted;
	private String role;

	/**
	 * Usuarios que tienen el rol 
	 */
	private List<User> users;
	
	/**
	 * Autorithies de este rol
	 */
	private List<Authority> authorities;
	

	public Role() {
	}

	public Role(Integer id, 
			Date inserted, String deleted, String role) {
		this.id = id;
		this.inserted = inserted;
		this.deleted = deleted;
		this.role = role;
	}

	@Id
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	
	public void setId(Integer id) {
		this.id = id;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "inserted", nullable = false, length = 29)
	public Date getInserted() {
		return this.inserted;
	}

	public void setInserted(Date inserted) {
		this.inserted = inserted;
	}

	@Column(name = "deleted", nullable = false)
	public String getDeleted() {
		return this.deleted;
	}

	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}

	@Column(name = "role", unique = true, nullable = false, length = 30)
	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	/**
	 * Devuelve los authorities del rol
	 * @return lista de authorities
	 */
	@ManyToMany(fetch= FetchType.EAGER)
	@JoinTable(name = "role_authority",  
			joinColumns = { @JoinColumn(name = "role_id") }, 
			inverseJoinColumns = { @JoinColumn(name = "authority_id") })
	public List<Authority> getAuthorities() {
		return (this.authorities);
	}

	/**
	 * Asigna una lista de authorities al rol
	 * @param authorities 
	 */
	public void setAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
	}
	
	public void addAuthority(Authority authority){
		if(this.authorities != null){
			this.authorities.add(authority);
		} else {
			this.authorities = new ArrayList<Authority>();
			this.authorities.add(authority);
		}
	}
	
	
	
	/**
	 * Devuelve la lista de usuarios que tienen el rol
	 * @return El valor de users.
	 */
	@ManyToMany
	@JoinTable(name = "user_role",  
			joinColumns = { @JoinColumn(name = "role_id") }, 
			inverseJoinColumns = { @JoinColumn(name = "user_id") })
	public List<User> getUsers() {
		return (this.users);
	}

	/**
	 * Asigna una lista de usuarios al rol
	 * @param 
	 */
	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	/*
	public RoleDto toDto(){
	    RoleDto dto = new RoleDto();
	    dto.setId(id);
	    dto.setDescripcion(role);
	    return dto;
	}
	*/

}
