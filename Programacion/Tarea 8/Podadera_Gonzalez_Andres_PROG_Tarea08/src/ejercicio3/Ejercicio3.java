
package ejercicio3;

import java.time.LocalDate;

/**
 * Ejercicio 3: Lectura y escritura de objetos. XML.
 *
 * @author profe
 */

public class Ejercicio3 {

    /**
     * Método principal.
     * @param args argumentos que recibe el método
     */
    public static void main(String args[]) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        // Variables de entrada
        String ruta = System.getProperty("user.dir") + "/recursos/BDCAgendaContactos.xml";
        CAgendaContactos miAgenda;
        CPersona p1, p2, p3, p4, p5;
        CAgendaContactosXML agendaBD;

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
            System.out.printf("He creado y almaceno en el archivo %d contactos.\n",
                    miAgenda.numPersonas());
            System.out.println("LISTADO DE CONTACTOS GUARDADOS EN LA AGENDA:");
            System.out.println(miAgenda.toString());

            // Escribo en el archivo XML a partir de la clase CAgendaContactosXML.
            System.out.println("Escribiendo en el archivo BDCAgendaContactos.xml...");
            agendaBD = new CAgendaContactosXML(ruta);
            agendaBD.escribir(miAgenda);

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
            System.out.printf("\nAhora inserto 2 contactos más. Tengo %d contactos.\n",
                    miAgenda.numPersonas());
            System.out.println("LISTADO DE CONTACTOS GUARDADOS EN LA AGENDA:");
            System.out.println(miAgenda);

            // Leo del archivo XML, almacenando su contenido (los tres contactos creados originalmente) 
            // en el objeto de tipo CAgendaContactos.
            miAgenda = agendaBD.leer();

            // Muestro por pantalla los tres contactos de la agenda (los que se han leído del archivo XML).
            System.out.printf("Leo del archivo %d contactos.\n", miAgenda.numPersonas());
            System.out.println("LISTADO DE CONTACTOS GUARDADOS EN EL FICHERO:");
            System.out.println(miAgenda);
            
        } catch (NullPointerException | IllegalArgumentException e) {
            System.out.printf(e.getMessage());
        }
    }
}
