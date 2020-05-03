/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import JDBC.ConnectionFactory;
import Models.Incidents;
import Models.Ong;
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
public class IncidentsDAO {
    
    private Connection con;
    
    Ong o = new Ong();

    public IncidentsDAO() {
        this.con = new ConnectionFactory().getConnection();
    }
    

    
      public List<Incidents> getList(){
        List<Incidents> incidents = new ArrayList();
        String sql = "select * from incidents"; 
 
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Incidents i = new Incidents();
                i.setTitle(rs.getString("title"));
                i.setDescription(rs.getString("description"));
                i.setValue(rs.getFloat("value"));
                incidents.add(i);
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
