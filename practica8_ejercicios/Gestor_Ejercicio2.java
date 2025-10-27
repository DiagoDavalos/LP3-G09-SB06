package practica8_ejercicios;
import java.util.*;
public class Gestor_Ejercicio2 {
    Persona_Ejercicio2[] personas;
    int cantidad;

    public Gestor_Ejercicio2(int tamaño) {
        personas = new Persona_Ejercicio2[tamaño];
        cantidad = 0;
    }

    public void agregarPersona(Persona_Ejercicio2 p) {
        if (cantidad < personas.length) {
            personas[cantidad] = p;
            cantidad++;
        } else {
            System.out.println(" No se pueden agregar más personas, arreglo lleno.");
        }
    }

    public void consultar(String campoMostrar, String campoCondicion, String valorCondicion, 
                          String ordenCampo, boolean ascendente, int limite) {
        List<Persona_Ejercicio2> lista = new ArrayList<>();
        for (int i = 0; i < cantidad; i++) {
            lista.add(personas[i]);
        }
        if (campoCondicion != null && !campoCondicion.isEmpty() && valorCondicion != null) {
            List<Persona_Ejercicio2> filtrada = new ArrayList<>();
            for (Persona_Ejercicio2 p : lista) {
                if (campoCondicion.equalsIgnoreCase("nombre") && p.nombre.equalsIgnoreCase(valorCondicion)) {
                    filtrada.add(p);
                } else if (campoCondicion.equalsIgnoreCase("edad")) {
                    try {
                        int valor = Integer.parseInt(valorCondicion);
                        if (p.edad == valor) filtrada.add(p);
                    } catch (Exception e) {}
                } else if (campoCondicion.equalsIgnoreCase("correo") && p.correo.equalsIgnoreCase(valorCondicion)) {
                    filtrada.add(p);
                }
            }
            lista = filtrada;
        }
        if (ordenCampo != null && !ordenCampo.isEmpty()) {
            lista.sort((a, b) -> {
                int comparacion = 0;
                if (ordenCampo.equalsIgnoreCase("id")) comparacion = Integer.compare(a.id, b.id);
                if (ordenCampo.equalsIgnoreCase("edad")) comparacion = Integer.compare(a.edad, b.edad);
                if (ordenCampo.equalsIgnoreCase("nombre")) comparacion = a.nombre.compareToIgnoreCase(b.nombre);
                if (!ascendente) comparacion *= -1;
                return comparacion;
            });
        }
        if (limite > 0 && limite < lista.size()) {
            lista = lista.subList(0, limite);
        }

        System.out.println("\n RESULTADO DE LA CONSULTA:");
        for (Persona_Ejercicio2 p : lista) {
            if (campoMostrar.equalsIgnoreCase("todo")) {
                System.out.println(p.id + " | " + p.nombre + " | " + p.edad + " | " + p.correo);
            } else if (campoMostrar.equalsIgnoreCase("nombre")) {
                System.out.println(p.nombre);
            } else if (campoMostrar.equalsIgnoreCase("edad")) {
                System.out.println(p.edad);
            } else if (campoMostrar.equalsIgnoreCase("correo")) {
                System.out.println(p.correo);
            } else if (campoMostrar.equalsIgnoreCase("id")) {
                System.out.println(p.id);
            }
        }
    }
}