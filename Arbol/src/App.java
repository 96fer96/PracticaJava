public class App {
    public static void main(String[] args) throws Exception {
        //debo instanciar si o si un abjeto arbol para acceder a sus metodos y atributos
        Arbol arbol = new Arbol();
        
        arbol.insertar(15);
        arbol.insertar(8);
        arbol.insertar(11);
        arbol.insertar(3);
        arbol.insertar(17);
        arbol.insertar(15);
        arbol.insertar(19);
        System.out.println("InOrden\n");
        arbol.inOrden(arbol.getRaiz());
        System.out.println("preOrden\n");
        arbol.preOrden(arbol.getRaiz());
        System.out.println("posOrden\n");
        arbol.posOrden(arbol.getRaiz());
    }
}
