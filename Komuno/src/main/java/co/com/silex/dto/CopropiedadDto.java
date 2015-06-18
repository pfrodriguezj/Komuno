package co.com.silex.dto;


import co.com.silex.model.entity.User;

public class CopropiedadDto {

	private Long id;

	private String nombre;
	
	private String nit;
	
	private UserDto administrador;

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

	public UserDto getAdministrador() {
		return administrador;
	}

	public void setAdministrador(UserDto administrador) {
		this.administrador = administrador;
	}
	

}
