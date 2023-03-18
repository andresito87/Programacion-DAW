package tarea05;

/**
 * Clase que representa un <strong>teatro</strong> y la gestión de sus obras y
 * entradas.
 * <p>
 * Los objetos de esta clase permiten almacenar y gestionar información sobre el
 * propio teatro (código, nombre y aforo) así como de las obras que se están
 * representando y de las entradas vendidas.</p>
 *
 * <p>
 * La clase también dispone de información general independiente de los objetos
 * concretos que se hayan creado. Es el caso de:</p>
 * <ul>
 * <li><strong>número de teatros</strong> creados hasta el momento;</li>
 * <li><strong>cantidad total de obras activas</strong> en el momento actual,
 * o</li>
 * <li><strong>cantidad total de entradas vendidas</strong> para todos los
 * teatros y todas las obras.</li>
 * </ul>
 *
 * @author Andrés Samuel Podadera González
 */
public class Teatro {

    //ATRIBUTOS DE CLASE
    //atributos públicos constantes de clase
    /**
     * Máximo aforo permitido: {@value}.
     */
    public static final int AFORO_MAX = 1000;

    /**
     * Mínimo aforo permitido: {@value}.
     */
    public static final int AFORO_MIN = 300;

    /**
     * Valor por omisión para el aforo: {@value}.
     */
    public static final int DEFAULT_AFORO = 800;

    //atributos privados de clase
    private static int teatrosTotales = 0;
    private static int obrasActivas;
    private static int entradasVendidas;
    private static int codigosTeatros = 1;

    //ATRIBUTOS DE OBJETO
    //atributos constantes privados de objeto
    private final int codigo;
    private final String nombre;
    private final int aforo;

    //atributos privados de objeto
    private String nombreObraAsignada = null;
    private int entradasObraVendidas;

    //CONSTRUCTORES
    //constructor con dos parámetros
    /**
     * Constructor basado en el nombre del teatro, así como en el aforo. Crea un
     * nuevo objeto <code>Teatro</code> con el nombre y el
     * <strong>aforo</strong> indicados. El aforo debe estar entre
     * <code>Teatro.AFORO_MIN</code> y <code>Teatro.AFORO_MAX</code>.
     *
     * @param nombre nombre del teatro
     * @param aforo número de butacas del teatro
     * @throws NullPointerException Si el nombre del teatro es una cadena vacía
     * o bien si el aforno no es correcto
     * @throws IllegalArgumentException si el parámetro nombre es nulo
     */
    public Teatro(String nombre, int aforo) throws NullPointerException, IllegalArgumentException {
        if (nombre == null) {
            throw new NullPointerException("El nombre del teatro no puede ser nulo");
        } else if (nombre.isEmpty()) { //nombre.lenght()==0
            throw new IllegalArgumentException("El nombre del teatro no puede ser cadena vacía");
        } else if (aforo < Teatro.AFORO_MIN || Teatro.AFORO_MAX < aforo) {
            throw new IllegalArgumentException(String.format("Aforo incorrecto: %d", aforo));
        }
        this.nombre = nombre;
        this.aforo = aforo;
        this.codigo = Teatro.codigosTeatros;
        Teatro.codigosTeatros++;
        Teatro.teatrosTotales++;
    }

    //constructor con un parámetro
    /**
     * Constructor basado en el nombre del teatro. Crea un nuevo objeto
     * <code>Teatro</code> con el nombre indicado y con el valor por omisión
     * para el aforo.
     *
     * @param nombre nombre del teatro
     * @throws NullPointerException si el nombre del teatro es una cadena vacía
     * @throws IllegalArgumentException si el parámetro nombre es nulo
     */
    public Teatro(String nombre) throws NullPointerException, IllegalArgumentException {
        this(nombre, Teatro.DEFAULT_AFORO);
    }

