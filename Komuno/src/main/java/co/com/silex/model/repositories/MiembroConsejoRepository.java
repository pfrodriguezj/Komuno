package co.com.silex.model.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import co.com.silex.model.entity.MiembroConsejo;

public interface MiembroConsejoRepository extends CrudRepository<MiembroConsejo, Long>{

	List<MiembroConsejo> findAllByConsejoId(Long consejoId);
}
