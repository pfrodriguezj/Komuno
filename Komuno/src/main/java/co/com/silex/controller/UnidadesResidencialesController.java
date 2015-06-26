package co.com.silex.controller;

import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import co.com.silex.model.entity.PagoCuota;
import co.com.silex.model.entity.UnidadResidencial;
import co.com.silex.model.repositories.PagoCuotaRepository;
import co.com.silex.model.repositories.ResidenteRepository;
import co.com.silex.model.repositories.UnidadResidencialRepository;

@Controller
@RequestMapping(value = "/protected/unidades_residenciales")
public class UnidadesResidencialesController {

	@Autowired
	UnidadResidencialRepository unidadRepo;

	@Autowired
	PagoCuotaRepository pagoCuotaRepo;

	@RequestMapping(value="/lst",  method = RequestMethod.GET)
    public @ResponseBody String copropiedadesLst() {
		String response = "";
		
		//List<Copropiedad> copropiedades = cRepo.findByAdministradorId(1L);
		List<UnidadResidencial> unidades = unidadRepo.findAllByEdificioId(1L);
		if(unidades != null && unidades.size() > 0){
			try {
				String json = new ObjectMapper().writeValueAsString(unidades);
				response ="{\"aaData\":" + json + "}";
			} catch (Exception e) {
				response ="{\"aaData\":" + response + "}";
			}
		} else {
			response= "{\"aaData\":\"\"}";
		}
        return response;
    }

	@RequestMapping(value = "/ver/{idUnidad}", method = RequestMethod.GET)
    public ModelAndView copropiedadesVer(@PathVariable Long idUnidad, ModelMap model) {
		UnidadResidencial ur = unidadRepo.findOne(idUnidad);
		List<PagoCuota> listPagos = pagoCuotaRepo.findAllByUnidadIdOrderByAnyoDescMesDesc(idUnidad);
		
		model.put("unidad", ur);
		model.put("pagos", listPagos);
        return new ModelAndView("unidadResidencial","model",model);
    }

	
}
