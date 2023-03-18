/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PSPReto5;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class Lanzadora {
    public static void main(String[] args) {
        try {
            ProcessBuilder pb2 = new ProcessBuilder("javac", "HolaMundo.java");
            Process p2 = pb2.start();

           /* try {
                p2.waitFor();
            } catch (InterruptedException ex) {
                Logger.getLogger(Ejercicio7.class.getName()).log(Level.SEVERE, null, ex);
            }*/

            ProcessBuilder pb1 = new ProcessBuilder("java", "HolaMundo");
            Process p1 = pb1.start();

            int exitVal;
            try {
                //El proceso actual espera hasta que el subproceso Process finalice
                exitVal = p1.waitFor(); //Recoge la salida de System.exit()
                if (exitVal == 0) {
                    System.out.println("Salida del repetidor");
                    System.out.println("====================");
                } else {
                    System.out.println("MALLLLLLLLLL");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                InputStream is = p1.getInputStream();
                int c;
                while ((c = is.read()) != -1) {
                    System.out.print((char) c);
                }
                is.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

            //Redirección a un archivo
            File f = new File("SalidaEjercicio7.txt");
            pb1.redirectOutput(f).start();

        } catch (IOException ex) {
            System.out.println("Falló");
        }
    }
}
