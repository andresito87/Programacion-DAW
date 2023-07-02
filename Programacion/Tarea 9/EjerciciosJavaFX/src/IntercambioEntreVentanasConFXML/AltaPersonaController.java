package IntercambioEntreVentanasConFXML;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Clase controladora de la ventana secundaria para dar de alta personas
 * 
 * @author JJBH
 */
public class AltaPersonaController implements Initializable {
    private Stage stagePrincipal;
    
    @FXML
    private TextField campoNombre ;
    
    public void setStagePrincipal(Stage stagePrincipal) {
        this.stagePrincipal = stagePrincipal;
    }
    
    @FXML
    private void aceptarPersona(ActionEvent event) {
        
        // Si se introdujo algún texto, creamos el objeto
        if  (!campoNombre.getText().trim().isEmpty()) {
            // Aquí creo el objeto con los datos de este formulario
            Persona persona1 = new Persona(campoNombre.getText()) ;
            // Añadir la persona recién creada a la lista de personas
            ComunicaVentanas.agregarPersona(persona1) ;
        } else {
            // Mostrar mensaje
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Di�logo de confirmaci�n");
            alert.setContentText("No se introdujo dato alguno.");
            alert.setHeaderText(null);
            Optional<ButtonType> result = alert.showAndWait();
        }
                
        // Cerrar esta ventana
        stagePrincipal.close();
    }
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}
