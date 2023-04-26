package tarea07.pruebas;

import java.time.LocalDate;
import tarea07.tienda.Tienda;

/**
 * Programa de pruebas para la clase <code>TicketCompra</code>: métodos <code>getImporte</code> y
 * <code>getNumArticulos</code>. 
 */
public class Pruebas02 {

    // Declaramos un constructor privado para que la clase no sea instanciable (es un programa "ejecutable")
    private Pruebas02() {        

    }

    /**
     * Programa principal.
     * @param args posibles argumentos desde la línea de órdenes (no se usa)
     */
    public static void main(String[] args) {
        
        //---------------------------------------------------------------------------
        //  2. Prueba de obtención del artículos vendidos y del importe total
        //     de facturación de toda la tienda
        //---------------------------------------------------------------------------
        System.out.print(Utilidades.cabecera("2.PRUEBA DE DE LOS MÉTODOS getNumArticulosVendidos Y getFacturacionTotal DE LA CLASE Tienda"));
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
        // Pruebas de los métodos 
        // getNumArticulosVendidos y getFacturacionTotal 
        // de la clase Tienda
        //----------------------------------------------
        System.out.print(Utilidades.cabecera("PROBANDO MÉTODOS DE LA TIENDA"));
        System.out.printf ("Probando getNumArticulosVendidos: %d\n", tienda.getNumArticulosVendidos());
        System.out.printf ("Probando getFacturacionTotal: %.2f\n", tienda.getFacturacionTotal());
        System.out.println();
    }
}
