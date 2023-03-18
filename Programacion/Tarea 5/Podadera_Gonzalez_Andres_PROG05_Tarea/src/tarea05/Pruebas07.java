package tarea05;

import java.time.LocalDate;

/**
 * Programa de pruebas para la clase <code>Teatro</code>: método <code>toString</code>. 
 * @author profe
 */

public class Pruebas07 {
    // Declaramos un constructor privado para que la clase no sea instanciable
    private Pruebas07() {

    }
    
    public static void main(String[] args) {
        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        Teatro teatro1;
Teatro teatro2, teatro3;

        //----------------------------------
        //  5. PRUEBA DEL MÉTODO TOSTRING
        //----------------------------------
        System.out.print(Utilidades.cabecera("7. PRUEBA DEL MÉTODO TOSTRING"));
        System.out.printf("Fecha de realización de la prueba: %s\n", LocalDate.now().format(Utilidades.FORMATO_FECHA));
        System.out.println();
        
        //----------------------------------------------
        // Creación de objetos Teatro para las pruebas 
        //----------------------------------------------

        // Creamos objeto 1
        System.out.print(Utilidades.cabecera("CREACIÓN DE TEATRO 1 DE PRUEBA:"));
        teatro1 =Utilidades.constructor2Parametros ("Gran Teatro", 600);
        System.out.print(Utilidades.consultaToString(teatro1));
        System.out.println();
        
        // Creamos objeto 2
        System.out.print(Utilidades.cabecera("CREACIÓN DE TEATRO 2 DE PRUEBA:"));
        teatro2 =Utilidades.constructor2Parametros ("Teatro Romano de Mérida", 1000);
        System.out.print(Utilidades.consultaToString(teatro2));
        System.out.println();
        
        // Creamos objeto 3
        System.out.print(Utilidades.cabecera("CREACIÓN DE TEATRO 3 DE PRUEBA:"));
        teatro3 =Utilidades.constructor1Parametro ("Cervantes");
        System.out.print(Utilidades.consultaToString(teatro3));
        System.out.println();
        
        //-------------------------------------------------------
        // Asignación de obras a los teatros para las pruebas 
        //-------------------------------------------------------
        
        System.out.print(Utilidades.cabecera("ASIGNACIÓN DE OBRAS A LOS TEATROS"));

        Utilidades.asignarObraTeatro(teatro1,"El barbero de Sevilla"); // Asignamos obra al teatro 1
        Utilidades.asignarObraTeatro(teatro2,"La comedia del fantasma"); // Asignamos obra al teatro 2
        Utilidades.asignarObraTeatro(teatro3,"La Venganza de Don Mendo"); // Asignamos obra al teatro 3
        System.out.println();
        
        //-------------------------------------------------------
        // Compra-Venta de entradas para las pruebas 
        //-------------------------------------------------------
        
        System.out.print(Utilidades.cabecera("COMPRA-DEVOLUCIÓN DE ENTRADAS DE OBRAS DE TEATRO"));
        
        Utilidades.llenarTeatro(teatro1);  //Llenamos el teatro 1
        Utilidades.comprarEntradasTeatro(teatro2, 20); //Compramos 20 entradas del teatro 2
        Utilidades.comprarEntradasTeatro(teatro3, 5); //Compramos 5 entrardas del teatro 3
        Utilidades.comprarEntradaTeatro(teatro3); //Compramos 1 entrada del teatro 3
        Utilidades.devolverEntradasTeatro(teatro2, 2); //Devolvemos 2 entradas del teatro 2
        Utilidades.devolverEntradaTeatro(teatro3); //Devolver 1 entrada del teatro 3
        System.out.println();
        
        System.out.print(Utilidades.consultaToString(teatro1));
        System.out.print(Utilidades.consultaToString(teatro2));
        System.out.print(Utilidades.consultaToString(teatro3));
        System.out.println();
        
        Utilidades.vaciarTeatro(teatro3);//Vaciamos el teatro 3
        System.out.print(Utilidades.consultaEstadoObjeto(teatro3)); // Estado del teatro después de vaciarlo
        System.out.print(Utilidades.consultaToString(teatro3));
        System.out.println();
    }
    
}
