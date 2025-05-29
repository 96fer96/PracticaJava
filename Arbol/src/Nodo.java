public class Nodo {
    private int numero;
    private Nodo nodoIzquierdo;
    private Nodo nodoDerecho;

    //creo un nodo para la raiz, con ramas nulas
    public Nodo(int numero) {
        this.numero = numero;
        nodoDerecho = null;
        nodoIzquierdo = null;
    }

    //creo otro nodo que llama al nodo raiz, que va agregando nuevos nodos al arbol, recibiendo los atributos
    public Nodo(Nodo izqNodo, int elemento, Nodo derNodo) {
        //llamo al constructor de arriba, el del nodo raiz y le proporciono el elemento, para no volver a escribir codigo
        this(elemento);
        this.nodoIzquierdo= izqNodo;
        this.nodoDerecho= derNodo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Nodo getIzquierdo() {
        return nodoIzquierdo;
    }

    public void setIzquierdo(Nodo izquierdo) {
        this.nodoIzquierdo = izquierdo;
    }

    public Nodo getDerecho() {
        return nodoDerecho;
    }

    public void setDerecho(Nodo derecho) {
        this.nodoDerecho = derecho;
    }
}
