package co.com.silex.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;

import co.com.silex.dto.CopropiedadDto;
import co.com.silex.dto.UserDto;

@Entity
@Table(name="copropiedad", schema="komuno")
public class Copropiedad {
	
	@Id
	@Column(name = "id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nombre", nullable = false, length = 255)
	private String nombre;
	
	@Column(name = "nit", nullable = false, length = 255)
	private String nit;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "administrador", nullable = false)
	@ForeignKey(name = "FK_copropiedad_usuario")
	private User administrador;
	
	


	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public String getNombre() {
		return nombre;
	}




	public void setNombre(String nombre) {
		this.nombre = nombre;
	}




	public String getNit() {
		return nit;
	}




	public void setNit(String nit) {
		this.nit = nit;
	}




	public User getAdministrador() {
		return administrador;
	}




	public void setAdministrador(User administrador) {
		this.administrador = administrador;
	}




	public CopropiedadDto toDto(){
		CopropiedadDto cDto = new CopropiedadDto();
		cDto.setId(id);
		cDto.setNombre(nombre);
		cDto.setNit(nit);
		cDto.setAdministrador(cDto.getAdministrador());
		return cDto;
	}

}
