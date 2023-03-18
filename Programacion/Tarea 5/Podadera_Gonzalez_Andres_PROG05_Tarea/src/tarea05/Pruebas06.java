package tarea05;

import java.time.LocalDate;

/**
 * Programa de pruebas para la clase <code>Teatro</code>: método <code>traspasarObra</code>. 
 * @author profe
 */

public class Pruebas06 {
    // Declaramos un constructor privado para que la clase no sea instanciable
    private Pruebas06() {

    }
    
    public static void main(String[] args) {
        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        Teatro teatro1;
Teatro teatro2, teatro3;

        //----------------------------------------------------
        //  5. PRUEBA DE TRASPASO DE OBRA DE UN TEATRO A OTRO
        //----------------------------------------------------
        System.out.print(Utilidades.cabecera("6. PRUEBA DE TRASPASO DE OBRA"));
        System.out.printf("Fecha de realización de la prueba: %s\n", LocalDate.now().format(Utilidades.FORMATO_FECHA));
        System.out.println();
        
        //----------------------------------------------
        // Creación de objetos Teatro para las pruebas 
        //----------------------------------------------

        System.out.print(Utilidades.cabecera("6.1 CREACIÓN DE TEATROS PARA LAS PRUEBAS"));
        // Creamos objeto 1
        System.out.print(Utilidades.cabecera("CREACIÓN DE TEATRO 1 DE PRUEBA:"));
        teatro1 =Utilidades.constructor2Parametros ("Español", 763);
        System.out.println();
        
        // Creamos objeto 2
        System.out.print(Utilidades.cabecera("CREACIÓN DE TEATRO 2 DE PRUEBA:"));
        teatro2 =Utilidades.constructor2Parametros ("Reina Victoria", 600);
        System.out.println();
        
        // Creamos objeto 3
        System.out.print(Utilidades.cabecera("CREACIÓN DE TEATRO 3 DE PRUEBA:"));
        teatro3 =Utilidades.constructor2Parametros ("Teatro de la Zarzuela", 1000);
        System.out.println();
        
        //------------------------------------------------------------------------
        // Asignación de obra a un teatro y llenado de teatro para las pruebas 
        //------------------------------------------------------------------------
        
        System.out.print(Utilidades.cabecera("6.2 ASIGNACIÓN DE OBRAS A LOS TEATROS PARA LAS PRUEBAS"));

        Utilidades.asignarObraTeatro(teatro1,"Cuento de Navidad"); // Asignamos obra al teatro 1
        System.out.println();
        Utilidades.llenarTeatro(teatro1); //LLenamos del teatro1 para la obra actual para pruebas
        
        //--------------------------------------------------------
        // Traspaso de obra de teatro - pruebas con errores
        //--------------------------------------------------------
        
        System.out.println();
        System.out.print(Utilidades.cabecera("6.3 INTENTOS DE TRASPASO (CON ERRORES)"));
        
        //Intento de traspaso de un teatro a un objeto nulo
        Utilidades.traspasarObraTeatro(teatro1, null); //Error. El teatro al que se está intentando traspasar la obra no existe.
        System.out.println();
        
        //Intento de traspaso de un teatro sin obra a otro teatro
        Utilidades.traspasarObraTeatro(teatro2, teatro3); //Error. El teatro actual no tiene una obra asignada, no puede traspasarse.
        System.out.println();
        
        //Asignamos una obra de teatro al teatro3 para las pruebas
        Utilidades.asignarObraTeatro(teatro3, "La vida es sueño");
        System.out.println();
        
        //Intento de traspaso de un teatro a otro con obra de teatro asignada
        Utilidades.traspasarObraTeatro(teatro1, teatro3); //Error. El teatro de respaldo tiene ya una obra asignada, no puede traspasarse.
        System.out.println();
        
        //Intento de traspaso de un teatro a otro con falta de aforo
        Utilidades.traspasarObraTeatro(teatro1, teatro2); //Error. Se supera el aforo del teatro de respaldo, no se puede realizar el traspaso.
        System.out.println();
        
        System.out.print(Utilidades.cabecera("6.4 CONSULTAS DE ESTADO ANTES DE REALIZAR EL TRASPASO"));
        //----------------------------------------------
        //   Consulta de atributos privados de clase 
        //----------------------------------------------
        
        // Consulta inicial de los atributos de clase, antes de realizar el traspaso
        System.out.print(Utilidades.cabecera("CONSULTA DE LOS ATRIBUTOS PRIVADOS DE CLASE:"));
        System.out.printf(Utilidades.consultaEstadoClase());
        System.out.println();
        
        //----------------------------------------------
        //   Consulta de atributos privados de objeto 
        //----------------------------------------------
        
        // Consulta inicial de los atributos de objeto, antes de realizar el traspaso
        System.out.print(Utilidades.cabecera("CONSULTA DEL ESTADO DEL TEATRO 1:"));
        System.out.printf(Utilidades.consultaEstadoObjeto(teatro1));
        System.out.println();
        System.out.print(Utilidades.cabecera("CONSULTA DEL ESTADO DEL TEATRO 2:"));
        System.out.printf(Utilidades.consultaEstadoObjeto(teatro2));
        System.out.println();
        System.out.print(Utilidades.cabecera("CONSULTA DEL ESTADO DEL TEATRO 3:"));
        System.out.printf(Utilidades.consultaEstadoObjeto(teatro3));
        System.out.println();
        
        //--------------------------------------------------------
        // Traspaso de obra de teatro - pruebas sin error
        //--------------------------------------------------------
        
        System.out.print(Utilidades.cabecera("6.5 TRASPASOS DE OBRAS"));
        
        //Traspaso de la obra del teatro 3 al 2
        Utilidades.traspasarObraTeatro(teatro3, teatro2);
        System.out.println();
        
        //Traspaso de la obra del teatro 1 al 3
        Utilidades.traspasarObraTeatro(teatro1, teatro3);
        System.out.println();
        
        System.out.print(Utilidades.cabecera("6.6 CONSULTAS DE ESTADO DESPUÉS DE REALIZAR EL TRASPASO"));
        //----------------------------------------------
        //   Consulta de atributos privados de objeto 
        //----------------------------------------------

        // Consulta inicial de los atributos de objeto, después de realizar el traspaso
        System.out.print(Utilidades.cabecera("CONSULTA DEL ESTADO DEL TEATRO 1:"));
        System.out.printf(Utilidades.consultaEstadoObjeto(teatro1));
        System.out.println();
        System.out.print(Utilidades.cabecera("CONSULTA DEL ESTADO DEL TEATRO 2:"));
        System.out.printf(Utilidades.consultaEstadoObjeto(teatro2));
        System.out.println();
        System.out.print(Utilidades.cabecera("CONSULTA DEL ESTADO DEL TEATRO 3:"));
        System.out.printf(Utilidades.consultaEstadoObjeto(teatro3));
        System.out.println();
        
        //----------------------------------------------
        //   Consulta de atributos privados de clase 
        //----------------------------------------------

        // Consulta de los atributos de clase una vez realizado el traspaso
        System.out.print(Utilidades.cabecera("CONSULTA DE LOS ATRIBUTOS PRIVADOS DE CLASE:"));
        System.out.printf(Utilidades.consultaEstadoClase());
        System.out.println();
        
    }
}
