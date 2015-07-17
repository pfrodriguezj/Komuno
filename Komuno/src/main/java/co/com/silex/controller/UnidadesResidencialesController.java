package co.com.silex.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import co.com.silex.dto.CopropiedadDto;
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
    public @ResponseBody String unidadesLst(HttpSession session) {
		String response = "";
		
		CopropiedadDto cDto = (CopropiedadDto)session.getAttribute("copropiedad");
		
		List<UnidadResidencial> unidades = unidadRepo.findAllByCopropiedadId(cDto.getId());
		
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
    public ModelAndView copropiedadesVer(HttpSession session, @PathVariable Long idUnidad, ModelMap model) {
		
		CopropiedadDto cDto = (CopropiedadDto)session.getAttribute("copropiedad");
		
		UnidadResidencial ur = unidadRepo.findOne(idUnidad);
		List<PagoCuota> listPagos = pagoCuotaRepo.findAllByUnidadIdOrderByAnyoDescMesDesc(cDto.getId());
		
		
		
		model.put("unidad", ur);
		model.put("pagos", listPagos);
        return new ModelAndView("unidadResidencial","model",model);
    }


	
}
