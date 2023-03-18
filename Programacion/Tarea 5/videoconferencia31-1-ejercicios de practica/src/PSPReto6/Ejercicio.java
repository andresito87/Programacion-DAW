/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PSPReto6;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class Ejercicio {
    public static void main(String[] argv){
        Ulam miUlam = new Ulam(13);
        SucesionThread h1 = new SucesionThread(miUlam,"H1");
        SucesionThread h2 = new SucesionThread(miUlam,"H2");
        SucesionThread h3 = new SucesionThread(miUlam,"H3");
        ArrayList<SucesionThread> misHilos = new ArrayList<SucesionThread>();
        misHilos.add(h1);
        misHilos.add(h2);
        misHilos.add(h3);
        
        for(SucesionThread hilo: misHilos){
            System.out.println("Lanzo a ejecución el hilo "+hilo.getNombre());
            hilo.start();
        }
        
        for(SucesionThread hilo: misHilos){
            try {
                hilo.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(Ejercicio.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        System.out.println("\n\nSUCESIÓN ULAM MULTIHILO GENERADA:");
        System.out.println("---------------------------------");
        System.out.println(miUlam.getSucesion());
    }
}
