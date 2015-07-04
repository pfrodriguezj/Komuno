package co.com.silex.controller;

import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import co.com.silex.model.entity.Consejo;
import co.com.silex.model.entity.GastoPresupuesto;
import co.com.silex.model.repositories.GastoPresupuestoRepository;

@Controller
@RequestMapping(value = "/protected/gasto_presupuesto")
public class GastoPresupuestoController {

	@Autowired
	GastoPresupuestoRepository gastoPresupuestoRepo;
	
	@RequestMapping(value="/lst/{copropiedadId}",  method = RequestMethod.GET)
    public @ResponseBody String copropiedadesLst(@PathVariable Long copropiedadId) {
		String response = "";
		
		List<GastoPresupuesto> gastosPresupuesto = gastoPresupuestoRepo.findAllByCopropiedadId(copropiedadId);
		if(gastosPresupuesto != null && gastosPresupuesto.size() > 0){
			try {
				String json = new ObjectMapper().writeValueAsString(gastosPresupuesto);
				response ="{\"aaData\":" + json + "}";
			} catch (Exception e) {
				response ="{\"aaData\":" + response + "}";
			}
		} else {
			response= "{\"aaData\":\"\"}";
		}
        return response;
    }

}
