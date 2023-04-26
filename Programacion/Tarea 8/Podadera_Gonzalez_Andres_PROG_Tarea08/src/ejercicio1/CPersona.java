
package ejercicio1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa un <strong>contacto</strong> para la gestión de una agenda de contactos. 
 * <p>
 * Los objetos de esta clase permiten almacenar y gestionar información sobre el propio contacto:
 * identificador,nombre, fecha de nacimiento, dirección, teléfono, tipo de contacto y 
 * un listado con las aficiones de dicho contacto.</p>
 * <p>
 * La clase también dispone de información general independiente de los objetos
 * concretos que se hayan creado. Es el caso de:</p>
 * <ul>
 * <li><strong>Número de contactos</strong> creados hasta el momento.</li>
 * <li><strong>Fecha mínima de nacimiento</strong> que puede tener un contacto.</li>
 * <li><strong>Número de categorías</strong>: un contacto puede pertenecer a 
 * una de las <strong>tres</strong> categorías siguientes: amigos, familia o trabajo.</li>
 * </ul>
 * @author profe
 */

public class CPersona {
    
    // ------------------------------------------------------------------------
    // ATRIBUTOS ESTÁTICOS (de clase)
    // ------------------------------------------------------------------------
    // Atributos estáticos constantes
    /**
     * Mínimo año de nacimiento permitido: 01/01/1900
     */    
    public static final LocalDate FECHA_MINIMA = LocalDate.of(1900,1,1);
    
    /**
     * Número de categorías o tipos de contacto: {@value NUM_CATEGORIAS}.
     */
    public static final int NUM_CATEGORIAS = 3;
    
    //Atributos estáticos variables
    private static int contador=0; //Total de contactos creados hasta el momento
    
    // ------------------------------------------------------------------------
    // ATRIBUTOS DE OBJETO
    // ------------------------------------------------------------------------
    // Atributos de objeto constantes
    private final int identificador; //Identificador del contacto (automático, desde 1 hasta el máximo entero posible, coincide con contador)
    
    // Atributos de objeto variables
    private String nombre; // Nombre del contacto
    private String tipoContacto; // Tipo de contacto: "amigos", "familia" o "trabajo"
    private String direccion; // Dirección del contacto
    private String telefono; // Teléfono del contacto
    private LocalDate fechaNacimiento; // Fecha de nacimiento del contacto
    public List<String> aficiones; // Listado de aficiones del contacto.
    

    // ------------------------------------------------------------------------
    //                        CONSTRUCTOR
    // ------------------------------------------------------------------------
   
    /**
     * Crea un objeto CPersona con un nombre, dirección, teléfono, fecha de nacimiento 
     * y tipo de contacto.
     * @param nombre Nombre del contacto
     * @param direccion Dirección del contaco
     * @param telefono Teléfono del contacto
     * @param fechaNacimiento Fecha de nacimiento del contacto. Debe ser posterior a 01/01/1900
     * @param tipoContacto Tipo de contacto. Posibles valores: "amigos", "familia" o "trabajo".
     * @throws NullPointerException si alguno de los parámetros es nulo.
     * @throws IllegalArgumentException si la fecha de nacimiento o el tipo de contacto no es válido.
     */
    public CPersona(String nombre, String direccion, String telefono, LocalDate fechaNacimiento, String tipoContacto)
            throws NullPointerException, IllegalArgumentException {
        this.setNombre(nombre);
        this.setDireccion(direccion);
        this.setTipoContacto(tipoContacto);
        this.setTelefono(telefono);
        this.setFechaNacimiento(fechaNacimiento);
        this.identificador = ++CPersona.contador;
        this.aficiones = new ArrayList<>();

    }
    
    // ------------------------------------------------------------------------
    //                        GETTERS Y SETTERS
    // ------------------------------------------------------------------------
    /**
     * Devuelve el nombre de contacto.
     * @return nombre
     */
    public String getNombre(){
        return this.nombre;
    }
    
    /**
     * Asigna un nombre al contacto. 
     * @param nombre Nombre que se va a asignar al contacto
     * @throws NullPointerException si el parámetro nombre es nulo
     */
    public void setNombre(String nombre) throws NullPointerException{
        if (nombre==null)
             throw new NullPointerException ("El nombre no puede ser nulo.");  
        this.nombre=nombre;
    }

    /**
     * Devuelve la dirección del contacto
     * @return direccion
     */
    public String getDireccion() {
        return this.direccion;
    }
    
    /**
     * Asigna una dirección al contacto.
     * @param direccion Dirección que se va a asignar al contacto
     * @throws NullPointerException si el parametro direccion es nulo
     */
    public void setDireccion(String direccion) throws NullPointerException{
        if (direccion==null)
             throw new NullPointerException ("La dirección no puede ser nula.");  
        this.direccion = direccion;
    }

