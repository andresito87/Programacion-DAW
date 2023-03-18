package tarea04;

/**
 * Ejercicio 1. Ofuscación de contraseñas.
 *
 * @author Andres Podadera Gonzalez
 */
public class Ejercicio01 {

    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        // Variables de entrada
        // 1. Declaramos el array de contraseñas de entrada
        String[] contrasenas = new String[]{"Paella", "Vampiro", "CASANDRA", "DOdo", "GABOSVE", "HIPOlito", "AEGYPTOS", "ISISisis"};

        // Variables de salida
        // 2. Declaramos el array de resultados para rellenarlo con las contraseñas ofuscadas 
        String[] contrasenasOfuscadas;

        // Variables auxiliares
        //De esta forma, no veo necesidad de declarar ninguna variable auxiliar
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        // No hay entrada de datos como tal pues el programa se alimentará de la información proporcionada por el array listaPasswords
        System.out.println("OFUSCACIÓN DE CONTRASEÑAS");
        System.out.println("-------------------------");

        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        // 3. Reservamos espacio en memoria para el array de resultados
        contrasenasOfuscadas = new String[contrasenas.length];

        // 4. Recorremos cada uno de los elementos de la lista de contraseñas
        // Para cada contraseña, se generará su transformada ofuscada y se almacenará en el array de resultados
        for (int i = 0; i < contrasenas.length; i++) {
            contrasenasOfuscadas[i] = ""; //inicializo cada palabra del array de resultados a cadena vacía para evitar nulls en el resultado final
            for (int j = 0; j < contrasenas[i].length(); j++) { //empiezo a comprobar cada caracter y a construir el array de resultados
                switch (contrasenas[i].charAt(j)) {
                    case 'A':
                        contrasenasOfuscadas[i] += "4";
                        break;
                    case 'a':
                        contrasenasOfuscadas[i] += "@";
                        break;
                    case 'B':
                        contrasenasOfuscadas[i] += "8";
                        break;
                    case 'C':
                        contrasenasOfuscadas[i] += "((";
                        break;
                    case 'D':
                        contrasenasOfuscadas[i] += "))";
                        break;
                    case 'E':
                        contrasenasOfuscadas[i] += "3";
                        break;
                    case 'e':
                        contrasenasOfuscadas[i] += "?";
                        break;
                    case 'G':
                        contrasenasOfuscadas[i] += "6";
                        break;
                    case 'H':
                        contrasenasOfuscadas[i] += "#";
                        break;
                    case 'I':
                        contrasenasOfuscadas[i] += "|";
                        break;
                    case 'i':
                        contrasenasOfuscadas[i] += "1";
                        break;
                    case 'l':
                        contrasenasOfuscadas[i] += "!";
                        break;
                    case 'O':
                        contrasenasOfuscadas[i] += "0";
                        break;
                    case 'o':
                        contrasenasOfuscadas[i] += "*";
                        break;
                    case 'P':
                        contrasenasOfuscadas[i] += "9";
                        break;
                    case 'S':
                        contrasenasOfuscadas[i] += "$$";
                        break;
                    case 's':
                        contrasenasOfuscadas[i] += "2";
                        break;
                    case 'T':
                        contrasenasOfuscadas[i] += "7";
                        break;
                    case 't':
                        contrasenasOfuscadas[i] += "+";
                        break;
                    case 'V':
                        contrasenasOfuscadas[i] += "\\/";
                        break;
                    case 'Y':
                        contrasenasOfuscadas[i] += "&";
                        break;
                    default:
                        contrasenasOfuscadas[i] += contrasenas[i].charAt(j);
                        break;
                }
            }
        }

        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println();
        System.out.println("RESULTADO");
        System.out.println("---------");

        // 5. Recorremos el array de resultados y lo mostramos por pantalla.
        // Cada contraseña en una línea, en el formato: Contraseña original -> Contraseña ofuscada
        for (int i = 0; i < contrasenasOfuscadas.length; i++) {
            System.out.printf("%d.- %10s -> %s\n", i + 1, contrasenas[i], contrasenasOfuscadas[i]);
        }
    }
}
