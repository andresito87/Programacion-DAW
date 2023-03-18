package tarea04;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Ejercicio 2. Validación de contraseñas.
 *
 * @author Andres Podadera Gonzalez
 */
public class Ejercicio02 {

    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        String regex; //Declaro la variable donde voy a guarda la expresion regular
        Pattern patron; //Declaro la variable donde voy a guardar el patron compilado de la expresion regular
        // Variables de entrada
        // 1. Declaramos el array relleno de contraseñas (algunas inválidas y otras válidas)
        String[] listaPasswords = {
            // Passwords no válidos
            "Hh0011Aa\"99", // Contiene un carácter no válido (") 
            "/HhOoLlAa22/", // Contiene un carácter no válido (/)  
            "1234567890", // Faltan una mayúscula, una minúscula y un carácter especial
            "++LuisAntonio==2223++", // Demasiado largo
            "<Aa1!>", // Demasiado corto
            "3st0_3s_un@_pru3b@", // Falta una letra mayúscula
            "Est0_3s_0tr@_Pru3b@_+", // Demasiado largo
            "{[(P@$$w*rd)]}", // Falta un número 
            "SuperPaSSw0rd", // Falta un carácter especial
            "BARRATAI:4", // Falta una letra minúscula
            "C0LuOuP04", // Demasiado corto
            "{[(P@SSW0RD)]}", // Falta un número
            "[1234567890Aa^]", // Contiene un carácter no válido (^)
            // Passwords válidos                        
            "[1234567890Aa,]", "LuisAntonio=23", "RoyoRoyo42$", "1234567Aa-", "Est0_Es_1_Pru3b@",
            "Ju@n3nriqu301!", "BarTaLleGi.4", "<C0LuOuP0#4>", "{[(P@$$w0rd)]}", "\\UnoDosTres45\\"
        };

        // Variables de salida
        // 2 y 3. Declaramos el array de resultados para rellenarlo según los resultados de los análisis y reservamos memoria para él
        boolean[] resultados = new boolean[listaPasswords.length];

        // Variables auxiliares
        // 4. Declaramos cadenas que modelen, en forma de expresión regular, las distintas condiciones que deben darse
        regex = "(?=.*[a-z])" //minusculas
                + "(?=.*[A-Z])" //mayusculas
                + "(?=.*\\d)" //numeros
                + "(?=.*[!|\\#|\\$|%|&|\\|\\\\|=|\\?|\\*|\\+|\\-|_|\\{|\\}|\\[|\\]|\\{|\\}|:|;|,|\\.|<|>|@])" //caracteres especiales
                + "\\S{10,20}"; //longitud entre 10 y 20 de caracteres alfanumericos(sin espacios,tabulaciones,saltos de linea)
        patron = Pattern.compile(regex);

        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        // No hay entrada de datos como tal pues el programa se alimentará de la información proporcionada por el array listaPasswords
        System.out.println("VALIDACIÓN DE CONTRASEÑAS");
        System.out.println("-------------------------");
        System.out.println("Las contraseñas deben tener entre 10 y 20 caracteres.");
        System.out.println("Deben contener al menos: ");
        System.out.println("una mayúcula, una minúscula, un dígito y un carácter especial.");
        System.out.printf("Los únicos caracteres especiales permitidos son los del conjunto: %s\n", "\\!|#$%&()=?*+-_{}[]{}:;,.<>@");
        System.out.println("Cualquier otro carácter dará lugar a una contraseña inválida");

        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        // 5. Recorremos cada uno de los elementos de la lista de contraseñas
        for (int i = 0; i < listaPasswords.length; i++) {
            Matcher acoplamiento = patron.matcher(listaPasswords[i]);

            // 5.1. Para cada password, si se superan todas las condiciones, se incluirá un valor true en el array de resultados.
            // Si no es así, se incluirá un valor false
            resultados[i] = acoplamiento.matches();
        }
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------

        System.out.println();
        System.out.println("RESULTADO");
        System.out.println("---------");
        // 6. Mostramos por pantalla los resultados

        for (int i = 0; i < resultados.length; i++) {
            System.out.printf("%2d.- %23s -> %s\n", i + 1, listaPasswords[i], resultados[i] ? "Password válido" : "Password inválido");
        }
    }
}
