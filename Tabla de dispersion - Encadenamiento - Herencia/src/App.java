public class App {
    public static void main(String[] args) throws Exception {
        TablaDispersa tabla = new TablaDispersa();
        // Inserciones de alumnos
        tabla.insertarAlumno(15, "Juan");
        tabla.insertarAlumno(20, "Ana");
        tabla.insertarAlumno(22, "Luis");
        tabla.insertarAlumno(19, "Camila");
        tabla.insertarAlumno(21, "Mateo");
        tabla.insertarAlumno(25, "Lucía");
        tabla.insertarAlumno(23, "Sofía");
        tabla.insertarAlumno(17, "Martín");

        // Inserciones de profesores
        tabla.insertarProfesor(35, Profesor.Materia.Lengua);
        tabla.insertarProfesor(40, Profesor.Materia.Matematica);
        tabla.insertarProfesor(37, Profesor.Materia.Matematica);
        tabla.insertarProfesor(39, Profesor.Materia.Lengua);
        tabla.insertarProfesor(42, Profesor.Materia.Lengua);
        tabla.insertarProfesor(45, Profesor.Materia.Matematica);
        tabla.insertarProfesor(38, Profesor.Materia.Lengua);

        // Mostrar contenido
        tabla.mostrarPersonas();

    }
}
