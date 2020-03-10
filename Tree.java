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
	Pre: Con la ayuda de un map se obtiene el tamaño
	Post: Se obtiene el tamaño del map
	*/
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return map.size();
	}
	/**
	Pre: Se cuenta con una llave y un valor
	Post: Se asigna un valor a la llave
	*/
	@Override
	public void put(K k, V v) {
		// TODO Auto-generated method stub
		map.put(k,v);
	}
	/**
	Pre: La llave existe
	Post: Retorna el valor asignado a la llave
	*/	
	@Override
	public V get(K k) {
		// TODO Auto-generated method stub
		return map.get(k);
	}
	/**
	Pre: La llave existe
	Post: Se remueve el valor de la llave y la llave, ademas de que retorna el valor removido
	*/
	@Override
	public V remove(K k) {
		// TODO Auto-generated method stub
		return map.remove(k);
	}
	/**
	Pre: La llave existe
	Post: Retorna verdadero si la llave se encuentra en el mapa
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
	Pre: El valor existe
	Post: Retorna verdadero si el valor se encuentra en el mapa
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

	@Override
	public Set<Entry<K, V>> entrySet() {
		// TODO Auto-generated method stub
		return map.entrySet();
	}
}

