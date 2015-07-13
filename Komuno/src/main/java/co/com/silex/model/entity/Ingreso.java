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
@Table(name="ingreso", schema="komuno")
public class Ingreso {

	@Id
	@Column(name = "id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "concepto", nullable = true)
	private String concepto;
	
	@Column(name = "valor", nullable = true)
	private Double valor;
	
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Column(name = "fecha",  nullable = true)
	private Date fecha;

	@Column(name = "comprobante", nullable = true)
	private String comprobante;
	
	@Column(name = "pagado_a", nullable = true)
	private String recibidoPor;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "id_ingreso_presupuesto", nullable = false)
	@ForeignKey(name = "FK_ingreso_ingreso_presupuesto")
	private IngresoPresupuesto ingresoPresupuesto;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "id_copropiedad", nullable = false)
	@ForeignKey(name = "FK_ingreso_copropiedad")
	private Copropiedad copropiedad;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getConcepto() {
		return concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getComprobante() {
		return comprobante;
	}

	public void setComprobante(String comprobante) {
		this.comprobante = comprobante;
	}

	public String getRecibidoPor() {
		return recibidoPor;
	}

	public void setRecibidoPor(String recibidoPor) {
		this.recibidoPor = recibidoPor;
	}

	public IngresoPresupuesto getIngresoPresupuesto() {
		return ingresoPresupuesto;
	}

	public void setIngresoPresupuesto(IngresoPresupuesto ingresoPresupuesto) {
		this.ingresoPresupuesto = ingresoPresupuesto;
	}

	public Copropiedad getCopropiedad() {
		return copropiedad;
	}

	public void setCopropiedad(Copropiedad copropiedad) {
		this.copropiedad = copropiedad;
	}
}
