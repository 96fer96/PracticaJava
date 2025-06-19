public class PilaLista {
    private Nodo nodoRaiz;

    public PilaLista() {
        nodoRaiz = null;
    }

    // push: agrega al principio (top)
    public void push(int valor) {
        Nodo nuevoNodo = new Nodo(valor);
        nuevoNodo.siguiente = nodoRaiz;
        nodoRaiz = nuevoNodo;
    }

    // pop: saca el primer elemento (top)
    public int pop() throws Exception {
        if (isEmpty()) {
            throw new Exception("Pila vacía");
        }
        int valor = nodoRaiz.getNumeroVertice();
        nodoRaiz = nodoRaiz.siguiente;
        return valor;
    }

    public boolean isEmpty() {
        return nodoRaiz == null;
    }

    // ver el valor en el tope sin removerlo
    public int top() throws Exception {
        if (isEmpty()) {
            throw new Exception("Pila vacía");
        }
        return nodoRaiz.getNumeroVertice();
    }
}