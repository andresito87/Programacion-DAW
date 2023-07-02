package IntercambioEntreVentanas;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Clase que hereda de la clase Stage y que consiste en crear una ventana modal
 * para añadir personas. 
 * 
 * @author Salvador Romero Villegas
 */
public class DialogAltaPersona extends Stage {
    
    private TextField inputNombre = new TextField();
    private TextField inputEdad = new TextField();
    private boolean cancelado = true;
    private Persona p;
    
    /**
     * Constructor de la clase que genera el formulario de alta
     * @param parentStage Ventana padre 
     */
    public DialogAltaPersona (Stage parentStage)  {        
        crearContenido();
        
        //Modalidad "MODAL": bloquear eventos para que no vayan a otras venanas
        initModality(Modality.APPLICATION_MODAL);
        // Establecemos que el propietario es la clase padre
        initOwner(parentStage.getOwner());        
        // Establecer modo de ventana no redimensionable
        resizableProperty().setValue(false);
        // Establecer título de la ventana
        this.setTitle("Añadir persona");

    }
    
    /**
     *  Crear la escena: panel, botones, etc. 
     */
    private void crearContenido()  {
        // Crear panel
        GridPane gp = new GridPane();        
        gp.setVgap(10);
        gp.setHgap(10);
        gp.add(new Label("Nombre:"),0,0);
        gp.add(inputNombre, 0, 1);
        gp.add(new Label("Edad:"),1,0);
        gp.add(inputEdad, 1, 1);
     
        // Crear el botón aceptar y asociarle la funcionalidad
        Button aceptar = new Button(); 
        aceptar.setDefaultButton(true);
        aceptar.setText("_Aceptar");  
        aceptar.setOnAction(a->this.aceptar());
        
        // Crear el botón cancelar y asociarle la funcionalidad
        Button cancel = new Button("_Cancelar");        
        cancel.setCancelButton(true);        
        cancel.setOnAction(a->this.close());
        
        // Añadir los botones al panel
        gp.add(aceptar, 0, 2);
        gp.add(cancel, 1, 2);
                
        // Crear la escena añadiéndole el panel
        Scene s = new Scene(gp);
        setScene(s);
    }
    
    /**
     * Acciones a efectuar si se pulsa en el botón aceptar.
     */
    private void aceptar() {
        try {
            String nombre = inputNombre.getText();
            int edad = Integer.parseInt(inputEdad.getText());
            if (nombre.length()==0)  {
                mostrarError("El nombre debe ser mayor de 0");
            } else if (edad<=0) {
                mostrarError("Edad incorrecta");
            } else  {
                // Crear la persona y asignarle los datos tecleados
                p = new Persona() ;
                p.setEdad(edad) ;
                p.setNombre(nombre) ;
                // Se han aceptado correctamente los datos introducidos
                cancelado = false ;
                // Cerrar esta ventana de alta
                close() ;
            }
        } catch (NumberFormatException e) {
            mostrarError("La edad es incorrecta.");
            inputEdad.setText("");
        }
    }        
    
    /**
     * Ventanita para mostrar mensajes de error
     * @param error 
     */
    private void mostrarError(String error)  {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Error en los datos.");        
        alert.setContentText(error);
        alert.showAndWait();
    }
        
    /**
     * Este método se usa en la clase Main para saber si se aceptó y por tanto
     * se dio a aceptar en esta ventana de alta a una persona o bien si se dio
     * a cancelar el alta.
     * 
     * @return false si no se dio de alta, true si se dio de alta a la persona.
     */
    public boolean esCancelado()  {
        return cancelado;
    }
    
    public Persona getPersona()  {
        return p;
    }
    
}
