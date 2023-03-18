/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProgReto11;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Usuario
 */
public class Molecula {
    private String[] atomos;
    private int[]cantidades;
    private int numElementos;
    
    public Molecula(String formula){
        this.atomos = new String[10];
        this.cantidades =  new int[10];
        this.numElementos=0;
        String aux;
        //Generar patrón
        String expresion = "([A-Z][a-z]?([2-9]|[1-9][0-9])?)+";
        Pattern patron = Pattern.compile(expresion); 
        Matcher acoplamiento = patron.matcher(formula);
        String expresion2 = "([A-Z][a-z]?)([2-9]|[1-9][0-9])?";
        Pattern patron2 = Pattern.compile(expresion2); 
        Matcher acoplamiento2 = patron2.matcher(formula);
        if(acoplamiento.matches()){
            while(acoplamiento2.find()){
                aux = acoplamiento2.group(1);
                if(buscarAtomo(aux)!=-1)
                    throw new IllegalArgumentException("Átomo repetido");
                atomos[numElementos] = aux;
                aux = acoplamiento2.group(2);
                if(aux!=null)
                    cantidades[numElementos] = Integer.parseInt(acoplamiento2.group(2));
                else
                    cantidades[numElementos] = 1;
                numElementos++;
            }
        }else{
            throw new IllegalArgumentException("Fórmula no válida");
        }
        System.out.println(Arrays.toString(this.atomos));
    }

    public String[] getListaAtomos() {
        String[] aux = new String[numElementos];
        for(int i=0; i<numElementos;i++){
            aux[i]=atomos[i];
        }
        return aux;
    }
    
    public int getAtomo(String atomo){
        int pos=-1;
        for(int i=0; i<numElementos && pos==-1;i++){
            if(atomos[i].equals(atomo)){
                pos = i;
            }
        }
        if(pos != -1){
            //Estoy aquí dentro pq he encontrado el átomo
            return cantidades[pos];
        }else{
            //Estoy aquí dentro pq NO he encontrado el átomo
            return 0;
        }
    }
    
    private int buscarAtomo(String atomo){
        for(int i=0;i<this.numElementos;i++){
            if(atomos[i].equals(atomo)){
                return i;
            }
        }
        return -1;
    }
    
    public int getNumAtomosDistintos(){
        return this.numElementos;
    }
    
    public int getNumAtomosTotales(){
        int sumatoria=0;
        for(int i=0;  i<numElementos; i++){
            sumatoria+=cantidades[i];
        }
        return sumatoria;
    }
    
    public String toString(){
        String salida="";
        for(int i=0; i<numElementos;i++){
            salida = salida +atomos[i];
            if(cantidades[i]!=1)
                salida = salida + cantidades[i];
        }
        return salida;
    }
}
