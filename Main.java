import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

/**
 * @author Orlando Cabrera
 * @author Laura Tamath
 * @since 08/03/2020
 * @version /03/2020
 * Codigo para leer archivos sacado de: https://blog.openalfa.com/como-leer-un-fichero-de-texto-linea-a-linea-en-java
 * Main
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Factory<String,String> factory = new Factory<String,String>();
		Scanner teclado = new Scanner (System.in);
		String key;
		String val;
		boolean comprobante;
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
		//String fichero = args[0];
		System.out.println("Introduzca el nombre del documento (cards_desc.txt)");
		String documento = teclado.nextLine();
		documento = "cards_desc.txt";
	    try {
	      FileReader fr = new FileReader(documento);
	      BufferedReader br = new BufferedReader(fr);

	      String linea;
	      
	      while((linea = br.readLine()) != null) {
	    	  key = "";
	    	  val = "";
	    	  comprobante = false;
	    	  
	    	  for (int i = 0; i<linea.length();i++) {
	    		  if (linea.substring(i, i+1) != "|" && comprobante == false ) {
	    			 key = key +  linea.substring(i, i+1);
	    		  }if (linea.substring(i, i+1).equals("|") ) {
	    			  comprobante = true;
	    		  }
	    		  if (comprobante == true) {
	    			  val = val + linea.substring(i, i+1);
	    		  }
	    		  //System.out.println(val);
	    		  //System.out.println(key);
	    	  }
	    	  map.put(key,val);
    		  System.out.println(map.get(key));
	    	  //System.out.prin+tln(linea);
	    	  
	      }
	    	  
	        
	      fr.close();
	    }
	    catch(Exception e) {
	      System.out.println("Excepcion leyendo fichero "+ documento + ": " + e);
	    }
	    
	}

}
