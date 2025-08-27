package Ejercicio_P2;

import java.util.ArrayList;

abstract class Persona {
    protected String nombre;
    protected int edad;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public abstract void mostrarInfo();
}

class Estudiante extends Persona {
    private String carrera;
    private static int contadorEstudiantes = 0; 
    public Estudiante(String nombre, int edad, String carrera) {
        super(nombre, edad);
        this.carrera = carrera;
        contadorEstudiantes++;
    }

    public static int getContadorEstudiantes() {
        return contadorEstudiantes;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Estudiante: " + nombre + ", Edad: " + edad + ", Carrera: " + carrera);
    }
}

class Profesor extends Persona {
    private String especialidad;

    public Profesor(String nombre, int edad, String especialidad) {
        super(nombre, edad);
        this.especialidad = especialidad;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Profesor: " + nombre + ", Edad: " + edad + ", Especialidad: " + especialidad);
    }
}

class Curso {
    private String nombreCurso;
    private Profesor profesor; 
    private ArrayList<Estudiante> estudiantes; 
    public static final int MAX_ESTUDIANTES = 30; 

    public Curso(String nombreCurso, Profesor profesor) {
        this.nombreCurso = nombreCurso;
        this.profesor = profesor;
        this.estudiantes = new ArrayList<>();
    }

    public void agregarEstudiante(Estudiante e) {
        if(estudiantes.size() < MAX_ESTUDIANTES){
            estudiantes.add(e);
            System.out.println("Estudiante " + e.nombre + " agregado al curso " + nombreCurso);
        } else {
            System.out.println("Curso lleno. No se puede agregar más estudiantes.");
        }
    }

    public void mostrarCurso() {
        System.out.println("\nCurso: " + nombreCurso);
        profesor.mostrarInfo();
        System.out.println("Estudiantes matriculados: " + estudiantes.size());
        for(Estudiante e : estudiantes) {
            e.mostrarInfo();
        }
    }
}

class SistemaGestion {
    private ArrayList<Curso> cursos;

    public SistemaGestion() {
        cursos = new ArrayList<>();
    }

    public void agregarCurso(Curso c) {
        cursos.add(c);
    }

    public void mostrarSistema() {
        System.out.println("SISTEMA DE GESTIÓN DE CURSOS ");
        for(Curso c : cursos) {
            c.mostrarCurso();
        }
    }
}

public class prueba {
    public static void main(String[] args) {
        Profesor prof1 = new Profesor("Juan Perez", 40, "Matemáticas");
        Profesor prof2 = new Profesor("Ana Gómez", 35, "Programación");

        Curso curso1 = new Curso("Matemáticas 1", prof1);
        Curso curso2 = new Curso("Programación 1", prof2);

        Estudiante est1 = new Estudiante("Carlos", 20, "Ingeniería");
        Estudiante est2 = new Estudiante("Lucía", 19, "Ingeniería");
        Estudiante est3 = new Estudiante("Miguel", 21, "Ingeniería");

        curso1.agregarEstudiante(est1);
        curso1.agregarEstudiante(est2);
        curso2.agregarEstudiante(est3);

        SistemaGestion sistema = new SistemaGestion();
        sistema.agregarCurso(curso1);
        sistema.agregarCurso(curso2);

        sistema.mostrarSistema();

        System.out.println("\nTotal de estudiantes en el sistema: " + Estudiante.getContadorEstudiantes());
    }
}

