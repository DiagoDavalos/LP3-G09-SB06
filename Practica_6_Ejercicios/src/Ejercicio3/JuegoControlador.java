package Ejercicio3;

public class JuegoControlador {
    private JuegoModelo modelo;
    private JuegoVista vista;

    public JuegoControlador(JuegoModelo modelo, JuegoVista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void iniciarJuego() {
        String nombreJugador = vista.leerTexto("Ingresa el nombre del jugador: ");
        modelo.crearJugador(nombreJugador);
        modelo.crearEnemigo("Goblin");

        vista.mostrarMensaje("Comienza la batalla");
        vista.mostrarEstado(modelo.getJugador(), modelo.getEnemigo());

        int opcion;
        do {
            vista.mostrarMenu();
            opcion = vista.leerOpcion();

            switch (opcion) {
                case 1:
                    vista.mostrarMensaje("El jugador ataca al enemigo...");
                    modelo.ataqueJugador();
                    if (!modelo.getEnemigo().estaVivo()) break;

                    vista.mostrarMensaje("El enemigo contraataca...");
                    modelo.ataqueEnemigo();
                    break;

                case 2:
                    vista.mostrarEstado(modelo.getJugador(), modelo.getEnemigo());
                    break;

                case 3:
                    vista.mostrarMensaje("El jugador se ha rendido.");
                    modelo.getJugador().recibirDano(999); 
                    break;

                default:
                    vista.mostrarMensaje("Opción inválida.");
            }

        } while (!modelo.juegoTerminado());

        vista.mostrarEstado(modelo.getJugador(), modelo.getEnemigo());
        vista.mostrarMensaje("\n" + modelo.obtenerGanador());
        vista.cerrarScanner();
    }
}
