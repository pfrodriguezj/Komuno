package co.com.silex.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import co.com.silex.dto.CopropiedadDto;
import co.com.silex.model.entity.Persona;
import co.com.silex.model.entity.Residente;
import co.com.silex.model.repositories.PersonaRepository;
import co.com.silex.model.repositories.ResidenteRepository;
import co.com.silex.model.repositories.UnidadResidencialRepository;

@Controller
@RequestMapping(value = "/protected/residente")
public class ResidenteController {

	@Autowired
	ResidenteRepository residenteRepo;
	
	@Autowired
	PersonaRepository personaRepo;

	@Autowired
	UnidadResidencialRepository urRepo;
	
	@RequestMapping(value="/lst/{idUnidad}",  method = RequestMethod.GET)
    public @ResponseBody String residenteLst(@PathVariable Long idUnidad) {
		String response = "";
		
		List<Residente> residentes = residenteRepo.findAllByUnidadId(idUnidad);
		if(residentes != null && residentes.size() > 0){
			try {
				String json = new ObjectMapper().writeValueAsString(residentes);
				response ="{\"aaData\":" + json + "}";
			} catch (Exception e) {
				response ="{\"aaData\":" + response + "}";
			}
		} else {
			response= "{\"aaData\":\"\"}";
		}
        return response;
    }

	@RequestMapping(value="/ver/{idResidente}",  method = RequestMethod.GET)
    public @ResponseBody String verResidente(HttpSession session, @PathVariable Long idResidente, ModelMap model) {
		
		Residente r = residenteRepo.findOne(idResidente);
		String response = "";
		if(r != null){
			try {
				String json = new ObjectMapper().writeValueAsString(r);
				response =json;
			} catch (Exception e) {
				response = "";
			}
		} else {
			response= "";
		}
        return response;
    }

}
