package IntercambioEntreVentanas;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Clase principal de la aplicación
 * @author Salvador Romero Villegas
 */
public class Main extends Application{
    
    public static void main(String[] args) {
        Application.launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        primaryStage.setTitle("Lista de personas.");
        crearContenido(primaryStage);               
        primaryStage.show();
        
    }
    
    
    // Lista de personas
    private List<Persona> listaDePersona=new LinkedList<>() ;
    
    // Disposición donde aparecerán las personas
    private VBox layoutListaPersonas = new VBox(10) ;
    
    /**
     * Actualiza la lista de personas, las añade al layout.
     */
    private void actualizarLista() {
        // Limpiar el layout
        this.layoutListaPersonas.getChildren().clear();
        // Añadir los objetos persona al layout
        for (Persona p:this.listaDePersona)
            this.layoutListaPersonas.getChildren().add(new Text(p.toString()));
    }
    
    
    /**
     * Crea el contenido de la ventana principal: un panel y dos botones, el de 
     * añadir y el de vaciar.
     * @param primaryStage Ventana
     */
    public void crearContenido (Stage primaryStage) {
        // Crear panel
        BorderPane panel = new BorderPane();
        // Crear el botón de añadir
        Button agregar = new Button("Añadir Persona");
        // Crear el botón de vaciar la lista
        Button vaciar = new Button("Vaciar");
        // Añadir los botones en la parte superior del panel
        panel.setTop(new HBox(10, agregar, vaciar));
        // Añade en el centro del pañerl el layout con la lista de personas
        panel.setCenter(layoutListaPersonas);
        
        // Dar funcionalidad al pulsar el botón de añadir
        agregar.setOnAction((a)->  {
            DialogAltaPersona s = new DialogAltaPersona(primaryStage);
            s.showAndWait();
            if (!s.esCancelado())
                listaDePersona.add(s.getPersona());
            actualizarLista();
        } );
        
        // Dar funcionalidad al pulsar el botón de vaciar
        vaciar.setOnAction((a)-> { 
            Alert avisa = new Alert(AlertType.CONFIRMATION,
                    "¿Seguro que desea vaciar la lista?",
                    ButtonType.NO,ButtonType.YES);
            Optional<ButtonType> result = avisa.showAndWait();
            if (result.orElse(ButtonType.NO) == ButtonType.YES)
            {
                this.listaDePersona.clear();
                actualizarLista();
            }
        });
        
        // Mostrar la lista de personas mediante el laayout que manejamos
        actualizarLista();
        
        primaryStage.setScene(new Scene(panel, 300, 300));
    }    
}
