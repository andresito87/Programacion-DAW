/*Escribe un programa en Java que solicite una hora en formato 24 horas mediante la petición de tres números enteros: la hora, el minuto y el segundo. A continuación debe calcular cuál será el siguiente instante (segundo) de esa hora. Suponemos que se van a introducir horas válidas y no hay que realizar ninguna verificación de validez.
Para ello habrás de tener en cuenta que tras el segundo 59 se debe pasar de nuevo al segundo 0 e incrementar en uno los minutos, y algo similar para los minutos (de 59 a 0) y para las horas (de 23 a 0). Es decir, que tras el instante 15:30:59 vendrá el instante 15:31:00, o que tras el instante 23:59:59 vendrá el instante 00:00:00.
Para llevar a cabo estos cálculos te vendrán muy bien los operadores:
1.-división entera (cociente de la división entera), para obtener el posible acarreo que habría que traspasar desde los segundos hacia los minutos o desde los minutos hacia las horas;
2.-módulo (resto de la división entera), para garantizar que no vamos a superar el rango permitido (máximo 59 para segundos o minutos, o 23 para horas). */

import java.util.Scanner;

public class Ejercicio1_5 {
    public static void main(String[] args) {

        // Declaración de variables
        int hora, minuto, segundo;
        int horaSiguiente, minutoSiguiente, segundoSiguiente;
        Scanner sc = new Scanner(System.in);

        // Solicitud de datos
        System.out.println();
        System.out.println("SIGUIENTE SEGUNDO DE UNA HORA");
        System.out.println("----------------------");
        System.out.print("Introduce la hora (0-23): ");
        hora = sc.nextInt();
        System.out.print("Introduce los minutos (0-59): ");
        minuto = sc.nextInt();
        System.out.print("Introduce los segundos (0-59): ");
        segundo = sc.nextInt();
        sc.close();
        System.out.println();

        // Procesamiento de datos
        segundoSiguiente = (segundo + 1) % 60;
        minutoSiguiente = (minuto + (segundo + 1) / 60) % 60;
        horaSiguiente = (hora + (minuto + (segundo + 1) / 60) / 60) % 24;

        // Mostrar resultados
        System.out.println("RESULTADO");
        System.out.println("----------------------");
        System.out.println("Siguiente hora:" + horaSiguiente);
        System.out.println("Siguiente minuto:" + minutoSiguiente);
        System.out.println("Siguiente segundo:" + segundoSiguiente);
    }
}