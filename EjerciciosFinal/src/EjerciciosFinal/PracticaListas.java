package EjerciciosFinal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PracticaListas {
	
	public static void main(String[] args) {
		// Crear un mapa de estudiantes con su edad
		//gracias a hashmap podemos 1) Guardar datos del tipo key-value, 2) no permite claves duplicadas
		//3)permite valores nulos, 4) no garantiza el orden
		Map<String,Integer> estudiantes = new HashMap<>();
		//se utiliza put para añadir elementos
		
		estudiantes.put("pedro", 15);
		estudiantes.put("juan", 23);
		estudiantes.put("bau", 234);
		estudiantes.put("pedros", 215);
		System.out.println(estudiantes);
		
		// se puede acceder a datos
		int edadPedro = estudiantes.get("pedro");
		System.out.println(edadPedro);
	
	
	//List<type>
		
		List<Integer> edades = new ArrayList<>();
		// se utiliza add para agregar datos
		
		edades.add(15);
		edades.add(16);
		edades.add(15);
		edades.add(61);
		System.out.println(edades);
		//imprime el valor en la posicion de memoria del arreglo
		System.out.println(edades.get(1));
		
		
	//Arreglo de numeros type[] definition
		
		int[] numeros = new int[3];
		//no posee funcionalidades estilo add put
		
		numeros[0] = 15;
		numeros[1] = 151;
		numeros[2] = 153;
		
		System.out.println(numeros[0]);
		System.out.println(numeros[1]);
		System.out.println(numeros[2]);
	
		
		
	//ArrayList lista de cadenas
		
		List<String> cadenas = new ArrayList<>();
		
		cadenas.add("pedro");
		cadenas.add("gomez");
		cadenas.add("asdas");
		System.out.println(cadenas);
	
	
	
		//List<List<T>> lsitas de listas
		
		
		//Defino la lsita de listas
			List<List<Integer>> ListaDeListas = new ArrayList<>();
		


		//Defino una lista interna
			List<Integer> listaInterna = new ArrayList<>();
			
			listaInterna.add(15);
			listaInterna.add(12);
			
			ListaDeListas.add(listaInterna);
			System.out.println(ListaDeListas);
	
		//acceder a un elemento especifico
			
			//se accede segun indices, el primer get es la fila y el segundo
			//la columna
			System.out.println(ListaDeListas.get(0).get(0));
	
		
		//iterar la lista de listas
			
			for(List<Integer> ListaInterna : ListaDeListas) {
				for(Integer elemento : ListaInterna) {
					System.out.println(elemento);
				}
			}
	
	//Agregar una lista con elementos iniciales
			
			List<Integer> agregadaLista = Arrays.asList(15,14,12,12,51);
			ListaDeListas.add(agregadaLista);
			System.out.println(ListaDeListas);
			System.out.println(ListaDeListas.get(1).get(4));
			
	
	//eliminar una fila
			
			ListaDeListas.remove(1);
			System.out.println(ListaDeListas);
	
	//tamaño de una lista
			System.out.println(ListaDeListas.size());
			
	
	//verificar si una lista esta vacia
			System.out.println(ListaDeListas.get(0).isEmpty());
	
	
			// int[][] manejo de matrices
			
			
			int[][] matriz = new int[3][3]; //Crea una matriz de 3x3
		
			
		//inicializo la matriz
			
			int[][] matriz1 = { {1, 2, 3}, {4, 5, 6}, {7, 8, 9} };
			
			
		//acceder a un elemento
			
			int elemento = matriz1[1][2];
			System.out.println(elemento);
	
			
		//iterar a travez de una matriz
			
			for(int i = 0; i<matriz1.length; i++) {
				for(int j = 0; j<matriz1[i].length; j++) {
					int element = matriz1[i][j];
					System.out.println(element+ " ");
				}
				System.out.println();
			}
			
		//obtener longitud de una fila
			
			int longitud = matriz1[1].length;
			System.out.println(longitud);
		
		//copiar una matriz
			
			int[][] copiaMatriz = new int[matriz1.length][matriz1[0].length];
			for(int i = 0; i<matriz.length;i++) {
				for(int j = 0; j<matriz[i].length; j++) {
					copiaMatriz[i][j] = matriz1[i][j];
				}
			}
			System.out.println(copiaMatriz[1][2]);
			

			
		//buscar un elemento
			
			int elementoBuscado = 1
					;
			boolean encontrado = false;
			for(int i = 0; i<matriz1.length;i++) {
				for(int j = 0; i<matriz[i].length; j++) {
					if(matriz1[i][j] == elementoBuscado) {
						encontrado = true;
						break;
					}
				}
				if(encontrado) {
					break;
				}
			}
			
	}
	
		
	
	
		
	
}
