public class Alumno extends Persona{
    private String nombre;

    public Alumno(String nombre, int edad) {
        super(edad);
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Alumno - Edad: " + getEdad() + ", Nombre: " + getNombre();
    }
}
