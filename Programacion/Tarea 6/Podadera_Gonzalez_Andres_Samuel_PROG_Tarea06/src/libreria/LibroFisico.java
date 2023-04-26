package libreria;

/**
 * Clase que representa un <strong>producto</strong> de tipo <strong>Libro
 * Físico</strong> para la gestión de productos en una tienda.
 *
 * <p>
 * Los objetos de esta clase contienen atributos que permiten almacenar toda la
 * información relativa a un producto de tipo libro físico (no electrónico) en
 * una tienda. Además de los atributos propios de un libro en abstracto, deberá
 * contener los específicos de un libro físico, que son:</p>
 *
 * <ul>
 * <li><strong>Número de páginas</strong> del libro.</li>
 * </ul>
 *
 * @author Andres Samuel Podadera Gonzalez
 */
public final class LibroFisico extends Libro {

    //Atributos de clase
    /**
     * Máximo número de páginas permitido: {@value}.
     */
    public static final int MAX_PAGINAS = 5000;

    /**
     * Mínimo número de páginas permitido: {@value}.
     */
    public static final int MIN_PAGINAS = 20;

    //Atributos de instancia
    private final int numPaginas;

    //Constructor
    /**
     * Crea un objeto LibroFisico con un nombre, precio, texto de descripción,
     * autor, año de edición y número de páginas. El rango válido para las
     * páginas es entre {@value #MIN_PAGINAS} - {@value #MAX_PAGINAS}
     *
     * @param titulo Título del libro
     * @param precio Precio del libro (euros)
     * @param descripcion Descripción del libro
     * @param autor Autor del libro
     * @param year Año de edición del libro
     * @param numPaginas Número de páginas del libro. El rango válido es
     * {@value #MIN_PAGINAS} - {@value #MAX_PAGINAS}
     * @throws IllegalArgumentException si alguno de los parámetros no es válido
     */
    public LibroFisico(String titulo, double precio, String descripcion, String autor, int year, int numPaginas)
            throws IllegalArgumentException {

        super(titulo, precio, descripcion, autor, year);
        if (numPaginas < LibroFisico.MIN_PAGINAS || numPaginas > LibroFisico.MAX_PAGINAS) {
            throw new IllegalArgumentException("Número de páginas fuera del rango permitido: " + numPaginas);
        }
        this.numPaginas = numPaginas;
    }

    //Métodos getters
    /**
     * Devuelve el <strong>número de páginas</strong> del libro
     *
     * @return número depáginas del libro
     */
    public int getNumPaginas() {
        return this.numPaginas;
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
        return String.format("%-14s numPáginas:%-14d",
                super.toString(),
                this.getNumPaginas()
        );
    }
}
