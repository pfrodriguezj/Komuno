package co.com.silex.controller;

import java.text.SimpleDateFormat;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import co.com.silex.model.entity.PagoCuota;
import co.com.silex.model.repositories.PagoCuotaRepository;

@Controller
@RequestMapping(value = "/protected/pago_cuota")
public class PagoCuotaController {


	@Autowired
	PagoCuotaRepository pagoRepo;
	
	@RequestMapping(value="/lst/{idUnidad}",  method = RequestMethod.GET)
    public @ResponseBody String copropiedadesLst(@PathVariable Long idUnidad) {
		String response = "";
		
		List<PagoCuota> pagos = pagoRepo.findAllByUnidadIdOrderByAnyoDescMesDesc(idUnidad);
		if(pagos != null && pagos.size() > 0){
			try {
				ObjectMapper objectMapper = new ObjectMapper();
				objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MMMM-dd"));
				String json = objectMapper.writeValueAsString(pagos);
				
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
