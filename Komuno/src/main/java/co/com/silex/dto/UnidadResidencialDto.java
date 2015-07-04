package co.com.silex.dto;

import co.com.silex.model.entity.Copropiedad;
import co.com.silex.model.entity.Persona;

public class UnidadResidencialDto {

	
	private Long id;

	private String nombreUnidad;
	
	private Double estadoCuentaInicial;

	private Double estadoCuenta;

	private Double valorCuota;
	
	private PersonaDto propietario;
	
	private CopropiedadDto copropiedadDto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreUnidad() {
		return nombreUnidad;
	}

	public void setNombreUnidad(String nombreUnidad) {
		this.nombreUnidad = nombreUnidad;
	}

	public Double getEstadoCuentaInicial() {
		return estadoCuentaInicial;
	}

	public void setEstadoCuentaInicial(Double estadoCuentaInicial) {
		this.estadoCuentaInicial = estadoCuentaInicial;
	}

	public Double getEstadoCuenta() {
		return estadoCuenta;
	}

	public void setEstadoCuenta(Double estadoCuenta) {
		this.estadoCuenta = estadoCuenta;
	}

	public Double getValorCuota() {
		return valorCuota;
	}

	public void setValorCuota(Double valorCuota) {
		this.valorCuota = valorCuota;
	}

	public PersonaDto getPropietario() {
		return propietario;
	}

	public void setPropietario(PersonaDto propietario) {
		this.propietario = propietario;
	}

	public CopropiedadDto getCopropiedadDto() {
		return copropiedadDto;
	}

	public void setCopropiedadDto(CopropiedadDto copropiedadDto) {
		this.copropiedadDto = copropiedadDto;
	}
	
	

}
