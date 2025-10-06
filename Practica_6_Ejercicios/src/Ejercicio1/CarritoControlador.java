package Ejercicio1;
import java.util.List;
public class CarritoControlador {
    private CarritoModelo modelo;
    private CarritoVista vista;

    public CarritoControlador(CarritoModelo modelo, CarritoVista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }
    public void iniciar() {
        int opcion;
        do {
            vista.mostrarMenu();
            opcion = vista.leerOpcion();

            switch (opcion) {
                case 1: 
                    String nombre = vista.leerTexto("Nombre del producto: ");
                    double precio = vista.leerNumero("Precio del producto: S/");
                    String tipo = vista.leerTexto("Tipo de producto: ");
                    modelo.agregarProducto(new Producto(nombre, precio, tipo));
                    vista.mostrarMensaje("Producto agregado al catálogo.");
                    break;

                case 2: 
                    vista.mostrarMensaje("Productos disponibles:");
                    vista.mostrarProductos(modelo.getProductosDisponibles());
                    break;

                case 3: 
                    vista.mostrarProductos(modelo.getProductosDisponibles());
                    int indexAgregar = (int) vista.leerNumero("Elige el número del producto: ") - 1;
                    List<Producto> disponibles = modelo.getProductosDisponibles();
                    if (indexAgregar >= 0 && indexAgregar < disponibles.size()) {
                        modelo.agregarAlCarrito(disponibles.get(indexAgregar));
                        vista.mostrarMensaje("Producto agregado al carrito.");
                    } else {
                        vista.mostrarMensaje("Número inválido.");
                    }
                    break;

                case 4: 
                    vista.mostrarMensaje("Carrito actual:");
                    vista.mostrarProductos(modelo.getCarrito());
                    break;

                case 5: 
                    vista.mostrarProductos(modelo.getCarrito());
                    int indexEliminar = (int) vista.leerNumero("Elige el número del producto a eliminar: ") - 1;
                    modelo.eliminarDelCarrito(indexEliminar);
                    vista.mostrarMensaje("Producto eliminado del carrito.");
                    break;

                case 6: 
                    double total = modelo.calcularTotal();
                    double descuento = vista.leerNumero("Porcentaje de descuento (0 si no hay): ");
                    double totalConDescuento = modelo.aplicarDescuento(total, descuento);
                    double envio = modelo.calcularEnvio(totalConDescuento);
                    vista.mostrarMensaje("Total con descuento: S/" + totalConDescuento);
                    vista.mostrarMensaje("Envío: S/" + envio);
                    vista.mostrarMensaje("Total a pagar: S/" + (totalConDescuento + envio));
                    break;

                case 7: 
                    modelo.guardarCompra();
                    vista.mostrarMensaje("Compra realizada. Carrito vaciado y guardado en historial.");
                    break;

                case 8: 
                    List<List<Producto>> historial = modelo.getHistorialCompras();
                    if (historial.isEmpty()) {
                        vista.mostrarMensaje("No hay historial de compras.");
                    } else {
                        for (int i = 0; i < historial.size(); i++) {
                            vista.mostrarMensaje("Compra #" + (i + 1));
                            vista.mostrarProductos(historial.get(i));
                        }
                    }
                    break;

                case 9: 
                    vista.mostrarMensaje("Saliendo del sistema");
                    break;

                default:
                    vista.mostrarMensaje("Opción no válida.");
            }
        } while (opcion != 9);

        vista.cerrarScanner();
    }
   }