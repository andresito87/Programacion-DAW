package pruebas;

/**
 * Programa de pruebas de la jearquía de clases <code>Producto</code>.
 */
public class Prueba01 {

    public static void main(String[] args) {

        //----------------------------------------------
        //           PRUEBA DE PRODUCTOS
        //----------------------------------------------
        System.out.println("--------------------------");
        System.out.println("1. PRUEBA DE CONSTRUCTORES");
        System.out.println("--------------------------");
        System.out.println();

        // Prueba de constructores con errores
        Utilidades.PruebaConstructoresError();

        // Generamos productos de prueba
        Utilidades.generarArrayProductos();

    }

}
