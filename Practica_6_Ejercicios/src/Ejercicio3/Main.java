package Ejercicio3;

public class Main {
    public static void main(String[] args) {
        JuegoModelo modelo = new JuegoModelo();
        JuegoVista vista = new JuegoVista();
        JuegoControlador controlador = new JuegoControlador(modelo, vista);
        controlador.iniciarJuego();
    }
}
