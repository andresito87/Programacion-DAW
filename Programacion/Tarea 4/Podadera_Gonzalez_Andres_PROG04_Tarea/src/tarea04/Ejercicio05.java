package tarea04;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Ejercicio 5. Tabla de días de la semana por mes: lista de días.
 *
 * @author Andres Podadera Gonzalez
 */
public class Ejercicio05 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /**
         * @param args the command line arguments
         */
        //----------------------------------------------
        //          Declaración de variables
        //----------------------------------------------
        // Constantes
        final String[] MESES = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};

        // Variables de entrada
        int anyoSolicitado = 0;

        // Variables de salida
        // 1. Declaramos la tabla para almacenar el resultado (array de int de tamaño 12x7x?)
        int[][][] resultados = new int[12][7][];

        // Variables auxiliares
        boolean anyoValido = false;
        int dia;
        int mes;
        LocalDate primerDiaDelMes;
        int cantidadLunes;
        int cantidadMartes;
        int cantidadMiercoles;
        int cantidadJueves;
        int cantidadViernes;
        int cantidadSabado;
        int cantidadDomingo;

        // Objeto Scanner para lectura desde teclado
        Scanner teclado = new Scanner(System.in);

        //----------------------------------------------
        //                Entrada de datos
        //----------------------------------------------
        System.out.println("LISTA DE DÍAS DE LA SEMANA POR MES");
        System.out.println("----------------------------------");

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
            cantidadLunes = 0;
            cantidadMartes = 0;
            cantidadMiercoles = 0;
            cantidadJueves = 0;
            cantidadViernes = 0;
            cantidadSabado = 0;
            cantidadDomingo = 0;
            for (dia = 1; dia <= primerDiaDelMes.lengthOfMonth(); dia++) {
                String diaActual = LocalDate.of(anyoSolicitado, mes, dia).getDayOfWeek().toString();
                switch (diaActual) {
                    case "MONDAY":
                        cantidadLunes++;
                        break;
                    case "TUESDAY":
                        cantidadMartes++;
                        break;
                    case "WEDNESDAY":
                        cantidadMiercoles++;
                        break;
                    case "THURSDAY":
                        cantidadJueves++;
                        break;
                    case "FRIDAY":
                        cantidadViernes++;
                        break;
                    case "SATURDAY":
                        cantidadSabado++;
                        break;
                    case "SUNDAY":
                        cantidadDomingo++;
                        break;
                }
            }
            // 4. Recorremos todas las celdas de la tabla resultado hasta la segunda dimensión (bucles) para reservar espacio para el subarray de los días de mes (4 o 5)
            resultados[mes - 1][0] = new int[cantidadLunes];
            resultados[mes - 1][1] = new int[cantidadMartes];
            resultados[mes - 1][2] = new int[cantidadMiercoles];
            resultados[mes - 1][3] = new int[cantidadJueves];
            resultados[mes - 1][4] = new int[cantidadViernes];
            resultados[mes - 1][5] = new int[cantidadSabado];
            resultados[mes - 1][6] = new int[cantidadDomingo];
        }

        // 5. Volvemos a recorrer todos los días del año (bucle) y colocamos cada día en su lista correspondiente (mes, diaSemana)
        for (mes = 1; mes <= 12; mes++) {
            primerDiaDelMes = LocalDate.of(anyoSolicitado, mes, 1); //asigno valor a la variable que usaré para determinar en que mes me encuentro
            int contadorLunes = 0;
            int contadorMartes = 0;
            int contadorMiercoles = 0;
            int contadorJueves = 0;
            int contadorViernes = 0;
            int contadorSabado = 0;
            int contadorDomingo = 0;
            for (dia = 1; dia <= primerDiaDelMes.lengthOfMonth(); dia++) {
                String diaActual = LocalDate.of(anyoSolicitado, mes, dia).getDayOfWeek().toString();
                switch (diaActual) {
                    case "MONDAY":
                        resultados[mes - 1][0][contadorLunes] = dia;
                        contadorLunes++;
                        break;
                    case "TUESDAY":
                        resultados[mes - 1][1][contadorMartes] = dia;
                        contadorMartes++;
                        break;
                    case "WEDNESDAY":
                        resultados[mes - 1][2][contadorMiercoles] = dia;
                        contadorMiercoles++;
                        break;
                    case "THURSDAY":
                        resultados[mes - 1][3][contadorJueves] = dia;
                        contadorJueves++;
                        break;
                    case "FRIDAY":
                        resultados[mes - 1][4][contadorViernes] = dia;
                        contadorViernes++;
                        break;
                    case "SATURDAY":
                        resultados[mes - 1][5][contadorSabado] = dia;
                        contadorSabado++;
                        break;
                    case "SUNDAY":
                        resultados[mes - 1][6][contadorDomingo] = dia;
                        contadorDomingo++;
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
        // 6. Mostramos el contenido de la tabla resultado de manera tabulada
        // 6.1. Cabecera de la tabla
        String separacion = " ".repeat(20);
        String margen = " ".repeat(19);
        String cabeceraDiasSemana = String.format("%1$sL%2$sM%2$sX%2$sJ%2$sV%2$sS%2$sD",
                margen, separacion);
        System.out.printf("%33s\n", cabeceraDiasSemana);

        // 6.2. Filas repetitivas (una por mes)
        for (mes = 1; mes <= 12; mes++) {
            System.out.printf("%10s  ", MESES[mes - 1]);

            // 6.2.1. Columnas repetititvas (una por día de la semana)
            for (dia = 1; dia <= 7; dia++) {
                System.out.printf("%-21s", Arrays.toString(resultados[mes - 1][dia - 1]));
            }
            System.out.printf("%n");
        }
    }
}
