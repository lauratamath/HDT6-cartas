// import java.io.BufferedReader;
// import java.io.FileReader;
// import java.util.Map;
// import java.util.Scanner;

import java.util.*;
import java.io.*; 
/**
 * @author Orlando Cabrera
 * @author Laura Tamath
 * @since 08/03/2020
 * @version 10/03/2020
 * Codigo para leer archivos sacado de: https://blog.openalfa.com/como-leer-un-fichero-de-texto-linea-a-linea-en-java
 * Main
 */
public class Main {

	/**
	 * @param args
	 */
	static InterfaceMap<String, String> userCollection;
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
		InterfaceMap<String,String> mapC = factory.getMap(tipo);
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
	    		  
	    	  }
	    	  map.put(key,val);
    		 // System.out.println(map.get(key));
	    	  
	    	  
	      }
	    	  
	        
	      fr.close();
	    }
	    catch(Exception e) {
	      System.out.println("Excepcion leyendo fichero "+ documento + ": " + e);
	    }
	    int n = 0;
	    int r = 0;
	    int i = 0;
	    
	    do {
	    	System.out.println("Que desea hacer?");
	    	System.out.println("1.Agregar una carta a la coleccion\n2.Datos de cartas\n3.Datos de cartas en la coleccion\n4.Salir");
	    	n = teclado.nextInt();
	    	if (n == 1) {
	    		System.out.println("Ingrese el nombre de la carta que desea agregar");
	    		key = teclado.nextLine();
	    		if (map.containsKey(key)) {
	    			mapC.put(key, map.get(key));
	    		}else {
	    			System.out.println("La carta ingresada no existe");
	    		}
	    	}
	    	if (n == 2) {
	    		do {
	    			System.out.println("1.Mostrar tipo de una carta\n2.Mostrar Cartas (desordenadas)\n3.Mostrar Cartas (Ordenadas por tipo)");
		    		r = teclado.nextInt();
		    		if (r == 1) {
		    			System.out.println("Ingrese el nombre de la carta");
			    		key = teclado.nextLine();
			    		if (map.containsKey(key)) {
			    			System.out.println("Carta: " + key + " Tipo: " + map.get(key));
			    		}else {
			    			System.out.println("La carta ingresada no existe");
			    		}
		    		}
		    		if (r == 2) {
		    			for (Map.Entry<String, String> cartas:map.entrySet())
		    			{
		    				System.out.println(cartas.getKey() + " " + cartas.getValue());
		    			}
		    		}
		    		if (r == 3) {
	
		    		}
	    		}while (r<4);
	    		
	    	}
	    	if (n == 3) {
	    		do {
	    			System.out.println("1.Mostrar Cartas (desordenadas)\n2.Mostrar Cartas (Ordenadas por tipo)");
		    		i = teclado.nextInt();
		    		ArrayList<String> valu = new ArrayList<String>();
		    		if (i == 1) {
		    			ArrayList<String> cartord = new ArrayList<String>();
		    			int trampa = 0;
		    			int hechizo = 0;
		    			int monstruo = 0;

		    			cartord.add(0,"Tipo__________ : Nombre________");
		    			cartord.add(0, "______________________________");
		    			for (Map.Entry<String, String> entry : userCollection.entrySet()){
		    				cartord.add(entry.getValue() + " : " + entry.getKey());
		    				if (entry.getValue().equalsIgnoreCase("trampa")){
		    					trampa++;
		    				}	else if (entry.getValue().equalsIgnoreCase("hechizo")){
		    					hechizo++;
		    				} else if (entry.getValue().equalsIgnoreCase("monstruo")){
		    					monstruo++;
		    				}
		    			}
		    			cartord.add("Tipo de monstruo: "+ monstruo);
		    			cartord.add("Tipo de hechizo: "+ hechizo);
		    			cartord.add("Tipo de trampa: "+ trampa);
		    			System.out.println(cartord) ;

		    		}//Mostrar las cartas ordenadas por tipo
		    		if (i == 2) {
		    			ArrayList<String> cartord = new ArrayList<String>();
		    			int trampa = 0;
		    			int hechizo = 0;
		    			int monstruo = 0;

		    			//Para eliminar las llaves duplicadas
		    			LinkedHashSet<String> hashSet = new LinkedHashSet<String>(valu);
		    			ArrayList<String> newVal = new ArrayList<>(hashSet);

		    			//Luego de eliminar, se obtiene el tipo y nombre
		    			for (Map.Entry<String, String> entry : userCollection.entrySet()){
		    				cartord.add(entry.getValue() + " : " + entry.getKey());
		    				if (entry.getValue().equalsIgnoreCase("trampa")){
		    					trampa++;
		    				}	else if (entry.getValue().equalsIgnoreCase("hechizo")){
		    					hechizo++;
		    				} else if (entry.getValue().equalsIgnoreCase("monstruo")){
		    					monstruo++;
		    				}
		    			} Collections.sort(cartord);
		    			cartord.add(0,"Tipo__________ : Nombre________");
		    			cartord.add(0, "______________________________");
		    			cartord.add(0, "______________________________");
		    			cartord.add("Tipo de monstruo: "+ monstruo);
		    			cartord.add("Tipo de hechizo: "+ hechizo);
		    			cartord.add("Tipo de trampa: "+ trampa);

		    			System.out.println(cartord) ;
		    		} 
	    		}while (i<3);
	    		
	    	}
	    	
	    	
		    
		    
	    }while (n<0);
	    
	}

}
