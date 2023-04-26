/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio4;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa una <strong>agenda</strong> para la gestión de contactos. 
 * <p>
 * Los objetos de esta clase permiten almacenar y gestionar una lista de objetos de tipo
 * <strong>CPersona</strong></p>
 * 
 * @author profe
 */

public class CAgendaContactos {
    
    // -------------------------------------------------------------------------
    // ATRIBUTOS DE OBJETO
    // ------------------------------------------------------------------------
    // Lista de objetos CPersona.
    private List<CPersona> personas;  
    
    // Nombre del archivo que almacena los nombres de las imágenes asociadas
    // a las categorías (familia, amigos y trabajo) de los contactos.
    private String archivoCategorias;
    
    // ------------------------------------------------------------------------
    // Constructor
    // ------------------------------------------------------------------------
    
    /**
     * Crea un objeto CAgendaContactos vacía.
     * 
     * @param archivoCategorias Archivo que almacena los nombres de las imágenes
     * asociadas a las categorías (familia,amigos y trabajo) de los contactos.
     */
    public CAgendaContactos(String archivoCategorias){
        personas=new ArrayList<>();
        this.archivoCategorias=archivoCategorias;
    }

    /**
     * Asigna a la agenda un listado de contactos que se pasa por parámetro.
     * 
     * @param personas Lista de objetos de tipo CPersona.
     */
    public void setPersonas(List<CPersona> personas) {
        this.personas = personas;
    }
    
    /**
     * Añade un nuevo contacto a la agenda.
     * 
     * @param nueva Objeto de tipo CPersona que se añade
     * @throws NullPointerException si el parámetro es nulo.
     */
    public void add(CPersona nueva) throws NullPointerException{
        if (nueva==null)
             throw new NullPointerException ("El objeto CPersona no puede ser nulo.");
        
        personas.add(nueva); 
    }
     
   /**
    * Busca un contacto en la agenda a partir de su nombre.
    * 
    * @param nombre Nombre del contacto que estamos buscando
    * @return si el contacto se encuentra o no en la agenda
    * @throws NullPointerException si el parámetro es nulo    
    */
    public boolean buscarPorNombre(String nombre) throws NullPointerException {
        if (nombre==null)
            throw new NullPointerException ("El nombre de la persona no puede ser nulo.");
        
        boolean encontrado = false;
        for (int i = 0; i < personas.size() && !encontrado; i++) {
            if (personas.get(i).getNombre().equalsIgnoreCase(nombre)) {
                encontrado = true;
            }
        }
        return encontrado;
    }
    
    /**
     * Busca un contacto en la agenda a partir de su identificador.
     * 
     * @param id Identificador del contacto que estamos buscando
     * @return si el contacto se encuentra o no en la ageda
     */
    public boolean buscarPorID (int id){
        boolean encontrado=false;
        
        for (int i=0;i<personas.size() && !encontrado;i++){
            if (personas.get(i).getIdentificador()==id)
                encontrado=true;
        }
        return encontrado;
    }
      
    /**
     * Obtiene el número de contactos de la agenda.
     * 
     * @return número de contactos
     */
    public int numPersonas(){
        return personas.size();
    }
    
    /**
     * Permite borrar un contacto de la agenda.
     * 
     * @param borrada Objeto de tipo CPersona que queremos borrar
     * @return si el contacto ha sido eliminado
     * @throws NullPointerException si el parámetro es nulo
     */
    public boolean borrarPersona (CPersona borrada) throws NullPointerException{
        if (borrada==null)
            throw new NullPointerException ("El objeto CPersona no puede ser nulo.");
        
        return personas.remove(borrada);
    }
    
    /**
     * Permite vaciar la agenda de contactos.
     */
    public void vaciarAgenda(){
        personas.clear();
    }
    
    /**
     * Devuelve una cadena que representa las características de la agenda de 
     * forma textual.
     * 
     * @return cadena que representa las característias de la agenda de forma textual
     */
    @Override
    public String toString() {
        String listado="";

        if (personas.isEmpty()) {
            listado = "La agenda está vacía";
        } else {
            for (CPersona c : personas) {
                listado = listado + c.toString()+"\n";
            }
        }
        return listado;
    }
    
    /**
     * Devuelve una cadena con la representación en forma de caracteres de la 
     * imagen asociada a la categoría "familia" y los contactos de esta categoría 
     * almacenados en la agenda.
     * 
     * @return Cadena con los contactos de la categoría "familia" y la imagen 
     * asocidada.
     */
    public String listarFamilia(){
        int cont=0;
        CAgendaContactosImagen imag = new CAgendaContactosImagen(archivoCategorias, CPersona.NUM_CATEGORIAS);
        String listado="LISTADO DE FAMILIARES:\n"; //añado un \n que no tenía el proyecto base
        listado = listado + imag.leerImagen("familia")+"\n";
        
        if (personas.isEmpty()) {
            listado = listado + "La agenda está vacía";
        } else {
            for (CPersona c : personas) {
                if(c.getTipoContacto().equals("familia")){
                    listado = listado + c.toString() + "\n";
                    cont++;
                }
            }
            if(cont==0){
                listado = listado + "No hay familiares en la agenda";
            }
        }
        return listado;
    }
    
    /**
     * Devuelve una cadena con la representación en forma de caracteres de la 
     * imagen asociada a la categoría "amigos" y los contactos de esta categoría 
     * almacenados en la agenda.
     * 
     * @return Cadena con los contactos de la categoría "amigos" y la imagen 
     * asocidada.
     */
    public String listarAmigos(){
        int cont=0;
        CAgendaContactosImagen imag = new CAgendaContactosImagen(archivoCategorias,CPersona.NUM_CATEGORIAS);
        String listado="\nLISTADO DE AMISTADES:\n"; //añado un \n para dar mejorar la salida por consola
        listado = listado + imag.leerImagen("amigos")+"\n";
        
        if (personas.isEmpty()) {
            listado = listado + "La agenda está vacía";
        } else {
            for (CPersona c : personas) {
                if(c.getTipoContacto().equals("amigos")){
                    listado = listado + c.toString() + "\n";
                    cont++;
                }
            }
            if(cont==0){
                listado = listado + "No hay amigos en la agenda";
            }
        }
        return listado;
    }
    
    /**
     * Devuelve una cadena con la representación en forma de caracteres de la 
     * imagen asociada a la categoría "trabajo" y los contactos de esta categoría 
     * almacenados en la agenda.
     * 
     * @return Cadena con los contactos de la categoría "trabajo" y la imagen 
     * asocidada.
     */   
    public String listarCompanerosTrabajo(){
        int cont=0;
        CAgendaContactosImagen imag = new CAgendaContactosImagen(archivoCategorias,CPersona.NUM_CATEGORIAS);
        String listado="\nLISTADO DE COMPAÑEROS DE TRABAJO:\n";//añado un \n para dar mejorar la salida por consola
        listado = listado + imag.leerImagen("trabajo")+"\n";
        
        if (personas.isEmpty()) {
            listado = listado + "La agenda está vacía";
        } else {
            for (CPersona c : personas) {
                if(c.getTipoContacto().equals("trabajo")){
                    listado = listado + c.toString() + "\n";
                    cont++;
                }
            }
            if(cont==0){
                listado = listado + "No hay compañeros de trabajo en la agenda";
            }
        }
        return listado;
    }
}
