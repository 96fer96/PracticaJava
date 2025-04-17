

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int menu, posicion;
        boolean controlArreglo;
        Scanner sc = new Scanner(System.in);
        
        Articulo articulos[] = new Articulo[1000];
        
        do {
            mostrarMenu();
            menu= sc.nextInt();
            switch (menu) {
                case 1:
                    posicion = ultimaPosicionVacia(articulos);
                    
                    if (posicion != -1) {
                            articulos[posicion] = crearArticulo(sc, articulos);  // crearArticulo debe devolver un Articulo
                            
                        } else {
                            System.out.println("\nNo hay espacio disponible para más artículos.\n");
                        }
                    break;
                case 2:
                    
                    controlArreglo= estaVacio(articulos);
                    if (!controlArreglo) {
                        verArticulos(articulos);
                    }  else {
                        System.out.println("\nNo hay articulos\n");
                    }                  
                    break;
                case 3:
                    controlArreglo= estaVacio(articulos);
                    if (!controlArreglo) {                        
                        verArticulos(articulos);
                        System.out.println("\nSeleccione el id de un articulo para modificar\n");
                        posicion= sc.nextInt();
                        boolean controlVacio = posicionVacia(articulos [posicion]);
                        if (!controlVacio) {
                            actualizarArticulo(articulos [posicion], sc, articulos);
                        } else {
                            System.out.println("\nLa posicion ingresada esta vacia\n");
                        }                        
                    }                    
                    break;
                case 4:
                    controlArreglo= estaVacio(articulos);
                    if (!controlArreglo) {                        
                        verArticulos(articulos);
                        System.out.println("\nSeleccione la posicion de un articulo para eliminar\n");
                        posicion= sc.nextInt();
                        boolean controlVacio = posicionVacia(articulos [posicion]);
                        if (!controlVacio) {
                            eliminarArticulo(articulos, posicion);
                        } else {
                            System.out.println("\nLa posicion ingresada esta vacia\n");
                        }                        
                    }
                    
                    break;
                case 0:
                    break;
                default:
                    System.out.println("\nIngresar una opcion valida\n");
                    break;
            }
        } while (menu!=0);
        
        
    }
    
    public static boolean posicionVacia(Articulo articulos) {
        if (articulos == null) {
            return true;
        }
        return false;
    }
    
    public static boolean estaVacio(Articulo[] articulos) {
        for (int i=0; i<articulos.length ; i++) {
            if (articulos[i]!= null) {
                //System.out.println("No esta vacio");
                return false;
            }
        }
        
        return true;
        
    }
    
    public static int ultimaPosicionVacia(Articulo[] articulos) {
        for (int i = 0; i < articulos.length; i++) {
            if (articulos[i] == null || articulos[i].getId().equals("0")) {
                return i;
            }
        }
        return -1;
    }
        
    public static void mostrarMenu() {
        System.out.println("\nMenu principal");
        System.out.println("\n1- Crear articulo");
        System.out.println("\n2- Ver articulos");
        System.out.println("\n3- Actualizar articulo");
        System.out.println("\n4- Eliminar articulo\n");
        System.out.println("\n0- Salir");
    }
    
    public static Articulo crearArticulo(Scanner sc, Articulo[] articulos) {
        String palabra, id = "", nombre = "", marca = "";
        int control = 0, stock = 0;
        double precio = 0.0;
        boolean valido;
        
        do {
        sc.nextLine();
        System.out.println("Ingresar un ID alfanumérico (máx. 10 caracteres):");
        
        id = sc.nextLine();
        valido = controlId(id, articulos);
        } while (!valido);

        do {
            System.out.println("Ingresar un nombre (3 a 50 caracteres):");
            nombre = sc.nextLine();
            valido = controlNombre(nombre);
        } while (!valido);

        do {
            System.out.println("Ingresar una marca (2 a 50 caracteres):");
            marca = sc.nextLine();
            valido = controlMarca(marca);
        } while (!valido);

        do {
            System.out.println("Ingresar la cantidad en stock:");
            stock = sc.nextInt();
            sc.nextLine();
            if (stock<0) {
                System.out.println("Ingresar un valor positivo");
            }
        } while (stock <= 0);

        do {
            System.out.println("Ingresar el precio:");
            precio = sc.nextDouble();
            sc.nextLine();
            if (precio<0) {
                System.out.println("Ingresar un valor positivo");
            }
        } while (precio <= 0);
        
        return new Articulo(id, nombre, marca, stock, precio);
    }
    
    public static boolean controlMarca(String palabra) {
        if (palabra.length()>50 || palabra.length()<2) {
            return false;
        }
        
     return true;
    }
    
    public static boolean controlNombre(String palabra) {
        if (palabra.length()>50 || palabra.length()<3) {
            return false;
        }
        
     return true;
    }
    
    public static boolean controlId(String palabra, Articulo[] articulos) {
        if (palabra.length()>10) {
            System.out.println("\nDebe escribir como maximo 10 caracteres\n");
            return false;
        }
        if (palabra.isEmpty()) {
            System.out.println("\nDebe escribir al menos 1 caracter\n");
            return false;
        }
        
        for (int i=0; i<palabra.length(); i++) {
            char c = palabra.charAt(i);           
            
            if (!Character.isLetterOrDigit(c)) {
                return false;
            }
        } 
        
        if (controlDuplicado(palabra, articulos)) {
            return false;
        }
        
        return true;
    }
    
    public static boolean controlDuplicado(String palabra, Articulo[] articulos) {
    for (int i = 0; i < articulos.length; i++) {
        if (articulos[i] != null && articulos[i].getId().equals(palabra)) {
            System.out.println("El ID ya está en uso.");
            return true;  // HAY duplicado
        }
    }
    return false; // NO hay duplicado
}
    
    public static void verArticulos(Articulo[] articulos) {
        
        for (int i = 0; i < articulos.length; i++) {
            if (articulos[i] != null) {                
                System.out.println("\nArtículo en posición: " + i);
                System.out.println("ID: " + articulos[i].getId());
                System.out.println("Nombre: " + articulos[i].getNombre());
                System.out.println("Marca: " + articulos[i].getMarca());
                System.out.println("Precio: $" + articulos[i].getPrecio());
                System.out.println("Stock: " + articulos[i].getStock());
            }
        }

    }
    
    //para este metodo paso como parametros el indice del arreglo sobre el que voy a trabajar y ademas el arreglo completo par ahacer el 
    //control de id al ingresar una actualizacion
    public static void actualizarArticulo(Articulo articulo, Scanner sc, Articulo[] arregloArticulos) {
        String id, nombre, marca;
        int stock;
        double precio;
        boolean valido;
        System.out.println("\nQue desea actualizar?");
        System.out.println("\n1- id");
        System.out.println("\n2- nombre");
        System.out.println("\n3- marca");
        System.out.println("\n4- precio");
        System.out.println("\n5- stock\n");
        int opcion = sc.nextInt();
        switch (opcion) {
            case 1:
                do {
                    sc.nextLine();
                    System.out.println("Ingresar un ID alfanumérico (máx. 10 caracteres):");

                    id = sc.nextLine();
                    valido = controlId(id, arregloArticulos);
                } while (!valido);
                articulo.setId(id);
                break;
            case 2:
                do {
                    System.out.println("Ingresar un nombre (3 a 50 caracteres):");
                    nombre = sc.nextLine();
                    valido = controlNombre(nombre);
                } while (!valido);
                articulo.setNombre(nombre);
                break;
            case 3:
                do {
                    System.out.println("Ingresar una marca (2 a 50 caracteres):");
                    marca = sc.nextLine();
                    valido = controlMarca(marca);
                } while (!valido);
                articulo.setMarca(marca);
                break;
            case 4:
                do {
                    System.out.println("Ingresar la cantidad en stock:");
                    stock = sc.nextInt();
                    sc.nextLine();
                    if (stock<0) {
                        System.out.println("Ingresar un valor positivo");
                    }
                } while (stock <= 0);   
                articulo.setStock(stock);
                break;
            case 5:
                do {
                    System.out.println("Ingresar el precio:");
                    precio = sc.nextDouble();
                    sc.nextLine();
                    if (precio<0) {
                        System.out.println("Ingresar un valor positivo");
                    }
                    articulo.setPrecio(precio);
                } while (precio <= 0);
                break;
            default:
                System.out.println("\nIngresar una opcion valida\n");
                break;
        }
    }
    
    //es necesario pasarle a este metodo el arreglo completo para poder hacer modificaciones sobre el, sino estoy pasando la avariable
    //arreglo por valor, y necesito pasarla por referencia
    public static void eliminarArticulo(Articulo[] articulo, int posicion) {
        articulo[posicion] = null;
    }
    
}
    