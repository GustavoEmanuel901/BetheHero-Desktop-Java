/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DAO.OngDAO;
import DAO.UsuarioDAO;
import Models.Ong;
import Models.Usuario;
import betheheronew.BetheHero;
import betheheronew.Cadastro;
import betheheronew.Profile;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author 55419
 */
public class LoginController implements Initializable {

    @FXML
    private Button btEntrar;

    @FXML
    private TextField txEntrar;

    @FXML
    private Button btCadastrar;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
            btCadastrar.setOnMouseClicked((MouseEvent e) ->{
               IrCadastro();
           });

           btCadastrar.setOnKeyPressed((KeyEvent e)->{
               if(e.getCode() == KeyCode.ENTER){
                  IrCadastro();
               }
           });

           btEntrar.setOnMouseClicked((MouseEvent e) ->{
               logar();
           });

           btEntrar.setOnKeyPressed((KeyEvent e)->{
               if(e.getCode() == KeyCode.ENTER){
                  logar();
               }
           });
    }    
    
    public void IrCadastro(){
        Cadastro co = new Cadastro ();
        fecha();
        try {
          co.start(new Stage());
        } catch (IOException ex) {
          Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
     
     public void logar(){
         UsuarioDAO dao = new UsuarioDAO();
         List<Usuario> usuarios = dao.getList();
         
         for(int x = 0; x < usuarios.size(); x++){
            if(txEntrar.getText().equals(usuarios.get(x).getId())){
                Profile lc = new Profile();
                x = usuarios.size();
                //id();
                fecha();
                try {
                    lc.start(new Stage());
                    //System.out.println(id());
                } catch (IOException ex) {
                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
              if( x == usuarios.size()-1){
                Alert alert = new Alert (Alert.AlertType.ERROR);
                alert.setTitle("Erro");
                alert.setHeaderText("Login Inválido");
                alert.setContentText("Erro devido a usuario inválido");
                alert.show();
              } 
            } 
         }
    }
     
     public void fecha(){
        BetheHero.getStage().close();
    } 
     
        
    
}
