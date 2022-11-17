package tarea02;

import java.util.Scanner;

/**
 * Ejercicio 2. Análisis de hora.
 *
 * @author Andrés Samuel Podadera González
 */
public class Ejercicio02 {

    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de constantes 
        //----------------------------------------------
        final int SEGUNDOS_EN_UN_DIA = 86400; // 24 horas * 60 minutos * 60 segundos
        final int SEGUNDOS_EN_UNA_HORA = 3600; // 1 hora * 60 minutos * 60 segundos
        final int SEGUNDOS_EN_UN_MINUTO = 60; // 1 minuto * 60 segundos

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Variables de entrada
        int horas, minutos, segundos;

        // Variables de salida
        String mensaje;

        // Variables Auxiliares
        boolean horaValida;
        int segundosTranscurridos;
        int segundosRestantesParaMediodia;
        int segundosRestantesParaMedianoche;

        // Clase Scanner para petición de datos de entrada
        Scanner teclado = new Scanner(System.in);

        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("ANÁLISIS DE LA HORA");
        System.out.println("-------------------");

        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        // 0. Solicitamos las horas, los minutos y los segundos
        System.out.print("Introduce la hora: ");
        horas = teclado.nextInt();
        System.out.print("Introduce los minutos: ");
        minutos = teclado.nextInt();
        System.out.print("Introduce los segundos: ");
        segundos = teclado.nextInt();
        // 1. Calculamos si la hora completa (hora, minuto, segundo) es válida
        horaValida = (horas >= 0 && horas <= 23) && (minutos >= 0 && minutos <= 59) && (segundos >= 0 && segundos <= 59);
        if (horaValida) {
            // 2. Solamente si la hora es válida, llevamos a cabo los cálculos
            segundosTranscurridos = horas * SEGUNDOS_EN_UNA_HORA + minutos * SEGUNDOS_EN_UN_MINUTO + segundos;
            segundosRestantesParaMediodia = SEGUNDOS_EN_UN_DIA / 2 - segundosTranscurridos;
            segundosRestantesParaMedianoche = SEGUNDOS_EN_UN_DIA - segundosTranscurridos;
            // 2.1. Comprobamos si es medianoche
            if (segundosTranscurridos == 0) {
                mensaje = "Es medianoche.\nFalta para mediodía: " + segundosRestantesParaMediodia + " segundos.\nFalta para medianoche: 0 segundos.";
                // 2.2. Comprobamos si es mediodía
            } else if (segundosTranscurridos == 43200) {
                mensaje = "Es mediodía.\nFalta para mediodía: 0 segundos.\nFalta para medianoche: " + segundosRestantesParaMedianoche + " segundos.";
                // 2.3. Si es antes de mediodía, calculamos el tiempo hasta mediodía (en segundos)
            } else if (segundosTranscurridos < 43200) {
                mensaje = "Falta para mediodía: " + segundosRestantesParaMediodia + " segundos.\nFalta para medianoche: " + segundosRestantesParaMedianoche + " segundos.";
                // 2.4 Si es antes de medianoche, calculamos el tiempo hasta medianoche (en segundos)
            } else {
                mensaje = "Falta para mediodía: 0 segundos.\nFalta para medianoche: " + segundosRestantesParaMedianoche + " segundos.";
            }
        } else {
            mensaje = "La hora introducida no es válida";
        }

        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println();
        System.out.println("RESULTADO");
        System.out.println("---------");
        // 3. Solo mostramos los resultados si la hora era válida
        System.out.println(mensaje);
    }
}
