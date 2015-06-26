package co.com.silex.model.entity;

import java.util.Date;

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
import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="pago_cuota", schema="komuno")
public class PagoCuota {

	@Id
	@Column(name = "id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "unidad_id", nullable = false)
	@ForeignKey(name = "FK_pago_cuota_unidad")
	private UnidadResidencial unidad;
	
	@Column(name = "mes",  nullable = true)
	private Long mes;
	
	@Column(name = "anyo",  nullable = true)
	private Long anyo;
	
	@Column(name = "valor",  nullable = true)
	private Double valor;
	
	@Column(name = "comprobante",  nullable = true)
	private String comprobante;

	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Column(name = "fecha_pago",  nullable = true)
	private Date fechaPago;

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

	public String getComprobante() {
		return comprobante;
	}

	public void setComprobante(String comprobante) {
		this.comprobante = comprobante;
	}

	public Date getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}
}
