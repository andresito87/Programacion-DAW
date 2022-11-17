package tarea03;

// Aquí tendrás que incluir los "import" que necesites
import libtarea3.Bombo;

/**
 * Ejercicio 2: Uso de la clase Bombo
 *
 * @author Andres Samuel Podadera Gonzalez
 */
public class Ejercicio02 {

    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Variables de entrada (bombos)
        Bombo bombo1, bombo2;
        // Variables de salida

        // Variables auxiliares
        //Generador de números aleatorios entre 11 y 14, uso 15 como extremo superior porque Math.random genera entre 0 y 1 pero no incluye al 1
        int cantidadAleatoriaBolas = (int) (Math.random() * (15 - 11)) + 11; //Generador de números aleatorios entre 11 y 14

        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        // En realidad no hay entrada de datos como tal dado que la información 
        // de entrada es fija y siempre la misma
        System.out.println("USO DE BOMBOS");
        System.out.println("-------------");
        System.out.println();

        //----------------------------------------------
        //      Procesamiento y salida de resultados
        //----------------------------------------------
        System.out.println("----------------------------------");
        System.out.println("CREACIÓN DE BOMBOS (CONSTRUCTORES)");
        System.out.println("----------------------------------");

        //1. Intentos de creación y llenado de bombos
        //1.1 Creación de bombos con capacidades no válidas
        //1.1.1 Intentamos crear un bombo con una capacidad no válida (inferior a la permitida)
        System.out.println("Intentando crear bombo con capacidad inferior a la permitida...");
        try {
            bombo1 = new Bombo(Bombo.MINIMA_CAPACIDAD - 1);
        } catch (IllegalArgumentException ex) {
            System.out.printf("Error. %s%n", ex.getMessage());
        }

        //1.1.2 Intentamos crear un bombo con una capacidad no válida (superior a la permitida)
        System.out.println("\nIntentando crear bombo con capacidad superior a la permitida...");
        try {
            bombo1 = new Bombo(Bombo.MAXIMA_CAPACIDAD + 1);
        } catch (IllegalArgumentException ex) {
            System.out.printf("Error. %s%n", ex.getMessage());
        }

        //1.2 Creación de bombos con capacidades válidas
        //1.2.1 Intentamos crear un bombo con la capacidad por omisión
        //usando para ello el constructor sin parámetros        
        System.out.println("\nCreando bombo por omisión...");
        bombo1 = new Bombo();
        System.out.printf("Correcto. Creado bombo de %d elementos.%n", bombo1.getCapacidad());
        System.out.printf("Estado inicial del bombo: %s%n", bombo1.toString());

        //1.2.2 Intentamos crear un bombo con una capacidad válida
        //usando para ello el constructor con un parámetro
        System.out.println("\nIntentando crear bombo de 15 elementos...");
        bombo2 = new Bombo(15);
        System.out.printf("Correcto. Creado bombo de %d elementos.%n", bombo2.getCapacidad());
        System.out.printf("Estado inicial del bombo: %s%n", bombo2.toString());
        System.out.printf("Bolas extraídas: %s%n", bombo2.getBolasExtraidas());
        System.out.printf("Cantidad de bolas extraídas: %s%n", bombo2.getCantidadBolasExtraidas());
        System.out.printf("Bolas restantes: %s%n", bombo2.getBolasRestantes());
        System.out.printf("Cantidad de bolas restantes: %s%n", bombo2.getCantidadBolasRestantes());

        //2. Pruebas de extracción
        System.out.println();
        System.out.println("----------------------");
        System.out.println("PRUEBAS DE EXTRACCIÓN:");
        System.out.println("----------------------");

        // 2.1 Extraemos todas las bolas del bombo creado
        System.out.println("PRUEBA 1: EXTRACCIÓN DE TODAS LAS BOLAS DE UN BOMBO:");
        System.out.println("----------------------------------------------------");
        System.out.println("Extrayendo todas las bolas del bombo...");

        // Vamos extrayendo una a una cada bola y vamos informando
        for (int i = 1; i <= 15; i++) {    //uso el intervalo 1-15 por legibilidad pero 0-14 fué la primera opción implementada
            System.out.printf("Extraída la bola: %d%n", bombo2.extraerBola());
        }

        //Mostramos los resultados obtenidos
        System.out.printf("Estado del bombo tras sacar todas las bolas: %s%n", bombo2.toString());
        System.out.printf("Bolas extraídas: %s%n", bombo2.getBolasExtraidas());
        System.out.printf("Cantidad de bolas extraídas: %s%n", bombo2.getCantidadBolasExtraidas());
        System.out.printf("Bolas restantes: %s%n", bombo2.getBolasRestantes());
        System.out.printf("Cantidad de bolas restantes: %s%n\n", bombo2.getCantidadBolasRestantes());

        //2.2 Reiniciamos el bombo para poder seguir extrayendo bolas y mostramos su estado   
        System.out.println("PRUEBA 2: REINICIO DEL BOMBO:");
        System.out.println("-----------------------------------------------------------------");

        System.out.println("Rellenamos de nuevo el bombo con la misma capacidad...");
        System.out.printf("Se han añadido %d bolas. %n", bombo2.reset());
        System.out.printf("Estado del bombo tras rellenar: %s%n\n", bombo2.toString());

        // 2.3 Extraemos del bombo creado un número aleatorio de bolas entre 11 y 14 (ambos incluidos)
        System.out.println("PRUEBA 3: EXTRACCIÓN DE UN NÚMERO ALEATORIO DE BOLAS DE UN BOMBO:");
        System.out.println("-----------------------------------------------------------------");
        System.out.println("Extrayendo un número aleatorio de bolas...");

        // Vamos extrayendo las bolas y vamos informando
        System.out.printf("Vamos a extraer %d bolas.%n", cantidadAleatoriaBolas);

        for (int i = 1; i <= cantidadAleatoriaBolas; i++) {    //uso el intervalo 1-15 por legibilidad pero 0-14 fué la primera opción implementada
            System.out.printf("Extraída la bola: %d%n", bombo2.extraerBola());
        }

        // Mostramos los resultados finales obtenidos       
        System.out.printf("Estado del bombo tras sacar un número aleatorio de bolas: %s%n", bombo2.toString());
        System.out.printf("Bolas extraídas: %s%n", bombo2.getBolasExtraidas());
        System.out.printf("Cantidad de bolas extraídas: %s%n", bombo2.getCantidadBolasExtraidas());
        System.out.printf("Bolas restantes: %s%n", bombo2.getBolasRestantes());
        System.out.printf("Cantidad de bolas restantes: %s%n\n", bombo2.getCantidadBolasRestantes());

    }

}
