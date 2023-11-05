package EjerciciosFinal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

public class FiltroElementos {

    public static <T> List<T> filtrar(Collection<T> coleccion, Predicate<T> criterio) {
        List<T> elementosFiltrados = new ArrayList<>();
        for (T elemento : coleccion) {
            if (criterio.test(elemento)) {
                elementosFiltrados.add(elemento);
            }
        }
        return elementosFiltrados;
    }

    public static void main(String[] args) {
        List<Integer> numeros = new ArrayList<>();
        numeros.add(1);
        numeros.add(5);
        numeros.add(3);
        numeros.add(7);
        numeros.add(2);

        Predicate<Integer> criterioMenorQue4 = num -> num < 4;
        List<Integer> numerosFiltrados = filtrar(numeros, criterioMenorQue4);
        System.out.println("Números menores que 4: " + numerosFiltrados); // Imprimirá [1, 3, 2]

        List<String> palabras = new ArrayList<>();
        palabras.add("manzana");
        palabras.add("banana");
        palabras.add("cereza");
        palabras.add("dátiles");

        Predicate<String> criterioNoEmpiezaConB = palabra -> !palabra.startsWith("b");
        List<String> palabrasFiltradas = filtrar(palabras, criterioNoEmpiezaConB);
        System.out.println("Palabras que no empiezan con 'b': " + palabrasFiltradas); // Imprimirá [manzana, cereza, dátiles]
    }
}
