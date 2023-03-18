/*Escribe un programa en Java que solicite dos números reales y lleve a cabo los siguientes cálculos:
1.-tres cuartos del primer número,
2.-cuadrado de la semisuma de los dos números,
3.-cuádruple de la diferencia entre ambos números,
4.-mitad del cuadrado de la suma por la diferencia de ambos números. */

import java.util.Locale;
import java.util.Scanner;

public class Ejercicio1_2 {

    public static void main(String[] args) {

        // Declaración de variables
        double num1, num2, tresCuartos, cuadradoSemiSuma, cuadrupleDiferencia, mitadCuadradoSumaDiferencia;
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US); // Para que el s decimal sea el punto y no la coma

        // Solicitud de datos
        System.out.println();
        System.out.println("CÁLCULOS ARITMÉTICOS");
        System.out.println("----------------------");
        System.out.print("Introduce el primer número: ");
        num1 = sc.nextDouble();
        System.out.print("Introduce el segundo número: ");
        num2 = sc.nextDouble();
        sc.close();
        System.out.println();

        // Procesamiento de datos
        tresCuartos = num1 * 0.75;
        cuadradoSemiSuma = Math.pow((num1 + num2) / 2, 2);
        cuadrupleDiferencia = (num1 - num2) * 4;
        mitadCuadradoSumaDiferencia = Math.pow((num1 + num2) * (num1 - num2), 2) / 2;

        // Mostrar resultados
        System.out.println("RESULTADO");
        System.out.println("----------------------");
        System.out.println("Tres cuartos del primer número: " + tresCuartos);
        System.out.println("Cuadrado de la semisuma de los dos números: " + cuadradoSemiSuma);
        System.out
                .println("Cuádruple de la diferencia entre ambos números: " + cuadrupleDiferencia);
        System.out.println("Mitad del cuadrado de la suma por la diferencia de ambos números: "
                + mitadCuadradoSumaDiferencia);
    }

}