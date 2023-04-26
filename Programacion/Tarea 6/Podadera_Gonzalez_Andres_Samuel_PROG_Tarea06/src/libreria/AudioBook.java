package libreria;

/**
 * Clase que representa un <strong>producto</strong> de tipo
 * <strong>AudioBook</strong> para la gestión de productos en una tienda.
 *
 * <p>
 * Un Ebook es un libro digital que puede ser leído mediante un dispositivo
 * EReader.</p>
 *
 * <p>
 * Los objetos de esta clase contienen atributos que permiten almacenar toda la
 * información relativa a un producto de tipo libro electrónico (ebook) en una
 * tienda online. Dado que implementa la interfaz <code>Readable</code>,
 * contiene la información necesaria para poder cumplir los requisitos de esta
 * interfaz.</p>
 *
 * @author Andres Samuel Podadera Gonzalez
 */
public final class AudioBook extends LibroDigital implements Audible {

    //Atributos de clase
    /**
     * Máxima duración permitida: {@value} minutos.
     *
     */
    public static final int MAX_DURACION = 9999;

    /**
     * Mínima duración permitida: {@value} minutos.
     */
    public static final int MIN_DURACION = 15;

    //Atributos de instancia
    private final int duracion;
    private final int numVoces;
    private final int duracionMinima = 1;
    private final int cantidadVocesMinima = 1;

    //Constructor
    /**
     * Crea un objeto AudioBook con un nombre, precio, texto de descripción,
     * autor, año de edición y tamaño en Kbytes.
     *
     * @param titulo Título del libro
     * @param precio Precio del libro (euros)
     * @param descripcion Descripción del libro
     * @param autor Autor del libro
     * @param year Año de edición del libro
     * @param size Tamaño del archivo del libro digital (Kb)
     * @param duracion Duración del Audiolibro (minutos). Valor mínimo:
     * {@value #duracionMinima} minuto
     * @param numVoces Cantidad de voces diferentes que se oyen en el
     * audiolibro. Valor mínimo: {@value #cantidadVocesMinima} voz
     * @throws IllegalArgumentException si alguno de los parámetros no es válido
     */
    public AudioBook(String titulo, double precio, String descripcion, String autor, int year, int size, int duracion, int numVoces)
            throws IllegalArgumentException {

        super(titulo, precio, descripcion, autor, year, size);
        if (duracion < duracionMinima) {
            throw new IllegalArgumentException("Duración no válida: " + duracion);
        }
        if (numVoces < cantidadVocesMinima) {
            throw new IllegalArgumentException("Cantidad de voces no válida: " + numVoces);
        }
        this.duracion = duracion;
        this.numVoces = numVoces;
    }

    //Métodos getters
    /**
     * Devuelve la duración del audio libro en minutos.
     *
     * @return duración del audio libro en minutos
     */
    @Override
    public int getDuracion() {
        return this.duracion;
    }

    /**
     * Devuelve la cantidad de voces diferentes que se pueden escuchar a lo
     * largo de la audición.
     *
     * @return cantidad de voces diferentes en el audiolibro
     */
    @Override
    public int getNumVoces() {
        return this.numVoces;
    }

    //Métodos de acción
    /**
     * Descarga el AudioBook por la red. Cada vez que se realiza una descarga,
     * se incrementa el tamaño en 1 Kb porque se añade una firma que identifica
     * al usuario que lo ha descargado, salvo que se supere el tamaño máximo del
     * archivo.
     *
     * @return cantidad de descargas realizadas de este AudioBook
     */
    @Override
    public int descargar() {
        super.descargar();
        if (this.getSize() < LibroDigital.MAX_SIZE) {
            this.size++;
        }
        return this.getNumDescargas();
    }

    /**
     * Indica si en la audición interviene más de una voz.
     *
     * @return <code>true</code> si interviene más de una voz,
     * <code>false</code> en caso contrario
     */
    @Override
    public boolean isCoral() {
        return this.getNumVoces() > 1;
    }

    /**
     * Indica si en la audición interviene una única voz.
     *
     * @return <code>true</code> si interviene una única voz, <code>false</code>
     * en caso contrario
     */
    @Override
    public boolean isMonologo() {
        return this.getNumVoces() == 1;
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
        return String.format("%-14s duración:%-14d numVoces:%-6d",
                super.toString(),
                this.getDuracion(),
                this.getNumVoces());
    }
}
