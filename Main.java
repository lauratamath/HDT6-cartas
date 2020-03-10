import java.util.Scanner;

/**
 * 
 */

/**
 * @author Orlando
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Factory<String,String> factory = new Factory<String,String>();
		Scanner teclado = new Scanner (System.in);
		System.out.println("Introduzca el tipo de mapa que desea utilizar");
		System.out.println("1.HashMap.    2.LinkedHashMap.    3.TreeMap.");
		String tipo = teclado.nextLine();
		InterfaceMap<String,String> map = factory.getMap(tipo);
		if (map instanceof Hash) {
			System.out.println("El mapa a utilizar es: HashMap");
		}
		else if (map instanceof Tree) {
			System.out.println("El mapa a utilizar es: TreeMap");
		}
		else if (map instanceof Linked) {
			System.out.println("El mapa a utilizar es: LinkedHashMap");
		}
	}

}
