package servicios;

import modelos.Alumno;
import modelos.Materia;
import java.util.Map;
import java.util.HashMap;

public class AlumnoServicio {
    private Map<String, Alumno> listaAlumnos = new HashMap<>();

    public void crearAlumno(Alumno alumno) {
        listaAlumnos.put(alumno.getRut(), alumno);
    }

    public void agregarMateria(String rutAlumno, Materia materia) {
        Alumno alumno = listaAlumnos.get(rutAlumno);
        if (alumno != null) {
            alumno.getMaterias().add(materia);
        }
    }

    public Map<String, Alumno> listarAlumnos() {
        return listaAlumnos;
    }
}

