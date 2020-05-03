/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DAO.IncidentsDAO;
import DAO.ListagemDAO;
import Models.Incidents;
import Models.Listagem;
import betheheronew.BetheHero;
import betheheronew.Delete;
import betheheronew.ListOngs;
import betheheronew.Profile;
import betheheronew.Update;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author 55419
 */

public class ProfileController implements Initializable {
    @FXML
    private TableColumn<Listagem, String> clmOng;

    @FXML
    private Button btUpdate;

    @FXML
    private TextField txPesquisa;

    @FXML
    private Button btLogout;

    @FXML
    private TableColumn<Listagem, String> clmNome;

    @FXML
    private Button btDeletar;

    @FXML
    private Button btPesquisa;
    
    @FXML
    private Button btOngs;

    @FXML
    private TableView<Listagem> casos;

    @FXML
    private TableColumn<Listagem, String> clmWhatsapp;

    @FXML
    private TableColumn<Listagem, String> clmEmail;

    @FXML
    private TableColumn<Listagem, String> clmDescricao;

    @FXML
    private TableColumn<Listagem, Float> clmValor;
    /**
     * Initializes the controller class.
     */
    
    private ObservableList<Listagem> list = FXCollections.observableArrayList();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        initTable();
        
        btPesquisa.setOnMouseClicked((MouseEvent e)->{
            casos.setItems(busca());
        });
        
        txPesquisa.setOnKeyReleased((KeyEvent e) ->{
            casos.setItems(busca());
        });
        
        btLogout.setOnMouseClicked((MouseEvent e)->{
            Logout();
        });
         
        btLogout.setOnKeyPressed((KeyEvent e)->{
           if(e.getCode() == KeyCode.ENTER){
             Logout();
           }
        });
        
        btUpdate.setOnMouseClicked((MouseEvent e)->{
            IrUpdate();
        });
         
        btUpdate.setOnKeyPressed((KeyEvent e)->{
           if(e.getCode() == KeyCode.ENTER){
             IrUpdate();
           }
        });
        
        btOngs.setOnMouseClicked((MouseEvent e)->{
            IrOngs();
        });
         
        btOngs.setOnKeyPressed((KeyEvent e)->{
           if(e.getCode() == KeyCode.ENTER){
             IrOngs();
           }
        });
        
        btDeletar.setOnMouseClicked((MouseEvent e)->{
            IrDeletar();
        });
         
        btDeletar.setOnKeyPressed((KeyEvent e)->{
           if(e.getCode() == KeyCode.ENTER){
             IrDeletar();
           }
        });
        
    }    
    
    
    public void initTable(){
        clmNome.setCellValueFactory(new PropertyValueFactory("title"));
        clmDescricao.setCellValueFactory(new PropertyValueFactory("description"));
        clmValor.setCellValueFactory(new PropertyValueFactory("value"));
        clmOng.setCellValueFactory(new PropertyValueFactory("name"));
        clmEmail.setCellValueFactory(new PropertyValueFactory("email"));
        clmWhatsapp.setCellValueFactory(new PropertyValueFactory("whatsapp"));
        casos.setItems(atualizaTabela());
    }
    
    public ObservableList<Listagem> atualizaTabela(){ 
        ListagemDAO dao = new ListagemDAO();
        list = FXCollections.observableArrayList(dao.getList());
        return list;
    }
    
    private ObservableList<Listagem> busca(){
        ObservableList<Listagem> casosPesquisa = FXCollections.observableArrayList();
        for(int x= 0; x < list.size(); x++){
            if(list.get(x).getTitle().toLowerCase().contains(txPesquisa.getText().toLowerCase()) || 
               list.get(x).getName().toLowerCase().contains(txPesquisa.getText().toLowerCase()) ||
               list.get(x).getDescription().toLowerCase().contains(txPesquisa.getText().toLowerCase())){
                
                    casosPesquisa.add(list.get(x));
            }
        }
        
        return casosPesquisa;
    }
    
    public void Logout(){
        BetheHero b = new BetheHero();
        fecha();
        try {
            b.start(new Stage());
        } catch (IOException ex) {
            Logger.getLogger(ProfileController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void IrUpdate(){
        Update u = new Update();
        fecha();
        try {
            u.start(new Stage());
        } catch (IOException ex) {
            Logger.getLogger(ProfileController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void IrOngs(){
        ListOngs lo = new ListOngs ();
        fecha();
        try {
            lo.start(new Stage());
        } catch (IOException ex) {
          Logger.getLogger(ProfileController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
    public void IrDeletar(){
        Delete d = new Delete ();
        fecha();
        try {
            d.start(new Stage());
        } catch (IOException ex) {
          Logger.getLogger(ProfileController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
      public void fecha(){
        Profile.getStage().close();
    }    
}
