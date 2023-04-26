package ejercicio1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * Ejercicio 1: Lectura/escritura de una agenda de contactos en ficheros de
 * texto.
 *
 * @author profe
 */
public class Ejercicio1 {

    /**
     * Método principal.
     *
     * @param args argumentos que recibe el método
     */
    public static void main(String args[]) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        String rutaContactos = System.getProperty("user.dir") + "/recursos/ListadoContactos.txt";
        String rutaAficiones = System.getProperty("user.dir") + "/recursos/ListadoAficiones.txt";
        String rutaAgendaContactos = System.getProperty("user.dir") + "/recursos/BDCAgendaContactos.txt";

        // Variables de entrada
        List<CPersona> listaPersonas = new ArrayList<>();
        List<String> conjuntoAficiones = new ArrayList<>();

        // Variables de salida
        CAgendaContactos miAgenda;
        String cabeceraAgenda = String.format("ID.;NOMBRE Y APELLIDOS;DIRECCIÓN;TELÉFONO;FECHA NAC.;TIPO CONTACTO;AFICIONES");

        // Variables auxiliares
        String linea;

        //----------------------------------------------
        //       Entrada de datos + Procesamiento
        //----------------------------------------------
        // Abrimos archivo de contactos ListadoContactos.txt
        System.out.println("Abriendo archivo de contactos...");

        try (BufferedReader lectorContactos
                = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream(
                                        new File(rutaContactos))));) {
            while ((linea = lectorContactos.readLine()) != null) {
                /*Tener disponible un constructor que aceptara como parámetro un
                array de Strings facilitaría este paso(que fuera él quien se
                encargue de las conversiones y comprobaciones de los datos)*/
                listaPersonas.add(new CPersona(
                        linea.split(";")[0],
                        linea.split(";")[1],
                        linea.split(";")[2],
                        LocalDate.parse(linea.split(";")[3]),
                        linea.split(";")[4])
                );
            }
            for (CPersona contacto : listaPersonas) {
                System.out.println(contacto);
            }
            System.out.println("Cerrando archivo de contactos...");
        } catch (FileNotFoundException ex) {
            System.out.printf("Error. Archivo %s no encontrado", rutaContactos);
        } catch (ClassCastException | DateTimeParseException ex) {
            System.out.println("Error de conversión de datos");
        } catch (IOException ex) {
            System.out.println("Error de entrada/salida");
        }

        System.out.println();
        // Abrimos archivo de aficiones ListadoAficiones.txt
        System.out.println("Abriendo archivo de aficiones...");

        try (BufferedReader lectorAficiones
                = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream(
                                        new File(rutaAficiones))));) {

            while ((linea = lectorAficiones.readLine()) != null) {
                conjuntoAficiones.add(linea);
            }
            for (String aficion : conjuntoAficiones) {
                System.out.println(aficion);
            }
            System.out.println("Cerrando archivo de aficiones...");
        } catch (FileNotFoundException ex) {
            System.out.printf("Error. Archivo %s no encontrado", rutaContactos);
        } catch (IOException ex) {
            System.out.println("Error de entrada/salida");
        }
        System.out.println();

        //recorremos la lista de personas y guardamos su correspondiente 
        //lista de aficiones
        for (CPersona persona : listaPersonas) {
            persona.setAficiones(Utilidades.generarAficiones(conjuntoAficiones));
        }
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------

        // Abrimos el archivo de la agenda BDAgendaContactos.txt
        System.out.println("Abriendo archivo de la agenda...");

        miAgenda = new CAgendaContactos();
        miAgenda.setPersonas(listaPersonas);
        System.out.print(miAgenda.toString());

        try (PrintWriter escritorContactos = new PrintWriter(
                new FileWriter(rutaAgendaContactos, false));) {
            escritorContactos.printf("%s  %-23s %-26s %-12s %-12s %-15s %-25s\n",
                    cabeceraAgenda.split(";")[0],
                    cabeceraAgenda.split(";")[1],
                    cabeceraAgenda.split(";")[2],
                    cabeceraAgenda.split(";")[3],
                    cabeceraAgenda.split(";")[4],
                    cabeceraAgenda.split(";")[5],
                    cabeceraAgenda.split(";")[6]
            );
            for (CPersona persona : listaPersonas) {
                escritorContactos.printf("[%s]  %-23s %-26s %-12s %-12s %-15s %-25s\n",
                        /*Si no se pidiera en el enunciado usar el método toString de CPersona
                        más fácil hubiera sido hacer algo como
                        persona.getIdentificador(),
                        persona.getNombre(),
                        persona.getDireccion(),
                        persona.getTelefono(),
                        persona.getFechaNacimiento(),
                        persona.getTipoContacto(),
                        persona.getAficiones()
                                .toString()
                                .substring(1,
                                        persona.getAficiones().toString().length() - 1)
                         */
                        persona.toString().split(";")[0].substring(1),
                        persona.toString().split(";")[1],
                        persona.toString().split(";")[2],
                        persona.toString().split(";")[3],
                        persona.toString().split(";")[4],
                        persona.toString().split(";")[5],
                        persona.toString().split(";")[6]
                );

            }
            System.out.println("Cerrando archivo de la agenda... ");
        } catch (FileNotFoundException ex) {
            System.out.printf("Error. Archivo %s no encontrado", rutaContactos);
        } catch (IOException ex) {
            System.out.println("Error de entrada/salida");
        }

        System.out.println();
        System.out.println("Archivos cerrados y procesamiento finalizado.");
        System.out.println("---------");
        System.out.println();
        System.out.println("Fin del programa.");
    }

}
