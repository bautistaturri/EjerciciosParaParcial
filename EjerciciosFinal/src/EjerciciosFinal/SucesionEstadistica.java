

package EjerciciosFinal;
import java.util.ArrayList;
import java.util.List;

public class SucesionEstadistica {
	private List<Double> elementos;

	public List<Double> getListaElementos() {
        return elementos;
    }
	//metodo constructor que inicializa un array
	public SucesionEstadistica() {
		elementos = new ArrayList<>();
	}
	
	public void agregarElemento(double elemento) {
		elementos.add(elemento);
	}
	
	public int getCantElemento() {
		return elementos.size();
	}
	
	public double getMediaAritmetica() {
		if(elementos.isEmpty()) {
			return 0.0;
		}
		//inicializo la suma
		double sum = 0.0;
		for(double elemento:elementos) {
			sum +=elemento;
		}
		return sum/elementos.size();
	}
	
	public double getDesviacionEstandar() {
        if (elementos.isEmpty() || elementos.size() == 1) {
            return 0.0; // Puedes elegir manejar el caso de lista vacía o con un solo elemento como desviación 0
        }

        double media = getMediaAritmetica();
        double sumaCuadradosDiferencia = 0.0;

        for (double elemento : elementos) {
            sumaCuadradosDiferencia += Math.pow(elemento - media, 2);
        }

        double varianza = sumaCuadradosDiferencia / (elementos.size() - 1); // Usamos n-1 para calcular la varianza
        return Math.sqrt(varianza);
    }
	
	public static void main(String[] args) {
		SucesionEstadistica sucesion = new SucesionEstadistica();
		sucesion.agregarElemento(10.0);
		sucesion.agregarElemento(20.0);
		sucesion.agregarElemento(30.0);
		
		List<Double> elementos = sucesion.getListaElementos();
		
		System.out.println(sucesion);
		System.out.println("la cantidad de elementos es "+sucesion.getCantElemento());
		System.out.println("el desvio estandar es "+ sucesion.getDesviacionEstandar() + 
				"y la media aritmetica es "+ sucesion.getMediaAritmetica());
		System.out.println("elementos de la sucesion");
		for (double elemento : elementos) {
            System.out.println(elemento);
        }
	}
	
	
}
	

