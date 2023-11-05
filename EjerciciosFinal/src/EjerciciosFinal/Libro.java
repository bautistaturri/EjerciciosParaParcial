package EjerciciosFinal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class Libro {
    private List<Capitulo> capitulos;
    private List<Pagina> paginas;
    private Map<Integer, Capitulo> indiceCapitulos;

    public Libro() {
        capitulos = new ArrayList<>();
        paginas = new ArrayList<>();
        indiceCapitulos = new HashMap<>();
    }

    public void agregarCapitulo(String nombre) {
        int numeroPaginaInicial = paginas.size() + 1;
        Capitulo capitulo = new Capitulo(nombre, numeroPaginaInicial);
        capitulos.add(capitulo);
        indiceCapitulos.put(capitulos.size(), capitulo);
    }

    public List<String> obtenerNombresCapitulos() {
        List<String> nombres = new ArrayList<>();
        for (Capitulo capitulo : capitulos) {
            nombres.add(capitulo.getNombre());
        }
        return nombres;
    }

    public int obtenerCantidadPaginasTotales() {
        return paginas.size();
    }

    public int obtenerCantidadPaginasCapitulo(int numeroCapitulo) {
        if (indiceCapitulos.containsKey(numeroCapitulo)) {
            Capitulo capitulo = indiceCapitulos.get(numeroCapitulo);
            int paginaInicial = capitulo.getNumeroPaginaInicial();
            int paginaFinal = (numeroCapitulo < capitulos.size()) ? capitulos.get(numeroCapitulo).getNumeroPaginaInicial() - 1 : paginas.size();
            return paginaFinal - paginaInicial + 1;
        }
        return 0;
    }

    public int obtenerPaginaInicialCapitulo(int numeroCapitulo) {
        if (indiceCapitulos.containsKey(numeroCapitulo)) {
            Capitulo capitulo = indiceCapitulos.get(numeroCapitulo);
            return capitulo.getNumeroPaginaInicial();
        }
        return -1;
    }

    public int obtenerPaginaFinalCapitulo(int numeroCapitulo) {
        if (indiceCapitulos.containsKey(numeroCapitulo)) {
            Capitulo capitulo = indiceCapitulos.get(numeroCapitulo);
            int paginaInicial = capitulo.getNumeroPaginaInicial();
            return (numeroCapitulo < capitulos.size()) ? capitulos.get(numeroCapitulo).getNumeroPaginaInicial() - 1 : paginas.size();
        }
        return -1;
    }

    public int obtenerCantidadPalabrasCapitulo(int numeroCapitulo) {
        if (indiceCapitulos.containsKey(numeroCapitulo)) {
            int paginaInicial = obtenerPaginaInicialCapitulo(numeroCapitulo);
            int paginaFinal = obtenerPaginaFinalCapitulo(numeroCapitulo);
            int cantidadPalabras = 0;
            for (int i = paginaInicial - 1; i <= paginaFinal - 1; i++) {
                cantidadPalabras += paginas.get(i).obtenerCantidadPalabras();
            }
            return cantidadPalabras;
        }
        return -1;
    }

    public int obtenerCantidadCaracteresCapitulo(int numeroCapitulo) {
        if (indiceCapitulos.containsKey(numeroCapitulo)) {
            int paginaInicial = obtenerPaginaInicialCapitulo(numeroCapitulo);
            int paginaFinal = obtenerPaginaFinalCapitulo(numeroCapitulo);
            int cantidadCaracteres = 0;
            for (int i = paginaInicial - 1; i <= paginaFinal - 1; i++) {
                cantidadCaracteres += paginas.get(i).obtenerCantidadCaracteres();
            }
            return cantidadCaracteres;
        }
        return -1;
    }

    public void agregarReferencia(int numeroPagina, String textoIdentificatorio) {
        if (numeroPagina > 0 && numeroPagina <= paginas.size()) {
            Pagina pagina = paginas.get(numeroPagina - 1);
            pagina.agregarReferencia(textoIdentificatorio);
        }
    }

    public void agregarPagina(int numeroPagina, String contenido) {
        if (numeroPagina >= 0 && numeroPagina <= paginas.size()) {
            paginas.add(numeroPagina - 1, new Pagina(contenido));
            for (int i = numeroPagina - 1; i < paginas.size(); i++) {
                paginas.get(i).setNumero(i + 1);
            }
            actualizarIndicesCapitulos();
        }
    }

    public void eliminarPagina(int numeroPagina) {
        if (numeroPagina > 0 && numeroPagina <= paginas.size()) {
            paginas.remove(numeroPagina - 1);
            for (int i = numeroPagina - 1; i < paginas.size(); i++) {
                paginas.get(i).setNumero(i + 1);
            }
            actualizarIndicesCapitulos();
        }
    }

    public String buscarContenidoPagina(int numeroPagina) {
        if (numeroPagina > 0 && numeroPagina <= paginas.size()) {
            return paginas.get(numeroPagina - 1).obtenerContenido();
        }
        return "Página no encontrada.";
    }

    private void actualizarIndicesCapitulos() {
        for (int i = 0; i < capitulos.size(); i++) {
            capitulos.get(i).setNumeroPaginaInicial(paginas.get(i).getNumero());
        }
    }
    
}





