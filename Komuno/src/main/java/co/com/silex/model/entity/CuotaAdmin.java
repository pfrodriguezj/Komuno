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
@Table(name="cuota_admin", schema="komuno")
public class CuotaAdmin {

	@Id
	@Column(name = "id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "unidad_id", nullable = false)
	@ForeignKey(name = "FK_cuota_unidad")
	private UnidadResidencial unidad;

	/**
	 * Mes de la cuota 
	 */
	@Column(name = "mes",  nullable = true)
	private Long mes;
	
	/**
	 * Año de la cuota
	 */
	@Column(name = "anyo",  nullable = true)
	private Long anyo;
	
	/**
	 * Valor de la cuota
	 */
	@Column(name = "valor",  nullable = true)
	private Double valor;
	
	/**
	 * Número de recibo
	 */
	@Column(name = "recibo",  nullable = true)
	private String recibo;

	/**
	 * Campo que indica si la cuota fue cubierta totalmente por algún pago
	 */
	@Column(name = "cubierta",  nullable = true)
	private String cubierta;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UnidadResidencial getUnidad() {
		return unidad;
	}

	public void setUnidad(UnidadResidencial unidad) {
		this.unidad = unidad;
	}

	public Long getMes() {
		return mes;
	}

	public void setMes(Long mes) {
		this.mes = mes;
	}

	public Long getAnyo() {
		return anyo;
	}

	public void setAnyo(Long anyo) {
		this.anyo = anyo;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getRecibo() {
		return recibo;
	}

	public void setRecibo(String recibo) {
		this.recibo = recibo;
	}

	public String getCubierta() {
		return cubierta;
	}

	public void setCubierta(String cubierta) {
		this.cubierta = cubierta;
	}
}