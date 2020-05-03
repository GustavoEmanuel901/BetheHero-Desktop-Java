/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DAO.OngDAO;
import Models.Ong;
import betheheronew.ListOngs;
import betheheronew.Profile;
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
public class ListOngsController implements Initializable {

    
    @FXML
    private TableColumn<Ong, String> clmCidade;

    @FXML
    private TableColumn<Ong, String> clmUf;

    @FXML
    private Button btVoltar;

    @FXML
    private TextField txPesquisa;

    @FXML
    private TableColumn<Ong, String> clmNome;

    @FXML
    private Button btPesquisa;

    @FXML
    private TableColumn<Ong, String> clmWhatsapp;

    @FXML
    private TableColumn<Ong, String> clmEmail;
    
    @FXML
    private TableView<Ong> ongs;
    
    private ObservableList<Ong> list = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        btPesquisa.setOnMouseClicked((MouseEvent e)->{
            ongs.setItems(busca());
        });
        
        btVoltar.setOnMouseClicked((MouseEvent e) ->{
            voltar();
        });

        btVoltar.setOnKeyPressed((KeyEvent e)->{
            if(e.getCode() == KeyCode.ENTER){
              voltar();
            }
        });
        
        initTable();
        
        txPesquisa.setOnKeyReleased((KeyEvent e) ->{
            ongs.setItems(busca());
        });
        
        
    }    
    
    
     public void initTable(){
        
        clmNome.setCellValueFactory(new PropertyValueFactory("name"));
        clmEmail.setCellValueFactory(new PropertyValueFactory("email"));
        clmWhatsapp.setCellValueFactory(new PropertyValueFactory("whatsapp"));
        clmCidade.setCellValueFactory(new PropertyValueFactory("city"));
        clmUf.setCellValueFactory(new PropertyValueFactory("uf"));
        ongs.setItems(atualizaTabela());
    }
    
    public ObservableList<Ong> atualizaTabela(){ 
        OngDAO dao = new OngDAO();
        list = FXCollections.observableArrayList(dao.getList());
        return list;
    }

    
    public void voltar(){
        Profile p = new Profile ();
        fecha();
        try {
          p.start(new Stage());
        } catch (IOException ex) {
          Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
     
     public void fecha(){
        ListOngs.getStage().close();
    } 
     
    private ObservableList<Ong> busca(){
        ObservableList<Ong> ongPesquisa = FXCollections.observableArrayList();
        for(int x= 0; x < list.size(); x++){
            if(list.get(x).getCity().toLowerCase().contains(txPesquisa.getText().toLowerCase()) || 
               list.get(x).getName().toLowerCase().contains(txPesquisa.getText().toLowerCase()) ||
               list.get(x).getUf().toLowerCase().contains(txPesquisa.getText().toLowerCase())){
                
                    ongPesquisa.add(list.get(x));
            }
        }
        return ongPesquisa;
    }
    
}
