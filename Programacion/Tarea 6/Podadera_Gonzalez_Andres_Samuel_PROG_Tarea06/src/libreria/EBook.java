package libreria;

/**
 * Clase que representa un <strong>producto</strong> de tipo
 * <strong>EBook</strong> para la gestión de productos en una tienda.
 *
 * <p>
 * Un Ebook es un libro digital que puede ser leído mediante un dispositivo
 * EReader.</p>
 *
 * <p>
 * Los objetos de esta clase contienen atributos que permiten almacenar toda la
 * información relativa a un producto de tipo libro electrónico (ebook) en una
 * tienda online. El precio de un EBook irá creciendo según se vayan haciendo
 * descargas. Cada descarga supone un incremento de un céntimo en su precio.</p>
 *
 * @author Andres Samuel Podadera Gonzalez
 */
public final class EBook extends LibroDigital {

    //Atributo de instancia
    private final String codificacion;

    //Constructor
    /**
     * Crea un objeto EBook con un nombre, precio, texto de descripción, autor,
     * año de edición y tamaño en Kbytes.
     *
     * @param titulo Título del libro
     * @param precio Precio del libro (euros)
     * @param descripcion Descripción del libro
     * @param autor Autor del libro
     * @param year Año de edición del libro
     * @param size Tamaño del archivo del libro digital (Kb)
     * @param codificacion Tipo de codificación usado para los caracteres
     * (ASCII, Unicode, etc.). Puede ser vacía
     * @throws IllegalArgumentException si alguno de los parámetros no es válido
     */
    public EBook(String titulo, double precio, String descripcion, String autor, int year, int size, String codificacion)
            throws IllegalArgumentException {

        super(titulo, precio, descripcion, autor, year, size);
        this.codificacion = codificacion;
    }

    //Métodos getters
    /**
     * Devuelve el tipo de codificación usado para el texto del EBook.
     *
     * @return el tipo de codificación usado para el texto del EBook
     */
    public String getCodificacion() {
        return codificacion;
    }

    //Método de acción
    /**
     * Descarga el EBook por la red. Cada vez que se realiza una descarga, se
     * incrementa el precio en un céntimo.
     *
     * @return cantidad de descargas realizadas de este EBook
     */
    @Override
    public int descargar() {
        super.descargar();
        if (this.precio <= Producto.MAX_PRECIO - 0.01) {
            this.precio += 0.01;
        }
        return this.getNumDescargas();
    }

    /**
     * Devuelve una cadena que representa las características del EBook de forma
     * textual.
     *
     * @return cadena que representa las característias del EBook de forma
     * textual
     */
    @Override
    public String toString() {
        return String.format("%-14s codificación:%-6s",
                super.toString(),
                this.getCodificacion()
        );
    }
}
