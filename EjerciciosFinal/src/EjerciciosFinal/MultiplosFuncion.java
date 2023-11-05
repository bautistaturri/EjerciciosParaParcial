package EjerciciosFinal;

public class MultiplosFuncion {
    public static int[] multiplos(int X, int Y) {
        if (X <= 0 || Y <= 0) {
            throw new IllegalArgumentException("X e Y deben ser números enteros positivos.");
        }

        int[] resultado = new int[Y];
        for (int i = 0; i < Y; i++) {
            resultado[i] = X * (i + 1);
        }
        return resultado;
    }

    public static void main(String[] args) {
        int X = 3;
        int Y = 6;

        int[] multiplosDeX = multiplos(X, Y);

        System.out.print("[");
        for (int i = 0; i < multiplosDeX.length; i++) {
            System.out.print(multiplosDeX[i]);
            if (i < multiplosDeX.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
