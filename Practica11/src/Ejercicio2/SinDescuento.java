package Ejercicio2;

public class SinDescuento implements EstrategiaDescuento {
    @Override
    public double aplicarDescuento(Producto p, int cantidad) {
        return p.getPrecio() * cantidad;
    }
}
