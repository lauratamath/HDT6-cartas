/**
 * @author Orlando Cabrera
 * @author Laura Tamath
 *@since 08/03/2020
 *@version /03/2020
 * Interfaz que contiene los metodos a utilizar
 */
import java.util.*;
public interface InterfaceMap<K, V>{
	/** En donde:
	* @param k  Llave
	* @param v  Valor
	**/

	/**
	Pre: Con la ayuda de un map se obtiene el tamaño
	Post: Se obtiene el tamaño del map
	*/
	public int size();

    /**
	Pre: Se cuenta con una llave y un valor
	Post: Se asigna un valor a la llave
	*/
	public void put(K k, V v);

	/**
	Pre: La llave existe
	Post: Retorna el valor asignado a la llave
	*/	
    public V get(K k);


	/**
	Pre: La llave existe
	Post: Se remueve el valor de la llave y la llave, ademas de que retorna el valor removido
	*/
	public V remove(K k);

	
	/**
	Pre: La llave existe
	Post: Retorna verdadero si la llave se encuentra en el mapa
	*/	
	public boolean containsKey(K k);

	/**
	Pre: El valor existe
	Post: Retorna verdadero si el valor se encuentra en el mapa
	*/	
	public boolean containsValue(V v);


	public Set<Map.Entry<K,V>> entrySet();
	

}