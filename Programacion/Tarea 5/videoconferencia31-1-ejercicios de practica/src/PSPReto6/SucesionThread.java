/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PSPReto6;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class SucesionThread extends Thread{
    private String nombre;
    private static Ulam ulam;
    
    public SucesionThread(Ulam ulam, String nombre){
        SucesionThread.ulam=ulam;
        this.nombre=nombre;
    }
    
    public void run(){
        boolean sigue=true;
        while(sigue){
            //synchronized(ulam){
                sigue = ulam.generaTermino(nombre);
            //}
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ex) {
                Logger.getLogger(SucesionThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public String getNombre(){
        return nombre;
    }
    
}
