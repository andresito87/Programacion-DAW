package pruebas;

import libreria.AudioBook;
import libreria.EBook;
import libreria.EReader;
import libreria.Libro;
import libreria.LibroDigital;
import libreria.LibroFisico;
import libreria.Producto;

/**
 * Programa de pruebas de la jearquía de clases <code>Producto</code>.
 */
public class Prueba02 {

    public static void main(String[] args) {

        //----------------------------------------------
        //           PRUEBA DE PRODUCTOS
        //----------------------------------------------
        System.out.println("--------------------");
        System.out.println("2. PRUEBA DE GETTERS");
        System.out.println("--------------------");
        System.out.println();

        // Generamos productos de prueba
        System.out.println("Creando productos...");
        Producto[] listaProductos = Utilidades.generarArrayProductos();
        System.out.println();

        // Mostramos los productos creados usando los métodos apropiados
        System.out.println("Probando getters de los productos creados");
        System.out.println("-----------------------------------------");
        for (Producto p : listaProductos) {
            Utilidades.probarGettersProducto(p);
            if (p instanceof EReader) {
                Utilidades.probarGettersEReader((EReader) p);
            } else if (p instanceof Libro) {
                Utilidades.probarGettersLibro((Libro) p);
                if (p instanceof LibroFisico) {
                    Utilidades.probarGettersLibroFisico((LibroFisico) p);
                } else if (p instanceof LibroDigital) {
                    Utilidades.probarGettersLibroDigital((LibroDigital) p);
                    if (p instanceof EBook) {
                        Utilidades.probarGettersEBook((EBook) p);
                    } else if (p instanceof AudioBook) {
                        Utilidades.probarGettersAudioBook((AudioBook) p);
                    }
                }
            }
            System.out.println("-----------------------------------------");
        }
        System.out.println();

    }

}
