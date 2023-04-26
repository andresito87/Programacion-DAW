package libreria;

/**
 * Interfaz que incorpora la capacidad de un objeto de ser escuchado.
 *
 * @author Andres Samuel Podadera Gonzalez
 */
public interface Audible {

    /**
     * Devuelve la duración del elemento en minutos.
     *
     * @return duración del elemento en minutos
     */
    int getDuracion();

    /**
     * Devuelve la cantidad de voces diferentes que se pueden escuchar en el
     * elemento.
     *
     * @return cantidad de voces diferentes que se pueden escuchar
     */
    int getNumVoces();

    /**
     * Indica si en la audición interviene más de una voz.
     *
     * @return <code>true</code> si interviene más de una voz,
     * <code>false</code> en caso contrario
     */
    boolean isCoral();

    /**
     * Indica si en la audición interviene una única voz.
     *
     * @return <code>true</code> si interviene una única voz, <code>false</code>
     * en caso contrario
     */
    boolean isMonologo();
}
