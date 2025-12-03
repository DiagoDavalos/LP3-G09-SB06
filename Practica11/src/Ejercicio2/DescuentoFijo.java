package Ejercicio2;

public class DescuentoFijo implements EstrategiaDescuento {
    @Override
    public double aplicarDescuento(Producto p, int cantidad) {
        return p.getPrecio() * cantidad * 0.90;
    }
}