    //constructor sin parámetros
    /**
     * Constructor sin parámetros. Crea un nuevo objeto <code>Teatro</code> con
     * el valor por omisión para el aforo y el nombre del teatro generado de
     * forma automática como una cadena formada por el texto "teatro" seguida de
     * espacio y seguido de un número que representará los teatros que hay
     * creados (incluyendo el actual). Ej: "teatro 51".
     */
    public Teatro() {
        this(String.format("Teatro %d", Teatro.codigosTeatros), DEFAULT_AFORO);
    }

    //Métodos GETTERS
    /**
     * Obtiene el nombre del teatro.
     *
     * @return nombre del teatro
     */
    public String getNombreTeatro() {
        return this.nombre;
    }

    /**
     * Obtiene el código del teatro.
     *
     * @return código del teatro
     */
    public String getCodigoTeatro() {
        return String.format("%d", this.codigo);
    }

    /**
     * Obtiene el aforo del teatro.
     *
     * @return aforo del teatro
     */
    public int getAforo() {
        return this.aforo;
    }

    /**
     * Obtiene las entradas vendidas para la obra que se está representando.
     *
     * @return entradas vendidas
     */
    public int getEntradasVendidas() {
        return this.entradasObraVendidas;
    }

    /**
     * Indica si el teatro tiene obra asignada.
     *
     * @return si tiene obra o no
     */
    public boolean tieneObra() {
        return this.nombreObraAsignada != null;
    }

    /**
     * Obtiene el nombre de la obra que se está representando. Si no se está
     * representando ninguna obra, devolverá <code>null</code>.
     *
     * @return nombre de la obra. Si no se está representando ninguna obra
     * devuelve <code>null</code>
     */
    public String getObra() {
        return this.nombreObraAsignada;
    }

    //Métodos ESTÁTICOS
    /**
     * Obtiene el número de teatros creados hasta el momento.
     *
     * @return número de teatros totales
     */
    public static int getTeatrosTotales() {
        return Teatro.teatrosTotales;
    }

    /**
     * Obtiene el número de obras que se están representando en este momento en
     * todos los teatros.
     *
     * @return número de obras activas totales
     */
    public static int getObrasActivas() {
        return Teatro.obrasActivas;
    }

    /**
     * Obtiene las entradas vendidas en todos los teatros y para todas las obras
     * que se han representado hasta el momento.
     *
     * @return entradas vendidas totales
     */
    public static int getEntradasVendidasTotales() {
        return Teatro.entradasVendidas;
    }

    //Métodos VOID
    /**
     * Asigna una obra al teatro. Si el teatro ya tiene obra asignada no se
     * puede volver a asignar.
     *
     * @param obra obra que se va a asignar al teatro
     * @throws NullPointerException si el parámetro obra es nulo
     * @throws IllegalArgumentException si el nombre de la obra es una cadena
     * vacía o bien si el aforo no es correcto
     * @throws IllegalStateException si tiene obra asignada
     */
    public void asignarObra(String obra) throws NullPointerException, IllegalArgumentException, IllegalStateException {
        if (obra == null) {
            throw new NullPointerException("El nombre de la obra no puede ser nulo.");
        } else if (obra.isEmpty()) {
            throw new IllegalArgumentException("El nombre de la obra no puede ser cadena vacía.");
        } else if (this.nombreObraAsignada != null) {
            throw new IllegalStateException("El teatro ya tiene una obra asignada.");
        }
        this.nombreObraAsignada = obra;
        this.entradasObraVendidas=0;
        Teatro.obrasActivas++;
    }

    /**
     * Finaliza la obra que se está representando. Si el teatro no tiene obra
     * asignada no se puede finalizar.
     *
     * @throws IllegalStateException si no tiene obra asignada
     */
    public void terminarObra() throws IllegalStateException {
        if (!this.tieneObra()) {
            throw new IllegalStateException("El teatro no tiene una obra asignada que se pueda finalizar.");
        }
        this.nombreObraAsignada = null;
        Teatro.obrasActivas--;
    }

