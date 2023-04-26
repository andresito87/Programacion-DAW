package tarea07.pruebas;

import java.time.LocalDate;
import java.util.Map;
import java.util.Map.Entry;
import tarea07.tienda.Tienda;

/**
 * Programa de pruebas para la clase <code>TicketCompra</code>: método <code>getComprasPorVendedorYear</code>. 
 */
public class Pruebas05 {

    // Declaramos un constructor privado para que la clase no sea instanciable (es un programa "ejecutable")
    private Pruebas05() {        

    }

    /**
     * Programa principal.
     * @param args posibles argumentos desde la línea de órdenes (no se usa)
     */
    public static void main(String[] args) {
        
        //---------------------------------------------------------------------------
        //  5. Prueba del método getComprasPorVendedorYear de la clase Tienda
        //---------------------------------------------------------------------------
        System.out.print(Utilidades.cabecera("5.PRUEBA DEL MÉTODO getComprasPorVendedorYear DE LA CLASE Tienda"));
        System.out.printf("Fecha de realización de la prueba: %s\n", LocalDate.now().format(Utilidades.FORMATO_FECHA));
        System.out.println();

        //----------------------------------------------
        // Creación de objeto Tienda de prueba
        //----------------------------------------------
        System.out.print(Utilidades.cabecera("CREANDO TIENDA DE PRUEBA"));
        Tienda tienda =  Utilidades.CreaEjemploTienda();
        System.out.printf ("Creado ojeto Tienda de prueba: %s\n", tienda);
        System.out.println (tienda.toStringTicketsCompra());
        System.out.println();
        
        //----------------------------------------------
        // Prueba del método getProductosComprados
        // de la clase Tienda
        //----------------------------------------------
        System.out.print(Utilidades.cabecera("PROBANDO MÉTODOS DE LA TIENDA"));
        System.out.println ("Probando getComprasPorVendedorYear");
        Map<String, Map<Integer, Double>> comprasPorVendedorYear = tienda.getComprasPorVendedorYear();
        System.out.println ("Resultado obtenido:");
        if (comprasPorVendedorYear != null) {
            for (Entry<String, Map<Integer,Double>> parFechaImporte:comprasPorVendedorYear.entrySet()) {
                System.out.printf ("%10s -> Ventas %s\n", 
                        parFechaImporte.getKey(), parFechaImporte.getValue());
            }
        }
        System.out.println();
    }
}
