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
import Utils.Email;
import betheheronew.BetheHero;
import betheheronew.Cadastro;
import betheheronew.Profile;
import java.io.IOException;
import java.net.URL;
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
public class CadastroController implements Initializable {
      @FXML
    private Button btVoltar;

    @FXML
    private TextField txUf;

    @FXML
    private TextField txCidade;

    @FXML
    private Button btCadastrar;

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
         btVoltar.setOnMouseClicked((MouseEvent e) ->{
            Volta();
        });
        
        btVoltar.setOnKeyPressed((KeyEvent e)->{
            if(e.getCode() == KeyCode.ENTER){
               Volta();
            }
        });
        
        btCadastrar.setOnMouseClicked((MouseEvent e) ->{
            checkCampos();
        });
        
        btCadastrar.setOnKeyPressed((KeyEvent e)->{
            if(e.getCode() == KeyCode.ENTER){
               checkCampos();
            }
        });
    }    
    
    public void cadastraPessoa(){
        String nome = txNome.getText(); 
        String email = txEmail.getText();
        String whatsapp = txWhatsapp.getText();
        String cidade = txCidade.getText();
        String uf = txUf.getText();
        
        Usuario o = new Usuario(nome, email, whatsapp, cidade, uf);
        UsuarioDAO dao = new UsuarioDAO();
        if(dao.add(o)){
            Ir();
            Alert alert = new Alert (Alert.AlertType.CONFIRMATION);
            alert.setTitle("Cadastro Realizado com Sucesso");
            alert.setHeaderText("IMPORTANTE: Anote seu ID de Acesso " + o.getId());
            alert.show();
            String Mensagem = "Olá " + txNome.getText() + "," + " Seja Bem Vindo ao Be the Hero. " + "Seu ID de Acesso é " + o.getId();
            Email envia = new Email("Cadastro Be The Hero", Mensagem, email);
            envia.enviar();
        }else{
            Alert alert = new Alert (Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Erro com Cadastro, Tente Novamente");
            alert.show();
        }
    }
    
     public void Ir(){
        BetheHero lo = new BetheHero ();
        fecha();
        try {
            lo.start(new Stage());
        } catch (IOException ex) {
          Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
      public void fecha(){
        Cadastro.getStage().close();
    }    
    
    public void Volta(){
        BetheHero lo = new BetheHero ();
        fecha();
        try {
            lo.start(new Stage());
        } catch (IOException ex) {
          Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void checkCampos(){
        if(txNome.getText().equals("") ||
           txEmail.getText().equals("") ||
           txWhatsapp.getText().equals("")||
           txCidade.getText().equals("") ||
           txUf.getText().equals("")){
            
                Alert alert = new Alert (Alert.AlertType.ERROR);
                alert.setTitle("Erro");
                alert.setHeaderText("Preencha Todos os Campos");
                alert.show();
        } else {
           
            cadastraPessoa();
        }
    }
    
  
}
