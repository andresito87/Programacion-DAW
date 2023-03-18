package tarea02;

import java.util.Scanner;

/**
 * Ejercicio 3. Validación de una fecha.
 *
 * @author Andrés Samuel Podadera González
 */
public class Ejercicio03 {

    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Variables de entrada
        int dia, mes, anyo;

        // Variables de salida
        String mensaje;

        // Variables auxiliares
        boolean esAnyoBisiesto;
        boolean esFechaValida;

        // Clase Scanner para petición de datos de entrada
        Scanner teclado = new Scanner(System.in);

        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("VALIDACIÓN DE UNA FECHA");
        System.out.println("-----------------------");
        System.out.println("Introduzca día(1-31):");
        dia = teclado.nextInt();
        System.out.println("Introduce mes(1-12):");
        mes = teclado.nextInt();
        System.out.println("Introduce año(1900-2100)");
        anyo = teclado.nextInt();

        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        // 1. Calculamos si la fecha es "viable" (día, mes y año en sus rangos máximos y mínimos)
        esAnyoBisiesto = (anyo % 4 == 0 && anyo % 100 != 0) || anyo % 400 == 0;
        esFechaValida = dia > 0 && dia <= 31 && mes > 0 && mes <= 12 && anyo >= 1900 && anyo <= 2100;
        if (esFechaValida) {
           // 2. Si la fecha es "viable" comenzamos el análisis más "fino" (días según el mes)
            switch (mes) {
                // 2.1. Para el caso abril, junio, septiembre o noviembre, el máximo son 30 días
                case 4:
                case 6:
                case 9:
                case 11:
                    if (dia > 30) {
                        mensaje = "La fecha no es válida";
                    } else {
                        mensaje = "La fecha es válida";
                    }
                    break;
                // 2.2 Para el caso de febrero calculamos primero si el año es bisiesto  
                case 2:
                    // 2.2.1. Si es bisiesto el máximo serán 29 días
                    if (esAnyoBisiesto && dia <= 29) {
                        mensaje = "La fecha es válida";
                        // 2.2.2. Si no lo es, el máximo será 28
                    } else if (!esAnyoBisiesto && dia <= 28) {
                        mensaje = "La fecha es válida";
                    } else{
                        mensaje = "La fecha no es válida";
                    }
                    break;
                default:
                    mensaje = "La fecha es válida";
                }
        } else {
              mensaje = "La fecha no es válida";
            }
            //----------------------------------------------
            //              Salida de resultados 
            //----------------------------------------------
            System.out.println();
            System.out.println("RESULTADO");
            System.out.println("---------");
            System.out.println(mensaje);
        }
    
}
