
/**
 *
 * @author fer96
 */
public class Articulo {
    private String id="0", nombre, marca;
    private int stock;
    private double precio;
    
    public Articulo (String id, String nombre, String marca, int stock, double precio) {
        this.id = id;
        this.marca = marca;
        this.nombre = nombre;
        this.stock = stock;
        this.precio = precio;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
