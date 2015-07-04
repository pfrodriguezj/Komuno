package co.com.silex.model.repositories;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import co.com.silex.model.entity.PagoCuota;

public interface PagoCuotaRepository extends CrudRepository<PagoCuota, Long>{

	List<PagoCuota> findAllByUnidadIdOrderByAnyoDescMesDesc(Long unidadId);
	
	@Query(value = "SELECT sum(valor)  FROM pago_cuota WHERE unidad_id = ?1", nativeQuery = true)
	BigDecimal sumPagosCuotaByUnidadAndMes(Long unidadId);

	
}
