package co.com.silex.controller;

import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import co.com.silex.model.entity.MiembroConsejo;
import co.com.silex.model.repositories.MiembroConsejoRepository;

@Controller
@RequestMapping(value = "/protected/miembro_consejo")
public class MiembroConsejoController {

	@Autowired
	MiembroConsejoRepository mcRepo;
	
	@RequestMapping(value="/lst/{consejoId}",  method = RequestMethod.GET)
    public @ResponseBody String miembrosConsejoLst(@PathVariable Long consejoId) {
		String response = "";
		
		List<MiembroConsejo> miembrosConsejo = mcRepo.findAllByConsejoId(consejoId);
		if(miembrosConsejo != null && miembrosConsejo.size() > 0){
			try {
				String json = new ObjectMapper().writeValueAsString(miembrosConsejo);
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
