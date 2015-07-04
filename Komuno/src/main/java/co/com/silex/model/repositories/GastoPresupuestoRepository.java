package co.com.silex.model.repositories;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import co.com.silex.model.entity.GastoPresupuesto;

public interface GastoPresupuestoRepository extends CrudRepository<GastoPresupuesto, Long>{

	List<GastoPresupuesto> findAllByCopropiedadId(Long copropiedadId);

	@Query(value = "SELECT sum(valor_previsto)  FROM gasto_presupuesto WHERE copropiedad_id = ?1", nativeQuery = true)
	BigDecimal sumPresupuestoByCopropiedad(Long copropiedadId);

}
