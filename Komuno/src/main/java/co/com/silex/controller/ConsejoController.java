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
import co.com.silex.model.entity.Consejo;
import co.com.silex.model.repositories.ConsejoRepository;

@Controller
@RequestMapping(value = "/protected/consejo")
public class ConsejoController {

	@Autowired
	ConsejoRepository consejoRepo;
	
	@RequestMapping(value="/lst",  method = RequestMethod.GET)
    public @ResponseBody String copropiedadesLst(HttpSession session) {
		String response = "";
		
		CopropiedadDto cDto = (CopropiedadDto)session.getAttribute("copropiedad");
		List<Consejo> consejos = consejoRepo.findAllByCopropiedadId(cDto.getId());
		if(consejos  != null && consejos .size() > 0){
			try {
				String json = new ObjectMapper().writeValueAsString(consejos );
				response ="{\"aaData\":" + json + "}";
			} catch (Exception e) {
				response ="{\"aaData\":" + response + "}";
			}
		} else {
			response= "{\"aaData\":\"\"}";
		}
        return response;
    }
	
	@RequestMapping(value = "/ver/{idConsejo}", method = RequestMethod.GET)
    public ModelAndView copropiedadesVer(@PathVariable Long idConsejo, ModelMap model) {
		Consejo consejo = consejoRepo.findOne(idConsejo);
		model.put("consejo", consejo);
        return new ModelAndView("consejo","model",model);
    }


}
