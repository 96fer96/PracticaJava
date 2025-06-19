public class ComponentesConexas {
    private int[] ascendentes;
    private int[] descendentes;
    private GrafoMatriz grafo;

    public ComponentesConexas(GrafoMatriz grafo) {
        //recibe el grafo instanciado desde el main
        this.grafo = grafo;
        int cantidadVertices = grafo.getCantidadVertices();
        ascendentes = new int[cantidadVertices];
        descendentes = new int[cantidadVertices];
    }

    public void calcularDescendentes(int origen) {
    recorridoDFS(origen, descendentes, grafo.matriz); // Matriz original
    }

    public void calcularAscendentes(int origen) {
        int[][] grafoInverso = invertirMatriz(grafo.matriz);
        recorridoDFS(origen, ascendentes, grafoInverso);
    }

    private void recorridoDFS(int origen, int[] visitado, int[][] matrizAdyacencia) {
    PilaLista pila = new PilaLista();
    pila.push(origen);
    visitado[origen] = 1;

    while (!pila.isEmpty()) {
        try {
            int actual = pila.pop();

            for (int i = 0; i < grafo.getCantidadVertices(); i++) {
                if (matrizAdyacencia[actual][i] == 1 && visitado[i] == 0) {
                    pila.push(i);
                    visitado[i] = 1;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
    //metodo de grafo inverso ascendentes
    private int[][] invertirMatriz(int[][] original) {
    int n = grafo.getCantidadVertices();
    int[][] inversa = new int[n][n];

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            inversa[j][i] = original[i][j];
        }
    }
    return inversa;
    }
    //metodo de comparacion de conjuntos de ascendentes y descendentes

    public void compararComponentes() {
    System.out.print("Vértices comunes (componente fuerte): ");
    boolean todosCoinciden = true;

    for (int i = 0; i < ascendentes.length; i++) {
        if (ascendentes[i] == 1 && descendentes[i] == 1) {
            System.out.print(i + " ");
        } else {
            todosCoinciden = false;
        }
    }
    System.out.println();

    if (todosCoinciden) {
        System.out.println("El grafo es fuertemente conexo.");
    } else {
        System.out.println("El grafo NO es fuertemente conexo.");
    }
}

}
