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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Factory<String,String> factory = new Factory<String,String>();
		Scanner teclado = new Scanner (System.in);
		String key;
		String val;
		ArrayList<String> valu = new ArrayList<String>();
		boolean comprobante;
		int tipo = 0;	
		
			do {
				try {
					System.out.println("Introduzca el tipo de mapa que desea utilizar");		
					System.out.println("1.HashMap.    2.LinkedHashMap.    3.TreeMap.");
					tipo = teclado.nextInt();
					
				}catch (Exception e) {
					System.out.println("Introduzca correctamente el numero");
					teclado.nextLine();
				}
			}while (tipo>3||tipo<0);
		
		
		InterfaceMap<String,String> map = factory.getMap(tipo);//Cartas disponibles
		InterfaceMap<String,String> mapC = factory.getMap(tipo); //Castas del usuario
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
		String documento;
		teclado.nextLine();
		documento = teclado.nextLine();
		
	    try {
	      FileReader fr = new FileReader(documento);
	      BufferedReader br = new BufferedReader(fr);
	      String linea;	      
	      while((linea = br.readLine()) != null) {
	    	  key = "";
	    	  val = "";
	    	  comprobante = false;
	    	  
	    	  for (int i = 0; i<linea.length();i++) {
	    		  if (!linea.substring(i, i+1).equals("|")&& comprobante == false ) {
	    			 
	    			 key = key +  linea.substring(i, i+1);
	    			
	    		  }if (linea.substring(i, i+1).equals("|") ) {
	    			  comprobante = true;
	    		  }
	    		  if (comprobante == true&&!linea.substring(i, i+1).equals("|")) {
	    			  val = val + linea.substring(i, i+1);
	    		  }
	    		  
	    	  }
	    	  if (key.substring(0, 1).equals(" ")) {
 				 key = key.substring(1, key.length());
 				 //System.out.println(key);
 			 }
	    	  if (val.substring(0, 1).equals(" ")) {
	 				 val = val.substring(1, val.length());
	 				 System.out.println(val);
	 			 }
	    	  
	    	  //System.out.println(val);
	    	  map.put(key,val);
    		  //System.out.println(map.get(key));
	    	  
	    	  
	      }
	    	  
	        
	      fr.close();
	    }
	    catch(Exception e) {
	      System.out.println("Excepcion leyendo fichero "+ documento + ": " + e);
	    }
	    int n = 0;
	    int r = 0;
	    int i = 0;
	    
	    
	    while (n<4) {
			do {
				try {
					System.out.println("Que desea hacer?");
		    	
					System.out.println("1.Agregar una carta a la coleccion\n2.Datos de cartas\n3.Datos de cartas en la coleccion\n4.Salir");
		    	
					n = teclado.nextInt();
					
					if (n == 1) {
			    		Scanner sc = new Scanner (System.in);
			    		System.out.println("Ingrese el nombre de la carta que desea agregar");
			    		key = sc.nextLine();
			    		if (map.containsKey(key)) {
			    			mapC.put(key, map.remove(key));
			    		}else {
			    			System.out.println("La carta ingresada no existe en el mazo de cartas");
			    		}
			    	}
			    	if (n == 2) {
			    		
			    			System.out.println("1.Mostrar tipo de una carta\n2.Mostrar Cartas (desordenadas)\n3.Mostrar Cartas (Ordenadas por tipo)");
				    		r = teclado.nextInt();
				    		if (r == 1) {
				    			System.out.println("Ingrese el nombre de la carta");
				    			teclado.nextLine();
					    		key = teclado.nextLine();
					    		if (map.containsKey(key)) {
					    			System.out.println("Carta: " + key + " Tipo: " + map.get(key));
					    		}else {
					    			System.out.println("La carta ingresada no existe en la coleccion");
					    		} r=0;
				    		}
				    		if (r == 2) {
				    			for (Map.Entry<String, String> cartas:map.entrySet())
				    			{
				    				System.out.println(cartas.getKey() + " " + cartas.getValue());
				    			}
				    		}
				    		if (r == 3) {
								ArrayList<String> cartord = new ArrayList<String>();
				    			int trampa = 0;
				    			int hechizo = 0;
				    			int monstruo = 0;
				    			//Para eliminar las llaves duplicadas
				    			LinkedHashSet<String> hashSet = new LinkedHashSet<String>(valu);
				    			ArrayList<String> newVal = new ArrayList<>(hashSet);
				    			//Luego de eliminar, se obtiene el tipo y nombre
				    			for (Map.Entry<String, String> entry : map.entrySet()){
				    				cartord.add(entry.getValue() + " : " + entry.getKey());
				    				if (entry.getValue().equalsIgnoreCase("trampa")){
				    					trampa++;
				    				}	else if (entry.getValue().equalsIgnoreCase("hechizo")){
				    					hechizo++;
				    				} else if (entry.getValue().equalsIgnoreCase("monstruo")){
				    					monstruo++;
				    				}Collections.sort(cartord);
				    			}cartord.add(0,"Tipo__________ : Nombre________");
				    			cartord.add("Tipo de monstruo: "+ monstruo);
				    			cartord.add("Tipo de hechizo: "+ hechizo);
				    			cartord.add("Tipo de trampa: "+ trampa);
				    			for (int l = 0; l< cartord.size();l++) {
				    				System.out.println(cartord.get(l)) ;
				    			}

				    			

				    		}
			    		
			    		
			    	}
			    	if (n == 3) {
			    		
			    			System.out.println("1.Mostrar Cartas (desordenadas)\n2.Mostrar Cartas (Ordenadas por tipo)");
				    		i = teclado.nextInt();
				    		if (i == 1) {
				    			ArrayList<String> cartord = new ArrayList<String>();
				    			int trampa = 0;
				    			int hechizo = 0;
				    			int monstruo = 0;

				    			//Para eliminar las llaves duplicadas
				    			LinkedHashSet<String> hashSet = new LinkedHashSet<String>(valu);
				    			ArrayList<String> newVal = new ArrayList<>(hashSet);

				    			//Luego de eliminar, se obtiene el tipo y nombre
				    			for (Map.Entry<String, String> entry : mapC.entrySet()){
				    				cartord.add(entry.getValue() + " : " + entry.getKey());
				    				if (entry.getValue().equalsIgnoreCase("trampa")){
				    					trampa++;
				    				}	else if (entry.getValue().equalsIgnoreCase("hechizo")){
				    					hechizo++;
				    				} else if (entry.getValue().equalsIgnoreCase("monstruo")){
				    					monstruo++;
				    				} 
				    			}cartord.add(0,"Tipo__________ : Nombre________");
				    			cartord.add("Tipo de monstruo: "+ monstruo);
				    			cartord.add("Tipo de hechizo: "+ hechizo);
				    			cartord.add("Tipo de trampa: "+ trampa);
				    			for (int l = 0; l< cartord.size();l++) {
				    				System.out.println(cartord.get(l)) ;
				    			}
				    			

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
				    			for (Map.Entry<String, String> entry : mapC.entrySet()){
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
				    			cartord.add("Tipo de monstruo: "+ monstruo);
				    			cartord.add("Tipo de hechizo: "+ hechizo);
				    			cartord.add("Tipo de trampa: "+ trampa);

				    			for (int l = 0; l< cartord.size();l++) {
				    				System.out.println(cartord.get(l)) ;
				    			}
				    		} 
			    		
			    		
			    	}
					
				}catch (Exception e) {
					System.out.println("Introduzca correctamente el numero");
					teclado.nextLine();
				}
			}while (n>4||n<0);
			
		}
	    	
	    	
	    	
	    	
	    	
		    
		    
	    
	    
	    
	}

}
