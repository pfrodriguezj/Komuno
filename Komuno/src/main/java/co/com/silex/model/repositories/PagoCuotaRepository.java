package co.com.silex.model.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import co.com.silex.model.entity.PagoCuota;

public interface PagoCuotaRepository extends CrudRepository<PagoCuota, Long>{

	List<PagoCuota> findAllByUnidadIdOrderByAnyoDescMesDesc(Long unidadId);
	
	
	
}
