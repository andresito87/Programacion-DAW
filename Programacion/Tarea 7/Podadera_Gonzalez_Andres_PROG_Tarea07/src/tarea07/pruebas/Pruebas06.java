package tarea07.pruebas;

import java.time.LocalDate;
import tarea07.tienda.Tienda;

/**
 * Programa de pruebas para la clase <code>TicketCompra</code>: métodos <code>removeCompras</code>. 
 */
public class Pruebas06 {

    // Declaramos un constructor privado para que la clase no sea instanciable (es un programa "ejecutable")
    private Pruebas06() {        

    }

    /**
     * Programa principal.
     * @param args posibles argumentos desde la línea de órdenes (no se usa)
     */
    public static void main(String[] args) {
        
        //---------------------------------------------------------------------------
        //  5. Prueba del método getComprasPorVendedorYear de la clase Tienda
        //---------------------------------------------------------------------------
        System.out.print(Utilidades.cabecera("6.PRUEBA DE LOS MÉTODOS removeCompras DE LA CLASE Tienda"));
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
        // Prueba del método removeCompras
        // de la clase Tienda
        //----------------------------------------------
        int borrados;
        System.out.print(Utilidades.cabecera("PROBANDO MÉTODOS DE LA TIENDA"));
        System.out.println ("Probando removeCompras (\"Fran\")");
        borrados = tienda.removeCompras("Fran");
        System.out.printf ("Tickets eliminados: %d. La tienda queda:\n", borrados);
        System.out.println (tienda);
        System.out.println (tienda.toStringTicketsCompra());

        System.out.println ("Probando removeCompras (03/12/2022)");
        borrados = tienda.removeCompras(LocalDate.of(2022,12,3));
        System.out.printf ("Tickets eliminados: %d. La tienda queda:\n", borrados);
        System.out.println (tienda);
        System.out.println (tienda.toStringTicketsCompra());

        System.out.println ("Probando removeCompras (\"Dani\", 10/02/2022)");
        borrados = tienda.removeCompras("Dani", LocalDate.of(2022,2,10));
        System.out.printf ("Tickets eliminados: %d. La tienda queda:\n", borrados);
        System.out.println (tienda);
        System.out.println (tienda.toStringTicketsCompra());

        System.out.println ("Probando removeCompras (\"Dani\", 10/02/2023)");
        borrados = tienda.removeCompras("Dani", LocalDate.of(2023,2,10));
        System.out.printf ("Tickets eliminados: %d. La tienda queda:\n", borrados);
        System.out.println (tienda);
        System.out.println (tienda.toStringTicketsCompra());

        System.out.println ("Probando removeCompras (\"Juan\", 03/02/2023)");
        borrados = tienda.removeCompras("Juan", LocalDate.of(2023,2,3));
        System.out.printf ("Tickets eliminados: %d. La tienda queda:\n", borrados);
        System.out.println (tienda);
        System.out.println (tienda.toStringTicketsCompra());

        System.out.println ("Probando removeCompras (\"Fran\")");
        borrados = tienda.removeCompras("Fran");
        System.out.printf ("Tickets eliminados: %d. La tienda queda:\n", borrados);
        System.out.println (tienda);
        System.out.println (tienda.toStringTicketsCompra());

        System.out.println ("Probando removeCompras (05/02/2023)");
        borrados = tienda.removeCompras(LocalDate.of(2023,2,5));
        System.out.printf ("Tickets eliminados: %d. La tienda queda:\n", borrados);
        System.out.println (tienda);
        System.out.println (tienda.toStringTicketsCompra());

        System.out.println();
    }
}
