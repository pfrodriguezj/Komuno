package co.com.silex.model.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import co.com.silex.model.entity.Consejo;

public interface ConsejoRepository extends CrudRepository<Consejo, Long>{

	List<Consejo> findAllByCopropiedadId(Long copropiedadId);
}
