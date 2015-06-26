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

@Entity
@Table(name="unidad_residencial", schema="komuno")
public class UnidadResidencial {

	@Id
	@Column(name = "id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "edificio_id", nullable = false)
	@ForeignKey(name = "FK_unidad_residencial_copropiedad")
	private Copropiedad edificio;
	
	@Column(name = "nombre_unidad", nullable = false, length = 255)
	private String nombreUnidad;
	
	@Column(name = "estado_cuenta_inicial", nullable = true)
	private Double estadoCuentaInicial;

	@Column(name = "estado_cuenta", nullable = true)
	private Double estadoCuenta;

	@Column(name = "valor_cuota", nullable = true)
	private Double valorCuota;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "propietario_id", nullable = true)
	@ForeignKey(name = "FK_unidad_residencial_propietario")
	private Persona propietario;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Copropiedad getEdificio() {
		return edificio;
	}

	public void setEdificio(Copropiedad edificio) {
		this.edificio = edificio;
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
		return estadoCuentaInicial;
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

	public Persona getPropietario() {
		return propietario;
	}

	public void setPropietario(Persona propietario) {
		this.propietario = propietario;
	}
	
	
}
