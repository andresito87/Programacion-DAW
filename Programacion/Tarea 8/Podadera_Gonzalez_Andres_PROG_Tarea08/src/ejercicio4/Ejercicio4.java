package ejercicio4;

import java.time.LocalDate;

/**
 * Programa para el tratamiento de imágenes.
 *
 * @author profe
 */
public class Ejercicio4 {

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
        CAgendaContactos miAgenda = null;
        CPersona p1, p2, p3, p4, p5;

        // Variables de salida
        // Variables auxiliares
        //----------------------------------------------------------------------
        //                 Entrada de datos + Procesamiento + Salida 
        //----------------------------------------------------------------------  
        try {
            // Creo un objeto CAgendaContactos y cinco objetos CPersona.
            miAgenda = new CAgendaContactos("ListadoCategorias.txt");
            p1 = new CPersona("Manuel Pérez Pérez", "C/Sevilla,nº5,Aguadulce", "123321123",
                    LocalDate.parse("1980-01-01"), "amigos");
            p2 = new CPersona("Piedad Sánchez Gil", "C/Granada,nº7,Aguadulce", "666777888",
                    LocalDate.parse("1990-12-01"), "familia");
            p3 = new CPersona("Raúl Gómez Medina", "C/Málaga,nº10,Aguadulce", "999111222",
                    LocalDate.parse("1995-11-03"), "trabajo");
            p4 = new CPersona("Vera Aznar Aznar", "C/Cádiz,nº3,Aguadulce", "321123456",
                    LocalDate.parse("1998-03-28"), "familia");
            p5 = new CPersona("Esther Diaz Ruiz", "C/Huelva,nº8,Aguadulce", "999888777",
                    LocalDate.parse("1999-02-28"), "amigos");
            p1.setAficiones("cocinar");
            p2.setAficiones("lectura", "escritura");
            p3.setAficiones("bailar", "viajar", "hacer deporte");
            p4.setAficiones("flamenco");
            p5.setAficiones("meditación,tocar la guitarra");

            // Añado los cinco contactos creados a la agenda.
            miAgenda.add(p1);
            miAgenda.add(p2);
            miAgenda.add(p3);
            miAgenda.add(p4);
            miAgenda.add(p5);

            // Muestro por pantalla los contactos clasificados por categorías
            // (familia, amigos, trabajo).
            System.out.printf(miAgenda.listarFamilia());
            System.out.printf(miAgenda.listarAmigos());
            System.out.printf(miAgenda.listarCompanerosTrabajo());
        } catch (NullPointerException | IllegalArgumentException e) {
            System.out.printf(e.getMessage());
        }
    }
}
