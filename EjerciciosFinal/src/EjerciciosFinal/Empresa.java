package EjerciciosFinal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Empresa {
    private Map<String, Area> areas;

    public Empresa() {
        areas = new HashMap<>();
    }

    public void registrarNuevoEmpleado(String nombre, String apellido, int numeroEmpleado, String nombreArea) {
        if (areas.containsKey(nombreArea)) {
            areas.get(nombreArea).registrarEmpleado(new Empleado(nombre, apellido, numeroEmpleado));
        } else {
            Area nuevaArea = new Area(nombreArea);
            nuevaArea.registrarEmpleado(new Empleado(nombre, apellido, numeroEmpleado));
            areas.put(nombreArea, nuevaArea);
        }
    }

    public void transferirEmpleado(int numeroEmpleado, String nombreAreaOrigen, String nombreAreaDestino) {
        if (areas.containsKey(nombreAreaOrigen) && areas.containsKey(nombreAreaDestino)) {
            Empleado empleado = areas.get(nombreAreaOrigen).obtenerEmpleadoPorNumero(numeroEmpleado);
            if (empleado != null) {
                areas.get(nombreAreaOrigen).darDeBajaEmpleado(numeroEmpleado);
                areas.get(nombreAreaDestino).registrarEmpleado(empleado);
                System.out.println("Empleado transferido con éxito.");
            } else {
                System.out.println("Empleado no encontrado en el área de origen.");
            }
        } else {
            System.out.println("Área de origen o destino no encontrada.");
        }
    }

    public void darDeBajaEmpleado(int numeroEmpleado) {
        for (Area area : areas.values()) {
            if (area.darDeBajaEmpleado(numeroEmpleado)) {
                System.out.println("Empleado dado de baja con éxito.");
                return;
            }
        }
        System.out.println("Empleado no encontrado en ninguna área.");
    }

    public String obtenerAreaDeEmpleado(int numeroEmpleado) {
        for (Area area : areas.values()) {
            if (area.existeEmpleado(numeroEmpleado)) {
                return area.getNombre();
            }
        }
        return "Empleado no encontrado en ninguna área.";
    }

    public static void main(String[] args) {
        Empresa empresa = new Empresa();

        empresa.registrarNuevoEmpleado("Juan", "Pérez", 1, "Ventas");
        empresa.registrarNuevoEmpleado("María", "Gómez", 2, "Recursos Humanos");
        empresa.registrarNuevoEmpleado("Pedro", "Sánchez", 3, "TI");

        System.out.println("Área de Juan Pérez: " + empresa.obtenerAreaDeEmpleado(1));

        empresa.transferirEmpleado(2, "Recursos Humanos", "Ventas");
        System.out.println("Área de María Gómez después de la transferencia: " + empresa.obtenerAreaDeEmpleado(2));

        empresa.darDeBajaEmpleado(3);
        System.out.println("Área de Pedro Sánchez después de la baja: " + empresa.obtenerAreaDeEmpleado(3));
    }
}

class Area {
    private String nombre;
    private List<Empleado> empleados;

    public Area(String nombre) {
        this.nombre = nombre;
        empleados = new ArrayList<>();
    }

    public void registrarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    public Empleado obtenerEmpleadoPorNumero(int numeroEmpleado) {
        for (Empleado empleado : empleados) {
            if (empleado.getNumeroEmpleado() == numeroEmpleado) {
                return empleado;
            }
        }
        return null;
    }

    public boolean darDeBajaEmpleado(int numeroEmpleado) {
        for (Empleado empleado : empleados) {
            if (empleado.getNumeroEmpleado() == numeroEmpleado) {
                empleados.remove(empleado);
                return true;
            }
        }
        return false;
    }

    public boolean existeEmpleado(int numeroEmpleado) {
        for (Empleado empleado : empleados) {
            if (empleado.getNumeroEmpleado() == numeroEmpleado) {
                return true;
            }
        }
        return false;
    }

    public String getNombre() {
        return nombre;
    }
}

class Empleado {
    private String nombre;
    private String apellido;
    private int numeroEmpleado;

    public Empleado(String nombre, String apellido, int numeroEmpleado) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numeroEmpleado = numeroEmpleado;
    }

    public int getNumeroEmpleado() {
        return numeroEmpleado;
    }
}
