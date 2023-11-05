package EjerciciosFinal;

import java.util.ArrayList;
import java.util.List;

class Hotel {
    private String nombre;
    private List<Habitacion> habitaciones;

    public Hotel(String nombre) {
        this.nombre = nombre;
        this.habitaciones = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarHabitacion(Habitacion habitacion) {
        habitaciones.add(habitacion);
    }

    public List<Habitacion> getHabitacionesDisponiblesEnFecha(String fecha) {
        List<Habitacion> disponibles = new ArrayList<>();
        for (Habitacion habitacion : habitaciones) {
            if (habitacion.estaDisponibleEnFecha(fecha)) {
                disponibles.add(habitacion);
            }
        }
        return disponibles;
    }

    @Override
    public String toString() {
        return "Hotel: " + nombre;
    }
}

class Habitacion {
    private int numero;
    private int capacidad;
    private double precioPorNoche;
    private List<Reserva> reservas;

    public Habitacion(int numero, int capacidad, double precioPorNoche) {
        this.numero = numero;
        this.capacidad = capacidad;
        this.precioPorNoche = precioPorNoche;
        this.reservas = new ArrayList<>();
    }

    public int getNumero() {
        return numero;
    }

    public boolean estaDisponibleEnFecha(String fecha) {
        for (Reserva reserva : reservas) {
            if (reserva.getFecha().equals(fecha)) {
                return false;
            }
        }
        return true;
    }

    public void reservar(String fecha, Cliente cliente) {
        Reserva reserva = new Reserva(fecha, cliente);
        reservas.add(reserva);
        cliente.agregarReserva(reserva);
    }

    public double calcularCostoTotal(String fechaInicio, String fechaFin) {
        int numNoches = obtenerNumeroNoches(fechaInicio, fechaFin);
        return numNoches * precioPorNoche;
    }

    private int obtenerNumeroNoches(String fechaInicio, String fechaFin) {
        // Aquí puedes implementar la lógica para calcular el número de noches
        return 0;
    }
}

class Reserva {
    private String fecha;
    private Cliente cliente;

    public Reserva(String fecha, Cliente cliente) {
        this.fecha = fecha;
        this.cliente = cliente;
    }

    public String getFecha() {
        return fecha;
    }
}

class Cliente {
    private String nombre;
    private List<Reserva> reservas;

    public Cliente(String nombre) {
        this.nombre = nombre;
        this.reservas = new ArrayList<>();
    }

    public void agregarReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    public List<Reserva> getReservas() {
        return reservas;
    }
}

public class SistemaReservas {
    public static void main(String[] args) {
        Hotel hotel = new Hotel("Hotel Ejemplo");
        Habitacion habitacion1 = new Habitacion(101, 2, 100.0);
        Habitacion habitacion2 = new Habitacion(102, 4, 150.0);

        hotel.agregarHabitacion(habitacion1);
        hotel.agregarHabitacion(habitacion2);

        Cliente cliente1 = new Cliente("Cliente 1");
        Cliente cliente2 = new Cliente("Cliente 2");

        habitacion1.reservar("2023-10-20", cliente1);
        habitacion1.reservar("2023-10-21", cliente1);
        habitacion2.reservar("2023-10-22", cliente2);

        List<Habitacion> disponibles = hotel.getHabitacionesDisponiblesEnFecha("2023-10-20");

        System.out.println(hotel);
        System.out.println("Habitaciones disponibles el 2023-10-20: " + disponibles);
        System.out.println(cliente1 + " reservas: " + cliente1.getReservas());
        System.out.println(cliente2 + " reservas: " + cliente2.getReservas());
    }
}
