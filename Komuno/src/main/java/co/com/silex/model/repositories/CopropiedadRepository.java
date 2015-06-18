package co.com.silex.model.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import co.com.silex.model.entity.Copropiedad;

public interface CopropiedadRepository extends CrudRepository<Copropiedad, Long>{

	List<Copropiedad> findByAdministradorId(Long adminId);
	
}
