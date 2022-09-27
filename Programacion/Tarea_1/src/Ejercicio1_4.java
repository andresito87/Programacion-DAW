/*Se nos pide escribir un programa en Java que supervise los trasvases de agua desde un primer depósito que contiene inicialmente 40.0 litros hacia otro depósito que contiene inicialmente 20.0 litros. Esta información debe ser almacenada en un programa mediante constantes y se mostrará al inicio de su ejecución.
El programa solicitará por teclado la el porcentaje de la cantidad actual del primer depósito que se desea trasvasar hacia el segundo depósito y a continuación calcule y muestre por pantalla 
1.-los litros que van a ser trasvasados;
2.-el nivel del primer depósito (en litros) tras el trasvase;
3.-el nivel del segundo depósito (en litros) tras el trasvase.*/

import java.util.Scanner;

public class Ejercicio1_4 {
    public static void main(String[] args) {

        // Declaración de variables
        final double CAPACIDAD_DEPOSITO1 = 40.0;
        final double CAPACIDAD_DEPOSITO2 = 20.0;
        double porcentajeTrasvasar, litrosTrasvasar, nivelDeposito1, nivelDeposito2;
        Scanner sc = new Scanner(System.in);

        // Solicitud de datos
        System.out.println();
        System.out.println("TRASVASE DE DEPOSITOS");
        System.out.println("----------------------");
        System.out.println("Nivel inicial del depósito 1: " + CAPACIDAD_DEPOSITO1 + " litros");
        System.out.println("Nivel inicial del depósito 2: " + CAPACIDAD_DEPOSITO2 + " litros");
        System.out.print(
                "Introduce el porcentaje de trasvase de liquido de un déposito a otro: ");
        porcentajeTrasvasar = sc.nextDouble();
        sc.close();
        System.out.println();

        // Procesamiento de datos
        litrosTrasvasar = CAPACIDAD_DEPOSITO1 * porcentajeTrasvasar / 100;
        nivelDeposito1 = CAPACIDAD_DEPOSITO1 - litrosTrasvasar;
        nivelDeposito2 = CAPACIDAD_DEPOSITO2 + litrosTrasvasar;

        // Mostrar resultados
        System.out.println("RESULTADO");
        System.out.println("----------------------");
        System.out.println("Porcentaje extraido en el trasvase: " + porcentajeTrasvasar + "%");
        System.out.println("Litros trasvasados: " + litrosTrasvasar);
        System.out.println("Nivel del primer depósito (en litros) tras el trasvase: " + nivelDeposito1);
        System.out.println("Nivel del segundo depósito (en litros) tras el trasvase: " + nivelDeposito2);
    }
}