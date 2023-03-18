package tarea03;

// Aquí tendrás que incluir los "import" que necesites
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

/**
 * Ejercicio 3: Contador de domingos.
 *
 * @author Andres Samuel Podadera Gonzalez
 */
public class Ejercicio03 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes

        // Variables de entrada
        int anyo = 0;

        // Variables de salida
        int cantidadDomingosEnAnyo;
        int cantidadDomingosEnMes;

        // Variables auxiliares
        boolean entradaValida = false;
        int dia;
        int mes;
        LocalDate primerDiaDelMes;

        // Objeto Scanner para lectura desde teclado
        Scanner teclado = new Scanner(System.in);

        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("CONTADOR DE DOMINGOS");
        System.out.println("--------------------");

        // 1.- Leer y comprobar el año (entre 1900 y 2100), ambos incluidos
        do {
            System.out.println("Introduzca año (1900-2100)");
            try {
                anyo = teclado.nextInt();
                if (1900 <= anyo && anyo <= 2100) {
                    entradaValida = true;
                }
            } catch (InputMismatchException ex) {
                System.err.println("Error de lectura: no es un número entero válido.");
                teclado.nextLine(); //limpiar el buffer de entrada de datos del teclado para que no entre en bucle infinito
            }
        } while (!entradaValida);

        //----------------------------------------------
        //    Procesamiento + Salida de resultados  
        //----------------------------------------------
        System.out.printf("\nCANTIDAD DE DOMINGOS DEL AÑO %d%n", anyo);
        System.out.println("---------------------------------");
        
        // Iniciamos acumuladores
        cantidadDomingosEnAnyo = 0;

        // 2.- Recorremos todos los meses del año (bucle)
     
        for (mes = 1; mes <= 12; mes++) {
            cantidadDomingosEnMes = 0; //Cada vez que empiezo a comprobar un mes diferente reinicio a 0 el contador
            primerDiaDelMes = LocalDate.of(anyo, mes, 1); //asigno valor a la variable que usaré para determinar en que mes me encuentro
            // 2.1.- Para cada mes, recorremos cada una de las fechas que contiene y contamos cuántas hay que sean domingo
            for (dia = 1; dia <= primerDiaDelMes.lengthOfMonth(); dia++) {
                if (LocalDate.of(anyo, mes, dia).getDayOfWeek() == LocalDate.of(anyo, mes, dia).getDayOfWeek().SUNDAY) {
                    // 2.3.- Incrementamos el cómputo global de domingos para el año
                    cantidadDomingosEnMes++;
                }
            }
            
            // 2.2.- Mostramos por pantalla la cantidad de domingos del mes (una línea por mes)
            System.out.printf("%-10s : %d%n", primerDiaDelMes.getMonth().getDisplayName(TextStyle.FULL, new Locale("es", "ES")), cantidadDomingosEnMes);
            cantidadDomingosEnAnyo += cantidadDomingosEnMes;
        }

        // 3.- Mostramos por pantalla la cantidad de domingos totales
        System.out.printf("Número total de domingos: %d.%n", cantidadDomingosEnAnyo);

    }

}
