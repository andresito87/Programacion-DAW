package tarea05;

/**
 * Programa prueba para la clase Teatro
 */
import java.time.LocalDate;

/**
 * Programa de pruebas para la clase <code>Teatro</code>: métodos <code>getter</code>.
 * @author profe
 */
public class Pruebas03 {

    // Declaramos un constructor privado para que la clase no sea instanciable
    private Pruebas03() {

    }

    public static void main(String[] args) {
        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        Teatro teatro1;
Teatro teatro2, teatro3;

        //----------------------------------------------
        //  3. PRUEBA DE ATRIBUTOS PRIVADOS Y GETTERS
        //----------------------------------------------
        System.out.print(Utilidades.cabecera("3. PRUEBA DE ATRIBUTOS PRIVADOS Y GETTERS"));
        System.out.printf("Fecha de realización de la prueba: %s\n", LocalDate.now().format(Utilidades.FORMATO_FECHA));
        System.out.println();

        //----------------------------------------------
        //   Consulta de atributos públicos de clase 
        //----------------------------------------------
        // Consulta inicial de los atributos de clase, antes de crear ningún objeto
        System.out.printf(Utilidades.consultaEstadoClase());
        System.out.println();
        
        //----------------------------------------------
        // Creación de objetos Teatro para las pruebas 
        //----------------------------------------------

        // Pruebas que deben funcionar
        // ---------------------------
        
        // Creamos objeto y mostramos sus atributos mediante getters
        System.out.print(Utilidades.cabecera("CREACIÓN DE TEATRO 1 DE PRUEBA:"));
        teatro1 =Utilidades.constructor2Parametros ("Real", 1000);
        System.out.print(Utilidades.consultaEstadoObjeto(teatro1));
        System.out.println();
        
        // Creamos objeto y mostramos sus atributos mediante getters
        System.out.print(Utilidades.cabecera("CREACIÓN DE TEATRO 2 DE PRUEBA:"));
        teatro2 =Utilidades.constructor1Parametro ("Lope de Vega");
        System.out.print(Utilidades.consultaEstadoObjeto(teatro2));
        System.out.println();

        // Creamos objeto y mostramos sus atributos mediante getters
        System.out.print(Utilidades.cabecera("CREACIÓN DE TEATRO 3 DE PRUEBA:"));
        teatro3= Utilidades.constructorSinParametros();
        System.out.print(Utilidades.consultaEstadoObjeto(teatro3));
        System.out.println();
        
        //----------------------------------------------
        //   Consulta de atributos públicos de clase 
        //----------------------------------------------
        // Consulta de los atributos de clase una vez creados varios objetos
        System.out.printf(Utilidades.consultaEstadoClase());
        System.out.println();
    }
    
}
