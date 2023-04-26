package tarea07.pruebas;

import java.time.LocalDate;
import tarea07.tienda.Tienda;

/**
 * Programa de pruebas para la clase <code>TicketCompra</code>: método <code>getProductosComprados</code>. 
 */
public class Pruebas03 {

    // Declaramos un constructor privado para que la clase no sea instanciable (es un programa "ejecutable")
    private Pruebas03() {        

    }

    /**
     * Programa principal.
     * @param args posibles argumentos desde la línea de órdenes (no se usa)
     */
    public static void main(String[] args) {
        
        //---------------------------------------------------------------------------
        //  3. Prueba de obtención del artículos vendidos y del importe total
        //     de facturación de toda la tienda
        //---------------------------------------------------------------------------
        System.out.print(Utilidades.cabecera("3.PRUEBA DEL MÉTODO getProductosComprados DE LA CLASE Tienda"));
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
        // Pruebas del método getProductosComprados
        // de la clase Tienda
        //----------------------------------------------
        System.out.print(Utilidades.cabecera("PROBANDO MÉTODOS DE LA TIENDA"));
        System.out.printf ("Probando getProductosComprados a partir del 11/02/2023: %s\n", tienda.getProductosComprados(LocalDate.of(2023,  2, 11)));
        System.out.printf ("Probando getProductosComprados a partir del 10/02/2023: %s\n", tienda.getProductosComprados(LocalDate.of(2023,  2, 10)));
        System.out.printf ("Probando getProductosComprados a partir del 04/02/2023: %s\n", tienda.getProductosComprados(LocalDate.of(2023,  2,  4)));
        System.out.printf ("Probando getProductosComprados a partir del 01/12/2022: %s\n", tienda.getProductosComprados(LocalDate.of(2022, 12,  1)));
        System.out.println();
    }
}
