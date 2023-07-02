package IntercambioEntreVentanasConFXML;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * Clase controladora de la ventana Principal
 * 
 * @author JJBH
 */
public class PrincipalController implements Initializable {

    // La referencia al programa principal se tiene en esta variable de tipo
    // Principal. La declaramos privado para que solo se pueda acceder desde 
    // este controlador. 
    private ComunicaVentanas ProgramaPrincipal;

    // Un elemento clave a destacar en JavaFX es la notaci�n @FXML, que sirve
    // para indicar al c�digo que el elemento tiene referencia en el 
    // archivo FXML de la vista (Principal.fxml).
    @FXML
    private void nuevaVentana(ActionEvent event) {
        ProgramaPrincipal.mostrarVentanaAltaPersona() ;
    }
    
    @FXML
    private void listarPersonas(ActionEvent event) {
        ProgramaPrincipal.listado();
    }

    public void setProgramaPrincipal(ComunicaVentanas ProgramaPrincipal) {
        this.ProgramaPrincipal = ProgramaPrincipal;
    }

    /**
     * En JavaFX 2.1 y versiones anteriores, era necesario que las 
     * clases controlador implementaran la interfaz Initializable para
     * recibir notificaciones cuando el contenido del documento de FXML 
     * asociado se hab�a cargado por completo. En JavaFX 2.2 y posteriores, 
     * esto ya no es necesario.
     * Una instancia de la clase FXMLLoader simplemente busca el método
     * initialize() en el controlador y lo llama, si est� disponible.
     * Hay que tener en cuenta que, al igual que otros métodos de devoluci�n de
     * llamada de FXML, como los manejadores de eventos,este método debe ser
     * anotado con la anotaci�n @FXML si no es p�blico.
     * 
    */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
