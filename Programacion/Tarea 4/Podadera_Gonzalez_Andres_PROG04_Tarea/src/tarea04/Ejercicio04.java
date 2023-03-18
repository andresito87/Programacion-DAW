package tarea04;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Ejercicio 4. Tabla de días de la semana por mes: cantidad.
 *
 * @author Andres Podadera Gonzalez
 */
public class Ejercicio04 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        final String[] MESES = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};

        // Variables de entrada
        int anyoSolicitado = 0;

        // Variables de salida
        // 1. Declaramos la tabla para almacenar el resultado (array de int de tamaño 12x7)
        int[][] resultados = new int[12][7];

        // Variables auxiliares
        boolean anyoValido = false;
        int dia;
        int mes;
        LocalDate primerDiaDelMes;
        
        // Objeto Scanner para lectura desde teclado
        Scanner teclado = new Scanner(System.in);

        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("NÚMERO DE DÍAS DE LA SEMANA POR MES");
        System.out.println("-----------------------------------");

        // 2. Solicitamos por teclado el año
        // Leer y comprobar el año (1900 y 2023), ambos incluidos
        do {
            try {
                System.out.print("Introduzca año(1900-2100): ");
                anyoSolicitado = teclado.nextInt();
                if (anyoSolicitado >= 1900 && anyoSolicitado <= 2100) {
                    anyoValido = true;
                }
            } catch (InputMismatchException ex) {
                System.out.println("Error de lectura: no es un número entero válido.");
                teclado.nextLine();
            }
        } while (!anyoValido);

        //----------------------------------------------
        //               Procesamiento
        //----------------------------------------------
        // 3. Recorremos todos los días del año (bucle) y calculamos cuántos días de semana (L,M,X, etc.) hay por mes
        for (mes = 1; mes <= 12; mes++) {
            primerDiaDelMes = LocalDate.of(anyoSolicitado, mes, 1); //asigno valor a la variable que usaré para determinar en que mes me encuentro
            for (dia = 1; dia <= primerDiaDelMes.lengthOfMonth(); dia++) {
                switch (LocalDate.of(anyoSolicitado, mes, dia).getDayOfWeek()) {
                    case MONDAY:
                        resultados[mes - 1][0]++;
                        break;
                    case TUESDAY:
                        resultados[mes - 1][1]++;
                        break;
                    case WEDNESDAY:
                        resultados[mes - 1][2]++;
                        break;
                    case THURSDAY:
                        resultados[mes - 1][3]++;
                        break;
                    case FRIDAY:
                        resultados[mes - 1][4]++;
                        break;
                    case SATURDAY:
                        resultados[mes - 1][5]++;
                        break;
                    case SUNDAY:
                        resultados[mes - 1][6]++;
                        break;
                }
            }
        }

        //----------------------------------------------
        //            Salida de resultados  
        //----------------------------------------------
        System.out.println();
        System.out.printf("RESULTADO: AÑO %d\n", anyoSolicitado);
        System.out.println();
        // 4. Mostramos el contenido de la tabla resultado de manera tabulada
        // 4.1. Cabecera de la tabla

        System.out.printf("             L   M   X   J   V   S   D\n");

        // 4.2. Filas repetitivas (una por mes)
        for (int i = 0; i < resultados.length; i++) {
            System.out.printf("%10s", MESES[i]);

            // 4.2.1. Columnas repetititvas (una por día de la semana)
            for (int j = 0; j < resultados[i].length; j++) {
                System.out.printf("%4d", resultados[i][j]);
            }
            System.out.println();
        }
    }
}
