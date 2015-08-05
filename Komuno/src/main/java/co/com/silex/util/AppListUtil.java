package co.com.silex.util;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Clase para obtener listas fijas del sistema
 * @author Cesar Rodriguez
 */
public class AppListUtil {
	static boolean init;
	
	static LinkedList<ListaProceso> listaProcesos;
	/**
	 * Inicialización de listas
	 */
	private static void init(){
		if (init) return;
		
		listaProcesos = new LinkedList<ListaProceso>();
		
		listaProcesos.add(new ListaProceso("presupuestoTipo", "G", "GASTO"));
		listaProcesos.add(new ListaProceso("presupuestoTipo", "I", "INGRESO"));
		
		listaProcesos.add(new ListaProceso("periodoUnidad", "A", "AÑO"));
		listaProcesos.add(new ListaProceso("periodoUnidad", "M", "MES"));
		listaProcesos.add(new ListaProceso("periodoUnidad", "D", "DIA"));
		
		listaProcesos.add(new ListaProceso("pagoEstado", "E", "EN ESPERA"));
		listaProcesos.add(new ListaProceso("pagoEstado", "F", "FACTURADO"));
		listaProcesos.add(new ListaProceso("pagoEstado", "P", "PAGADO"));
		listaProcesos.add(new ListaProceso("pagoEstado", "A", "ANULADO"));
		listaProcesos.add(new ListaProceso("pagoEstado", "S", "SUSPENDIDO"));
		
		listaProcesos.add(new ListaProceso("tipoDocumento", "1", "CEDULA"));
		listaProcesos.add(new ListaProceso("tipoDocumento", "2", "REGISTRO CIVIL"));
		listaProcesos.add(new ListaProceso("tipoDocumento", "3", "TARJETA DE IDENTIDAD"));
		listaProcesos.add(new ListaProceso("tipoDocumento", "4", "NIT"));
		listaProcesos.add(new ListaProceso("tipoDocumento", "5", "NUIP"));
		listaProcesos.add(new ListaProceso("tipoDocumento", "6", "CEDULA DE EXTRANJERIA"));

		
		init = true;
	}
	
	/**
	 * Obtener texto de listas
	 * @param lista
	 * @param valor
	 * @return
	 */
	public static String listaProcesoTexto (String lista, String valor){
		init();
		
		//Si el valor enviado es vacío retorna vacío
		if (CodeUtil.isNullOrEmpty(valor)) return "";
		
		for (ListaProceso lp : listaProcesos) {
			if (lista.equalsIgnoreCase(lp.getLista()) && valor.equalsIgnoreCase(lp.getValor())){
				return lp.getTexto();
			}
		}
		
		return lista + "::" + valor;
	}
	
	/**
	 * Obtener lista de acuerdo al nombre
	 * @param lista Nombre de la lista
	 * @return Lista
	 */
	public static Map<String, String> getLista (String listaNombre){
		init();
		
		LinkedList<ListaProceso> lista = listaProcesos;
		Map<String, String> map = new LinkedHashMap<String, String>();
 		
		for (ListaProceso lp : lista) {
			if (listaNombre.equalsIgnoreCase(lp.getLista())){
				map.put(lp.getValor(), lp.getTexto());
			}
		}
		
		return map;
	}
}
