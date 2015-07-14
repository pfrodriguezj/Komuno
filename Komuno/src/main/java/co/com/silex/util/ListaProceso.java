package co.com.silex.util;

public class ListaProceso{
	public String lista;
	public String valor;
	public String texto;
	/**
	 * @return the lista
	 */
	public String getLista() {
		return lista;
	}
	/**
	 * @param lista the lista to set
	 */
	public void setLista(String lista) {
		this.lista = lista;
	}
	/**
	 * @return the valor
	 */
	public String getValor() {
		return valor;
	}
	/**
	 * @param valor the valor to set
	 */
	public void setValor(String valor) {
		this.valor = valor;
	}
	/**
	 * @return the texto
	 */
	public String getTexto() {
		return texto;
	}
	/**
	 * @param texto the texto to set
	 */
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public ListaProceso(String lista, String valor, String texto) {
		super();
		this.lista = lista;
		this.valor = valor;
		this.texto = texto;
	}
}