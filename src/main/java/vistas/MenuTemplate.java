package vistas;

import java.util.Scanner;

public abstract class MenuTemplate {
    protected Scanner scanner = new Scanner(System.in);

    // Métodos a sobrescribir en las subclases
    public abstract void exportarDatos();
    public abstract void crearAlumno();
    public abstract void agregarMateria();
    public abstract void agregarNotaPasoUno();
    public abstract void listarAlumnos();
    public abstract void terminarPrograma();

    // Método que no debe ser sobrescrito
    public final void iniciarMenu() {
        int opcion = 0;
        do {
        	System.out.print("--------------------------\n");
        	System.out.println("Menú Principal");
            System.out.println("1. Crear Alumno");
            System.out.println("2. Agregar Materia");
            System.out.println("3. Agregar Nota");
            System.out.println("4. Listar Alumnos");
            System.out.println("5. Exportar Datos");
            System.out.println("6. Terminar Programa");
            System.out.print("Seleccione una opción: ");
            
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer de entrada
            System.out.print("--------------------------\n");
            switch (opcion) {
                case 1:
                    crearAlumno();
                    break;
                case 2:
                    agregarMateria();
                    break;
                case 3:
                    agregarNotaPasoUno();
                    break;
                case 4:
                    listarAlumnos();
                    break;
                case 5:
                    exportarDatos();
                    break;
                case 6:
                    terminarPrograma();
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 6);
    }
}

