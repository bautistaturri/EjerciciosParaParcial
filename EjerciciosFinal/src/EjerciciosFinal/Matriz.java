package EjerciciosFinal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Matriz<T extends Comparable<T>> {
    List<List<T>> columnas;
    Map<String, Integer> colLabels;
    Map<String, Integer> rowLabels;
    String[] orden;

    public Matriz(int cantidadColumnas) {
        if (cantidadColumnas < 1)
            throw new IllegalArgumentException("La longitud de columnas debe ser mayor a 0.");

        columnas = new ArrayList<>();
        colLabels = new HashMap<>();
        rowLabels = new HashMap<>();
        regenerarOrden();
        for (int j = 0; j < cantidadColumnas; j++) {
            columnas.add(j, new ArrayList<>());
            colLabels.put(String.valueOf(j), j);
        }
    }

    public Matriz(int cantidadColumnas, String[] etiquetas) {
        this(cantidadColumnas);
        if (cantidadColumnas != etiquetas.length)
            throw new IllegalArgumentException("La longitud de etiquetas no coincide.");
        setEtiquetasColumnas(etiquetas);
    }

    public Matriz(T[][] matriz) {
        this(matriz[0].length);
        inicializarDesdeMatriz(matriz);
    }

    public Matriz(T[][] matriz, String[] etiquetasColumnas) {
        this(matriz[0].length, etiquetasColumnas);
        inicializarDesdeMatriz(matriz);
    }

    public Matriz(T[][] matriz, String[] etiquetasColumnas, String[] etiquetasFilas) {
        this(matriz, etiquetasColumnas);
        if (columnas.get(0).size() != etiquetasFilas.length)
            throw new IllegalArgumentException("La longitud de etiquetas de filas no coincide.");
        setEtiquetasFilas(etiquetasFilas);
    }

    private void regenerarOrden() {
        orden = rowLabels.keySet().toArray(new String[0]);
    }

    public void setEtiquetasFilas(String[] etiquetas) {
        rowLabels.clear();
        for (int i = 0; i < columnas.get(0).size(); i++) {
            rowLabels.put(etiquetas[i], i);
        }
        regenerarOrden();
    }

    public void setEtiquetasColumnas(String[] etiquetas) {
        colLabels.clear();
        for (int j = 0; j < columnas.size(); j++) {
            colLabels.put(etiquetas[j], j);
        }
    }

    private void inicializarDesdeMatriz(T[][] matriz) {
        for (int j = 0; j < columnas.size(); j++) {
            for (int i = 0; i < matriz.length; i++) {
                columnas.get(j).add(i, matriz[i][j]);
            }
        }
        for (int i = 0; i < columnas.get(0).size(); i++) {
            rowLabels.put(String.valueOf(i), i);
        }
        regenerarOrden();
    }

    public static <T extends Comparable<T>> Matriz<T> crearDesdeMatriz(T[][] matriz) {
        return new Matriz<>(matriz);
    }

    public T getCelda(String fila, String columna) {
        return columnas.get(colLabels.get(columna)).get(rowLabels.get(fila)); // columnas[columna][fila]
    }

    public void setCelda(int fila, int columna, T valor) {
        columnas.get(columna).set(fila, valor);
    }

    public Fila<T> getFila(String fila) {
        List<T> celdas = new ArrayList<>();
        if (!rowLabels.containsKey(fila)) {
            throw new IllegalArgumentException();
        }
        for (Integer indiceCol : colLabels.values()) {
            celdas.add(columnas.get(indiceCol).get(rowLabels.get(fila)));
        }
        return new Fila<>(celdas);
    }

    public Fila<T> getFila(String fila, String[] columnas) {
        List<T> retorno = new ArrayList<>();
        if (rowLabels.get(fila) == null) {
            throw new IllegalArgumentException();
        }
        for (String etiquetaCol : columnas) {
            if (!rowLabels.containsKey(fila))
                throw new IllegalArgumentException();

            retorno.add(this.columnas.get(
                colLabels.get(etiquetaCol)
            ).get(rowLabels.get(fila)));
        }
        return new Fila<>(retorno);
    }

    public List<Fila<T>> seleccion(String[] filas, String[] columnas) {
        List<Fila<T>> retorno = new ArrayList<>();
        for(String fila : filas) {
            retorno.add(getFila(fila, columnas));
        }
        return retorno;
    }

    public List<Fila<T>> getColumnas(String[] columnas) {
        return seleccion(orden, columnas);
    }

    public void ordernarPorColumnas(String[] columnasOrden) {
        int n = orden.length;
        boolean huboCambio;
        
        do {
            huboCambio = false;
            for (int i = 1; i < n; i++) {
                String etiquetaPrevia = orden[i - 1];
                String etiquetaActual = orden[i];

                // Obtener filas con seleccion de columnas a ordenar
                Fila<T> filaPrevia = getFila(etiquetaPrevia, columnasOrden);
                Fila<T> filaActual = getFila(etiquetaActual, columnasOrden);

                if (filaPrevia.compareTo(filaActual) > 0) {
                    orden[i - 1] = orden[i];
                    orden[i] = etiquetaPrevia;
                    huboCambio = true;
                }
            }
            n--;
        } while (huboCambio);
    }


    @Override
    public String toString() {
        String out = "  | ";
        String sep = " | ";
        for (String label : colLabels.keySet()) {
            out += label + sep;
        }
        out += "\n";
        for (String fila : orden) {
            out += fila + sep;
            for (String columna : colLabels.keySet()) {
                out += getCelda(fila, columna);
                out += sep;
            }
            out += "\n";
        }
        return out;
    }
}
