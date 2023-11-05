package EjerciciosFinal;

public class VueltaCadena {

	public static String reversa(String cadena) {
		//convierto la cadena a una cadena de catacteres
		char[] caracteres = cadena.toCharArray();
		
		//incializo dos indices, uno al comienzo y otro al final
		int inicio = 0;
		int fin = caracteres.length - 1;
		
		while(inicio < fin) {
			char temp = caracteres[inicio];
			caracteres[inicio] = caracteres[fin];
			caracteres[fin] = temp;
			inicio ++;
			fin --;
		}
		
		
		
		return new String(caracteres);
	}
	public static void main(String[] args) {
		String cadena = "hola";
		System.out.println(reversa(cadena));
	}
	
}
