package EjerciciosFinal;

import java.util.ArrayList;
import java.util.List;

public class CombineSortedLists {
    public static List<Integer> combineSortedLists(List<Integer> lista1, List<Integer> lista2) {
        List<Integer> listaCombinada = new ArrayList<>();
        int i = 0; // Índice para lista1
        int j = 0; // Índice para lista2

        while (i < lista1.size() && j < lista2.size()) {
            if (lista1.get(i) < lista2.get(j)) {
                listaCombinada.add(lista1.get(i));
                i++;
            } else {
                listaCombinada.add(lista2.get(j));
                j++;
            }
        }

        // Agregar los elementos restantes de lista1 (si los hay)
        while (i < lista1.size()) {
            listaCombinada.add(lista1.get(i));
            i++;
        }

        // Agregar los elementos restantes de lista2 (si los hay)
        while (j < lista2.size()) {
            listaCombinada.add(lista2.get(j));
            j++;
        }

        return listaCombinada;
    }

    public static void main(String[] args) {
        List<Integer> lista1 = new ArrayList<>();
        lista1.add(1);
        lista1.add(3);
        lista1.add(5);

        List<Integer> lista2 = new ArrayList<>();
        lista2.add(2);
        lista2.add(4);
        lista2.add(6);

        List<Integer> listaCombinada = combineSortedLists(lista1, lista2);

        System.out.println("Lista 1: " + lista1);
        System.out.println("Lista 2: " + lista2);
        System.out.println("Lista Combinada: " + listaCombinada);
    }
}
