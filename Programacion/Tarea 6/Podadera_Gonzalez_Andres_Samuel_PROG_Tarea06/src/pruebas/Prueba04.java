package pruebas;

import libreria.AudioBook;
import libreria.Descargable;
import libreria.EBook;
import libreria.LibroDigital;
import libreria.Producto;

/**
 * Programa de pruebas la clase <code>Producto</code>: Constructor y
 * <code>getters</code>
 */
public class Prueba04 {

    public static void main(String[] args) {

        //----------------------------------------------
        //           PRUEBA DE PRODUCTOS
        //----------------------------------------------
        System.out.println("------------------------------------");
        System.out.println("4. PRUEBA DE LA INTERFAZ DESCARGABLE");
        System.out.println("------------------------------------");

        // Generamos productos de prueba
        System.out.println("Creando productos...");
        Producto[] listaProductos = Utilidades.generarArrayProductos();
        System.out.println();

        // Intentamos descargar todos los productos "que se dejen" :-)
        System.out.println("Descargamos 100 veces todos los productos que sean 'descargables'");
        System.out.println("-----------------------------------------------------------------");
        for (Producto producto : listaProductos) {
            if (producto instanceof Descargable) {
                try {
                    int ti, tf; // Tamaños inicial y final
                    double pi, pf; // Precios inicial y final
                    int nd; // Número de descargas
                    int descargas = 100;

                    System.out.printf("Descargando producto %s (tipo %s) 100 veces.\n",
                            producto.getId(), producto.getClass().getSimpleName(), descargas);
                    pi = ((LibroDigital) producto).getPrecio();
                    ti = ((LibroDigital) producto).getSize();
                    for (int i = 0; i < descargas; i++) {
                        ((Descargable) producto).descargar();
                    }
                    pf = ((LibroDigital) producto).getPrecio();
                    tf = ((LibroDigital) producto).getSize();
                    if (producto instanceof EBook) {
                        System.out.printf("Precio inicial: %.2f - Precio final: %.2f -> %s\n",
                                pi, pf, Math.abs(pf - (pi + 0.01 * descargas)) < 0.01 ? "CORRECTO" : "INCORRECTO");
                        System.out.printf("Tamaño inicial: %d - Tamaño final: %d -> %s\n",
                                ti, tf, tf == ti ? "CORRECTO" : "INCORRECTO");
                    } else if (producto instanceof AudioBook) {
                        System.out.printf("Precio inicial: %.2f - Precio final: %.2f -> %s\n",
                                pi, pf, Math.abs(pf - pi) < 0.01 ? "CORRECTO" : "INCORRECTO");
                        System.out.printf("Tamaño inicial: %d - Tamaño final: %d -> %s\n",
                                ti, tf, tf == ti + 1 * descargas ? "CORRECTO" : "INCORRECTO");
                    }
                    nd = ((Descargable) producto).descargar();
                    System.out.printf("Prueba de la descarga %d. Núm descargas: %d -> %s\n",
                            descargas + 1, nd, nd == descargas + 1 ? "CORRECTO" : "INCORRECTO");
                } catch (IllegalStateException ex) {
                    System.out.printf("Error: %s.", ex.getMessage());
                }
                //System.out.println(producto);
            } else {
                System.out.printf("Producto %s no descargable.\n", producto != null ? producto.getId() : "");
            }
            System.out.println();
        }
        System.out.println();

    }

}
