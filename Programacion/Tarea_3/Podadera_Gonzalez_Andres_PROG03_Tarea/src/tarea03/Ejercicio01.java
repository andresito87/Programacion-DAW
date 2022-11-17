package tarea03;

// Aquí tendrás que incluir los "import" que necesites
import java.time.format.DateTimeFormatter;
import libtarea3.Bombilla;
import libtarea3.Utilidades;

/**
 * Ejercicio 1: trabajo con bombillas
 *
 * @author Andres Samuel Podadera Gonzalez
 */
public class Ejercicio01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // 1.1. Declaración de tres variables referencia a objetos instancia de la clase Bombilla
        Bombilla bombilla1;
        Bombilla bombilla2;
        Bombilla bombilla3;

        // 1.2. Declaración de variable para dar formato de fecha hora 
        DateTimeFormatter formatoFechaHora = DateTimeFormatter.ofPattern("dd/mm/yyyy hh:mm:ss");
        //----------------------------------------------
        //              Presentación
        //----------------------------------------------
        System.out.println("TRABAJO CON BOMBILLAS");
        System.out.println("--------------------");
        System.out.println();

        //----------------------------------------------
        //               Análisis inicial
        //----------------------------------------------        
        // 2. Consulta de valores iniciales
        System.out.println("1.-CONSULTA INICIAL DE VALORES GLOBALES");
        System.out.println("---------------------------------------");
        System.out.println();

        // 2.1. Número de bombillas creadas hasta el momento
        System.out.printf("Número de bombillas creadas hasta el momento: %d%n", Bombilla.getBombillasCreadas());

        // 2.2. Número de bombillas encendidas en este momento
        System.out.printf("Número de bombillas encendidas hasta el momento: %d%n", Bombilla.getBombillasEncendidas());

        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        // En realidad no hay entrada de datos como tal dado que la información 
        // de entrada es fija y siempre la misma
        System.out.println("\n2.-CREACIÓN Y USO DE BOMBILLAS");
        System.out.println("------------------------------\n");

        // 3.- Instanciación de tres objetos Bombilla
        System.out.println("Creación de bombillas (constructores)");
        System.out.println("-------------------------------------");

        // 3.1.- Intento de crear una bombilla encendida con una potencia no válida (hay que gestionar la posible excepción)
        try {
            System.out.println("Intentando crear una bombilla encendida con una potencia no válida.");
            bombilla1 = new Bombilla(true, 250.0);
        } catch (IllegalArgumentException ex) {
            System.out.printf("Error: %s%n", ex.getMessage());
        }
        // 3.2.- Intento de crear una bombilla con estado por defecto y una potencia no válida (hay que gestionar la posible excepción)
        try {
            System.out.println("\nIntentando crear una bombilla con potencia no válida.");
            bombilla2 = new Bombilla(5.0);
        } catch (IllegalArgumentException ex) {
            System.out.printf("Error: %s%n", ex.getMessage());
        }

        // 3.3.- Creación de una primera bombilla usando el constructor de dos parámetros
        System.out.println("\nCreando bombilla encendida con una potencia válida con un constructor de dos parámetros...");
        bombilla1 = new Bombilla(true, 100);
        System.out.printf("Bombilla 1 creada, estado: %s%n", bombilla1.toString());

        // 3.4.- Creación de una segunda bombilla encendida y potencia por defecto usando el constructor de un parámetro
        System.out.println("\nCreando bombilla encendida con una potencia por defecto usando un constructor de un parámetro...");
        bombilla2 = new Bombilla(true);
        System.out.printf("Bombilla 2 creada, estado: %s%n", bombilla2.toString());

        // 3.5.- Creación de una tercera bombilla usando el constructor sin parámetros        
        System.out.println("\nCreando bombilla con valores por defecto usando un constructor sin parámetros...");
        bombilla3 = new Bombilla();
        System.out.printf("Bombilla 3 creada, estado: %s%n", bombilla3.toString());

        //----------------------------------------------
        //       Procesamiento + Salida de Resultados
        //----------------------------------------------
        // Dado que se va a ir mostrando información de salida a la vez que 
        // se van realizando operaciones, podemos considerar en este caso
        // que el procesamiento y la salida de resultado van unidos y "mezclados"
        // 4.- Operaciones con bombillas
        System.out.println("\nManipulación de bombillas (métodos)");
        System.out.println("-----------------------------------");

        // 4.1.- Intento de encender una bombilla ya encendida
        System.out.println("Encendidendo la primera bombilla");
        try {
            bombilla1.encender();
        } catch (IllegalStateException ex) {
            System.out.printf("Error: %s%n", ex.getMessage());
        }

        // 4.2.- Conmutar la primera bombilla seis veces (utilizando un bucle)
        for (int i = 0; i < 6; i++) {
            System.out.println("\nConmutando estado de la Bombilla 1");
            bombilla1.conmutar();
            System.out.printf("Estado de Bombilla 1: %s%n", bombilla1.toString());
            System.out.println("Esperando 1 segundo...");
            Utilidades.esperar(1);
        }

        // 4.3.- Apagar la segunda bombilla
        System.out.println("\nApagando la Bombilla 2...");
        bombilla2.apagar();
        // 4.4.- Encender la tercera bombilla
        System.out.println("Encendiendo la Bombilla 3...");
        bombilla3.encender();

        // 5.- Obtención de información de cada bombilla creada
        System.out.println("\nPrueba de los getters de las bombillas creadas:");
        System.out.println("-----------------------------------------------");
        System.out.println("Bombilla 1");
        System.out.printf("\tPotencia: %.2f W%n", bombilla1.getPotencia());
        System.out.printf("\tEstado: %s%n", bombilla1.getEstado() ? "Encendida" : "Apagada");
        System.out.printf("\tÚltima vez que se encendió: %s %n", bombilla1.getUltimaVezEncendida().format(formatoFechaHora));
        System.out.printf("\tNúmero de veces encendida: %d veces %n", bombilla1.getVecesEncendida());
        System.out.printf("\tTiempo que lleva encendida: %.2f segundos %n", bombilla1.getTiempoEncendida());
        System.out.printf("\tPotencia consumida: %.2f Ws %n", bombilla1.getPotenciaConsumida());
        System.out.println();

        //----------------------------------------------
        //               Análisis Final
        //----------------------------------------------        
        // 6. Consulta de valores finales
        System.out.println("3.-CONSULTA FINAL DE VALORES GLOBALES");
        System.out.println("-------------------------------------");
        System.out.println();

        // 6.1. Número de bombillas creadas hasta el momento
        System.out.printf("Número de bombillas creadas hasta el momento: %d%n", Bombilla.getBombillasCreadas());

        // 6.2. Número de bombillas encendidas en este momento
        System.out.printf("Número de bombillas encendidas en este momento: %d%n", Bombilla.getBombillasEncendidas());

        System.out.println();
        System.out.println("Fin del programa.");
    }

}
