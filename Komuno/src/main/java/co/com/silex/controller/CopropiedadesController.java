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

import co.com.silex.dto.CopropiedadDto;
import co.com.silex.model.entity.Copropiedad;
import co.com.silex.model.repositories.CopropiedadRepository;

@Controller
@RequestMapping(value = "/protected/copropiedades")
public class CopropiedadesController {

	@Autowired
	CopropiedadRepository cRepo;
	
	@RequestMapping(method = RequestMethod.GET)
    public ModelAndView copropiedadesPage() {
		
        return new ModelAndView("copropiedades");
    }
	
	@RequestMapping(value="/lst",  method = RequestMethod.GET)
    public @ResponseBody String copropiedadesLst() {
		String response = "";
		
		List<Copropiedad> copropiedades = cRepo.findByAdministradorId(1L);
		if(copropiedades != null && copropiedades.size() > 0){
			try {
				String json = new ObjectMapper().writeValueAsString(copropiedades);
				response ="{\"aaData\":" + json + "}";
			} catch (Exception e) {
				response ="{\"aaData\":" + response + "}";
			}
		} else {
			response= "{\"aaData\":\"\"}";
		}
        return response;
    }
	
	@RequestMapping(value = "/ver/{idCopropiedad}", method = RequestMethod.GET)
    public ModelAndView copropiedadesVer(@PathVariable Long idCopropiedad, ModelMap model) {
		Copropiedad cop = cRepo.findOne(idCopropiedad);
		CopropiedadDto copDto = cop.toDto();
		model.put("copropiedad", copDto);
        return new ModelAndView("copropiedad","model",model);
    }
	

}
