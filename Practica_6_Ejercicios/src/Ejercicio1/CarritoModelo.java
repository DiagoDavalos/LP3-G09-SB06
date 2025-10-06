package Ejercicio1;

import java.util.ArrayList;
import java.util.List;

public class CarritoModelo {
    private List<Producto> productosDisponibles;
    private List<Producto> carrito;
    private List<List<Producto>> historialCompras;

    public CarritoModelo() {
        productosDisponibles = new ArrayList<>();
        carrito = new ArrayList<>();
        historialCompras = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        productosDisponibles.add(producto);
    }

    public List<Producto> getProductosDisponibles() {
        return productosDisponibles;
    }

    public void agregarAlCarrito(Producto producto) {
        carrito.add(producto);
    }

    public List<Producto> getCarrito() {
        return carrito;
    }

    public void eliminarDelCarrito(int index) {
        if (index >= 0 && index < carrito.size()) {
            carrito.remove(index);
        }
    }

    public double calcularTotal() {
        double total = 0;
        for (Producto p : carrito) {
            total += p.getPrecio();
        }
        return total;
    }
    
    public double aplicarDescuento(double total, double porcentaje) {
        return total - (total * porcentaje / 100);
    }

    public double calcularEnvio(double total) {
        if (total >= 100) { 
            return 0;
        } else {
            return 10;
        }
    }

    public void guardarCompra() {
        if (!carrito.isEmpty()) {
            historialCompras.add(new ArrayList<>(carrito));
            carrito.clear();
        }
    }

    public List<List<Producto>> getHistorialCompras() {
        return historialCompras;
    }
}
