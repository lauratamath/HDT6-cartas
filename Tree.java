import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;

/**
 * @author Orlando Cabrera
 * @author Laura Tamath
 *@since 08/03/2020
 *@version /03/2020
 * Clase que utilizara Map: TreeMap
 */
public class Tree<K,V> implements InterfaceMap<K,V> {
	TreeMap <K,V> map = new TreeMap<K,V>();
	/** En donde:
	* @param k  Llave
	* @param v  Valor
	**/

	/**
	*@pre: Con la ayuda de un map se obtiene el tamaño
	*@post: Se obtiene el tamaño del map
	*/
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return map.size();
	}
	/**
	*@pre: Se cuenta con una llave y un valor
	*@post: Se asigna un valor a la llave
	*/
	@Override
	public void put(K k, V v) {
		// TODO Auto-generated method stub
		map.put(k,v);
	}
	/**
	*@pre: La llave existe
	*@post: Retorna el valor asignado a la llave
	*/	
	@Override
	public V get(K k) {
		// TODO Auto-generated method stub
		return map.get(k);
	}
	/**
	*@pre: La llave existe
	*@post: Se remueve el valor de la llave y la llave, ademas de que retorna el valor removido
	*/
	@Override
	public V remove(K k) {
		// TODO Auto-generated method stub
		return map.remove(k);
	}
	/**
	*@pre: La llave existe
	*@post: Retorna verdadero si la llave se encuentra en el mapa
	*/	
	@Override
	public boolean containsKey(K k) {
		// TODO Auto-generated method stub
		if (map.get(k)!=null) {
			return true;
		}else {
			return false;
		}
		
	}
	/**
	*@pre: El valor existe
	*@post: Retorna verdadero si el valor se encuentra en el mapa
	*/	
	@Override
	public boolean containsValue(V v) {
		// TODO Auto-generated method stub
		if (map.containsValue(v)) {
			return true;
		}else {
			return false;
		}
		
	}
	/**
	 * @pre: Hay valores en el mapa
	 * @post: Retorna el contenido del mapa
	 */
	@Override
	public Set<Entry<K, V>> entrySet() {
		// TODO Auto-generated method stub
		return map.entrySet();
	}
}

