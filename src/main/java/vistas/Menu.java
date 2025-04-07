package vistas;

import servicios.AlumnoServicio;
import servicios.ArchivoServicio;
import modelos.Alumno;
import modelos.Materia;
import modelos.MateriaEnum;
import utilidades.Utilidad;

public class Menu extends MenuTemplate {
    private AlumnoServicio alumnoServicio = new AlumnoServicio();
    private ArchivoServicio archivoServicio = new ArchivoServicio();

    @Override
    public void exportarDatos() {
       // archivoServicio.exportarPromedios();
    }

    @Override
    public void crearAlumno() {
        System.out.print("Ingrese RUT del alumno: ");
        String rut = scanner.nextLine();
        System.out.print("Ingrese nombre del alumno: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese apellido del alumno: ");
        String apellido = scanner.nextLine();
        System.out.print("Ingrese dirección del alumno: ");
        String direccion = scanner.nextLine();

        Alumno alumno = new Alumno(rut, nombre, apellido, direccion);
        alumnoServicio.crearAlumno(alumno);
        System.out.println("Alumno creado exitosamente.");
    }

    @Override
    public void agregarMateria() {
        System.out.print("Ingrese RUT del alumno: ");
        String rut = scanner.nextLine();
        System.out.print("Ingrese nombre de la materia (MATEMATICAS, LENGUAJE, CIENCIA, HISTORIA): ");
        String nombreMateria = scanner.nextLine().toUpperCase();
        
        MateriaEnum materiaEnum;
        try {
            materiaEnum = MateriaEnum.valueOf(nombreMateria);
        } catch (IllegalArgumentException e) {
            System.out.println("Materia no válida.");
            return;
        }

        Materia materia = new Materia(materiaEnum);
        alumnoServicio.agregarMateria(rut, materia);
        System.out.println("Materia agregada exitosamente.");
    }

    @Override
    public void agregarNotaPasoUno() {
        // Implementación similar a la anterior para agregar nota
        System.out.print("Funcionalidad por implementar.");
    }

    @Override
    public void listarAlumnos() {
        alumnoServicio.listarAlumnos().forEach((rut, alumno) -> {
            System.out.println("Alumno: " + alumno.getNombre() + " " + alumno.getApellido() + " - RUT: " + rut);
        });
    }

    @Override
    public void terminarPrograma() {
        System.out.println("Finalizando programa...");
        System.exit(0);
    }
}
