package pruebas;

import libreria.Audible;
import libreria.Descargable;
import libreria.LibroDigital;
import libreria.Producto;

/**
 * Programa de pruebas la clase <code>Producto</code>: Constructor y
 * <code>getters</code>
 */
public class Prueba05 {

    public static void main(String[] args) {

        //----------------------------------------------
        //           PRUEBA DE PRODUCTOS
        //----------------------------------------------
        System.out.println("--------------------------------");
        System.out.println("5. PRUEBA DE LA INTERFAZ AUDIBLE");
        System.out.println("--------------------------------");

        // Generamos productos de prueba
        System.out.println("Creando productos...");
        Producto[] listaProductos = Utilidades.generarArrayProductos();
        System.out.println();

        // Intentamos descargar todos los productos "que se dejen" :-)
        System.out.println("Mostramos información de todos los productos que sean 'audibles'");
        System.out.println("----------------------------------------------------------------");
        for (Producto producto : listaProductos) {
            System.out.printf("Observando producto %d.\n", producto.getId());
            if (producto instanceof Audible) {
                try {
                    Utilidades.probarGettersAudible((Audible) producto);
                } catch (IllegalStateException ex) {
                    System.out.printf("Error: %s.", ex.getMessage());
                }
            } else {
                System.out.printf("Producto %s no audible.\n", producto.getId());
            }
            System.out.println("----------------------------");
        }
        System.out.println();

    }

}
