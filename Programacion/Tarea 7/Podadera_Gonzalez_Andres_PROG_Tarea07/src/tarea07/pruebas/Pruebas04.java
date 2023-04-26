package tarea07.pruebas;

import java.time.LocalDate;
import java.util.Map;
import java.util.Map.Entry;
import tarea07.tienda.Tienda;

/**
 * Programa de pruebas para la clase <code>TicketCompra</code>: método <code>getImportesPorFechas</code>. 
 */
public class Pruebas04 {

    // Declaramos un constructor privado para que la clase no sea instanciable (es un programa "ejecutable")
    private Pruebas04() {        

    }

    /**
     * Programa principal.
     * @param args posibles argumentos desde la línea de órdenes (no se usa)
     */
    public static void main(String[] args) {
        
        //---------------------------------------------------------------------------
        //  4. Prueba del método getImportesPorFechas de la clase Tienda
        //---------------------------------------------------------------------------
        System.out.print(Utilidades.cabecera("4.PRUEBA DEL MÉTODO getImportesPorFechas DE LA CLASE Tienda"));
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
        System.out.println ("Probando getImportesPorFechas");
        Map<LocalDate, Double> importesPorFechas = tienda.getImportesPorFechas();
        System.out.println ("Resultado obtenido:");
        if (importesPorFechas != null) {
            for (Entry<LocalDate, Double> parFechaImporte:importesPorFechas.entrySet()) {
                System.out.printf ("Fecha %s -> Importe %7.2f\n", 
                        parFechaImporte.getKey().format(Utilidades.FORMATO_FECHA), parFechaImporte.getValue());
            }
        }
        System.out.println();
    }    
}
