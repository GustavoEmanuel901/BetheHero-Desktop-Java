/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import JDBC.ConnectionFactory;
import Models.Usuario;
import Utils.GerarId;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 55419
 */

public class UsuarioDAO {
    private Connection con;


    GerarId id = new GerarId();


    public UsuarioDAO() {
        this.con = new ConnectionFactory().getConnection();
    }
    
    public boolean add(Usuario u){
        String sql = "insert into usuario(id, nome, email, telefone, cidade, uf) VALUES (?,?,?,?,?,?); ";
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            u.setId(id.GerarHex());
            stmt.setString(1, u.getId());
            stmt.setString(2, u.getNome());
            stmt.setString(3, u.getEmail());
            stmt.setString(4, u.getWhatsapp());
            stmt.setString(5, u.getCidade());
            stmt.setString(6, u.getUf());
            stmt.execute();
            stmt.close();
            con.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }    
    }
    
    public boolean update(Usuario u){
        String sql = "UPDATE usuario SET nome = ?, email = ?, telefone = ?, cidade = ?, uf = ? WHERE id=? ";
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getEmail());
            stmt.setString(3, u.getWhatsapp());
            stmt.setString(4, u.getCidade());
            stmt.setString(5, u.getUf());
            stmt.setString(6, u.getId());
            stmt.execute();
            stmt.close();
            con.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }    
    }
    
    public boolean delete(Usuario u){
        String sql = "delete from usuario where id=?";
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, u.getId());
            stmt.execute();
            stmt.close();
            con.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }    
    }
    
   public List<Usuario> getList(){
        List<Usuario> usuarios = new ArrayList();
        String sql = "SELECT * FROM usuario";
 
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Usuario u = new Usuario();
                u.setId(rs.getString("id"));
                u.setNome(rs.getString("nome"));
                u.setEmail(rs.getString("email"));
                u.setWhatsapp(rs.getString("telefone"));
                u.setCidade(rs.getString("Cidade"));
                u.setUf(rs.getString("uf"));
                usuarios.add(u);
            }
            stmt.close();
            rs.close();
            con.close();
        } catch (SQLException ex) {
           System.out.println("ERRO, select");
           return null;
        }
        return usuarios;
    }
    
}