    /**
     * Compra todas las entradas para llenar el teatro para la obra que se está
     * representando. Si el teatro no tiene obra asignada no podrá llenarse, y
     * si ya está lleno, tampoco.
     *
     * @throws IllegalStateException si no tiene obra asignada
     * @throws IllegalStateException si tiene todas las entradas vendidas
     */
    public void llenarTeatro() throws IllegalStateException {
        comprarEntradas(this.aforo - this.entradasObraVendidas);
    }

    /**
     * Devuelve todas las entradas para vaciar el teatro para la obra que se
     * está representando. Si el teatro no tiene obra asignada no podrá
     * vaciarse, y si ya está vacío, tampoco.
     *
     * @throws IllegalStateException si no tiene obra asignada
     * @throws IllegalStateException si no tiene entradas vendidas
     */
    public void vaciarTeatro() throws IllegalStateException {
        devolverEntradas(this.entradasObraVendidas);
    }

    /**
     * Compra entradas para la obra que se está representando. Si el teatro no
     * tiene obra asignada no podrán comprarse entradas, y si el número de
     * entradas supera el aforo, tampoco.
     *
     * @param entradas número de entradas a comprar
     * @throws IllegalArgumentException si entradas son 0 o negativas
     * @throws IllegalStateException si no tiene obra asignada o si el número de
     * entradas supera el aforo
     */
    public void comprarEntradas(int entradas) throws IllegalStateException, IllegalArgumentException {
        if (this.nombreObraAsignada == null) {
            throw new IllegalStateException("El teatro no tiene una obra asignada, por tanto no se pueden comprar entradas.");
        } else if (entradas < 0) {
            throw new IllegalArgumentException(String.format("No se pueden comprar %d entradas.", entradas));
        } else if (entradas > this.aforo) {
            throw new IllegalArgumentException("El número de entradas supera el aforo, no pueden aumentarse las entradas.");
        } else if (this.entradasObraVendidas == this.aforo) {
            throw new IllegalStateException("El teatro ya estaba completo para esa obra, por tanto no puede llenarse.");
        }
        this.entradasObraVendidas += entradas;
        Teatro.entradasVendidas += entradas;
    }

    /**
     * Compra una entrada para la obra que se está representando. Si el teatro
     * no tiene obra asignada no podrán comprarse entradas, y si el número de
     * entradas supera el aforo, tampoco.
     *
     * @throws IllegalStateException si no tiene obra asignada o si el número de
     * entradas supera el aforo
     */
    public void comprarEntrada() throws IllegalStateException {
        comprarEntradas(1);
    }

    /**
     * Devuelve entradas para la obra que se está representando. Si el teatro no
     * tiene obra asignada no podrán delvolverse entradas, y si el número de
     * entradas a devolver supera las entradas vendidas, tampoco.
     *
     * @param entradas número de entradas a devolver
     * @throws IllegalArgumentException si entradas son 0 o negativas
     * @throws IllegalStateException si no tiene obra asignada o si no hay
     * tantas entradas vendidas
     */
    public void devolverEntradas(int entradas) throws IllegalStateException, IllegalArgumentException {
        if (this.entradasObraVendidas - entradas < 0) {
            throw new IllegalStateException("No hay tantas entradas vendidas en este teatro, no pueden devolverse las entradas.");
        } else if (this.nombreObraAsignada == null || this.entradasObraVendidas == 0) {
            throw new IllegalStateException("El teatro no tiene entradas vendidas para esa obra, por tanto no puede vaciarse.");
        } else if (entradas < 0) {
            throw new IllegalArgumentException(String.format("No se pueden devolver %d entradas.", entradas));
        }
        this.entradasObraVendidas -= entradas;
        Teatro.entradasVendidas -= entradas;
    }

    /**
     * Devuelve una entrada para la obra que se está representando. Si el teatro
     * no tiene obra asignada no podrán delvolverse entradas, y si no hay
     * ninguna entrada vendida, tampoco.
     *
     * @throws IllegalStateException si no tiene obra asignada o si no hay
     * entradas vendidas
     *
     */
    public void devolverEntrada() throws IllegalStateException {
        devolverEntradas(1);
    }

