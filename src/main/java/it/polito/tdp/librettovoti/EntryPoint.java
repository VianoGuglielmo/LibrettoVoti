package it.polito.tdp.librettovoti;

import it.polito.tdp.librettovoti_model.Libretto;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class EntryPoint extends Application {

    @Override
    public void start(Stage stage) throws Exception {
       // Parent root = FXMLLoader.load(getClass().getResource("/fxml/Scene.fxml"));
    	//lezione 14/3/22 h 9:55 GUARDARE BENE
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Scene.fxml"));
 
        Parent root = loader.load();
        
        FXMLController controller = loader.getController();
        
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");
        
        //costruisco il modello visto a lezione 14/3/22 h 9(teoria) e nell'ess h 9:49
        Libretto model = new Libretto(); //creo classe model non ha nulla a che fare con FXML
        controller.setModel(model);
        
        stage.setTitle("JavaFX and Maven");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
