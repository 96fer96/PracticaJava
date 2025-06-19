public class Nodo {
    private int numeroVertice;
    Nodo siguiente;

    public Nodo(int numero) {
        this.numeroVertice = numero;
        this.siguiente = null;
    }

    public int getNumeroVertice() {
        return numeroVertice;
    }
}