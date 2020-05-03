/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DAO.UsuarioDAO;
import Models.Usuario;
import betheheronew.BetheHero;
import betheheronew.Delete;
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
public class DeleteController implements Initializable {
    @FXML
    private Button btVoltar;

    @FXML
    private Button btDeletar;

    @FXML
    private TextField txId;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
            btDeletar.setOnMouseClicked((MouseEvent e) ->{
               Procurar();
            });

           btDeletar.setOnKeyPressed((KeyEvent e)->{
               if(e.getCode() == KeyCode.ENTER){
                  Procurar();
               }
           });
           
           btVoltar.setOnMouseClicked((MouseEvent e) ->{
               Voltar();
           });

           btVoltar.setOnKeyPressed((KeyEvent e)->{
               if(e.getCode() == KeyCode.ENTER){
                  Voltar();
               }
           });
    }    
    
    
     
     public void Deletar(){
        String Id = txId.getText();
        Usuario o = new Usuario();
        o.setId(Id);
        UsuarioDAO dao = new UsuarioDAO();
        
            if(dao.delete(o)){
                System.out.println("Conta Deletada");
                
            }else{      
                Alert alert = new Alert (Alert.AlertType.ERROR);
                alert.setTitle("Erro");
                alert.setHeaderText("Erro ao deletar conta");
                alert.show();
                        
                }         
            }
        
    
     
     
     public void Voltar(){
        Profile p = new Profile ();
        fecha();
        try {
          p.start(new Stage());
        } catch (IOException ex) {
          Logger.getLogger(DeleteController.class.getName()).log(Level.SEVERE, null, ex);
            }
    } 
     
     public void fecha(){
        Delete.getStage().close();
    } 
     
    public void Ir(){
         BetheHero p = new BetheHero ();
        fecha();
        try {
          p.start(new Stage());
        } catch (IOException ex) {
          Logger.getLogger(DeleteController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    public void Procurar(){
         UsuarioDAO dao = new UsuarioDAO();
         List<Usuario> usuarios = dao.getList();
         
         for(int x = 0; x < usuarios.size(); x++){
            if(txId.getText().equals(usuarios.get(x).getId())){
                    x = usuarios.size();
                    Deletar();
                    Ir();
                    Alert alert = new Alert (Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Conta Deletada");
                    alert.setHeaderText("Sua Conta foi deletada com Sucesso");
                    alert.show();
            } else {
              if( x == usuarios.size()-1){
                Alert alert = new Alert (Alert.AlertType.ERROR);
                alert.setTitle("Erro");
                alert.setHeaderText("Id Inválido");
                alert.setContentText("Erro devido ao Id inválido");
                alert.show();
              } 
            } 
         }
    }
    
}
