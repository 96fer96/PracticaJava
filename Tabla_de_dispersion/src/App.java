import java.time.LocalDateTime;

public class App {
    public static void main(String[] args) throws Exception {
        String nombre;
        String descripcion;
        LocalDateTime fechaFin;
        //creo una vez la tabla dispersa
        //cuando creo un objeto de tipo TablaDispersa, ese objeto va a contener un arreglo de 101 posiciones,
        TablaDispersa tabla = new TablaDispersa();

        //ahora voy a ir llamando a la clase insertarTarea con los datos que voy a ir proporcionando en cada
        //llamada al metodo
        nombre = "Tarea 1";
        descripcion = "Descripcion de la tarea 1";
        fechaFin = LocalDateTime.of(2023, 10, 31, 23, 59); // Fecha de fin de la tarea

        //el metodo insertarTarea llama al contructor de tarea y le pasa los datos y despues los inserta mediante
        //el metodo dispersion en la TablaDispersa
        tabla.insertarTarea(nombre, descripcion, fechaFin);

        nombre = "Tarea 2";
        descripcion = "Descripcion de la tarea 2";
        fechaFin = LocalDateTime.of(2023, 11, 15, 23, 59); // Fecha de fin de la tarea
        tabla.insertarTarea(nombre, descripcion, fechaFin);

        nombre = "Tarea 3";
        descripcion = "Descripcion de la tarea 3";
        fechaFin = LocalDateTime.of(2023, 12, 1, 23, 59); // Fecha de fin de la tarea
        tabla.insertarTarea(nombre, descripcion, fechaFin);

        tabla.mostrarInsertados();
        //primero busco una tarea insertada por el nombre
        tabla.buscarTarea("Tarea 1");
        //despues doy de baja la tarea insertada por el nombre
        tabla.bajaTarea("Tarea 1");
        //despues busco de vuelta para verificar que la tarea se dio de baja correctamente
        tabla.buscarTarea("Tarea 1");
    }
}
