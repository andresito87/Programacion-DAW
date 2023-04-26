package libreria;

/**
 * Clase abstracta que representa un <strong>producto</strong> genérico para una
 * librería de venta online.
 *
 * <p>
 * Los objetos de esta clase contienen atributos que permiten almacenar la
 * mínima información necesaria de un producto para ser comercializado en la
 * tienda:</p>
 *
 * <ul>
 * <li><strong>Id</strong> del producto.</li>
 * <li><strong>Precio</strong> del producto (valor real en el rango
 * {@value #MIN_PRECIO} - {@value #MAX_PRECIO} euros).</li>
 * <li><strong>Descripción</strong> del producto.</li>
 * </ul>
 *
 * <p>
 * El precio de un producto puede cambiar a lo largo del tiempo, por ejemplo si
 * se trata de un <code>EBook</code>.</p>
 *
 * @author Andres Samuel Podadera Gonzalez
 */
public abstract class Producto {

    //Atributos de clase
    /**
     * Máximo precio permitido: {@value}
     */
    public static final double MAX_PRECIO = 10000.00;
    /**
     * Mínimo precio permitido: {@value}.
     */
    public static final double MIN_PRECIO = 0.01;
    
    //contador que se autoincrementará cada vez que se cree un objeto
    private static int contadorIdsAutoincremental = 1;

    //Atributo protegido de instancia
    /**
     * Precio actual del producto
     */
    protected double precio;

    //Atributos privados de instancia
    private final int id;
    private final String descripcion;

    //Constructor
    /**
     * Crea un objeto <code>Producto</code> con un <strong>nombre</strong>, un
     * <strong>precio</strong> y un <strong>texto de descripción</strong>.
     *
     * @param precio Precio del producto. El rango válido es 0.01-10000.0 euros
     * @param descripcion Descripción del producto
     * @throws IllegalArgumentException si alguno de los parámetros no es válido
     */
    public Producto(double precio, String descripcion)
            throws IllegalArgumentException {

        if (precio < Producto.MIN_PRECIO || precio > Producto.MAX_PRECIO) {
            throw new IllegalArgumentException(String.format("El precio no está en el rango permitido: %.2f", precio));
        }
        Producto.contadorIdsAutoincremental++;
        this.id = contadorIdsAutoincremental;
        this.precio = precio;
        this.descripcion = descripcion;
    }

    //Métodos getters
    /**
     * Devuelve el <strong>nombre</strong> o <strong>identificador</strong> del
     * producto
     *
     * @return Nombre del producto
     */
    public int getId() {
        return this.id;
    }

    /**
     * Devuelve el <strong>precio</strong> actual del producto
     *
     * @return precio del producto
     */
    public double getPrecio() {
        return this.precio;
    }

    /**
     * Devuelve la <strong>descripción</strong> del producto
     *
     * @return Descripción del producto
     */
    public String getDescripcion() {
        return this.descripcion;
    }

    /**
     * Devuelve una cadena que representa las característias del producto de
     * forma textual.
     *
     * @return cadena que representa las característias del producto de forma
     * textual.
     */
    @Override
    public String toString() {
        return String.format(" tipo:%-12s id:%-4d precio: %-8.2f descripción:%-20s",
                this.getClass().getSimpleName(),
                this.getId(),
                this.getPrecio(),
                this.getDescripcion()
        );
    }
}
