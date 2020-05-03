/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package betheheronew;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author 55419
 */
public class Delete extends Application {
    
    private static Stage stage;
    
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/View/Delete.fxml"));
        Scene scene = new Scene(root);// Coloca FXML EM UMA CENA
        stage.setTitle("Deletar");
        stage.setScene(scene); // COLOCA UMA CENA EM UMA JANELA
        stage.show();// ABRE A JANELA
        setStage(stage);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * @return the stage
     */
    public static Stage getStage() {
        return stage;
    }

    /**
     * @param aStage the stage to set
     */
    public static void setStage(Stage aStage) {
        Delete.stage = aStage;
    }
    
}
