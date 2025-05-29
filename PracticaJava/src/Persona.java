import java.time.LocalDateTime;
import java.util.UUID;

public class Persona {
    //si yo hago los modificadores de acceso de tipo protected entonces las clases hijas no necesitan los getters y setter
    //para acceder a los atributos de la clase, lo cual rompe el encapsulamiento
    private String id = UUID.randomUUID().toString();
    private int edad;
    private LocalDateTime fecha= LocalDateTime.now();
    private Persona siguiente= null;

    public Persona (int edad) {
        this.edad = edad;
    }

    public String getId() {
        return id;
    }

    public Persona getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Persona siguiente) {
        this.siguiente = siguiente;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
}
