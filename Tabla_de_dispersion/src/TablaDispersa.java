import java.time.LocalDateTime;
//cuando creo un objeto de tipo TablaDispersa, ese objeto va a contener un arreglo de 101 posiciones, 
//preparado para almacenar referencias a objetos de tipo Tarea

public class TablaDispersa {
    static final int TAMTABLA = 101;
    private Tarea[] tabla = new Tarea[TAMTABLA];
    private int cantidadTareas = 0;
    private double cargaMaxima = 0.7;
    

    public TablaDispersa() {
        // Atributos del objeto TablaDispersa inicializados en el constructor por defecto, pues ya tienen
        // valores asignados al momento de la creación del objeto.
    }


    public void insertarTarea(String nombre, String descripcion, LocalDateTime fechaFin) {
        Tarea tarea = new Tarea(nombre, descripcion, fechaFin);
        //creo un metodo para transformar el id en un entero y despues obtener la posicion del indice
        int direccion = obtenerDireccion(tarea.getId());
        //una vez que la direccion esta disponible se inserta la tarea en la direccion proporcionada por el
        //metodo obtener direccion y aumento la cantidad de tareas para despues hacer el calculo del factor
        //de carga
        tabla[direccion] = tarea;
        cantidadTareas++;
        calcularCarga();
        System.out.println("Tarea insertada en la tabla dispersa en la posicion "+ direccion +".");            
        
    }
    //dentro de este metodo se hashea el id de la tarea y tambien se explora si no esta ocupada la
    //direccion donde se desea insertar la tarea
    public int obtenerDireccion (String clave) {
        double c = 0.6180339887; // Constante para el método de multiplicación
        int intento=0;
        double numero = transformarString(clave);

        //tengo que hashear ese numero para obtener la posicion
        //aca tengo que obtener el producto entre el numero y la constante
        double producto = numero * c;
        
        //aca tengo que obtener la parte decimal del producto
        double decimal = producto - Math.floor(producto);
        //ahora tengo que multiplicar el decimal por el tamaño de la tabla
        int posicion = (int)(decimal * TAMTABLA);
        
        //bucle de exploracion
        while (tabla[posicion] != null) {
            intento++;
            posicion= resolverColision(posicion, intento);
        }
        return posicion;
    }

    public double transformarString(String clave) {
        long numero = 0;

        //Esto recorre los primeros 10 caracteres del String id
        for (int i=0; i< Math.min(10, clave.length()); i++) {
            numero = numero * 27+ (int) clave.charAt(i); // combina caracteres en base 27
        }
        //aca si bien la variable numero es un long y la funcion retorna un double la funcion aca va a hacer un cast
        //automatico y no va a perder precision, va a hacer un cast implicito y va a retornar un double
        return numero;
    }

    public int resolverColision(int posicion, int intento) {
        return (posicion + intento * intento) % TAMTABLA;
    }

    public void mostrarInsertados() {
        for (int i = 0; i < TAMTABLA; i++) {
            if (tabla[i] != null) {
                //Cuando quiero imprimir un objeto instanciado de una clase, automaticamente
                //llama al metodo toString de esa clase, de modo que no es imprescindible que coloque el
                //metodo que estoy intentando llamar para obtener la informacion.
                System.out.println(tabla[i]);
            }
        }
    }

//crear metodo para buscar tarea
public void buscarTarea(String nombreTarea) {
    int encontrado=0;
    for (int i=0; i<TAMTABLA; i++) {
        //Como el arreglo de objetos que estoy usando almacena en sus posiciones punteros a la posicion de memoria 
        //donde se almacena cada objeto, cuando las posicones estan vacias no se puede acceder al metodo de un 
        //objeto que aun no se ha creado, de modo que primero debo verificar si la posicion i no esta vacia y despues
        //verificar si el valor que busco comparar es el mismo
        if(tabla[i] != null && tabla[i].getNombre() == nombreTarea && tabla[i].isEsAlta() == true) {
            System.out.println("\nTarea encontrada en la posicion: "+ i);
            return;
        }
    }
    if (encontrado==0) {
            System.out.println("\nTarea no encontrada o dada de baja");
        }
}
//crear el metodo para dar de baja una tarea
public void bajaTarea(String nombreTarea) {
    for (int i=0; i<TAMTABLA; i++) {
        if(tabla[i] != null && tabla[i].getNombre() == nombreTarea) {
            tabla[i].setEsAlta(false);
            System.out.println("Tarea: " + nombreTarea +" dada de baja exitosamente\n");
            cantidadTareas--;
        }
    }
}
//crear un metodo que calcule el factor de carga arctual con una advetencia para saber cuando la tabla de 
//dispersion alcanzo la carga maxima
public void calcularCarga() {
    double carga= (double)cantidadTareas/TAMTABLA;
    if (carga > cargaMaxima) {
        System.out.println("Se ha superado la carga maxima\n");
    } else {
        System.out.println("La carga actual es de: "+ carga);
    }
}
}






