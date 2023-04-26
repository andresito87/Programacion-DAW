
package ejercicio2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa una <strong>agenda</strong> para la gestión de contactos. 
 * <p>
 * Los objetos de esta clase permiten almacenar y gestionar una lista de objetos de tipo
 * <strong>CPersona</strong>. 
 * 
 * @author profe
 */

public class CAgendaContactos implements Serializable{   
    // ------------------------------------------------------------------------
    // ATRIBUTOS ESTÁTICOS (de clase)
    // ------------------------------------------------------------------------
    // Atributos estáticos constantes
    /**
     * Atributo necesario para una correcta serialización/des-serialización en Java: {@value serialVersionUID}
     * Ver: https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/io/Serializable.html
    */
    private static final long serialVersionUID = 42L;
    
    // ------------------------------------------------------------------------
    // Atributo de objeto variable
    // ------------------------------------------------------------------------
    private List<CPersona> personas;
    
    // ------------------------------------------------------------------------
    //                        CONSTRUCTOR
    // ------------------------------------------------------------------------
    /**
     * Crea un objeto CAgenda vacía.
     */
    public CAgendaContactos(){
        personas=new ArrayList<>();
    }

    /**
     * Asigna a la agenda un listado de contactos que se pasa por parámetro.
     * @param personas Lista de objetos de tipo CPersona.
     */
    public void setPersonas(List<CPersona> personas) {
        this.personas = personas;
    }
    
    /**
     * Añade un nuevo contacto a la agenda.
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
     * @return número de contactos
     */
    public int numPersonas(){
        return personas.size();
    }
    
    /**
     * Permite borrar un contacto de la agenda.
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
}
