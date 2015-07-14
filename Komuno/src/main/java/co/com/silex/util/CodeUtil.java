package co.com.silex.util; 

import java.util.Calendar;

/**
 * @author crodriguez
 *
 */
public class CodeUtil {
	
	/**
	 * Verifica si un string es nulo o vació
	 * @param str
	 * @return verdadero si es nulo o vacío
	 */
	public static boolean isNullOrEmpty(String str){
		return ! (str!=null && str.length()>0);
	}
	
	/**
	 * Verifica si un string es nulo o vació y si lo es retorna el valor por defecto
	 * @param str
	 * @return verdadero si es nulo o vacío
	 */
	public static String isNullOrEmpty(String str, String defValue){
		return (isNullOrEmpty(str)?defValue:str);
	}
	
	
	/**
	 * Obtiene el año en curso
	 * @return año en curso
	 */
	public static int getCurrentYear(){
		Calendar now = Calendar.getInstance();
		return now.get(Calendar.YEAR);
	}
}
