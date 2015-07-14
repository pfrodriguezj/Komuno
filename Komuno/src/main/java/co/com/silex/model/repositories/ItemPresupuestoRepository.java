package co.com.silex.model.repositories;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import co.com.silex.model.entity.ItemPresupuesto;

public interface ItemPresupuestoRepository extends CrudRepository<ItemPresupuesto, Long>{

	List<ItemPresupuesto> findAllByCopropiedadId(Long copropiedadId);

	@Query(value = "SELECT sum(valor_previsto)  FROM item_presupuesto WHERE copropiedad_id = ?1 AND tipo_item = 'G'", nativeQuery = true)
	BigDecimal sumGastosPresupuestoByCopropiedad(Long copropiedadId);

	@Query(value = "SELECT sum(valor_previsto)  FROM item_presupuesto WHERE copropiedad_id = ?1 AND tipo_item = 'I'", nativeQuery = true)
	BigDecimal sumIngresosPresupuestoByCopropiedad(Long copropiedadId);

}
