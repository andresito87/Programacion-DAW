package tarea07.pruebas;

import java.time.LocalDate;
import tarea07.tienda.Tienda;

/**
 * Programa de pruebas para la clase <code>TicketCompra</code>: métodos <code>removeCompras</code>. 
 */
public class Pruebas07 {

    // Declaramos un constructor privado para que la clase no sea instanciable
    private Pruebas07() {        

    }
    
    /**
     * Programa principal.
     * @param args posibles argumentos desde la línea de órdenes (no se usa)
     */
    public static void main(String[] args) {
        
        //---------------------------------------------------------------------------
        //  7. Prueba de los métodos de ordenación de tickets de la clase Tienda
        //---------------------------------------------------------------------------
        System.out.print(Utilidades.cabecera("7.PRUEBA DE LOS MÉTODOS DE ORDENACIÓN DE TICKETS DE LA CLASE Tienda"));
        System.out.printf("Fecha de realización de la prueba: %s\n", LocalDate.now().format(Utilidades.FORMATO_FECHA));
        System.out.println();

        //----------------------------------------------
        // Creación de objeto Tienda de prueba
        //----------------------------------------------
        System.out.print(Utilidades.cabecera("CREANDO TIENDA DE PRUEBA"));
        Tienda tienda =  Utilidades.CreaEjemploTienda();
        System.out.printf ("Creado ojeto Tienda de prueba: %s\n", tienda);
        System.out.println ("Orden inicial de la lista de tickets:");
        System.out.println (tienda.toStringTicketsCompra());
        System.out.println();
        
        //----------------------------------------------
        // Prueba del método sortListaTicketsPorInstante
        //----------------------------------------------
        System.out.print(Utilidades.cabecera("PROBANDO MÉTODOS DE LA TIENDA"));
        System.out.println ("Probando sortListaTicketsPorInstante:");
        tienda.sortListaTicketsPorInstante();
        System.out.println (tienda.toStringTicketsCompra());

        //-------------------------------------------------------------
        // Prueba del método sortListaTicketsPorNumArticulos
        //-------------------------------------------------------------
        System.out.println ("Probando sortListaTicketsPorNumArticulos:");
        tienda.sortListaTicketsPorNumArticulos();
        System.out.println (tienda.toStringTicketsCompra());

        //-------------------------------------------------------------
        // Prueba del método sortListaTicketsPorVendedor
        //-------------------------------------------------------------
        System.out.println ("Probando sortListaTicketsPorVendedor:");
        tienda.sortListaTicketsPorVendedor();
        System.out.println (tienda.toStringTicketsCompra());

        //-------------------------------------------------------------
        // Prueba del método sortListaTicketsPorImporte
        //-------------------------------------------------------------
        System.out.println ("Probando sortListaTicketsPorImporte:");
        tienda.sortListaTicketsPorImporte();
        System.out.println (tienda.toStringTicketsCompra());

        System.out.println();
    }

    
}
