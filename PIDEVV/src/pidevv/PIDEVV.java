/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidevv;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author DELL
 */
public class PIDEVV extends Application {
    
      @Override
    public void start(Stage stage) {
        
         Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/Interfaces/IPage.fxml"));
            Scene scene = new Scene(root);
            
        stage.setScene(scene);
        stage.setTitle("Bienvenue à HealthHaven !");
        stage.show();
        } catch (IOException ex) {
            Logger.getLogger(PIDEVV.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
