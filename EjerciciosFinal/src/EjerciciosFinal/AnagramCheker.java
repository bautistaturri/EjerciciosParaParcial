package EjerciciosFinal;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class AnagramCheker {
	public static boolean esAnagrama(String cadena1, String cadena2) {

	    // Convertir ambas cadenas a minúsculas.
	    String cadena1Min = cadena1.toLowerCase();
	    String cadena2Min = cadena2.toLowerCase();

	    // Crear un mapa para almacenar la frecuencia de cada carácter en la primera cadena.
	    Map<Character, Integer> mapaFrecuencias = new HashMap<>();
	    for (int i = 0; i < cadena1Min.length(); i++) {
	        Character caracter = cadena1Min.charAt(i);
	        Integer frecuencia = mapaFrecuencias.get(caracter);
	        if (frecuencia == null) {
	            frecuencia = 0;
	        }
	        frecuencia++;
	        mapaFrecuencias.put(caracter, frecuencia);
	    }

	    // Iterar sobre la segunda cadena y decrementar la frecuencia de cada carácter en el mapa.
	    for (int i = 0; i < cadena2Min.length(); i++) {
	        Character caracter = cadena2Min.charAt(i);
	        Integer frecuencia = mapaFrecuencias.get(caracter);
	        if (frecuencia == null || frecuencia <= 0) {
	            return false;
	        }
	        frecuencia--;
	        mapaFrecuencias.put(caracter, frecuencia);
	    }

	    // Si la frecuencia de todos los caracteres en el mapa es cero, entonces las cadenas son anagramas.
	    return true;
	}

	public static void main(String[] args) {
		String cadena1 = "listen";
		String cadena2 = "sident";
		
		if(esAnagrama(cadena1,cadena2)) {
			System.out.println(cadena1 + " y " + cadena2 + " son anagramas.");
		}else {
			System.out.println(cadena1 + " y " + cadena2 + " no son anagramas.");
		}
	}
	
}
