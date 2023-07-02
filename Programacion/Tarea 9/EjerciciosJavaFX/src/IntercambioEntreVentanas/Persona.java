package IntercambioEntreVentanas;



/**
 * Sencilla clase Persona con dos atributos: nombre y edad
 * @author Salvador Romero
 */
public class Persona {
    private int edad;
    private String nombre;

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String persona) {
        this.nombre = persona;
    }
    
    @Override
    public String toString() {
        return this.nombre + " (" + this.edad + ")";
    }
    
}
