package EjerciciosFinal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BuscarElemento {

	public static <T> T buscarElemento(Collection<T> coleccion, T elemento, T valorPorDefecto) {
	    for (T item : coleccion) {
	        if (item.equals(elemento)) {
	            return item;
	        }
	    }
	    return valorPorDefecto;
	}

    public static void main(String[] args) {
        // Ejemplo de uso
        List<String> lista = new ArrayList<>();
        lista.add("A");
        lista.add("f");
        lista.add("H");

        String elementoBuscado = "B";
        String valorPorDefecto = "No encontrado";

        String resultado = buscarElemento(lista, elementoBuscado, valorPorDefecto);
        System.out.println("Resultado: " + resultado); // Imprimirá "Resultado: B"

        String elementoNoEncontrado = "D";
        String resultadoNoEncontrado = buscarElemento(lista, elementoNoEncontrado, valorPorDefecto);
        System.out.println("Resultado no encontrado: " + resultadoNoEncontrado); // Imprimirá "Resultado no encontrado: No encontrado"
    }
}
