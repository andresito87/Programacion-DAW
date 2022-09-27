/*Escribe un programa en Java que lea de teclado un texto y lo analice averiguando lo siguiente:
1.-si el texto contiene entre cinco y diez caracteres,
2.-si el texto comienza con una letra,
3.-si el texto termina con un punto ('.'), coma (',') o punto y coma (';'),
4.-si el texto finaliza con la palabra "fin" (en minúsculas). */

import java.util.Scanner;

public class Ejercicio1_6 {
    public static void main(String[] args) {

        // Declaración de variables
        String texto;
        char primeraLetra;
        boolean longitudEntre5y10, comienzaConLetra, terminaConPuntoComaComa, terminaConFin;
        Scanner sc = new Scanner(System.in);

        // Solicitud de datos
        System.out.println();
        System.out.println("ANÁLISIS DE UN TEXTO");
        System.out.println("----------------------");
        System.out.print("Introduzca un texto: ");
        texto = sc.nextLine();
        sc.close();
        System.out.println();

        // Procesamiento de datos
        primeraLetra = texto.toLowerCase().charAt(0); // Pasamos el texto a minúsculas y obtenemos la primera letra
        longitudEntre5y10 = texto.length() >= 5
                && texto.length() <= 10; // Comprobamos si el texto tiene entre 5 y 10 caracteres
        comienzaConLetra = primeraLetra >= 'a' && primeraLetra <= 'z'; // Comprobamos si la primera letra es una letra
        terminaConPuntoComaComa = texto.endsWith(".")
                || texto.endsWith(",")
                || texto.endsWith(";"); // Comprobamos si el texto termina con un punto, coma o punto y coma
        terminaConFin = texto.endsWith("fin"); // Comprobamos si el texto termina con la palabra "fin"

        // Mostrar resultados
        System.out.println("RESULTADO");
        System.out.println("----------------------");
        System.out.println("El texto contiene entre 5 y 10 caracteres: " + longitudEntre5y10);
        System.out.println("El texto comienza con una letra: " + comienzaConLetra);
        System.out.println("El texto termina con un punto, coma o punto y coma: " + terminaConPuntoComaComa);
        System.out.println("El texto termina con la palabra \"fin\": " + terminaConFin);

    }
}