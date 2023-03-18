package tarea02;

import java.util.Scanner;
import libtarea2.Utilidades;

/**
 * Ejercicio 5. Validación de PIN.
 *
 * @author Andrés Samuel Podadera González
 */
public class Ejercicio05 {

    public static void main(String[] args) {
        //----------------------------------------------
        //          Declaración de variables
        //----------------------------------------------

        // Variables de entrada
        char numeroEnPosicionSolicitada1, numeroEnPosicionSolicitada2;

        // Variables de salida
        String pinDesenmascarado;

        // Variables auxiliares
        String pin;
        int posicionAleatoria1;
        int posicionAleatoria2;
        String pinEnmascarado;
        byte intentos;
        int contador;
        boolean esCorrecto;

        // Clase Scanner para petición de datos de entrada
        Scanner teclado = new Scanner(System.in);

        //----------------------------------------------
        //        Entrada de datos + Procesamiento
        //----------------------------------------------
        System.out.println("VALIDACIÓN DE PIN");
        System.out.println("-----------------");

        // 1. Creamos el PIN de seis dígitos
        pin = Utilidades.generaPin();
        System.out.println("Creando un número de identificación personal de seis dígitos: " + pin);

        // 2. Generamos aleatoriamente dos posiciones aleatorias y diferentes entre la 1 y la 6
        // 2.1. Generamos primer número
        posicionAleatoria1 = Utilidades.numAleatorio(1, 6) - 1; //resto 1 para trabajar empezando en 0, el usuario si empieza en 1
        // 2.2. Generamos segundo número garantizando que va a ser diferente al primero
        do {
            posicionAleatoria2 = Utilidades.numAleatorio(1, 6) - 1;////resto 1 para trabajar empezando en 0, el usuario si empieza en 1
        } while (posicionAleatoria1 == posicionAleatoria2);
        // 2.3. Si el primer número es superior al segundo, los intercambiamos

        if (posicionAleatoria1 > posicionAleatoria2) {
            int aux = posicionAleatoria1;
            posicionAleatoria1 = posicionAleatoria2;
            posicionAleatoria2 = aux;
        }
        // 3. Creamos el String con el PIN "enmascarado"
        pinEnmascarado = "";
        contador = 0;
        while (contador < 6) {
            if (contador == posicionAleatoria1 || contador == posicionAleatoria2) {
                pinEnmascarado += "_";
            } else {
                pinEnmascarado += "*";
            }
            contador++;
        }
        // 4. Mostramos el PIN enmascarado por pantalla e indicamos las posiciones que se deben introducir
        System.out.println("Para acceder al sistema debe introducir el contenido de las posiciones " + (posicionAleatoria1 + 1) + " y " + (posicionAleatoria2 + 1) + " de su PIN:");
        System.out.println(pinEnmascarado);

        // 5. Solicitamos esas posiciones al usuario y se lleva a cabo la comprobación (tres intentos como máximo)
        intentos = 0;
        esCorrecto = false;
        do {
            // 5.1. Solicitamos la primera posición
            System.out.println("Introduzca contenido de la posición " + (posicionAleatoria1 + 1) + " del PIN:");
            numeroEnPosicionSolicitada1 = teclado.nextLine().charAt(0);
            // 5.2. Solicitamos la segunda posición
            System.out.println("Introduzca contenido de la posición " + (posicionAleatoria2 + 1) + " del PIN:");
            numeroEnPosicionSolicitada2 = teclado.nextLine().charAt(0);
            // 5.3. Comprobamos si lo introducido por el usuario es correcto (esos valores coinciden con los contenidos de las posiciones del PIN solicitadas)
            if (numeroEnPosicionSolicitada1 == pin.charAt(posicionAleatoria1) && numeroEnPosicionSolicitada2 == pin.charAt(posicionAleatoria2)) {
                esCorrecto = true;
            } else {
                System.out.println("PIN incorrecto.");
                intentos++;
            }
        } while (intentos < 3 && !esCorrecto);

        //----------------------------------------------
        //           Salida de Resultados
        //----------------------------------------------
        System.out.println();
        System.out.println("RESULTADO");
        System.out.println("---------");
        // 6. Mostramos un resultado
        if (esCorrecto) {

            // 6.1. Si el PIN es válido: Creamos el String con el PIN "enmascarado" desenmascarando la dos posiciones solicitadas e indicando el éxito
            pinDesenmascarado = "";
            for (int i = 0; i < 6; i++) {
                if (i == posicionAleatoria1) {
                    pinDesenmascarado += pin.charAt(i);
                } else if (i == posicionAleatoria2) {
                    pinDesenmascarado += pin.charAt(i);
                } else {
                    pinDesenmascarado += "*";
                }
            }
            System.out.println("PIN correcto: " + pinDesenmascarado + "\nEntrando en el sistema...");

            // 6.2. Si el PIN no es válido: Se indica que no se ha logrado introducir un PIN correcto y que el sistema se bloqueará
        } else {
            System.out.println("Ha introducido tres veces un PIN incorrecto. Sistema bloqueado.");
        }

    }
}
