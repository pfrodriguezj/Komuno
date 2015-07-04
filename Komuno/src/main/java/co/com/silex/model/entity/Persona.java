package co.com.silex.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import co.com.silex.dto.PersonaDto;

@Entity
@Table(name="persona", schema="komuno")
public class Persona {

	@Id
	@Column(name = "id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nombre", nullable = false, length = 255)
	private String nombre;

	@Column(name = "tipo_documento", nullable = true)
	private Long tipoDocumento;

	@Column(name = "documento", nullable = true, length = 45)
	private String documento;

	@Column(name = "telefono", nullable = true, length = 45)
	private String telefono;

	@Column(name = "email", nullable = true, length = 255)
	private String email;

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

	public Long getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(Long tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public PersonaDto toDto(){
		PersonaDto pDto = new PersonaDto();
		pDto.setId(id);
		pDto.setDocumento(documento);
		pDto.setEmail(email);
		pDto.setNombre(nombre);
		pDto.setTelefono(telefono);
		pDto.setTipoDocumento(tipoDocumento);
		return pDto;
	}
	

}
