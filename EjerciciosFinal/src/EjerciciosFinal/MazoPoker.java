package EjerciciosFinal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MazoPoker {
    private List<Carta> mazo;
    
    

    public MazoPoker() {
        mazo = new ArrayList<>();
        // Crear cartas del 1 al 10 en cada palo
        for (int numero = 1; numero <= 10; numero++) {
            for (Palo palo : Palo.values()) {
                mazo.add(new Carta(numero, palo));
            }
        }
        // Agregar figuras (J, Q, K) en cada palo
        for (Palo palo : Palo.values()) {
            mazo.add(new Carta(11, palo)); // J
            mazo.add(new Carta(12, palo)); // Q
            mazo.add(new Carta(13, palo)); // K
        }
    }

    public void barajar() {
        Collections.shuffle(mazo);
    }

    public List<Carta> sacarXCartasDeArriba(int cantidad) {
        if (cantidad > mazo.size()) {
            cantidad = mazo.size();
        }
        List<Carta> cartasSacadas = new ArrayList<>();
        for (int i = 0; i < cantidad; i++) {
            cartasSacadas.add(mazo.remove(0));
        }
        return cartasSacadas;
    }

    public List<Carta> sacarXCartasDeAbajo(int cantidad) {
        if (cantidad > mazo.size()) {
            cantidad = mazo.size();
        }
        List<Carta> cartasSacadas = new ArrayList<>();
        for (int i = 0; i < cantidad; i++) {
            cartasSacadas.add(mazo.remove(mazo.size() - 1));
        }
        return cartasSacadas;
    }

    public void colocarXCartasArriba(List<Carta> cartas) {
        mazo.addAll(0, cartas);
    }

    public void colocarXCartasAbajo(List<Carta> cartas) {
        mazo.addAll(cartas);
    }

    public void ordenarMazoSegunOrdenDePalos() {
        Collections.sort(mazo, new CartaComparator());
    }

    public List<Carta> getMazo() {
        return mazo;
    }

    public static void main(String[] args) {
        MazoPoker mazo = new MazoPoker();
        System.out.println("Mazo original:");
        mazo.barajar();
        for (Carta carta : mazo.getMazo()) {
            System.out.println(carta);
        }

        System.out.println("\nMazo ordenado por palos:");
        mazo.ordenarMazoSegunOrdenDePalos();
        for (Carta carta : mazo.getMazo()) {
            System.out.println(carta);
        }
    }
}

class Carta {
    private int numero;
    private Palo palo;

    public Carta(int numero, Palo palo) {
        this.numero = numero;
        this.palo = palo;
    }

    public int getNumero() {
        return numero;
    }

    public Palo getPalo() {
        return palo;
    }

    @Override
    public String toString() {
        return numero + " de " + palo;
    }
}

enum Palo {
    PICA, CORAZON, DIAMANTE, TREBOL
}

class CartaComparator implements java.util.Comparator<Carta> {
    @Override
    public int compare(Carta carta1, Carta carta2) {
        int paloComparison = carta1.getPalo().compareTo(carta2.getPalo());
        if (paloComparison != 0) {
            return paloComparison;
        }
        return Integer.compare(carta1.getNumero(), carta2.getNumero());
    }
}






