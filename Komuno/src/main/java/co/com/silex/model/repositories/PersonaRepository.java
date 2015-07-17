package co.com.silex.model.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import co.com.silex.model.entity.Persona;

public interface PersonaRepository extends CrudRepository<Persona, Long>{
	
	@Query(value = "SELECT p.*  "
			+ "FROM persona p, residente r, unidad_residencial ur "
			+ "WHERE r.unidad_residencial_id = ur.id "
			+ "AND r.persona_id = p.id "
			+ "AND ur.copropiedad_id = ?1"
			+ "", nativeQuery = true)
	List<Persona> findAllPersonasByCopropiedad(Long copropiedadId);

}
