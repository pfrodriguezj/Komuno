package co.com.silex.util; 

import java.util.Calendar;

/**
 * @author crodriguez
 *
 */
public class CodeUtil {
	
	/**
	 * Verifica si un string es nulo o vaci�
	 * @param str
	 * @return verdadero si es nulo o vac�o
	 */
	public static boolean isNullOrEmpty(String str){
		return ! (str!=null && str.length()>0);
	}
	
	/**
	 * Verifica si un string es nulo o vaci� y si lo es retorna el valor por defecto
	 * @param str
	 * @return verdadero si es nulo o vac�o
	 */
	public static String isNullOrEmpty(String str, String defValue){
		return (isNullOrEmpty(str)?defValue:str);
	}
	
	
	/**
	 * Obtiene el a�o en curso
	 * @return a�o en curso
	 */
	public static int getCurrentYear(){
		Calendar now = Calendar.getInstance();
		return now.get(Calendar.YEAR);
	}
}
