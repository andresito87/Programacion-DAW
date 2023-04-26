package libreria;

/**
 * Clase que representa un <strong>producto</strong> de tipo
 * <strong>EReader</strong> para la gestión de productos en una tienda.
 *
 * <p>
 * Los objetos de esta clase contienen atributos que permiten almacenar toda la
 * información relativa a un producto de tipo EReader (lector de libros
 * electrónicos) en una tienda. Además de los atributos propios de un producto,
 * deberá contener los específicos de un EReader, que son:</p>
 *
 * <ul>
 * <li><strong>Fabricante</strong> del EReader (Amazon, BQ, Sony, Onyx, ICARUS,
 * etc.).</li>
 * </ul>
 *
 * @author Andres Samuel Podadera Gonzalez
 */
public class EReader extends Producto {

    //Atributo de instancia
    private final String fabricante;

    //Constructor
    /**
     * Crea un objeto ERreader con un nombre, precio, texto de descripción y
     * fabricante.
     *
     * @param precio Precio del dispostivo (euros)
     * @param descripcion Descripción del dispostivo
     * @param fabricante fabricante del dispostivo (Amazon, BQ, Kobo, Tolino,
     * etc.)
     * @throws IllegalArgumentException si alguno de los parámetros no es válido
     */
    public EReader(double precio, String descripcion, String fabricante)
            throws IllegalArgumentException {

        super(precio, descripcion);
        this.fabricante = fabricante;
    }

    //Métodos getters
    /**
     * Devuelve el nombre del <strong>fabricante</strong> del dispositivo
     *
     * @return fabricante del dispositivo
     */
    public String getFabricante() {
        return this.fabricante;
    }

    /**
     * Devuelve una cadena que representa las característias del dispositivo de
     * forma textual.
     *
     * @return cadena que representa las características del dispositivo de
     * forma textual
     */
    @Override
    public String toString() {
        return String.format("%-14s fabricante:%-14s",
                super.toString(),
                this.getFabricante()
        );
    }
}
