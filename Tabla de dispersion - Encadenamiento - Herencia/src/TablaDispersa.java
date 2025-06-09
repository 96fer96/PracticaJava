public class TablaDispersa {
    private int cantidadPersonas=0;
    public static final int TAMTABLA = 10;    
    private Persona[] personas = new Persona[TAMTABLA];

    public TablaDispersa() {
    }

    public void insertarAlumno(int edad, String nombre) {
        Alumno alumno = new Alumno(nombre, edad);
        int direccion = obtenerDireccion(alumno.getId());
        if (personas[direccion]!= null) {
            resolverColisionEncadenamiento(direccion, alumno);
        } else {
            personas[direccion] = alumno;
        }
        cantidadPersonas++;
    }
//para pasarle a una funcion un dato enum debo invocar a la clase en la cual esta definido el enum, en este caso la clase 
//Profesor y llamar al enum que estoy intentando insertar
    public void insertarProfesor(int edad, Profesor.Materia materia) {
        Profesor profesor = new Profesor(edad, materia);
        int direccion = obtenerDireccion(profesor.getId());
        if (personas[direccion]!= null) {
            resolverColisionEncadenamiento(direccion, profesor);
        } else {
            personas[direccion] = profesor;
        }
        cantidadPersonas++;
    }

    private void resolverColisionEncadenamiento(int direccion, Persona nuevaPersona) {
        //almaceno el puntero al objeto siguiente al objeto que estaba almacenado en el arreglo de personas[] dentro de
            //otro puntero que se llama persona
            //tengo x y la lista o->o->o->null, almaceno x en el siguiente o->x->o->null
            //no necesito pasarle el objeto ya creado "personas" a este metodo por la forma en la que trabaja java
            Persona actual = personas[direccion];
            //mientras el siguiente nodo este ocupado sigo buscando hasta encontrar uno no nulo
            while (actual.getSiguiente()!=null) {
                actual = actual.getSiguiente();
            }
            //cuando se encontro un siguiente inserto el nodo en el siguiente del actual
            actual.setSiguiente(nuevaPersona);
    }
    
    private int obtenerDireccion(String id) {
        
        double constante = 0.6180339887;
        double clave= transformarString(id);
        double producto= clave* constante;
        double decimal = producto - Math.floor(producto);
        int direccion  = (int)(decimal * TAMTABLA);
        return direccion;
    }

    private double transformarString(String id) {
        long numero=0;
        for(int i=0; i< Math.min(10, id.length()); i++) {
            numero= numero*27 + (int) id.charAt(i);
        }
        return numero;
    }

    public void mostrarPersonas() {
        for (int i=0; i<TAMTABLA; i++) {
            if (personas[i]!= null) {
                System.out.println(personas[i]);
                System.out.println("\nPosicion: " + i);
                if (personas[i].getSiguiente()!=null) {
                    Persona persona = personas[i];
                    int numeroNodo=0;
                    while (persona.getSiguiente()!=null) {
                        numeroNodo++;
                        persona = persona.getSiguiente();
                        System.out.println(persona);
                        System.out.println("\nNumero de nodo: " + numeroNodo);
                    }
                }
            }
        }
        System.out.println("\nLa cantidad de personas es de: "+ cantidadPersonas);
    }

}
