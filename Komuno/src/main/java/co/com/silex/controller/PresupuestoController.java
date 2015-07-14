package co.com.silex.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
import co.com.silex.model.entity.ItemPresupuesto;
import co.com.silex.model.repositories.CopropiedadRepository;
import co.com.silex.model.repositories.EgresoRepository;
import co.com.silex.model.repositories.ItemPresupuestoRepository;
import co.com.silex.model.repositories.IngresoRepository;
import co.com.silex.model.repositories.UnidadResidencialRepository;
import co.com.silex.util.AppListUtil;

@Controller
@RequestMapping(value = "/protected/presupuesto")
public class PresupuestoController {

	@Autowired
	ItemPresupuestoRepository itemPresupuestoRepo;
	
	@Autowired
	UnidadResidencialRepository unidadRepo;
	
	@Autowired
	EgresoRepository egresoRepo;
	
	@Autowired
	IngresoRepository ingresoRepo;
	
	@Autowired
	CopropiedadRepository copropiedadRepo;
	
	@RequestMapping(value="/lst",  method = RequestMethod.GET)
    public @ResponseBody String copropiedadesLst(HttpSession session) {
		
		CopropiedadDto cDto = (CopropiedadDto)session.getAttribute("copropiedad");
		
		String response = "";
		
		List<ItemPresupuesto> itemsPresupuesto = itemPresupuestoRepo.findAllByCopropiedadId(cDto.getId());
		if(itemsPresupuesto != null && itemsPresupuesto.size() > 0){
			try {
				String json = new ObjectMapper().writeValueAsString(itemsPresupuesto);
				response ="{\"aaData\":" + json + "}";
			} catch (Exception e) {
				response ="{\"aaData\":" + response + "}";
			}
		} else {
			response= "{\"aaData\":\"\"}";
		}
        return response;
    }
	
	@RequestMapping(value = "/ver_presupuesto", method = RequestMethod.GET)
    public ModelAndView verPresupuesto(ModelMap model, HttpSession session) {
		CopropiedadDto cDto =(CopropiedadDto)session.getAttribute("copropiedad");
		
		if(cDto != null){
		
			//Total de cuotas de administracion
			BigDecimal sumCuotas = unidadRepo.sumCoutasByCopropiedad(cDto.getId());
			model.put("cuotasTotales",sumCuotas !=null?sumCuotas.doubleValue():0);
			
			//Total de gastos presupuestados
			BigDecimal sumPresupuesto = itemPresupuestoRepo.sumGastosPresupuestoByCopropiedad(cDto.getId());
			model.put("sumPresupuesto", sumPresupuesto!=null?sumPresupuesto.doubleValue():0);
	
			//Total de gastos mes actual
			Calendar cal = new GregorianCalendar();
			String fechaIni = cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH) + 1) + "- 01";
			String fechaFin = cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH) + 1) + "-" + cal.get(Calendar.DAY_OF_MONTH);
			BigDecimal sumEgresosMes = egresoRepo.sumEgresosByCopropiedadAndFechaBetweenFechaIniAndFechaFin(cDto.getId(), fechaIni, fechaFin);
			model.put("sumEgresosMes", sumEgresosMes!=null?sumEgresosMes.doubleValue():0);
			
			//Total de ingresos mes actual
			BigDecimal sumIngresosMes = ingresoRepo.sumIngresosByCopropiedadAndFechaBetweenFechaIniAndFechaFin(cDto.getId(), fechaIni, fechaFin);
			model.put("sumIngresosMes", sumIngresosMes!=null?sumIngresosMes.doubleValue():0);
			
			SimpleDateFormat formateador = new SimpleDateFormat("MMMMM");
			model.put("mes", formateador.format(new Date()));
			
			model.put("listPeriodicidad", AppListUtil.getLista("periodoUnidad"));
			
			ItemPresupuesto ip = new ItemPresupuesto();
			
			model.put("itemPresupuesto",ip);
		}

        return new ModelAndView("presupuesto","model",model);
    }

	@RequestMapping(value="/save",  method = RequestMethod.POST)
    public ModelAndView saveItemPresupuesto(ModelMap model, HttpSession session, @ModelAttribute("itemPresupuesto") ItemPresupuesto nuevoItem) {
		
		ItemPresupuesto ip = nuevoItem;
		CopropiedadDto cDto = (CopropiedadDto)session.getAttribute("copropiedad");
		

		nuevoItem.setCopropiedad(copropiedadRepo.findOne(cDto.getId()));
		itemPresupuestoRepo.save(nuevoItem);
		
		return verPresupuesto(model, session);
    }


}
