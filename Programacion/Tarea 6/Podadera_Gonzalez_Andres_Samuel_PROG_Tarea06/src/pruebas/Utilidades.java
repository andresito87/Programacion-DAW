package pruebas;

import java.time.LocalDate;
import libreria.Audible;
import libreria.AudioBook;
import libreria.EBook;
import libreria.EReader;
import libreria.Libro;
import libreria.LibroDigital;
import libreria.LibroFisico;
import libreria.Producto;

/**
 * Herramientas para los programas de prueba
 *
 * @author profe
 */
public final class Utilidades {

    // Constructor privado para que no puedan instanciarse objetos de esta clase
    private Utilidades() {

    }

    public static void PruebaConstructoresError() {
        // Intentos de creación de objetos con errores
        System.out.println("Intentando ejecutar constructores con valores inválidos");
        System.out.println("-------------------------------------------------------");
        Producto p;

        // Precio mínimo
        try {
            System.out.printf("Producto. ");
            p = new LibroFisico("Don Quijote", Producto.MIN_PRECIO - 0.01, "Lit. Universal", "Cervantes", 2018, 1300);
            System.out.printf("INCORECTO. Esto no debería haber funcionado: %s\n", p);
        } catch (IllegalArgumentException ex) {
            System.out.printf("CORRECTO. %s.\n", ex.getMessage());
        }

        // Precio máximo (Producto)
        try {
            System.out.printf("Producto. ");
            p = new LibroFisico("Don Quijote", Producto.MAX_PRECIO + 0.01, "Lit. Universal", "Cervantes", 2018, 1300);
            System.out.printf("INCORECTO. Esto no debería haber funcionado: %s\n", p);
        } catch (IllegalArgumentException ex) {
            System.out.printf("CORRECTO. %s.\n", ex.getMessage());
        }

        // Año de edición mínimo (Libro)
        try {
            System.out.printf("Libro. ");
            p = new LibroFisico("Don Quijote", 15.0, "Lit. Universal", "Cervantes", Libro.MIN_YEAR - 1, 1300);
            System.out.printf("INCORECTO. Esto no debería haber funcionado: %s\n", p);
        } catch (IllegalArgumentException ex) {
            System.out.printf("CORRECTO. %s.\n", ex.getMessage());
        }

        // Año de edición máximo (Libro)
        try {
            System.out.printf("Libro. ");
            p = new LibroFisico("Don Quijote", 15.0, "Lit. Universal", "Cervantes", LocalDate.now().getYear() + 1, 1300);
            System.out.printf("INCORECTO. Esto no debería haber funcionado: %s\n", p);
        } catch (IllegalArgumentException ex) {
            System.out.printf("CORRECTO. %s.\n", ex.getMessage());
        }

        // Número de páginas mínimo (LibroFisico)
        try {
            System.out.printf("LibroFisico. ");
            p = new LibroFisico("Don Quijote", 15.0, "Lit. Universal", "Cervantes", 2018, LibroFisico.MIN_PAGINAS - 1);
            System.out.printf("INCORECTO. Esto no debería haber funcionado: %s\n", p);
        } catch (IllegalArgumentException ex) {
            System.out.printf("CORRECTO. %s.\n", ex.getMessage());
        }

        // Número de páginas máximo (LibroFisico)
        try {
            System.out.printf("LibroFisico. ");
            p = new LibroFisico("Don Quijote", 15.0, "Lit. Universal", "Cervantes", 2018, LibroFisico.MAX_PAGINAS + 1);
            System.out.printf("INCORECTO. Esto no debería haber funcionado: %s\n", p);
        } catch (IllegalArgumentException ex) {
            System.out.printf("CORRECTO. %s.\n", ex.getMessage());
        }

        // Tamaño mínimo (LibroDigital)
        try {
            System.out.printf("LibroDigital. ");
            p = new EBook("Don Quijote", 15.0, "Lit. Universal", "Cervantes", 2018, LibroDigital.MIN_SIZE - 1, "ASCII");
            System.out.printf("INCORECTO. Esto no debería haber funcionado: %s\n", p);
        } catch (IllegalArgumentException ex) {
            System.out.printf("CORRECTO. %s.\n", ex.getMessage());
        }

        // Tamaño máximo (LibroDigital)
        try {
            System.out.printf("LibroDigital. ");
            p = new EBook("Don Quijote", 15.0, "Lit. Universal", "Cervantes", 2018, LibroDigital.MAX_SIZE + 1, "ASCII");
            System.out.printf("INCORECTO. Esto no debería haber funcionado: %s\n", p);
        } catch (IllegalArgumentException ex) {
            System.out.printf("CORRECTO. %s.\n", ex.getMessage());
        }

        // Duración mínima (AudioBook)
        try {
            System.out.printf("AudioBook. ");
            p = new AudioBook("Don Quijote", 15.0, "Lit. Universal", "Cervantes", 2018, 625, 0, 1);
            System.out.printf("INCORECTO. Esto no debería haber funcionado: %s\n", p);
        } catch (IllegalArgumentException ex) {
            System.out.printf("CORRECTO. %s.\n", ex.getMessage());
        }

        // Núm. voces mínimo (AudioBook)
        try {
            System.out.printf("AudioBook. ");
            p = new AudioBook("Don Quijote", 15.0, "Lit. Universal", "Cervantes", 2018, 625, 1, -1);
            System.out.printf("INCORECTO. Esto no debería haber funcionado: %s\n", p);
        } catch (IllegalArgumentException ex) {
            System.out.printf("CORRECTO. %s.\n", ex.getMessage());
        }
        System.out.println();
    }

