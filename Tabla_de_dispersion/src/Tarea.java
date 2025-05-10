import java.time.LocalDateTime;
import java.util.UUID;

public class Tarea {
    private String id;
    private String nombre;
    private String descripcion;
    private Estado estado;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private boolean esAlta;

    public enum Estado {
        PENDIENTE,
        EN_PROGRESO,
        FINALIZADA
    }
    
    public Tarea(String nombre, String descripcion, LocalDateTime fechaFin) {
        this.id = UUID.randomUUID().toString(); // Genera un ID único
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = Estado.PENDIENTE;
        this.fechaInicio = LocalDateTime.now(); // Fecha de inicio es ahora
        this.fechaFin = fechaFin;
        this.esAlta = true; // Por defecto es alta
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Estado getEstado() {
        return estado;
    }

    //metodo que recibe un String
    // y lo asigna al atributo estado
    // y lanza una excepción si el String no es válido
    public void setEstado(String estado) {
        try {
            this.estado = Estado.valueOf(estado.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("El valor proporcionado no es válido para el atributo Estado. Valores válidos: PENDIENTE, EN_PROGRESO, FINALIZADA.");
        }
    }

    //metodo que recibe un objeto Estado
    // y lo asigna al atributo estado
    // y lanza una excepción si el objeto es nulo
    public void setEstado(Estado estado) {
        if (estado == null) {
            throw new IllegalArgumentException("El estado no puede ser nulo.");
        }
        this.estado = estado;
    }
    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }
    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    public LocalDateTime getFechaFin() {
        return fechaFin;
    }
    public void setFechaFin(LocalDateTime fechaFin) {
        this.fechaFin = fechaFin;
    }
    public boolean isEsAlta() {
        return esAlta;
    }
    public void setEsAlta(boolean esAlta) {
        this.esAlta = esAlta;
    }


    @Override
    public String toString() {
        return "Tarea{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", estado=" + estado +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                ", esAlta=" + esAlta +
                '}';
    }


}
