package Actividad2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PedidoModelo {
    private List<Pedido> pedidos;

    public PedidoModelo() {
        pedidos = new ArrayList<>();
    }

    public void agregarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public void eliminarPedido(int index) {
        if (index >= 0 && index < pedidos.size()) {
            pedidos.remove(index);
        }
    }

    public void actualizarPedido(int index, String nuevoNombre, String nuevoTipo) {
        if (index >= 0 && index < pedidos.size()) {
            Pedido pedido = pedidos.get(index);
            pedido.setNombrePlato(nuevoNombre);
            pedido.setTipoPlato(nuevoTipo);
        }
    }

    public List<Pedido> buscarPorNombre(String nombre) {
        return pedidos.stream()
                .filter(p -> p.getNombrePlato().equalsIgnoreCase(nombre))
                .collect(Collectors.toList());
    }

    public List<Pedido> buscarPorTipo(String tipo) {
        return pedidos.stream()
                .filter(p -> p.getTipoPlato().equalsIgnoreCase(tipo))
                .collect(Collectors.toList());
    }

    public int contarPedidos() {
        return pedidos.size();
    }

    public long contarPedidosPorTipo(String tipo) {
        return pedidos.stream()
                .filter(p -> p.getTipoPlato().equalsIgnoreCase(tipo))
                .count();
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }
}
