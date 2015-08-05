package co.com.silex.model.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import co.com.silex.model.entity.Residente;

public interface ResidenteRepository extends CrudRepository<Residente, Long>{

	List<Residente> findAllByUnidadId(Long unidadId);
	
	List<Residente> findAllByResidenteIdAndUnidadCopropiedadId(Long personaId, Long copropiedadId);
}
