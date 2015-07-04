package co.com.silex.controller;

import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import co.com.silex.model.entity.Residente;
import co.com.silex.model.repositories.ResidenteRepository;

@Controller
@RequestMapping(value = "/protected/residente")
public class ResidenteController {

	@Autowired
	ResidenteRepository residenteRepo;
	
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

}
