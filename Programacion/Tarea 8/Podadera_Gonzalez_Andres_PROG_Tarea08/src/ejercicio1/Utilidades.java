
package ejercicio1;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Utilidades para la realización del <code>Ejercicio 1: Lectura/Escritura de una
 * agenda de contactos en ficheros de texto.</code>
 * 
 * @author profe
 */

public final class Utilidades {
    
    // Declaramos un constructor privado para que la clase no sea instanciable
    // Es una "toolbox" o "caja de herramientas"
    private Utilidades() {

    }

    /**
     * Genera un array de aficiones de tamaño tres a partir de la lista de
     * aficiones que recibe como parámetro. Las aficiones se eligen al azar.
     * 
     * @param aficiones Objeto de tipo List de aficiones
     * @return array de aficiones
     */
    public static String[] generarAficiones(List<String> aficiones) {
        Set<String> aficionesAleatorias = new HashSet<>();

        while (aficionesAleatorias.size() < 3) {
            aficionesAleatorias.add(aficiones.get(numAleatorio(0, aficiones.size() - 1)));
        }

        return aficionesAleatorias.toArray(new String[0]);
    }

    /**
     * Genera un número aleatorio entre el mínimo y el máximo, ambos incluidos.
     *
     * @param minimo valor mínimo que tomará el número aleatorio
     * @param maximo valor máximo que tomará el número aleatorio
     * @return número aleatorio
     */
    public static int numAleatorio(int minimo, int maximo) {
        int num = (int) Math.floor(Math.random() * (maximo - minimo + 1) + (minimo));
        return num;
    }
}
