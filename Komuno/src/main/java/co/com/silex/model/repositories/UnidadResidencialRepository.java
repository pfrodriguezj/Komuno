package co.com.silex.model.repositories;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import co.com.silex.model.entity.UnidadResidencial;

public interface UnidadResidencialRepository extends CrudRepository<UnidadResidencial, Long>{

	List<UnidadResidencial> findAllByEdificioId(Long edificioId);
	
	@Query(value = "SELECT sum(valor_cuota)  FROM unidad_residencial WHERE edificio_id = ?1", nativeQuery = true)
	BigDecimal sumCoutasByEdificio(Long copropiedadId);

	@Query(value = "SELECT sum(estado_cuenta)  FROM unidad_residencial WHERE edificio_id = ?1", nativeQuery = true)
	BigDecimal sumEstadosCuentaByEdificio(Long copropiedadId);

}
