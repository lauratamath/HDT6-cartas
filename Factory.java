/**
 * @author Orlando Cabrera
 * @author Laura Tamath
 * @since 08/03/2020
 * @version /03/2020
 * Factory
 */
public class Factory<K,V> {
	public InterfaceMap<K,V> getMap (int tipo){
		switch (tipo){
			case 1:
				return new Hash<K,V>();
			case 2:
				return new Linked<K,V>();
			case 3:
				return new Tree<K,V>();
		}
		return null;
		
	}
}
