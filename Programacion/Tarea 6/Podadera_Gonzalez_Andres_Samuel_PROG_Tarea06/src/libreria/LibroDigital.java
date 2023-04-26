package libreria;

/**
 * Clase abstracta que representa un <strong>producto</strong> de tipo
 * <strong>Libro Digital</strong> para la gestión de productos en una tienda.
 *
 * <p>
 * Los objetos de esta clase contienen atributos que permiten almacenar toda la
 * información relativa a un producto de tipo libro digital en una tienda
 * online. Además de los atributos propios de un libro en abstracto, deberá
 * contener los específicos de un libro digital, que son:</p>
 *
 * <ul>
 * <li><strong>Tamaño del archivo</strong> (en kilobytes).</li>
 * <li><strong>Número de veces</strong> que se ha descargado el archivo.</li>
 * </ul>
 *
 * <p>
 * El tamaño de un libro digital en la tienda puede cambiar a lo largo de su
 * vida, dependiendo del tipo de libro digital que se trate (por ejemplo si es
 * un <code>AudioBook</code>).</p>
 *
 * @author Andres Samuel Podadera Gonzalez
 */
public abstract class LibroDigital extends Libro implements Descargable {

    //Atributos de clase
    /**
     * Mínimo tamaño de archivo permitido {@value}.
     */
    public static final int MIN_SIZE = 20;

    /**
     * Máximo tamaño de archivo permitido: {@value}.
     */
    public static final int MAX_SIZE = 65535;

    //Atributos de instancia
    /**
     * Tamaño del archivo que almacena el libro digital.
     */
    protected int size;
    private int numDescargas;

    //Constructor
    /**
     * Crea un objeto LibroElectronico con un nombre, precio, texto de
     * descripción, autor, año de edición y tamaño en Kbytes.
     *
     * @param titulo Título del libro
     * @param precio Precio del libro (euros)
     * @param descripcion Descripción del libro
     * @param autor Autor del libro
     * @param year Año de edición del libro
     * @param size Tamaño del archivo del libro electrónico (Kb)
     * @throws IllegalArgumentException si alguno de los parámetros no es válido
     */
    public LibroDigital(String titulo, double precio, String descripcion, String autor, int year, int size)
            throws IllegalArgumentException {

        super(titulo, precio, descripcion, autor, year);
        if (size < LibroDigital.MIN_SIZE || size > LibroDigital.MAX_SIZE) {
            throw new IllegalArgumentException(String.format("Tamaño fuera de rango: %d Kb", size));
        }
        this.size = size;
    }

    //Métodos getters
    /**
     * Devuelve el <strong>tamaño</strong> en Kb del archivo EBook
     *
     * @return Tamaño en Kb del EBook
     */
    @Override
    public int getSize() {
        return this.size;
    }

    /**
     * Devuelve el <strong>número de descargas</strong> del libro digital hasta
     * el momento
     *
     * @return número de descargas del libro digital hasta el momento
     */
    @Override
    public int getNumDescargas() {
        return this.numDescargas;
    }

    //Métodos de acción
    /**
     * Descarga el libro digital por la red.
     *
     * @return cantidad de descargas realizadas de este libro digital
     */
    @Override
    public int descargar() {
        this.numDescargas++;
        return this.getNumDescargas();
    }

    /**
     * Devuelve una cadena que representa las características del libro de forma
     * textual.
     *
     * @return cadena que representa las característias del libro de forma
     * textual
     */
    @Override
    public String toString() {
        return String.format("%-14s tamaño:%-10s numDescargas:%-4d",
                super.toString(),
                this.getSize(),
                this.getNumDescargas()
        );
    }
}
