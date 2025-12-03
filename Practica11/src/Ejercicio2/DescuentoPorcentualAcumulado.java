package Ejercicio2;

public class DescuentoPorcentualAcumulado implements EstrategiaDescuento {
    @Override
    public double aplicarDescuento(Producto p, int cantidad) {

        if (cantidad >= 3) {
            double precioTotal = p.getPrecio() * cantidad;
            double descuento = p.getPrecio() * 0.50; 
            return precioTotal - descuento;
        }

        return p.getPrecio() * cantidad;
    }
}
