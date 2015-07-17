package co.com.silex.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import co.com.silex.dto.CopropiedadDto;
import co.com.silex.model.entity.Persona;
import co.com.silex.model.repositories.PersonaRepository;

@Controller
@RequestMapping(value = "/protected/persona")
public class PersonaController {

	@Autowired
	PersonaRepository personaRepo;
	
	@RequestMapping(value="/lst_copropiedad",  method = RequestMethod.GET)
    public @ResponseBody String residenteLst(HttpSession session) {
		String response = "";
		
		CopropiedadDto cDto = (CopropiedadDto)session.getAttribute("copropiedad");
		List<Persona> personas = personaRepo.findAllPersonasByCopropiedad(cDto.getId());
		if(personas!= null && personas.size() > 0){
			try {
				String json = new ObjectMapper().writeValueAsString(personas);
				response ="{\"aaData\":" + json + "}";
			} catch (Exception e) {
				response ="{\"aaData\":" + response + "}";
			}
		} else {
			response= "{\"aaData\":\"\"}";
		}
        return response;
    }

	
	@RequestMapping(value = "/personas_page", method = RequestMethod.GET)
    public ModelAndView verP(ModelMap model) {
		Persona p = new Persona();
		
		model.put("persona",p);

        return new ModelAndView("personas","model",model);
    }

}
