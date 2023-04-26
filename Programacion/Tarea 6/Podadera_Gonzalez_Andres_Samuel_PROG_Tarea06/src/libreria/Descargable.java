package libreria;

/**
 * Interfaz que incorpora la capacidad de ser descargado de la red.
 *
 * @author Andres Samuel Podadera Gonzalez
 */
public interface Descargable {

    /**
     * Devuelve el <strong>tamaño</strong> en Kb del elemento descargable.
     *
     * @return Tamaño en Kb del elemento
     */
    int getSize();

    /**
     * Devuelve la cantidad de descargas realizadas de ese elemento hasta el
     * momento.
     *
     * @return cantidad de descargas realizadas de ese elemento hasta el momento
     */
    int getNumDescargas();

    /**
     * Descarga el elemento por la red.
     *
     * @return cantidad de descargas realizadas de ese elemento hasta el momento
     * (incluida la que se acaba de realizar)
     */
    int descargar();
}
