package tarea05;

import java.time.LocalDate;

/**
 * Programa de pruebas para la clase <code>Teatro</code>. Compra y devolución de entradas:
 * - método <code>comprarEntradas</code>.
 * - método <code>devolverEntradas</code>.
 * - método <code>llenarTeatro</code>.
 * - método <code>vaciarTeatro</code>.
 *
 * @author profe
 */
public class Pruebas05 {

    // Declaramos un constructor privado para que la clase no sea instanciable
    private Pruebas05() {

    }

    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        Teatro teatro1;
        Teatro teatro2;


        //----------------------------------------------
        //  5. PRUEBA DE COMPRA Y VENTA DE ENTRADAS
        //----------------------------------------------
        System.out.print(Utilidades.cabecera("5. PRUEBA DE COMPRA Y VENTA DE ENTRADAS"));
        System.out.printf("Fecha de realización de la prueba: %s\n", LocalDate.now().format(Utilidades.FORMATO_FECHA));
        System.out.println();

        //----------------------------------------------
        //   Consulta de atributos privados de clase 
        //----------------------------------------------

        // Consulta inicial de los atributos de clase, antes de crear ningún objeto
        System.out.print(Utilidades.cabecera("5.1 CONSULTA DE LOS ATRIBUTOS PRIVADOS DE CLASE:"));
        System.out.printf(Utilidades.consultaEstadoClase());
        System.out.println();
        
        //----------------------------------------------
        // Creación de objetos Teatro para las pruebas 
        //----------------------------------------------

        // Creamos objeto 1
        System.out.print(Utilidades.cabecera("CREACIÓN DE TEATRO 1 DE PRUEBA:"));
        teatro1 =Utilidades.constructor2Parametros ("Cánovas", 1000);
        System.out.println();
        
        // Creamos objeto 2
        System.out.print(Utilidades.cabecera("CREACIÓN DE TEATRO 2 DE PRUEBA:"));
        teatro2 =Utilidades.constructor1Parametro ("Maestranza");
        System.out.println();

        //-------------------------------------------------------
        // Asignación de obras a los teatros para las pruebas 
        //-------------------------------------------------------
        
        System.out.print(Utilidades.cabecera("5.2 ASIGNACIÓN DE OBRAS A LOS TEATROS"));

        Utilidades.asignarObraTeatro(teatro1,"El joven Frankenstein"); // Asignamos obra al teatro 1
        
        //-----------------------------------------------------
        //       Compra y devolución de entradas para las pruebas 
        //-----------------------------------------------------      
        
        System.out.print(Utilidades.cabecera("5.3 COMPRA Y DEVOLUCIÓN DE ENTRADAS"));
        
        //Intento de devolver entradas en un teatro sin entradas compradas
        Utilidades.devolverEntradasTeatro(teatro1,4); //Error: No hay tantas entradas vendidas en este teatro
        //Compra de entradas en un teatro sin obra (teatro 2)
        Utilidades.comprarEntradaTeatro(teatro2); //Error: El teatro no tiene una obra asignada
        //Compra  de entradas en un teatro con obra (teatro 1)
        Utilidades.comprarEntradaTeatro(teatro1); 
        //Compra de más entradas que las disponibles
        Utilidades.comprarEntradasTeatro(teatro1, teatro1.getAforo()+1); //Error: El número de entradas supera el aforo
        //Devolución de más entradas que las compradas
        Utilidades.devolverEntradasTeatro(teatro1, teatro1.getAforo()+1); //Error: No hay tantas entradas vendidas en este teatro
        //Compra de todas las entradas del teatro (llenar teatro)
        Utilidades.llenarTeatro(teatro1);
        //Intento de volver a comprar todas las entradas del teatro (llenar teatro)
        Utilidades.llenarTeatro(teatro1); //Error: El teatro ya estaba completo para esa obra, por tanto no puede llenarse.
        //Devolución de entradas válidas
        Utilidades.devolverEntradaTeatro(teatro1); 
        //Devolución de todas las entradas (vaciar teatro)
        Utilidades.vaciarTeatro(teatro1);
        //Intento de volver a devolver todas las entradas (vaciar teatro)
        Utilidades.vaciarTeatro(teatro1); //Error: El teatro no tiene entradas vendidas para esa obra, por tanto no puede vaciarse.
        
        
        //----------------------------------------------
        //   Consulta de atributos privados de clase 
        //----------------------------------------------

        // Consulta de los atributos de clase una vez creados varios objetos
        System.out.print(Utilidades.cabecera("5.4 CONSULTA DE LOS ATRIBUTOS PRIVADOS DE CLASE:"));
        System.out.printf(Utilidades.consultaEstadoClase());
        System.out.println();


    }
   
}
