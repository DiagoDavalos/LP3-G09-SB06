package Ejercicio2;

public class InventarioControlador {
    private InventarioModelo modelo;
    private InventarioVista vista;

    public InventarioControlador(InventarioModelo modelo, InventarioVista vista) {
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
                    String tipo = vista.leerTexto("Tipo de producto: ");
                    int cantidad = vista.leerEntero("Cantidad: ");
                    double precio = vista.leerDecimal("Precio: S/");
                    modelo.agregarProducto(new Producto(nombre, tipo, cantidad, precio));
                    vista.mostrarMensaje("Producto agregado correctamente.");
                    break;

                case 2:
                    vista.mostrarProductos(modelo.getProductos());
                    break;

                case 3: 
                    String nombreBuscar = vista.leerTexto("Nombre del producto a buscar: ");
                    Producto encontrado = modelo.buscarProducto(nombreBuscar);
                    if (encontrado != null) {
                        vista.mostrarMensaje("Producto encontrado: " + encontrado);
                    } else {
                        vista.mostrarMensaje("No se encontró el producto.");
                    }
                    break;

                case 4: 
                    String nombreActualizar = vista.leerTexto("Nombre del producto a actualizar: ");
                    int nuevaCantidad = vista.leerEntero("Nueva cantidad: ");
                    double nuevoPrecio = vista.leerDecimal("Nuevo precio: S/");
                    boolean actualizado = modelo.actualizarProducto(nombreActualizar, nuevaCantidad, nuevoPrecio);
                    if (actualizado) {
                        vista.mostrarMensaje("Producto actualizado correctamente.");
                    } else {
                        vista.mostrarMensaje("No se encontró el producto.");
                    }
                    break;

                case 5: 
                    String nombreEliminar = vista.leerTexto("Nombre del producto a eliminar: ");
                    modelo.eliminarProducto(nombreEliminar);
                    vista.mostrarMensaje("Producto eliminado (si existía).");
                    break;

                case 6:
                    vista.mostrarMensaje("Saliendo del sistema de inventario");
                    break;

                default:
                    vista.mostrarMensaje("Opción inválida.");
            }
        } while (opcion != 6);

        vista.cerrarScanner();
    }
}
