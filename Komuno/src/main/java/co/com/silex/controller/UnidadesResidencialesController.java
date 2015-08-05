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
import co.com.silex.model.entity.PagoCuota;
import co.com.silex.model.entity.Persona;
import co.com.silex.model.entity.Residente;
import co.com.silex.model.entity.UnidadResidencial;
import co.com.silex.model.repositories.PagoCuotaRepository;
import co.com.silex.model.repositories.PersonaRepository;
import co.com.silex.model.repositories.ResidenteRepository;
import co.com.silex.model.repositories.UnidadResidencialRepository;
import co.com.silex.util.AppListUtil;

@Controller
@RequestMapping(value = "/protected/unidades_residenciales")
public class UnidadesResidencialesController {

	@Autowired
	UnidadResidencialRepository unidadRepo;

	@Autowired
	PagoCuotaRepository pagoCuotaRepo;
	
	@Autowired
	ResidenteRepository residenteRepo;

	@Autowired
	PersonaRepository personaRepo;
	

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
    public ModelAndView unidadVer(HttpSession session, @PathVariable Long idUnidad, ModelMap model) {
		
		CopropiedadDto cDto = (CopropiedadDto)session.getAttribute("copropiedad");
		
		UnidadResidencial ur = unidadRepo.findOne(idUnidad);
		List<PagoCuota> listPagos = pagoCuotaRepo.findAllByUnidadIdOrderByAnyoDescMesDesc(cDto.getId());
		
		Persona p = new Persona();
		
		model.put("residente", p);
		model.put("unidad", ur);
		model.put("pagos", listPagos);
		model.put("listTipoDocumento", AppListUtil.getLista("tipoDocumento"));
        return new ModelAndView("unidadResidencial","model",model);
    }

	@RequestMapping(value="/save_residente/{idUnidad}",  method = RequestMethod.POST)
    public ModelAndView saveResidente(ModelMap model, HttpSession session, @ModelAttribute("residente") Persona nuevoResidente, @PathVariable Long idUnidad) {
		
		CopropiedadDto cDto = (CopropiedadDto)session.getAttribute("copropiedad");
		
		/*
		 * 1. Verificar si existe la persona (por tipo y numero de documento)
		 * 1.1 si no existe, crearla
		 * 1.2 si existe, actualizar los datos
		 * 2. Verificar si existe el residente (por el id de la persona asociado a la unidad)
		 */

		if(nuevoResidente != null && nuevoResidente.getTipoDocumento() != null && nuevoResidente.getDocumento() != null){
			
			Persona p = personaRepo.findByTipoDocumentoAndDocumento(nuevoResidente.getTipoDocumento(), nuevoResidente.getDocumento());
			if(p!=null){
				personaRepo.save(p);
				//Es posible que una persona resida en más de 1 unidad residencial del conjunto, en este caso, hay que informar y preguntar
				//TODO: mostrar la lista de residentes del conjunto que coinciden con el tipo y numero de documento en el modal de registro de residentes de la unidad
				//residenteRepo.findAllByResidenteIdAndUnidadCopropiedadId(p.getId(), cDto.getId());
				Residente r = new Residente();
				r.setResidente(p);
				r.setUnidad(unidadRepo.findOne(idUnidad));
				residenteRepo.save(r);
			} else {
				personaRepo.save(nuevoResidente);
				Residente r = new Residente();
				r.setResidente(nuevoResidente);
				r.setUnidad(unidadRepo.findOne(idUnidad));
				residenteRepo.save(r);
			}
		}
		
		/*
		nuevoItem.setCopropiedad(copropiedadRepo.findOne(cDto.getId()));
		itemPresupuestoRepo.save(nuevoItem);
		*/
		return unidadVer(session, idUnidad, model);
    }

	
}
