/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DAO.UsuarioDAO;
import Models.Usuario;
import betheheronew.Profile;
import betheheronew.Update;
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
public class UpdateController implements Initializable {

    @FXML
    private Button btVoltar;

    @FXML
    private TextField txCity;

    @FXML
    private TextField txUf;

    @FXML
    private Button btAtualizar;

    @FXML
    private TextField txId;

    @FXML
    private TextField txWhatsapp;

    @FXML
    private TextField txNome;

    @FXML
    private TextField txEmail;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         btAtualizar.setOnMouseClicked((MouseEvent e)->{
            checkCampos();
        });
         
        btAtualizar.setOnKeyPressed((KeyEvent e)->{
           if(e.getCode() == KeyCode.ENTER){
             checkCampos();
           }
        });
        
         btVoltar.setOnMouseClicked((MouseEvent e)->{
            Ir();
        });
         
        btVoltar.setOnKeyPressed((KeyEvent e)->{
           if(e.getCode() == KeyCode.ENTER){
             Ir();
           }
        });
    }    
    
    public void atualizaPessoa(){
        String nome = txNome.getText(); 
        String email = txEmail.getText();
        String whatsapp = txWhatsapp.getText();
        String cidade = txCity.getText();
        String uf = txUf.getText();
        String id = txId.getText();
        
       
        Usuario u = new Usuario(id, nome, email, whatsapp, cidade, uf);
        UsuarioDAO dao = new UsuarioDAO();
        
        
            if(dao.update(u)){
                //x = usuarios.size();
                Procurar();
            }else{
                Alert alert = new Alert (Alert.AlertType.ERROR);
                alert.setTitle("Erro");
                alert.setHeaderText("Erro com a atualização, Tente Novamente");
                alert.show();
            
        }
    }
    
     public void Ir(){
        Profile p = new Profile ();
        fecha();
        try {
            p.start(new Stage());
        } catch (IOException ex) {
          Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
    public void fecha(){
      Update.getStage().close();
    }
      
    public void Procurar(){
         UsuarioDAO dao = new UsuarioDAO();
         List<Usuario> usuarios = dao.getList();
         
         for(int x = 0; x < usuarios.size(); x++){
            if(txId.getText().equals(usuarios.get(x).getId())){
                    x = usuarios.size();
                    Ir();
                    Alert alert = new Alert (Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Atualizado com Sucesso");
                    alert.setHeaderText("Seu Registro foi Atuliazado com Sucesso");
                    alert.show();
                    
            } else {
              if( x == usuarios.size()-1){
                Alert alert = new Alert (Alert.AlertType.ERROR);
                alert.setTitle("Erro");
                alert.setHeaderText("Id Inválido");
                alert.setContentText("O id digitado é inválido");
                alert.show();
              } 
            } 
         }
    }
    
    public void checkCampos(){
        if(txNome.getText().equals("") ||
           txEmail.getText().equals("") ||
           txWhatsapp.getText().equals("")||
           txCity.getText().equals("") ||
           txUf.getText().equals("") ||
           txId.getText().equals("")){
            
                Alert alert = new Alert (Alert.AlertType.ERROR);
                alert.setTitle("Erro");
                alert.setHeaderText("Preencha Todos os Campos");
                alert.show();
        } else {
           
            atualizaPessoa();
        }
    
}
    
}
