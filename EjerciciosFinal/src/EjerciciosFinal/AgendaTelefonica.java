package EjerciciosFinal;

import java.util.HashMap;
import java.util.Map;

public class AgendaTelefonica {
    private Map<String, Individuo> agenda;

    public AgendaTelefonica() {
        agenda = new HashMap<>();
    }

    public void agregarIndividuo(String nombre, String direccion, String telefono) {
        Individuo individuo = new Individuo(nombre, direccion, telefono);
        agenda.put(nombre, individuo);
    }

    public void eliminarIndividuo(String nombre) {
        agenda.remove(nombre);
    }

    public String obtenerDireccionYTelefono(String nombre) {
        Individuo individuo = agenda.get(nombre);
        if (individuo != null) {
            return "Nombre: " + individuo.getNombre() + "\nDirección: " + individuo.getDireccion() + "\nTeléfono: " + individuo.getTelefono();
        } else {
            return "Individuo no encontrado en la agenda.";
        }
    }

    public static void main(String[] args) {
        AgendaTelefonica agenda = new AgendaTelefonica();

        // Agregar individuos
        agenda.agregarIndividuo("Juan", "Calle A, Ciudad X", "123-456-7890");
        agenda.agregarIndividuo("María", "Calle B, Ciudad Y", "987-654-3210");

        // Obtener información de un individuo
        String infoJuan = agenda.obtenerDireccionYTelefono("Juan");
        String infoMaria = agenda.obtenerDireccionYTelefono("María");
        String infoPedro = agenda.obtenerDireccionYTelefono("Pedro");

        System.out.println(infoJuan);
        System.out.println(infoMaria);
        System.out.println(infoPedro);

        // Eliminar un individuo
        agenda.eliminarIndividuo("Juan");
        String infoJuanDespuesDeEliminar = agenda.obtenerDireccionYTelefono("Juan");
        System.out.println(infoJuanDespuesDeEliminar);
    }
}

class Individuo {
    private String nombre;
    private String direccion;
    private String telefono;

    public Individuo(String nombre, String direccion, String telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }
}