    /**
     * Traspasa la obra que se está representando en este teatro a otro teatro.
     * Si este teatro no tiene obra asignada, no podrá traspasarse. Tampoco
     * podrá traspasarse si el teatro destino ya tiene una obra asignada o si el
     * aforo es insuficiente para cubrir las entradas vendidas de la obra que se
     * quiere traspasar.
     *
     * @param otroTeatro Teatro al que se va a traspasar la obra
     * @throws NullPointerException si el teatro destino es null
     * @throws IllegalStateException si este teatro no tiene obra asignada o si
     * el teatro destino ya tiene una obra asignada o si el aforo es
     * insuficiente para cubrir las entradas vendidas de la obra que se quiere
     * traspasar.
     */
    public void traspasarObra(Teatro otroTeatro) throws IllegalStateException, NullPointerException {
        if (otroTeatro == null) {
            throw new NullPointerException("El teatro al que está intentando traspasar la obra no existe.");
        } else if (otroTeatro.tieneObra()) {
            throw new IllegalStateException("El teatro de respaldo tiene ya una obra asignada, no puede traspasarse.");
        } else if (!this.tieneObra()) {
            throw new IllegalStateException("El teatro actual no tiene una obra asignada, no puede traspasarse.");
        } else if (this.entradasObraVendidas > otroTeatro.getAforo()) {
            throw new IllegalStateException("Se supera el aforo del teatro de respaldo, no se puede realizar el traspaso.");
        }
        otroTeatro.nombreObraAsignada = this.nombreObraAsignada;
        this.nombreObraAsignada = null;
        otroTeatro.entradasObraVendidas = this.entradasObraVendidas;
        this.entradasObraVendidas = 0;
    }

    //To String
    /**
     * Devuelve una cadena que representa el estado de un objeto
     * <code>Teatro</code>. El resultado devuelto representará el estado del
     * teatro y tendrá la siguiente estructura:
     * <ol>
     * <li>un inicio de bloque o llave (carácter '{');</li>
     * <li>la etiqueta "Nombre del teatro: " junto con el nombre del
     * teatro;</li>
     * <li>la etiqueta "Código del teatro: " junto con el código del
     * teatro;</li>
     * <li>la etiqueta "Aforo: " junto con el aforo del teatro;</li>
     * <li>si el teatro tiene una obra asignada;</li>
     * <li>la etiqueta "Representando la obra: " junto con el nombre de la obra,
     * en caso de no tener obra asignada se representará con el texto
     * "---";</li>
     * <li>la etiqueta "Entradas vendidas: " junto con el número de entradas
     * vendidas, en caso de no tener obra asignada se representará con el texto
     * "---";</li>
     * <li>un fin de bloque o llave (carácter '}').</li>
     * </ol>
     * <p>
     * Un ejemplo de cadena devuelta podría ser:</p>
     * <p>
     * <code>{ Nombre del teatro: Apolo; Aforo: 800; tiene una obra asignada;
     * Representando la obra: Moulin Rouge; Entradas vendidas: 0; }</code></p>
     * <p>
     * donde podríamos observar la siguiente información:</p>
     * <ul>
     * <li>el nombre del teatro es Apolo;</li>
     * <li>tiene un aforo de 800 butacas;</li>
     * <li>tiene una obra asignada;</li>
     * <li>el título de la obra es Moulin Rouge;</li>
     * <li>la cantidad de entradas vendidas es 0;</li>
     * </ul>
     *
     * @return una cadena que representa el estado de un objeto
     * <code>Teatro</code>
     */
    @Override
    public String toString() {
        return String.format("{ "
                + "Nombre del teatro: %s; "
                + "Código del teatro: %d; Aforo: %d; "
                + "%s tiene una obra asignada; "
                + "Representado la obra: %s; "
                + "Entradas vendidas: %d "
                + "}",
                this.getNombreTeatro(),
                this.codigo,
                this.aforo,
                this.tieneObra() ? "sí" : "no",
                this.tieneObra() ? this.nombreObraAsignada : "---",
                this.entradasObraVendidas);
    }

}
