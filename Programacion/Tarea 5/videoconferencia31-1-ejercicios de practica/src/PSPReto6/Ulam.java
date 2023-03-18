/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PSPReto6;

/**
 *
 * @author Usuario
 */
public class Ulam {
    private int valorActual;
    private String sucesion;
    
    public Ulam(int valorInicial){
        this.valorActual=valorInicial;
        if(this.valorActual != 1)
            this.sucesion=valorInicial+", ";
        else
            this.sucesion=valorInicial+".";
    }
    
    public synchronized boolean generaTermino(String nombre){
        if(valorActual==1)
            return false;
        if(valorActual%2 == 0){
            valorActual=valorActual/2;
            if(valorActual != 1)
                sucesion=sucesion+valorActual+"("+nombre+"), ";
            else
                sucesion=sucesion+valorActual+"("+nombre+").";
        }else{
            valorActual=valorActual*3+1;
            if(valorActual != 1)
                sucesion=sucesion+valorActual+"("+nombre+"), ";
            else
                sucesion=sucesion+valorActual+"("+nombre+").";
        }
        return true;
    }
    
    public String getSucesion(){
        return sucesion;
    }
}
