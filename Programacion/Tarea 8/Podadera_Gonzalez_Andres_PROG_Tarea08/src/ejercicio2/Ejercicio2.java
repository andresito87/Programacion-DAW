
package ejercicio2;

import java.time.LocalDate;

/**
 * Ejercicio 2: Lectura/Escritura de objetos. Serialización.
 *
 * @author profe
 */
public class Ejercicio2 {

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
        // Variables de entrada
        String ruta = System.getProperty("user.dir") + "/recursos/BDCAgendaContactos.dat";
        CAgendaContactosIO bd;
        CAgendaContactos miAgenda;
        CPersona p1, p2, p3, p4, p5;

        // Variables de salida
        // Variables auxiliares
        //----------------------------------------------------------------------
        //                 Entrada de datos + Procesamiento + Salida 
        //----------------------------------------------------------------------
        try {
            // Creo un objeto CAgendaContactos y tres objetos CPersona.             
            miAgenda = new CAgendaContactos();
            p1 = new CPersona("Manuel Pérez Pérez", "C/Sevilla,nº5,Aguadulce", "123321123",
                    LocalDate.parse("1980-01-01"), "amigos");
            p2 = new CPersona("Piedad Sánchez Gil", "C/Granada,nº7,Aguadulce", "666777888",
                    LocalDate.parse("1990-12-01"), "familia");
            p3 = new CPersona("Raúl Gómez Medina", "C/Málaga,nº10,Aguadulce", "999111222",
                    LocalDate.parse("1995-11-03"), "trabajo");
            p1.setAficiones("cocinar");
            p2.setAficiones("lectura", "escritura");
            p3.setAficiones("bailar", "viajar", "hacer deporte");

            // Añado los tres contactos creados a la agenda.
            miAgenda.add(p1);
            miAgenda.add(p2);
            miAgenda.add(p3);

            // Muestro por pantalla el listado de contactos que tiene la agenda.
            System.out.printf("He creado y almaceno en el archivo %d contactos.\n\n", miAgenda.numPersonas());
            System.out.println("LISTADO DE CONTACTOS GUARDADOS LA AGENDA:");
            System.out.println(miAgenda.toString());
        
            // Escribo en el fichero binario a partir de la clase CAgendaContactosIO.
            System.out.println("Escribiendo en el archivo BDCAgendaContactos.dat...");
            bd = new CAgendaContactosIO(ruta);
            bd.escribir(miAgenda);

            // Creo dos nuevos contactos (objetos CPersona) 
            p4 = new CPersona("Vera Aznar Aznar", "C/Cádiz,nº3,Aguadulce", "321123456",
                    LocalDate.parse("1998-03-28"), "amigos");
            p5 = new CPersona("Esther Diaz Ruiz", "C/Huelva,nº8,Aguadulce", "999888777",
                    LocalDate.parse("1999-02-28"), "amigos");
            p4.setAficiones("flamenco");
            p5.setAficiones("meditación,tocar la guitarra");

            // Añado los dos nuevos contactos a la agenda
            miAgenda.add(p4);
            miAgenda.add(p5);

            // Muestro por pantalla los cinco contactos que contiene la agenda.
            System.out.printf("\nAhora inserto 2 contactos más. Tengo %d contactos.\n\n",
                    miAgenda.numPersonas());
            System.out.println("LISTADO DE CONTACTOS GUARDADOS EN LA AGENDA:");
            System.out.println(miAgenda);

            // Leo del archivo binario, almacenando su contenido (los tres contactos creados originalmente) 
            // en el objeto de tipo CAgendaContactos.
            miAgenda = bd.leer();

            // Muestro por pantalla los tres contactos de la agenda (los que se han leído del archivo binario).
            System.out.printf("Leo del archivo %d contactos.\n\n", miAgenda.numPersonas());
            System.out.println("LISTADO DE CONTACTOS GUARDADOS EN EL FICHERO:");
            System.out.println(miAgenda);

        } catch (NullPointerException | IllegalArgumentException e) {
            System.out.printf(e.getMessage());
        }
    }
}
