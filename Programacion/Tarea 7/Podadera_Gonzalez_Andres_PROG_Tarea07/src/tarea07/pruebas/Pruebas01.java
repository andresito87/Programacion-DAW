package tarea07.pruebas;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import tarea07.tienda.TicketCompra;

/**
 * Programa de pruebas para la clase <code>TicketCompra</code>: métodos <code>getImporte</code> y
 * <code>getNumArticulos</code>.
 * @author profe
 */
public class Pruebas01 {
    
    // Declaramos un constructor privado para que la clase no sea instanciable (es un programa "ejecutable")
    private Pruebas01() {
        
    }
    
    /**
     * Programa principal.
     * @param args posibles argumentos desde la línea de órdenes (no se usa)
     */
    public static void main(String[] args) {
        
        //---------------------------------------------------------------------------
        //  1. Prueba de obtención del importe y el número de productos de una compra
        //---------------------------------------------------------------------------
        System.out.print(Utilidades.cabecera("1.PRUEBA DE DE LOS MÉTODOS getImporte Y getNumArticulos DE LA CLASE TicketCompra"));
        System.out.printf("Fecha de realización de la prueba: %s\n", LocalDate.now().format(Utilidades.FORMATO_FECHA));
        System.out.println();

        //----------------------------------------------
        // Creación de objetos TicketCompra de prueba
        //----------------------------------------------
        System.out.print(Utilidades.cabecera("CREANDO TICKETS DE COMPRA DE PRUEBA"));
        List <TicketCompra> listaCompras =  new LinkedList<>();
        for (int i=1 ; i<=8 ; i++) {
            TicketCompra ejemplo = Utilidades.creaEjemploTicketCompra(i);
            listaCompras.add (ejemplo);
            System.out.printf ("%d. Creado ticket de compra: %s\n", i, ejemplo);
        }
        System.out.println();
        
        //----------------------------------------------
        // Pruebas de los métodos 
        // getImporte y getNumArticulos 
        // de la clase TicketCompra
        //----------------------------------------------
        System.out.print(Utilidades.cabecera("VERIFICANDO TICKETS LA COMPRA DE PRUEBA"));
        int contador=1;
        for (TicketCompra compra: listaCompras) {
            System.out.printf ("%d. Probando ticket compra: %s\n", contador++, compra);
            System.out.printf ("Número de artículos: %d\n", compra.getNumArticulos());
            System.out.printf ("Importe: %5.2f\n", compra.getImporte());
            System.out.println();
        }
        System.out.println();
    }
}
