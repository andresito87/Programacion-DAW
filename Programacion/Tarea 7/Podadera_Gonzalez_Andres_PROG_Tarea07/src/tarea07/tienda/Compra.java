package tarea07.tienda;

/**
 * Representa una compra de unas determinadas unidades de un producto a un cierto precio.
 * Contiene una terna del tipo <code>(producto, precio, unidades)</code>.
 */
public class Compra {
    private final String producto;
    private final double precio;
    private final int    unidades;


    // --------------------------------------------------
    //               CONSTRUCTORES
    // --------------------------------------------------
    /**
     * Constructor para crear un objeto CompraProducto
     * @param producto  nombre del producto
     * @param precio    precio del producto
     * @param unidades  número de unidades compradas
     */
    public Compra (String producto, double precio, int unidades) {
        this.producto = producto;
        this.precio = precio;
        this.unidades = unidades;
    }
    

    // --------------------------------------------------
    //                    GETTERS
    // --------------------------------------------------
    /**
     * Obtiene el nombre del producto.
     * @return nombre del producto
     */
    public String getProducto() {
        return this.producto;
    }
    
    /**
     * Obtiene el precio del producto.
     * @return precio del producto
     */
    public double getPrecio() {
        return this.precio;
    }

    /**
     * Obtiene el número de unidades compradas del producto.
     * @return número de unidades compradas del producto
     */
    public int getUnidades() {
        return this.unidades;
    }
    
    /**
     * Obtiene el importe total de la compra. Se calcula multiplicando el precio 
     * del producto por el número de unidades adquiridas.
     * @return importe total de la compra
     */
    public double getImporte () {
        return this.unidades * this.precio;
    }
    

    // --------------------------------------------------
    //                   TOSTRING
    // --------------------------------------------------
    /**
     * Representación textual de la compra.
     * Se utiliza el formato (producto, precio, unidades).
     * @return representación textual de la compra
     */
    @Override
    public String toString() {
        return String.format("(%s, %5.2f, %2d)", 
                this.producto, 
                this.precio, 
                this.unidades);
    }
}
