package EjerciciosFinal;

public class Capitulo {
	int numeroPaginaInicial;
	String nombre;
	
	public Capitulo(String nombre, int numeroPaginaInicial) {
		this.nombre = nombre;
		this.numeroPaginaInicial = numeroPaginaInicial;
	}
	public String getNombre() {
        return nombre;
    }

    public int getNumeroPaginaInicial() {
        return numeroPaginaInicial;
    }
    public void setNumeroPaginaInicial(int numeroPaginaInicial) {
    	this.numeroPaginaInicial = numeroPaginaInicial;
    }
  
}
