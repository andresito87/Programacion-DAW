package tarea05;

import java.time.LocalDate;


/**
 * Programa de pruebas para la clase <code>Teatro</code>: atributos y constructores.
 * @author profe
 */

public class Pruebas0102{

    // Declaramos un constructor privado para que la clase no sea instanciable
    private Pruebas0102() {

    }

    public static void main(String[] args) {
        
        //------------------------------------------------------
        //  1 y 2. PRUEBA DE ATRIBUTOS PÚBLICOS Y CONSTRUCTORES 
        //------------------------------------------------------
        System.out.print(Utilidades.cabecera("1 y 2. PRUEBA DE ATRIBUTOS PÚBLICOS Y CONSTRUCTORES"));
        System.out.printf("Fecha de realización de la prueba: %s\n", LocalDate.now().format(Utilidades.FORMATO_FECHA));
        System.out.println();

        //----------------------------------------------
        //    Consulta de atributos públicos de clase 
        //----------------------------------------------
        System.out.printf(Utilidades.consultaAtributosPublicosClase());
        System.out.println();
             
        //----------------------------------------------
        //         Pruebas de los constructores
        //----------------------------------------------

        // Pruebas que deben dar error
        // ---------------------------
       
        System.out.print(Utilidades.cabecera("PRUEBAS DEL CONSTRUCTOR CON DOS PARÁMETROS QUE DEBEN DAR ERROR"));
        Utilidades.constructor2Parametros ("Teatro de prueba con aforo inferior", Teatro.AFORO_MIN - 1); //Error. Aforo incorrecto
        Utilidades.constructor2Parametros ("Teatro de prueba con aforo superior", Teatro.AFORO_MAX + 1); //Error. Aforo incorrecto
        Utilidades.constructor2Parametros ("", Teatro.AFORO_MAX); //Error. Nombre de teatro vacío
        Utilidades.constructor2Parametros (null, Teatro.AFORO_MAX); //Error. null
        System.out.println();

        // Pruebas que deben funcionar
        // ---------------------------

        System.out.print(Utilidades.cabecera("PRUEBAS DEL CONSTRUCTOR CON DOS PARÁMETROS QUE DEBEN FUNCIONAR:"));
        Utilidades.constructor2Parametros ("Teatro Apolo", 600);
        System.out.println();
        
        System.out.print(Utilidades.cabecera("PRUEBAS DEL CONSTRUCTOR CON UN PARÁMETRO QUE DEBE FUNCIONAR:"));
        Utilidades.constructor1Parametro ("Teatro Cervantes");
        System.out.println();

        System.out.print(Utilidades.cabecera("PRUEBA DEL CONSTRUCTOR SIN PARÁMETROS:"));
        Utilidades.constructorSinParametros();
        System.out.println();
        

    }

    
}