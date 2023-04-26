package ejercicio2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Clase que permite leer y escribir un objeto CAgendaContactos serializable en
 * un archivo binario.
 *
 * @author profe
 */
public class CAgendaContactosIO {

    /**
     * Ruta del archivo donde se lee y escribe el objeto CAgendaContactos
     */
    private String rutaArchivo;

    /**
     * Método constructor
     *
     * @param archivo Ruta del archivo donde se lee y escribe el objeto
     * CAgendaContactos
     */
    public CAgendaContactosIO(String archivo) {
        this.rutaArchivo = archivo;
    }

    // -----------------------------------------------------
    // Ejercicio 2: Métodos que debe implementar el alumnado
    // -----------------------------------------------------
    // 2.1. Método leer()
    /**
     * Método que lee, desde un archivo binario, un objeto CAgendaContactos
     * serializado.
     *
     * @return Objeto CAgendaContactos que estaba almacenado en el archivo
     * binario.
     */
    public CAgendaContactos leer() {
        CAgendaContactos miAgenda = null;
        try (FileInputStream fichero
                = new FileInputStream(
                        new File(this.rutaArchivo));
                ObjectInputStream ficheroEntrada
                = new ObjectInputStream(fichero);) {
            miAgenda = (CAgendaContactos) ficheroEntrada.readObject();
        } catch (FileNotFoundException ex) {
            System.out.printf("Error. Archivo %s no encontrado",
                    this.rutaArchivo);
        } catch (ClassNotFoundException ex) {
            System.out.printf("Error. Clase no encontrada en el archivo %s",
                    this.rutaArchivo);
        } catch (IOException ex) {
            System.out.printf("Error de entrada/salida: %s\n",
                    ex.getMessage());
        }
        return miAgenda;
    }

    // 2.2. Método escribir()
    /**
     * Método que escribe, en un archivo binario, un objeto CAgendaContactos
     * serializable.
     *
     * @param agenda Objeto CAgendaContactos serializable para almacenar en el
     * archivo binario.
     */
    public void escribir(CAgendaContactos agenda) {
        try (FileOutputStream fichero
                = new FileOutputStream(
                        new File(this.rutaArchivo));
                ObjectOutputStream ficheroSalida
                = new ObjectOutputStream(fichero);) {
            ficheroSalida.writeObject(agenda);
        } catch (FileNotFoundException ex) {
            System.out.printf("Error. Archivo %s no encontrado",
                    this.rutaArchivo);
        } catch (IOException ex) {
            System.out.printf("Error de entrada/salida: %s\n",
                    ex.getMessage());
        }
    }
}
