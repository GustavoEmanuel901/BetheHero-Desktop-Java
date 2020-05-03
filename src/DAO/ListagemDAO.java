/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import JDBC.ConnectionFactory;
import Models.Incidents;
import Models.Listagem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 55419
 */
public class ListagemDAO {
    
    private Connection con;
    
    public ListagemDAO() {
        this.con = new ConnectionFactory().getConnection();
    }
     
     public List<Listagem> getList(){
        List<Listagem> incidents = new ArrayList();
        String sql = "select i.title, i.description, i.value, o.name, o.email, o.whatsapp from incidents as i inner join ongs as o on (o.id = i.ong_id) "; 
 
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Listagem l = new Listagem();
                l.setTitle(rs.getString("title"));
                l.setDescription(rs.getString("description"));
                l.setValue(rs.getFloat("value"));
                l.setName(rs.getString("name"));
                l.setEmail(rs.getString("email"));
                l.setWhatsapp(rs.getString("whatsapp"));
                incidents.add(l);
            }
            stmt.close();
            rs.close();
            con.close();
        } catch (SQLException ex) {
           System.out.println("ERRO, select");
           return null;
        }
        return incidents;
    }
  
     
    
}
