package co.com.silex.model.repositories;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import co.com.silex.model.entity.Ingreso;

public interface IngresoRepository extends CrudRepository<Ingreso, Long>{

	List<Ingreso> findAllByCopropiedadId(Long copropiedadId, String fechaInicio, String fechaFin);
	
	@Query(value = "SELECT sum(valor)  FROM ingreso WHERE id_copropiedad = ?1 AND fecha BETWEEN ?2 AND ?3", nativeQuery = true)
	BigDecimal sumIngresosByCopropiedadAndFechaBetweenFechaIniAndFechaFin(Long copropiedadId, String fechaInicio, String fechaFin);

	
}
