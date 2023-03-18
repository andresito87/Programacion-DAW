package tarea05;

import java.time.LocalDate;

/**
 * Programa de pruebas para la clase <code>Teatro</code>: métodos <code>asignarObra</code> y <code>terminarObra</code>.
 * @author profe
 */
public class Pruebas04 {

    // Declaramos un constructor privado para que la clase no sea instanciable
    private Pruebas04() {

    }

    public static void main(String[] args) {
        //------------------------------------------------------
        //          Declaración de variables 
        //------------------------------------------------------
        Teatro teatro1;
Teatro teatro2, teatro3;

        //------------------------------------------------------
        // 4. PRUEBA DE LOS MÉTODOS ASIGNAR OBRA Y TERMINAR OBRA
        //------------------------------------------------------
        System.out.print(Utilidades.cabecera("4. PRUEBA DE LOS MÉTODOS ASIGNAR OBRA Y TERMINAR OBRA"));
        System.out.printf("Fecha de realización de la prueba: %s\n", LocalDate.now().format(Utilidades.FORMATO_FECHA));
        System.out.println();

        //------------------------------------------------------
        //   Consulta de atributos públicos de clase 
        //------------------------------------------------------

        // Consulta inicial de los atributos de clase, antes de crear ningún objeto
        System.out.printf(Utilidades.consultaEstadoClase());
        System.out.println();
        
        //------------------------------------------------------
        // Creación de objetos Teatro para las pruebas 
        //------------------------------------------------------

        // Creamos objeto 1
        System.out.print(Utilidades.cabecera("CREACIÓN DE TEATRO 1 DE PRUEBA:"));
        teatro1 =Utilidades.constructor2Parametros ("Falla", 1000);
        System.out.println();
        
        // Creamos objeto 2
        System.out.print(Utilidades.cabecera("CREACIÓN DE TEATRO 2 DE PRUEBA:"));
        teatro2 =Utilidades.constructor1Parametro ("Góngora");
        System.out.println();

        // Creamos objeto 3
        System.out.print(Utilidades.cabecera("CREACIÓN DE TEATRO 3 DE PRUEBA:"));
        teatro3= Utilidades.constructorSinParametros();
        System.out.println();
        
        //-------------------------------------------------------
        // Asignación de obras a los teatros para las pruebas 
        //-------------------------------------------------------
        
        System.out.print(Utilidades.cabecera("PRUEBAS DE ASIGNACIÓN DE OBRAS DE TEATRO"));

        //Intentamos asignar una cadena vacía a una obra
        Utilidades.asignarObraTeatro(teatro1,""); //Error. El nombre de la obra no puede ser cadena vacía.
        //Intentamos asignar null a una obra
        Utilidades.asignarObraTeatro(teatro1,null); //Error.
        // Intentamos terminar una obra en un teatro que no tiene obra asignada
        Utilidades.terminarObraTeatro(teatro1); //Error. El teatro no tiene una obra asignada que se pueda finalizar.
        // Asignamos obra al teatro 1
        Utilidades.asignarObraTeatro(teatro1,"La Venganza de Don Mendo"); 
        // Intentamos asignar otra obra al mismo teatro
        Utilidades.asignarObraTeatro(teatro1,"Eros de Roma"); // Error. El teatro ya tiene una obra asignada.
        // Asignamos obra al teatro 2
        Utilidades.asignarObraTeatro(teatro2,"La Molécula del Sueño"); 
        // Asignamos obra al teatro 3
        Utilidades.asignarObraTeatro(teatro3,"Grease"); 
        // Terminamos la obra del teatro 1
        Utilidades.terminarObraTeatro(teatro1); 
        // Intentamos volver a terminar la obra en el teatro 1
        Utilidades.terminarObraTeatro(teatro1); //Error. El teatro no tiene una obra asignada que se pueda finalizar.

        //------------------------------------------------------
        //   Consulta de atributos públicos de clase 
        //------------------------------------------------------
        // Consulta de los atributos de clase una vez creados y manipulados varios objetos
        System.out.printf(Utilidades.consultaEstadoClase());
        System.out.println();

    }
    
}
