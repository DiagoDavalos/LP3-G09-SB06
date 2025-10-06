package Actividad2;

import java.util.List;

public class PedidoControlador {
    private PedidoModelo modelo;
    private PedidoVista vista;

    public PedidoControlador(PedidoModelo modelo, PedidoVista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void agregarPedido(String nombre, String tipo) {
        if (!nombre.isEmpty() && !tipo.isEmpty()) {
            modelo.agregarPedido(new Pedido(nombre, tipo));
            vista.mostrarMensaje("Pedido agregado: " + nombre + " (" + tipo + ")");
        } else {
            vista.mostrarMensaje("El nombre y tipo no pueden estar vacíos.");
        }
    }

    public void mostrarPedidos() {
        vista.mostrarPedidos(modelo.getPedidos());
    }

    public void eliminarPedido(int index) {
        if (index >= 0 && index < modelo.getPedidos().size()) {
            Pedido eliminado = modelo.getPedidos().get(index);
            modelo.eliminarPedido(index);
            vista.mostrarMensaje(" Pedido eliminado: " + eliminado);
        } else {
            vista.mostrarMensaje(" Índice inválido.");
        }
    }

    public void actualizarPedido(int index, String nuevoNombre, String nuevoTipo) {
        if (index >= 0 && index < modelo.getPedidos().size()) {
            modelo.actualizarPedido(index, nuevoNombre, nuevoTipo);
            vista.mostrarMensaje(" Pedido actualizado.");
        } else {
            vista.mostrarMensaje(" Índice inválido.");
        }
    }

    public void buscarPorNombre(String nombre) {
        List<Pedido> resultados = modelo.buscarPorNombre(nombre);
        vista.mostrarPedidos(resultados);
    }

    public void buscarPorTipo(String tipo) {
        List<Pedido> resultados = modelo.buscarPorTipo(tipo);
        vista.mostrarPedidos(resultados);
    }

    public void contarPedidos() {
        vista.mostrarMensaje(" Total de pedidos: " + modelo.contarPedidos());
    }

    public void contarPedidosPorTipo(String tipo) {
        vista.mostrarMensaje(" Pedidos del tipo '" + tipo + "': " + modelo.contarPedidosPorTipo(tipo));
    }

    public void iniciar() {
        String opcion;
        do {
            vista.mostrarMenu();
            opcion = vista.solicitarOpcion();
            switch (opcion) {
                case "1":
                    String nombre = vista.solicitarNombrePlato();
                    String tipo = vista.solicitarTipoPlato();
                    agregarPedido(nombre, tipo);
                    break;
                case "2":
                    mostrarPedidos();
                    break;
                case "3":
                    mostrarPedidos();
                    eliminarPedido(vista.solicitarIndice());
                    break;
                case "4":
                    mostrarPedidos();
                    int index = vista.solicitarIndice();
                    String nuevoNombre = vista.solicitarNombrePlato();
                    String nuevoTipo = vista.solicitarTipoPlato();
                    actualizarPedido(index, nuevoNombre, nuevoTipo);
                    break;
                case "5":
                    buscarPorNombre(vista.solicitarNombrePlato());
                    break;
                case "6":
                    buscarPorTipo(vista.solicitarTipoPlato());
                    break;
                case "7":
                    contarPedidos();
                    break;
                case "8":
                    vista.mostrarMensaje(" Saliendo...");
                    break;
                default:
                    vista.mostrarMensaje(" Opción no válida.");
            }
        } while (!opcion.equals("8"));
        vista.cerrarScanner();
    }
}
