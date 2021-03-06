package co.com.silex.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.core.context.SecurityContextHolder;
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
import co.com.silex.model.repositories.ItemPresupuestoRepository;
import co.com.silex.model.repositories.UnidadResidencialRepository;
import co.com.silex.security.SilexUserDetails;
import co.com.silex.util.AppListUtil;

@Controller
@RequestMapping(value = "/protected/copropiedades")
public class CopropiedadesController {

	@Autowired
	CopropiedadRepository cRepo;
	
	@Autowired
	UnidadResidencialRepository unidadRepo;
	
	@Autowired
	ItemPresupuestoRepository itemRepo;
	
	@RequestMapping(method = RequestMethod.GET)
    public ModelAndView copropiedadesPage() {
		
        return new ModelAndView("copropiedades");
    }
	
	@RequestMapping(value="/lst",  method = RequestMethod.GET)
    public @ResponseBody String copropiedadesLst() {
		String response = "";
		
		SilexUserDetails user = (SilexUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		List<Copropiedad> copropiedades = cRepo.findByAdministradorId(user.getId());
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
    public ModelAndView copropiedadesVer(@PathVariable Long idCopropiedad, ModelMap model, HttpSession session) {
		Copropiedad cop = cRepo.findOne(idCopropiedad);
		
		if(cop != null){
		
			CopropiedadDto copDto = cop.toDto();
	
			session.setAttribute("copropiedad", copDto);
			
			model.put("copropiedad", copDto);
			
			BigDecimal sumCuotas = unidadRepo.sumCoutasByCopropiedad(idCopropiedad);
			model.put("cuotasTotales",sumCuotas !=null?sumCuotas.doubleValue():0);
			
			BigDecimal sumCuotasMora = unidadRepo.sumEstadosCuentaByCopropiedad(idCopropiedad);
			model.put("cuotasMora", sumCuotasMora!=null?sumCuotasMora.doubleValue():0);
			
			BigDecimal sumPresupuesto = itemRepo.sumGastosPresupuestoByCopropiedad(idCopropiedad);
			model.put("sumPresupuesto", sumPresupuesto!=null?sumPresupuesto.doubleValue():0);
	
			BigDecimal sumPagosMes = itemRepo.sumIngresosPresupuestoByCopropiedad(idCopropiedad);
			model.put("sumPresupuesto", sumPresupuesto!=null?sumPresupuesto.doubleValue():0);
			
		}

        return new ModelAndView("copropiedad","model",model);
    }
	
	@RequestMapping(value = "/ver_unidades", method = RequestMethod.GET)
    public ModelAndView verUnidades(ModelMap model) {
        return new ModelAndView("unidades","model",model);
    }

	@RequestMapping(value = "/ver_consejos", method = RequestMethod.GET)
    public ModelAndView verConsejos(ModelMap model) {
        return new ModelAndView("consejos","model",model);
    }

}
