package co.com.silex.model.repositories;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import co.com.silex.model.entity.IngresoPresupuesto;

public interface IngresoPresupuestoRepository  extends CrudRepository<IngresoPresupuesto, Long>{

	List<IngresoPresupuesto> findAllByCopropiedadId(Long copropiedadId);

	@Query(value = "SELECT sum(valor_previsto)  FROM ingreso_presupuesto WHERE copropiedad_id = ?1", nativeQuery = true)
	BigDecimal sumIngresoPresupuestoByCopropiedad(Long copropiedadId);

}
