package libreria;

import java.time.LocalDate;

/**
 * Clase abstracta que representa un <strong>producto</strong> de tipo
 * <strong>Libro</strong> para la gestión de productos en una tienda.
 *
 * <p>
 * Los objetos de esta clase contienen atributos que permiten almacenar la
 * información relativa a un producto de tipo Libro en una tienda. Además de los
 * atributos propios de un producto, deberá contener los específicos de un
 * libro, que son:</p>
 *
 * <ul>
 * <li><strong>Autor</strong> del libro.</li>
 * <li><strong>Año de edición</strong> del libro (valor mínimo 1500, valor
 * máximo el año actual).</li>
 * </ul>
 *
 * <p>
 * Se trata de una clase abastracta que contiene la información mínima sobre el
 * libro pero no contiene información que depende de su formato físico (si se
 * trata de un libro en papel o un libro electrónico). Para eso existen otras
 * clases especializadas que heredarán de ésta.</p>
 *
 * @author Andres Samuel Podadera Gonzalez
 */
public abstract class Libro extends Producto {

    //Atributo de clase
    /**
     * Mínimo año de edición permitido: {@value}.
     */
    public static final int MIN_YEAR = 1500;

    //Atributos de instancia
    private final String titulo;
    private final String autor;
    private final int year;

    //Constructor
    /**
     * Crea un objeto Libro con un nombre, precio, un texto de descripción,
     * autor y año de edición.
     *
     * @param titulo Título del libro
     * @param precio Precio del libro (euros)
     * @param descripcion Descripción del libro
     * @param autor Autor del libro
     * @param year Año de edición del libro. El rango válido es
     * {@value #MIN_YEAR}-Año actual
     * @throws IllegalArgumentException si alguno de los parámetros no es válido
     */
    public Libro(String titulo, double precio, String descripcion, String autor, int year)
            throws IllegalArgumentException {

        super(precio, descripcion);
        if (year < Libro.MIN_YEAR || year > LocalDate.now().getYear()) {
            throw new IllegalArgumentException("Año fuera de rango: " + year);
        }
        this.titulo = titulo;
        this.autor = autor;
        this.year = year;
    }

    //Métodos getters
    /**
     * Devuelve el <strong>título</strong> del libro
     *
     * @return autor
     */
    public String getTitulo() {
        return this.titulo;
    }

    /**
     * Devuelve el nombre del <strong>autor</strong> del libro
     *
     * @return autor
     */
    public String getAutor() {
        return this.autor;
    }

    /**
     * Devuelve el <strong>año de publicación</strong> del libro
     *
     * @return año de publicación
     */
    public int getYear() {
        return this.year;
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
        return String.format("%-14s titulo: %-14s autor:%-12s año:%-6d",
                super.toString(),
                this.getTitulo(),
                this.getAutor(),
                this.getYear()
        );
    }
}
