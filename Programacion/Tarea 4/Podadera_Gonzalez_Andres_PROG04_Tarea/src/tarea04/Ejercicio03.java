package tarea04;

import java.util.Scanner;

/**
 * Ejercicio 3. Cifras gigantes.
 *
 * @author Andres Podadera Gonzalez
 */
public class Ejercicio03 {

    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Variables de entrada
        String numeroSolicitado = "";
        
        // Variables de salida
        String plantillaResultado[][];

        // Variables auxiliares
        // 1. Declaramos el array con los modelos ASCII de las cifras
        String[][] plantillaNumeros = {
            {"   ###   ", "   #   ", "  #####  ", "  #####  ", " #       ", " ####### ", "  #####  ", " ####### ", "  #####  ", "  #####  "},
            {"  #   #  ", "  ##   ", " #     # ", " #     # ", " #    #  ", " #       ", " #     # ", " #    #  ", " #     # ", " #     # "},
            {" #     # ", " # #   ", "       # ", "       # ", " #    #  ", " #       ", " #       ", "     #   ", " #     # ", " #     # "},
            {" #     # ", "   #   ", "  #####  ", "  #####  ", " #    #  ", " ######  ", " ######  ", "    #    ", "  #####  ", "  ###### "},
            {" #     # ", "   #   ", " #       ", "       # ", " ####### ", "       # ", " #     # ", "   #     ", " #     # ", "       # "},
            {"  #   #  ", "   #   ", " #       ", " #     # ", "      #  ", " #     # ", " #     # ", "   #     ", " #     # ", " #     # "},
            {"   ###   ", " ##### ", " ####### ", "  #####  ", "      #  ", "  #####  ", "  #####  ", "   #     ", "  #####  ", "  #####  "}
        };

        int numeroADibujar; //Aquí guardaré temporalmente cada uno de los numeros que hay que dibujar
        boolean numeroValido = false; //Guardaré la condicion que verifique que un numero introdudico por el usuario es valido
        
        // Clase Scanner para petición de datos de entrada
        Scanner teclado = new Scanner(System.in);

        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("CIFRAS GIGANTES");
        System.out.println("---------------");
        
        // 2. Solicitamos un número entero no negativo de como máximo diez cifras
        do {
            System.out.print("Introduzca número entero no negativo de como máximo diez cifras: ");
            numeroSolicitado = teclado.nextLine();
            numeroValido |= numeroSolicitado.matches("[0-9]{1,10}"); //uso una concatenacíon de expresiones lógicas para validar si el numero introducido "encaja"
        } while (!numeroValido);

        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        // 3. Generamos el resultado final
        // 3.1. Declaramos un array de cadenas para almacenar temporalmente cada nivel del texto final
        plantillaResultado = new String[7][plantillaNumeros.length];

        // 3.2. Recorremos cada nivel del array de patrones
        for (int i = 0; i < plantillaNumeros.length; i++) {
            // 3.2.1. Inicializamos la cadena que contendrá el nivel del texto final
            plantillaResultado[i][0] = "";

            // 3.3. Una vez rellenados todos los niveles del array temporal, recorremos ese array 
            for (int j = 0; j < numeroSolicitado.length(); j++) {

                numeroADibujar = Integer.parseInt(numeroSolicitado.substring(j, j + 1)); //Hago una conversion de String a entero para determinar que numero dibujar

                // 3.3.1. Vamos concatenando en una única variable final todos los niveles, separándolos por medio de un avance de línea ('\n')
                plantillaResultado[i][0] += plantillaNumeros[i][numeroADibujar];
            }
            plantillaResultado[i][0] += "\n";
        }

        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println();
        System.out.println("RESULTADO");
        System.out.println("---------");
        // 4. Mostramos por pantalla un único String que contiene el número "gigante"
        for (int i = 0; i < plantillaResultado.length; i++) {
            System.out.print(plantillaResultado[i][0]);
        }
    }
}
