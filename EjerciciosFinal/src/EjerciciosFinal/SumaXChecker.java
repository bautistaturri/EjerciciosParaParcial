package EjerciciosFinal;

import java.util.HashSet;

public class SumaXChecker {
	public static boolean sumaX(int[] numeros,int X) {
		
		HashSet<Integer> elementosVistos = new HashSet<>();
		for(int numero : numeros) {
			int complemento = X - numero;
		
		if(elementosVistos.contains(complemento)) {
			return true;
		}
		//si cumple lo agregamos a la lista
		elementosVistos.add(numero);
		}
		return false;
	}
	public static void main(String[] args) {
        int[] arreglo = {1, 6, 0, 3, 5, 4, 3};
        int X = 8;

        if (sumaX(arreglo, X)) {
            System.out.println("Sí existen 3 números en el arreglo que suman " + X);
        } else {
            System.out.println("No existen 3 números en el arreglo que sumen " + X);
        }
    }
	
}