    /**
     * Devuelve el teléfono del contacto
     * @return telefono
     */
    public String getTelefono() {
        return this.telefono;
    }
    
    /**
     * Asigna un teléfono al contacto.
     * @param telefono Teléfono que se va asignar al contacto
     * @throws NullPointerException si el parámetro telefono es nulo
     */
    public void setTelefono(String telefono) throws NullPointerException {
        if (telefono==null)
            throw new NullPointerException ("El teléfono no puede ser nula.");  
        this.telefono = telefono;
    }

    /**
     * Devuelve la fecha de nacimiento del contacto
     * @return fecha de nacimiento
     */
    public LocalDate getFechaNacimiento() {
        return this.fechaNacimiento;
    }
    
    /**
     * Asigna una fecha de nacimiento al contacto
     * @param fechaNacimiento Fecha de nacimiento que se va a asignar al contacto
     * @throws NullPointerException si el parámetro fechaNacimiento es nulo
     * @throws IllegalArgumentException si la fecha de nacimiento es anterior a 01/01/1900
     */
    public void setFechaNacimiento(LocalDate fechaNacimiento) 
             throws NullPointerException, IllegalArgumentException {
        if (fechaNacimiento==null)
            throw new NullPointerException ("La fecha de nacimiento no puede ser nula."); 
        else if(fechaNacimiento.isBefore(FECHA_MINIMA))
            throw new IllegalArgumentException("La fecha de nacimiento no puede ser anterior a 1900");
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Devuelve el identificador del contacto
     * @return identificador
     */
    public int getIdentificador() {
        return this.identificador;
    }

    /**
     * Devuelve el tipo de contacto
     * @return tipo de contacto
     */
    public String getTipoContacto() {
        return this.tipoContacto;
    }
    
    /**
     * Asigna el tipo de contacto
     * @param tipoContacto Tipo de contacto
     * @throws NullPointerException si el parámetro tipoContacto es nulo
     * @throws IllegalArgumentException si el parámetro tipoContacto no tiene un valor válido.
     * Posibes valores: "amigos", "familia" o "trabajo".
     */
    public void setTipoContacto(String tipoContacto) throws NullPointerException, IllegalArgumentException {
        if (tipoContacto == null) {
            throw new NullPointerException("El tipo de contacto no puede ser nulo.");
        } else if (!(tipoContacto.equalsIgnoreCase("amigos")) && !(tipoContacto.equalsIgnoreCase("familia"))
                && !(tipoContacto.equalsIgnoreCase("trabajo"))) {
            throw new IllegalArgumentException("Los contactos solo pueden ser de tres tipos: Familia, Trabajo o Amigos.");
        }
        this.tipoContacto = tipoContacto.toLowerCase();
    }
    
    /**
     * Asigna una o más aficiones a un contacto
     * @param aficiones Listado de aficiones
     * @throws NullPointerException si el listado de aficiones es nulo
     */
    public void setAficiones(String... aficiones) throws NullPointerException {
        if (aficiones==null)
            throw new NullPointerException ("El listado de aficiones no puede ser nulo."); 
        for(int i=0; i<aficiones.length;i++){
            this.aficiones.add(aficiones[i]);
        }
    }
    
    /**
     * Devuelve una copia del listado de aficiones del contacto.
     * @return copia de la lista de aficiones.
     */
    public List<String> getAficiones() {
        // Otra alternativa:
        // List<String> listaCopiada= (ArrayList<String>)((ArrayList<String>)aficiones).clone(); 
        
        List<String> listaCopiada = new ArrayList<>();
        listaCopiada.addAll(this.aficiones);
        
        return listaCopiada;
    }

    /**
     * Devuelve el número de contactos creados hasta el momento.
     * @return número de contactos totales
     */
    public static int getContador() {
        return contador;
    }
    
 
    //-------------------------------------------------------------------------
    //                         MÉTODO TOSTRING
    //-------------------------------------------------------------------------
    /**
     * Devuelve una cadena que representa las características del contacto de 
     * forma textual.
     * @return cadena que representa las característias del contacto de forma textual
     */
    @Override
    public String toString(){
        String salida = String.format("#%d;%s;%s;%s;%s;%s;", 
                this.identificador,this.nombre, this.direccion, this.telefono, 
                this.fechaNacimiento, this.tipoContacto);
       
        for(int i=0; i<this.aficiones.size();i++){
            salida +=  this.aficiones.get(i);
            if((i+1)<this.aficiones.size())
                salida += ",";
            else
                salida += ";";
        }
        return salida;
    }
}
