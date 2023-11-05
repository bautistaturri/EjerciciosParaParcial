package EjerciciosFinal;

public class OrdenarSecuencia {
	public static boolean esSecuencia(int[] arreglo) {

	    // Crear un arreglo vacío para almacenar los números de la secuencia.
	    int[] secuencia = new int[arreglo.length];

	    // Iterar sobre el arreglo de números enteros, agregando cada número a la secuencia si no hay un número consecutivo en la secuencia.
	    int indiceSecuencia = 0;
	    for (int numero : arreglo) {
	        if (indiceSecuencia == 0 || numero == secuencia[indiceSecuencia - 1] + 1) {
	            secuencia[indiceSecuencia++] = numero;
	        }
	    }

	    // Si la secuencia tiene todos los números del arreglo de números enteros, entonces es posible reordenarlos para formar una secuencia de números consecutivos sin repeticiones.
	    return indiceSecuencia == arreglo.length;
	}
	public static void main(String[] args) {
		int[] cadena = {1,2,3,4,5,6,7};
		System.out.println(esSecuencia(cadena));
	}
	
	
}
