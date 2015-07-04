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
@Table(name="miembro_consejo", schema="komuno")
public class MiembroConsejo {

	@Id
	@Column(name = "id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "consejo_id", nullable = false)
	@ForeignKey(name = "FK_miembro_consejo_consejo")
	private Consejo consejo;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "persona_id", nullable = false)
	@ForeignKey(name = "FK_miemebro_consejo_persona")
	private Persona persona;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Consejo getConsejo() {
		return consejo;
	}

	public void setConsejo(Consejo consejo) {
		this.consejo = consejo;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}
}