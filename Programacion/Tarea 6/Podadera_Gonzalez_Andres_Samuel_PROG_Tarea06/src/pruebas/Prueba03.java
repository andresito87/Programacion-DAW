package pruebas;

import libreria.Producto;

/**
 * Programa de pruebas de la jearquía de clases <code>Producto</code>.
 */
public class Prueba03 {

    public static void main(String[] args) {

        //----------------------------------------------
        //           PRUEBA DE PRODUCTOS
        //----------------------------------------------
        System.out.println("-----------------------------");
        System.out.println("3. PRUEBA DEL MÉTODO TOSTRING");
        System.out.println("-----------------------------");
        System.out.println();

        // Generamos productos de prueba
        System.out.println("Creando productos...");
        Producto[] listaProductos = Utilidades.generarArrayProductos();
        System.out.println();

        // Mostramos los productos creados usando toString
        System.out.println("Probando toString de los productos creados");
        System.out.println("------------------------------------------");
        Utilidades.mostrarContenidoArrayProductos(listaProductos);
        System.out.println();

    }

}
