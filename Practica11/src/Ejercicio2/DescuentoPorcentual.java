package Ejercicio2;

public class DescuentoPorcentual implements EstrategiaDescuento {
    @Override
    public double aplicarDescuento(Producto p, int cantidad) {

        if (cantidad == 2) {
            return p.getPrecio() * cantidad * 0.70;
        }

        return p.getPrecio() * cantidad;
    }
}
