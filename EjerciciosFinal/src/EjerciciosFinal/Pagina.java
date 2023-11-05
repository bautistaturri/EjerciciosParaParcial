package EjerciciosFinal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
class Pagina {
    private int numero;
    private String contenido;
    private List<String> referencias;

    public Pagina(String contenido) {
        this.contenido = contenido;
        this.referencias = new ArrayList<>();
    }

    public Pagina(String contenido, int numero) {
        this.numero = numero;
        this.contenido = contenido;
        this.referencias = new ArrayList<>();
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String obtenerContenido() {
        return contenido;
    }

    public int obtenerCantidadPalabras() {
        String[] palabras = contenido.split("\\s+");
        return palabras.length;
    }

    public int obtenerCantidadCaracteres() {
        return contenido.length();
    }

    public void agregarReferencia(String textoIdentificatorio) {
        referencias.add(textoIdentificatorio);
    }
}