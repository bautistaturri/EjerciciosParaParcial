package EjerciciosFinal;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ContadorElementosUnicos {

	    public static int cantidadUnicos(Collection<?> coleccion) {
	        Set<?> conjunto = new HashSet<>(coleccion);
	        return conjunto.size();
	    }
	    
	    
	    public static void main(String[] args) {
	        Collection<Integer> coleccion = Arrays.asList(1, 2, 3, 2, 3);
	        int cantidad = cantidadUnicos(coleccion);
	        System.out.println("La cantidad de elementos únicos es: " + cantidad);
	    }
	}
