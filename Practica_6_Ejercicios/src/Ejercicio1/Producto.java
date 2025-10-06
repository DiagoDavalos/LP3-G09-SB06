package Ejercicio1;

public class Producto {
    private String nombre;
    private double precio;
    private String tipo;

    public Producto(String nombre, double precio, String tipo) {
        this.nombre = nombre;
        this.precio = precio;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return nombre + " - Tipo: " + tipo + " - Precio: S/" + precio;
    }
}
