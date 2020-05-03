/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import JDBC.ConnectionFactory;
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
public class OngDAO {
    private Connection con;
    
    public OngDAO() {
        this.con = new ConnectionFactory().getConnection();
    }
    
   public List<Ong> getList(){
        List<Ong> ongs = new ArrayList();
        String sql = "SELECT * FROM ongs";
 
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Ong o = new Ong();
                //o.setId(rs.getString("id"));
                o.setName(rs.getString("name"));
                o.setEmail(rs.getString("email"));
                o.setWhatsapp(rs.getString("whatsapp"));
                o.setCity(rs.getString("city"));
                o.setUf(rs.getString("uf"));
                ongs.add(o);
            }
            stmt.close();
            rs.close();
            con.close();
        } catch (SQLException ex) {
           System.out.println("ERRO, select");
           return null;
        }
        return ongs;
    }
}
