package EjerciciosFinal;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class FuncionUnicos {
	
	//<T> indica el tipo de elementos de la coleccion y set<T> indica el tipo
	// y permite que no hayan duplicados
    public static <T> Set<T> unicos(Collection<T> coleccion){
    	Set<T> conjunto = new HashSet<>(coleccion);
    	return Collections.unmodifiableSet(conjunto);
    }
    public static void main(String[] args) {
    	Collection<Integer> coleccion = Arrays.asList(1,2,3,2,4,3,4);
    	Set<Integer> conjunto = unicos(coleccion);
    	System.out.println("la lista sin repetidos es "+ conjunto);
    }
}
