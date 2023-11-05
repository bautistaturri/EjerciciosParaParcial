package EjerciciosFinal;

public class App {
    public static void main(String[] args) {
    Integer[][] m1 = {
        {11, 2, 3, 4},
        {5, 1, 7, 8},
        {5, 1, 3, 9}
    };
    String[] cols = {"A", "B", "C", "D"};
    String[] filas = {"x", "y", "z"};
    Matriz<Integer> miMatriz = new Matriz<>(m1, cols, filas);
    // Matriz<Integer> miMatriz = Matriz.crearDesdeMatriz(m1);
    // miMatriz.setCelda(0, 0, 9);
    System.out.println("se obtuvo la celda " + miMatriz.getCelda("x", "C"));
    miMatriz.setCelda(2, 2, 18);
    System.out.println(miMatriz);
    miMatriz.ordernarPorColumnas(new String[] {"A", "B", "C"});

    System.out.println(miMatriz);
}
}
