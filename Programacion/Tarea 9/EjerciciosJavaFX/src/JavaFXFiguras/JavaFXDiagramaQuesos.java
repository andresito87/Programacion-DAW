package JavaFXFiguras;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Crear un diagrama de "quesitos"
 * @author JJBH
 */
public class JavaFXDiagramaQuesos extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        // T�tulo de la ventana
        primaryStage.setTitle("Estadísticas uso de s.o. móviles.");

        // Crear el diagrama
        PieChart pieChart = new PieChart();

        // Instanciar las porciones con los datos que nos interesan
        PieChart.Data queso1 = new PieChart.Data("Android", 47);
        PieChart.Data queso2 = new PieChart.Data("iPhone"  , 27);
        PieChart.Data queso3 = new PieChart.Data("Windows Phone" , 13);
        PieChart.Data queso4 = new PieChart.Data("Blackberry" , 13);

        // A�adir las porciones al diagrama
        pieChart.getData().add(queso1);
        pieChart.getData().add(queso2);
        pieChart.getData().add(queso3);
        pieChart.getData().add(queso4);

        // Crear un layout y a�adir el diagrama
        VBox vbox = new VBox(pieChart);

        // Crear la escena
        Scene scene = new Scene(vbox, 400, 190);

        // A�adir la escena al escenario
        primaryStage.setScene(scene);
        // Mostrar el escenario
        primaryStage.show();
    }

   

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
