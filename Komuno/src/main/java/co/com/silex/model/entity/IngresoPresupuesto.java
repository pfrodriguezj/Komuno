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
@Table(name="ingreso_presupuesto", schema="komuno")
public class IngresoPresupuesto {

	@Id
	@Column(name = "id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "copropiedad_id", nullable = false)
	@ForeignKey(name = "FK_gasto_presupuesto_copropiedad")
	private Copropiedad copropiedad;
	
	@Column(name = "concepto", nullable = true)
	private String concepto;
	
	@Column(name = "periodicidad", nullable = true)
	private String periodicidad;
	
	@Column(name = "valor_previsto", nullable = true)
	private Double valorPrevisto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Copropiedad getCopropiedad() {
		return copropiedad;
	}

	public void setCopropiedad(Copropiedad copropiedad) {
		this.copropiedad = copropiedad;
	}

	public String getConcepto() {
		return concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	public String getPeriodicidad() {
		return periodicidad;
	}

	public void setPeriodicidad(String periodicidad) {
		this.periodicidad = periodicidad;
	}

	public Double getValorPrevisto() {
		return valorPrevisto;
	}

	public void setValorPrevisto(Double valorPrevisto) {
		this.valorPrevisto = valorPrevisto;
	}
}
