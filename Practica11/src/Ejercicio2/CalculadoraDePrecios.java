package Ejercicio2;

public class CalculadoraDePrecios {

    private EstrategiaDescuento estrategia;

    public void setEstrategia(EstrategiaDescuento estrategia) {
        this.estrategia = estrategia;
    }

    public double calcular(Producto p, int cantidad) {
        return estrategia.aplicarDescuento(p, cantidad);
    }
}
