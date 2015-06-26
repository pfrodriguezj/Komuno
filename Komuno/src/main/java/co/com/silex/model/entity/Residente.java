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
@Table(name="persona", schema="komuno")
public class Residente {

	@Id
	@Column(name = "id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "unidad_residencial_id", nullable = false)
	@ForeignKey(name = "FK_residente_unidad")
	private UnidadResidencial unidad;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "persona_id", nullable = false)
	@ForeignKey(name = "FK_residente_persona")
	private Persona residente;

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

	public Persona getResidente() {
		return residente;
	}

	public void setResidente(Persona residente) {
		this.residente = residente;
	}
}
