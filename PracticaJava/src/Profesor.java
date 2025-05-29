public class Profesor extends Persona {
    private Materia materia;

    public enum Materia{
        Matematica,
        Lengua
    }
    public Profesor(int edad, Materia materia) {
        super(edad);
        this.materia = materia;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    @Override
    public String toString() {
        return "Profesor - Edad: " + getEdad() + ", Materia: " + materia;
    }
}
