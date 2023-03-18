/*Escribe un programa en Java que solicite una hora en formato 24 horas mediante la petición de tres números enteros: la hora, el minuto y el segundo, y los analice para comprobar si esa hora es válida.
Para ello tendrás que utilizar operadores relacionales tales como menor o igual (<=) o mayor o igual (>=), junto con operadores lógicos como AND (&&), OR (||), etc. Ten en cuenta que el resultado de la aplicación de estos operadores es un valor de tipo boolean, es decir, un valor que será true o false. */

import java.util.Scanner;

public class Ejercicio1_3 {
    public static void main(String[] args) {

        // Declaración de variables
        int hora, minuto, segundo;
        boolean esHoraValida;
        Scanner sc = new Scanner(System.in);

        // Solicitud de datos
        System.out.println();
        System.out.println("COMPROBACIÓN DE HORA");
        System.out.println("----------------------");
        System.out.print("Introduce la hora: ");
        hora = sc.nextInt();
        System.out.print("Introduce los minutos: ");
        minuto = sc.nextInt();
        System.out.print("Introduce los segundos: ");
        segundo = sc.nextInt();
        sc.close();
        System.out.println();

        // Procesamiento de datos
        esHoraValida = hora >= 0
                && hora <= 23
                && minuto >= 0
                && minuto <= 59
                && segundo >= 0
                && segundo <= 59;

        // Mostrar resultados
        System.out.println("RESULTADO");
        System.out.println("----------------------");
        System.out.println("La hora introducida es válida: " + esHoraValida);
    }
}