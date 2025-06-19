public class GrafoMatriz {
    int[][] matriz;
    int numMaximoVertices=5;
    //instancia un arreglo de objetos vertices, en el cual ingresan todos los valores desde el main
    Vertice [] vertice;

    //constructor de grafo
    public GrafoMatriz(int cantidadVertices) {
        //creo desde el constructor una matriz de la cantidad de filas y columnas pasadas por argumento desde el main
        this.matriz = new int[cantidadVertices][cantidadVertices];
        //creo un arreglo que almacena los vertices que seran ingresados en la matriz de adyacencia
        this.vertice = new Vertice[cantidadVertices];
        //lleno los elementos d ela matriz con elementos vacios
        for (int i=0; i<cantidadVertices; i++) {
            for (int j=0; j<cantidadVertices; j++) {
                matriz[i][j]= 0;
            }
        }
    }

    public int getCantidadVertices() {
        int contadorVertices=0;
        for (int i=0; i<numMaximoVertices; i++) {
            if (vertice[i]!=null) {
                contadorVertices++;
            }
        }
        return contadorVertices;
    }

    public void cargarVertice(int numero) {
        //asigno en el arreglo de vertices un nuevo objeto de tipo vertice que recibe su nombre para ser instanciado
        //en su constructor y la posicion que tiene, la cual es importante para trabajar en la matriz de adyacencia
        int posicion = getPosicionLibre();
        if (posicion!=-1) {
            vertice[posicion] = new Vertice(numero);
        } else {
            System.out.println("\nArreglo de vertices lleno");
        }
        
        //contadorVertices++;
    }

    //defino un metodo arco, el cual recibe las posiciones de los vertices en el arreglo de vertices y va llenando 
    //la matriz de adyacencia con un nuevo arco
    public void nuevoArco(int verticeA, int verticeB) {
        //llamo a una funcion para conocer las posiciones de los vertices con el valor solicitado
        int posicionA = conocerPosicion(verticeA);
        int posicionB = conocerPosicion(verticeB);
        if (posicionA != -1 && posicionB != -1) {
            matriz[posicionA][posicionB] = 1;  // Usar las posiciones encontradas
        }
        
    }

    public int conocerPosicion (int valor) {
        for (int i=0; i<vertice.length; i++) {
            if (vertice[i] != null && valor == vertice[i].getNumero()) {
                return i;
            }
        }
        System.out.println("\nEl vertice enviado no existe");
        return -1;
    }

    

    public int getPosicionLibre() {
        for (int i = 0; i < vertice.length; i++) {
            if (vertice[i] == null) {
                return i;
            }
        }
        return -1;
    }

    public void imprimirMatriz() {
    System.out.println("Matriz de adyacencia:");
    for (int i = 0; i < getCantidadVertices(); i++) {
        for (int j = 0; j < getCantidadVertices(); j++) {
            System.out.print(matriz[i][j] + " ");
        }
        System.out.println();
    }
}
}
