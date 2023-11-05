package EjerciciosFinal;

public class MaximosMinimos {

	    public static void main(String[] args) {
	        String numeros = "5 -3 12 8 2 1 0 -9";
	        int[] resultado = maxMin(numeros);
	        System.out.println("Máximo: " + resultado[0]);
	        System.out.println("Mínimo: " + resultado[1]);
	    }

	    public static int[] maxMin(String numeros) {
	        String[] numerosArray = numeros.split(" ");
	        if (numerosArray.length == 0) {
	            // Manejar caso de cadena vacía
	            return new int[] { 0, 0 };
	        }

	        int maximo = Integer.MIN_VALUE;
	        int minimo = Integer.MAX_VALUE;

	        for (String numeroStr : numerosArray) {
	            try {
	                int numero = Integer.parseInt(numeroStr);
	                maximo = Math.max(maximo, numero);
	                minimo = Math.min(minimo, numero);
	            } catch (NumberFormatException e) {
	                // Ignorar valores no válidos
	            }
	        }

	        return new int[] { maximo, minimo };
	    }
	}
