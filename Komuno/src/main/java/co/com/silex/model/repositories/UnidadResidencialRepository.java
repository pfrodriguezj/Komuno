package co.com.silex.model.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import co.com.silex.model.entity.UnidadResidencial;

public interface UnidadResidencialRepository extends CrudRepository<UnidadResidencial, Long>{

	List<UnidadResidencial> findAllByEdificioId(Long edificioId);
}
