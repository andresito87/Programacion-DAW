package ejercicio4;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;

/**
 * Clase que permite leer archivos binarios que contienen imágenes y
 * transformarlas a una representación en forma de caracteres.
 *
 * @author profe
 */
public class CAgendaContactosImagen {

    // Archivo donde se leen los nombres de la imágenes asociadas a las 
    // respectivas categorías.
    private String nombreArchivo;

    // Array donde se almacenan las diferentes líneas del archivo "nombreArchivo". 
    private String[] imagenes;

    // Indica el número máximo de categorías existentes.
    private int numCategorias;

    // Constante que indica la ruta donde se ubica el archivo "nombreArchivo" y las
    // imágenes asociadas a las categorías.
    private static final String rutaImagen = System.getProperty("user.dir") + "/recursos/";

    /**
     * Crea un objeto CAgendaContactosImagen.
     *
     * @param nombreArchivo Archivo donde se leen los nombres de las imágenes
     * asociadas a las respectivas categorías.
     * @param numCategorias Número máximo de categorías existentes.
     */
    public CAgendaContactosImagen(String nombreArchivo, int numCategorias) {
        this.nombreArchivo = nombreArchivo;
        this.imagenes = new String[numCategorias];
        this.numCategorias = numCategorias;

        leerArchivoImagenes();
    }

    // -----------------------------------------------------
    // Ejercicio 4: Métodos que debe implementar el alumnado
    // -----------------------------------------------------
    // 4.1. Método leerArchivoImagenes()
    /*
     * Método que lee los nombres de las categorías y el de la imagen 
     * asociada a dichas categorías. Esta información la vuelca en el array 
     * imagenes.
     */
    private void leerArchivoImagenes() {
        // Abrimos el archivo que contiene cada categoría de contactos junto con 
        // el nombre del fichero con la imagen representativa de dicho contacto.
        try (BufferedReader lectorArchivo
                = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream(
                                        new File(CAgendaContactosImagen.rutaImagen
                                                + this.nombreArchivo))));) {

            // Almacenamos cada par "categoría;nombreArchivo.extensión" en el array 
            // imagenes.
            String linea;
            int i = 0;
            while ((linea = lectorArchivo.readLine()) != null) {
                this.imagenes[i] = linea;
                i++;
            }
        } catch (FileNotFoundException ex) {
            System.out.printf("Error. Archivo %s no encontrado",
                    CAgendaContactosImagen.rutaImagen + this.nombreArchivo);
        } catch (IOException ex) {
            System.out.println("Error en el proceso de lectura del archivo");
        }
    }

    // 4.2. Método leerImagen()
    /**
     * Método que lee una imagen correspondiente a una categoría específica.
     *
     * @param categoria nombre de la categoría de la que tiene que capturar la
     * imagen.
     * @return String Imagen correspondiente transformada a cadena de
     * caracteres.
     */
    public String leerImagen(String categoria) {
        // Obtenemos del array "imagenes" el nombre del archivo donde se encuentra
        // la imagen correspondiente a la categoría
        String nombreArchivoImagen = null;
        for (String categoriaImagen : this.imagenes) {
            if (categoriaImagen.split(";")[0].equalsIgnoreCase(categoria)) {
                nombreArchivoImagen = categoriaImagen.split(";")[1];
            }
        }

        StringBuilder representacionImagen = new StringBuilder();
        // Abrimos el archivo que contiene la imagen
        try (FileInputStream entradaImagen
                = new FileInputStream(CAgendaContactosImagen.rutaImagen
                        + nombreArchivoImagen);) {
            /*
            //Se podría haber abierto el archivo con "ImageInputStream" pero
            //esto genera errores del tipo I/O Exception en la salida por consola:
                ImageInputStream entradaImagen
                    = ImageIO.createImageInputStream(
                        new FileInputStream(
                                CAgendaContactosImagen.rutaImagen
                                    + nombreArchivoImagen))) {
             */

            //No puedo usar try-with-resources con la clase BufferedImage, no es Closeable
            BufferedImage lectorImagen = ImageIO.read(entradaImagen);

            // Recorremos la imagen y convertimos cada pixel en un carácter. 
            // Cada carácter lo vamos agregando a una cadena de caracteres.
            for (int y = 0; y < lectorImagen.getHeight(); y++) {
                for (int x = 0; x < lectorImagen.getWidth(); x++) {
                    Color color = new Color(lectorImagen.getRGB(x, y));
                    if (color.getBlue() == 255
                            && color.getRed() == 255
                            && color.getGreen() == 255) {
                        representacionImagen.append(" ");
                    } else {
                        representacionImagen.append("*");
                    }
                }
                representacionImagen.append("\n");
            }
        } catch (FileNotFoundException ex) {
            System.out.printf("Error. Archivo %s no encontrado",
                    CAgendaContactosImagen.rutaImagen + nombreArchivoImagen);
        } catch (IOException ex) {
            System.out.println("Error de entrada/salida");
        }
        return representacionImagen.toString();
    }
}
