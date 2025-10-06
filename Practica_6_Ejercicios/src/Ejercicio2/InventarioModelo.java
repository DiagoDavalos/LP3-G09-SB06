package Ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class InventarioModelo {
    private List<Producto> productos;

    public InventarioModelo() {
        productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public Producto buscarProducto(String nombre) {
        for (Producto p : productos) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                return p;
            }
        }
        return null;
    }

    public void eliminarProducto(String nombre) {
        Producto producto = buscarProducto(nombre);
        if (producto != null) {
            productos.remove(producto);
        }
    }

    public boolean actualizarProducto(String nombre, int nuevaCantidad, double nuevoPrecio) {
        Producto producto = buscarProducto(nombre);
        if (producto != null) {
            producto.setCantidad(nuevaCantidad);
            producto.setPrecio(nuevoPrecio);
            return true;
        }
        return false;
    }
}