    /**
     * Crea un array de productos de prueba
     *
     * @return array de productos de prueba
     */
    public static Producto[] generarArrayProductos() {
        // Reservamos espacio para el array de productos de prueba
        Producto[] listaProductos = new Producto[7];

        // Intentos de creación de objetos sin errores
        System.out.println("Intentando ejecutar constructores con valores válidos");
        System.out.println("-----------------------------------------------------");

        // Instanciamos productos
        try {
            listaProductos[0] = new EReader(139.99, "Kindle Paperwhite", "Amazon");
            listaProductos[1] = new EReader(39.90, "BQ Avant 2", "BQ");
            listaProductos[2] = new LibroFisico("Don Quijote", 20.0, "Lit. Universal", "Cervantes", 2018, 1300);
            listaProductos[3] = new EBook("Tuareg", 7.50, "La primera", "Figueroa", 2018, 625, "ASCII");
            listaProductos[4] = new EBook("Sin Rumbo", 9.50, "Espionaje", "Mantas", 2007, 1425, "Unicode");
            listaProductos[5] = new AudioBook("Guinea", 9.99, "Aventura africana", "Gamboa", 2014, 62000, 1850, 1);
            listaProductos[6] = new AudioBook("Rastas", 7.99, "Infantil", "Dark", 2023, 42000, 600, 3);
            System.out.println("CORRECTO. Todos los productos creados correctamente.");
        } catch (IllegalArgumentException ex) {
            System.out.printf("INCORRECTO. Error. %s\n", ex.getMessage());
        }

        return listaProductos;
    }

    public static void probarGettersProducto(Producto p) {
        System.out.printf("Tipo: %s\n", p.getClass().getSimpleName());
        System.out.printf("Id: %d\n", p.getId());
        System.out.printf("Precio: %.2f euros\n", p.getPrecio());
        System.out.printf("Descripción: %s\n", p.getDescripcion());
    }

    public static void probarGettersEReader(EReader p) {
        System.out.printf("Fabricante: %s\n", p.getFabricante());
    }

    public static void probarGettersLibro(Libro p) {
        System.out.printf("Título: %s\n", p.getTitulo());
        System.out.printf("Autor: %s\n", p.getAutor());
        System.out.printf("Año: %d\n", p.getYear());
    }

    public static void probarGettersLibroFisico(LibroFisico p) {
        System.out.printf("Núm. páginas: %d\n", p.getNumPaginas());
    }

    public static void probarGettersLibroDigital(LibroDigital p) {
        System.out.printf("Tamaño: %s Kb\n", p.getSize());
        System.out.printf("Núm. descargas: %s\n", p.getNumDescargas());
    }

    public static void probarGettersEBook(EBook p) {
        System.out.printf("Codificación: %s\n", p.getCodificacion());
    }

    public static void probarGettersAudioBook(AudioBook p) {
        System.out.printf("Duración: %d\n", p.getNumVoces());
        System.out.printf("Núm. voces: %d\n", p.getNumVoces());
    }

    public static void probarGettersAudible(Audible p) {
        System.out.printf("Duración: %d\n", p.getDuracion());
        System.out.printf("Núm voces: %d\n", p.getNumVoces());
        System.out.printf("Es coral: %s\n", p.isCoral());
        System.out.printf("Es monólogo: %s\n", p.isMonologo());
    }

    /**
     * Muestra por pantalla el conteido de un array de dispositivos usando el
     * método toString. Genera una línea por dispositivo.
     *
     * @param listaDispositivos array con los dispositivos
     */
    public static void mostrarContenidoArrayProductos(Producto[] listaDispositivos) {
        for (int i = 0; i < listaDispositivos.length; i++) {
            Producto prod = listaDispositivos[i];
            System.out.printf("Producto %d: %s\n", i, prod);
        }
        System.out.println();
    }

}
