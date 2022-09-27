/*Del mismo modo que en los contenidos de la unidad tienes un ejemplo donde se definen unidades de medida de volumen, escribe ahora un pequeño programa en Java que defina un enumerado con los nombres de los elementos químicos conocidos como gases nobles: HELIO, NEON, ARGON, KRIPTON, XENON, RADON, para posteriormente mostrar por pantalla cada valor del enumerado declarado. */
public class Ejercicio1_1 {

    public enum GasesNobles {
        HELIO, NEON, ARGON, KRIPTON, XENON, RADON
    }

    public static void main(String[] args) {

        // Declaración de variables

        // Solicitud de datos

        // Procesamiento de datos

        // Mostrar resultados
        System.out.println();
        System.out.println("ELEMENTOS QUÍMICOS: GASES NOBLES");
        System.out.println("---------------------------------");
        System.out.println("Elemento 1: " + GasesNobles.HELIO);
        System.out.println("Elemento 2: " + GasesNobles.NEON);
        System.out.println("Elemento 3: " + GasesNobles.ARGON);
        System.out.println("Elemento 4: " + GasesNobles.KRIPTON);
        System.out.println("Elemento 5: " + GasesNobles.XENON);
        System.out.println("Elemento 6: " + GasesNobles.RADON);

    }

}