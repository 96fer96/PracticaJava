public class Arbol {
    //El atributo del arbol es la raiz, la cual es un objeto puntero de la clase Nodo
    private Nodo raiz;
    //crea un arbol vacio
    public Arbol() {
        raiz= null;
    }

    public Nodo getRaiz() {
        return raiz;
    }

    public void insertar(int numero) {
        Nodo nuevoNodo = new Nodo(null, numero, null);
        if (raiz==null) {
            //primero consulto si la raiz es nula y asigno el nodo a la raiz, con raices nulas
            raiz = nuevoNodo;
        }
        else {
            //asigno el objeto a una nueva variable que me va a servir en el ambito de la funcion para iterar hasta encontrar
            //el lugar correcto donde insertar el nodo
            Nodo nodoActual = raiz;
            //comparo si el valor a insertar es mayor o menor que el de la raiz
            boolean asignado=false;
            do {
                if(nuevoNodo.getNumero()== nodoActual.getNumero()) {
                    System.out.println("\nNo se puede insertar porque ya existe un nodo con ese valor");
                    break;
                }
                if (nuevoNodo.getNumero()> nodoActual.getNumero()) {
                    //si el numero del nodo nuevo es mayor que el del nodo actual y el hijo derecho esta desocupado
                    //entonces asigno el nuevo nodo en el hijo derecho del actual
                    if (nodoActual.getDerecho()==null) {
                        nodoActual.setDerecho(nuevoNodo);
                        asignado = true;
                    } else {
                        //si el hijo derecho del actual esta ocupado entonces asigno el nodo actual al hijo derecho para
                        //seguir buscando el lugar que le corresponde
                        nodoActual = nodoActual.getDerecho();
                    }
                } else {
                    if (nodoActual.getIzquierdo()==null) {
                        nodoActual.setIzquierdo(nuevoNodo);
                        asignado = true;
                    } else {
                        //si el hijo izquierdo del actual esta ocupado entonces asigno el nodo actual al hijo izquierdo para
                        //seguir buscando el lugar que le corresponde
                        nodoActual = nodoActual.getIzquierdo();
                    }
                }
            } while (asignado==false);
        }
    }
    
    /*Cuando hago un metodo recursivo se abre hasta que se encuentra el stop de modo que se ejecuta en simultaneo a si mismo
    con los argumentos proporcionados hasta que llega a un nodo nulo. Por eso dado que es el metodo en orden primero visita 
    el subarbol izquierdo hasta que encuentra un nulo

        5
       /
      2
       \
        3
Pasos de ejecucion (Los metodos que se van abriendo M1,2,3,4 y los que se van cerrando xM1,2,3,4x)
1.1- M1 Se fija si actual es no nulo y el metodo le pasa a si mismo el hijo izquierdo inOrden(izquierdo) que seria 2
    1.2- M2 Se vuelve a fijar si el nuevo actual es no nulo y le pasa a si mismo el hijo izquierdo inOrden(izquierdo) que es nulo
        1.3- xM3x Se vuelve a fijar si el nuevo actual es no nulo y como es nulo se cierra el metodo
2- M2 Cuando se llego a un stop se imprime el numero del nodo actual System.out.println(actual.getNumero() + " "); pues ya no 
hay valores mas chicos en el arbol, recordar que actual correspondia al nodo que estaba posicionado en 1.2 que es 2
3- M3 Ahora toca preguntar si el lado derecho del nodo actual(3), en el que habia quedado posicionado el metodo en el paso 1.2 es
no nulo inOrden(actual.getDerecho()); y como no es nulo, se pregunta el metodo si tiene un izquierdo, volviendo a repetir 
los pasos del 1, entonces se llama al metodo inOrden(actual.getIzquierdo());
    3.1- xM4x Se fija si el nuevo actual es no nulo y como es nulo se cierra el metodo
4- M3 Se imprime el ultimo actual(3) que no se habia cerrado porque no era nulo y se imprime el valor del nodo 
System.out.println(actual.getNumero() + " ");
5- M5 Se busca en el lado derecho, de modo que se llama al metodo con el nodo derecho del actual(3)
    5-1- xM5x Se fija si el nuevo actual es no nulo y como es nulo se cierra el metodo
6- xM2x, xM3x Se terminaron de ejecutar los metodos M2 y M3 y se cierran, y se imprime el nodo actual del nodo raiz y ahora
se se pasa el valor del hijo derecho abrineod un nuevo metodo M7
    6-1 xM7x se consulta si el nuevo actual es nulo y como es nulo se cierra el metodo
    */
    public void inOrden(Nodo actual) {
        if (actual!=null) {
            //primero visita el subarbol izquierdo
            inOrden(actual.getIzquierdo());
            //visita el actual
            System.out.println(actual.getNumero() + " ");
            //despues visita el subarbol derecho
            inOrden(actual.getDerecho());
        }
    }

    public void preOrden(Nodo actual) {
        if (actual!=null) {
            //visita el actual
            System.out.println(actual.getNumero() + " ");
            //visita el subarbol izquierdo
            inOrden(actual.getIzquierdo());
            //despues visita el subarbol derecho
            inOrden(actual.getDerecho());
        }
    }

    public void posOrden(Nodo actual) {
        if (actual!=null) {
            //primero visita el subarbol izquierdo
            inOrden(actual.getIzquierdo());
            //despues visita el subarbol derecho
            inOrden(actual.getDerecho());
            //visita el actual
            System.out.println(actual.getNumero() + " ");
        }
    }
}
