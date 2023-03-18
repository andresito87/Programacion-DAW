/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProgReto11;

/**
 *
 * @author Usuario
 */
public class PruebaReto11 {
    public static void main(String[] args){
        String[] formulas={"H2O", "H02O","2O","H2SO4","NaCl","H2OH","Na1Cl2"};
        
        for(int i=0; i<formulas.length;i++){
            Molecula m1=null;
            try{
                System.out.println("\n\nIntento crear la fórmula: "+formulas[i]);
                m1 = new Molecula(formulas[i]);
                System.out.println(m1.toString());
                System.out.println("El número de átomos distintos es "+m1.getNumAtomosDistintos());
                System.out.println("La cantidad de átomos en la molécula es de "+m1.getNumAtomosTotales());
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
            
        }   
    }
}
