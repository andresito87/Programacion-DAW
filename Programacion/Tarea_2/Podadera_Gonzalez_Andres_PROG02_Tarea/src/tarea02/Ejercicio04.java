package tarea02;

import java.util.Scanner;

/**
 * Ejercicio 4. Entrada de fechas válidas.
 *
 * @author Andrés Samuel Podadera González
 */
public class Ejercicio04 {

    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Variables de entrada
        int dia, mes, anyo;

        // Variables auxiliares
        int diaMaximoDelMes;
        boolean esAnyoBisiesto;
        
        // Clase Scanner para petición de datos
        Scanner teclado = new Scanner(System.in);

        //----------------------------------------------
        //       Entrada de datos + Procesamiento
        //----------------------------------------------
        // Según se van introduciendo datos se van procesando
        System.out.println("ENTRADA DE FECHAS VÁLIDAS");
        System.out.println("-------------------------");

        // 1. Solicitamos el año y lo seguimos solicitando hasta que sea válido
        do {
            System.out.println("Introduce año(1900-2100):");
            anyo = teclado.nextInt();
        } while (1900 > anyo || anyo > 2100);

         // 2. Solicitamos el mes y lo seguimos solicitando hasta que sea válido
        do {
            System.out.println("Introduce mes(1-12):");
            mes = teclado.nextInt();
        } while (1 > mes || mes > 12);
        
        // 3. Calculamos el máximo día posible para ese mes de ese año
         switch (mes) {
                case 4:
                case 6:
                case 9:
                case 11:
                    diaMaximoDelMes=30;
                    break;
                case 2:
                    esAnyoBisiesto = (anyo % 4 == 0 && anyo % 100 != 0) || anyo % 400 == 0;
                    if(esAnyoBisiesto){
                        diaMaximoDelMes=29;
                    }else{
                        diaMaximoDelMes=28;
                    }
                    
                    break;
                default:
                    diaMaximoDelMes=31;
                }

        // 4. Solicitamos el día y lo seguimos solicitando hasta que sea válido
        do {
            System.out.println("Introduzca día(1-31):");
            dia = teclado.nextInt();
        } while (1 > dia || dia > diaMaximoDelMes);
        
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        // Si se llega hasta aquí es porque la fecha es correcta
        System.out.println();
        System.out.println("RESULTADO");
        System.out.println("---------");
        System.out.println("La fecha es correcta.");
    }
}
