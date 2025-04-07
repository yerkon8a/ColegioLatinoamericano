package servicios;

import modelos.Alumno;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ArchivoServicio {
    private List<String> alumnosACargar;  // Mantendrá los datos temporalmente.
    private PromedioServicioImp promedioServicioImp = new PromedioServicioImp();

    // Método para exportar datos a un archivo
    public void exportarDatos(Map<String, Alumno> alumnos, String ruta) {
        try (FileWriter writer = new FileWriter(ruta)) {
            for (Map.Entry<String, Alumno> entry : alumnos.entrySet()) {
                Alumno alumno = entry.getValue();
                writer.write("Rut: " + alumno.getRut() + ", Nombre: " + alumno.getNombre() + "\n");
                // Aquí puedes agregar más lógica para exportar otras propiedades del alumno.
            }
            System.out.println("Datos exportados correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

