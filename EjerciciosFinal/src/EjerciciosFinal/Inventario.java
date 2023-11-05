package EjerciciosFinal;

import java.util.ArrayList;
import java.util.List;

class Producto {
    private String nombre;
    private double precio;
    private int cantidadEnStock;

    public Producto(String nombre, double precio, int cantidadEnStock) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidadEnStock = cantidadEnStock;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantidadEnStock() {
        return cantidadEnStock;
    }

    public void vender(int cantidad) {
        if (cantidad > 0 && cantidad <= cantidadEnStock) {
            cantidadEnStock -= cantidad;
            System.out.println("Venta realizada. Stock actual: " + cantidadEnStock);
        } else {
            System.out.println("No hay suficiente stock para esta venta.");
        }
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Precio: $" + precio + ", Stock: " + cantidadEnStock;
    }
}

class Inventario {
    private List<Producto> productos;

    public Inventario() {
        productos = new ArrayList<>();
    }

    public void agregarProducto(String nombre, double precio, int cantidad) {
        Producto producto = new Producto(nombre, precio, cantidad);
        productos.add(producto);
        System.out.println("Producto agregado al inventario: " + producto.getNombre());
    }

    public void actualizarStock(String nombre, int cantidad) {
        for (Producto producto : productos) {
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                producto.vender(cantidad);
                return;
            }
        }
        System.out.println("Producto no encontrado en el inventario.");
    }

    public double calcularValorTotal() {
        double valorTotal = 0;
        for (Producto producto : productos) {
            valorTotal += producto.getPrecio() * producto.getCantidadEnStock();
        }
        return valorTotal;
    }

    public void mostrarProductosAgotados() {
        System.out.println("Productos agotados:");
        for (Producto producto : productos) {
            if (producto.getCantidadEnStock() == 0) {
                System.out.println(producto);
            }
        }
    }

    public void buscarProductoPorNombre(String nombre) {
        for (Producto producto : productos) {
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("Información del producto:");
                System.out.println(producto);
                return;
            }
        }
        System.out.println("Producto no encontrado en el inventario.");
    }

    public void buscarProductosPorNombreParcial(String nombreParcial) {
        System.out.println("Productos encontrados (nombre parcial):");
        for (Producto producto : productos) {
            if (producto.getNombre().toLowerCase().contains(nombreParcial.toLowerCase())) {
                System.out.println(producto);
            }
        }
    }
    
    public static void main(String[] args) {
        Inventario inventario = new Inventario();

        inventario.agregarProducto("Producto A", 10.0, 20);
        inventario.agregarProducto("Producto B", 15.0, 15);

        inventario.actualizarStock("Producto A", 5);
        inventario.actualizarStock("Producto C", 3);

        double valorTotal = inventario.calcularValorTotal();
        System.out.println("Valor total del inventario: $" + valorTotal);

        inventario.mostrarProductosAgotados();

        inventario.buscarProductoPorNombre("Producto A");
        inventario.buscarProductosPorNombreParcial("b");
    }
}

