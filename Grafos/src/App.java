public class App {
    public static void main(String[] args) throws Exception {
        //instancio un objeto de tipo GrafoMatriz
        GrafoMatriz grafo = new GrafoMatriz(5);
        grafo.cargarVertice(1);
        grafo.cargarVertice(2);
        grafo.cargarVertice(3);
        grafo.cargarVertice(4);
        grafo.cargarVertice(5);

        //Adyacencias del vertice 1
        grafo.nuevoArco(1,3);
        grafo.nuevoArco(1,2);

        //adyacencias del vertice 2
        grafo.nuevoArco(2,3);
        grafo.nuevoArco(2,4);
        grafo.nuevoArco(2,5);

        //adyacencias del vertice 3
        grafo.nuevoArco(3,1);

        //adyacencias del vertice 4
        grafo.nuevoArco(4,1);
        grafo.nuevoArco(4,2);

        //adyacencias del vertice 5
        grafo.nuevoArco(5,2);

        grafo.imprimirMatriz();
        
        ComponentesConexas cc = new ComponentesConexas(grafo);
        cc.calcularDescendentes(0);  // o el vértice de inicio
        cc.calcularAscendentes(0);
        cc.compararComponentes();

        //cargo la matriz de adyacencia con los datos proporcionados
        //ejecuto los metodos de ascendentes y descendentes y comparo
        //condicional grafo conexo (ascendentes=descendentes) o grafo no conexo (vertices fuertemente conexos)
    }
}
