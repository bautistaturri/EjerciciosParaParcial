package EjerciciosFinal;

public class ArregloDinamicoDeElementos {
    private int[] arreglo;
    private int tamaño;
    private int capacidad;

    public ArregloDinamicoDeElementos() {
        capacidad = 10; // Capacidad inicial del arreglo
        arreglo = new int[capacidad];
        tamaño = 0; // Tamaño actual del arreglo
    }

    public void agregar(int elemento) {
        // Verificar si el arreglo está lleno, en cuyo caso, aumentamos su capacidad
        if (tamaño == capacidad) {
            capacidad *= 2;
            int[] nuevoArreglo = new int[capacidad];
            System.arraycopy(arreglo, 0, nuevoArreglo, 0, tamaño);
            arreglo = nuevoArreglo;
        }
        arreglo[tamaño] = elemento;
        tamaño++;
    }

    public int obtener(int indice) {
        if (indice < 0 || indice >= tamaño) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
        return arreglo[indice];
    }

    public int tamaño() {
        return tamaño;
    }

    public void imprimir() {
        for (int i = 0; i < tamaño; i++) {
            System.out.print(arreglo[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArregloDinamicoDeElementos miArreglo = new ArregloDinamicoDeElementos();

        miArreglo.agregar(5);
        miArreglo.agregar(10);
        miArreglo.agregar(15);
        miArreglo.agregar(16);
        System.out.println("Tamaño del arreglo: " + miArreglo.tamaño());
        System.out.println("Elemento en el índice 1: " + miArreglo.obtener(1));

        miArreglo.imprimir();
    }
}

