/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author 55419
 */
public class ConnectionFactory {
    
    public Connection getConnection() {
        
        try {
            String nomeUsuario  = "postgres";
            String senhaUsuario = "gustavo";
            String enderecoServidor = "localhost";
            String nomeBanco = "academia";

            return DriverManager.getConnection("jdbc:postgresql://"+enderecoServidor+
                        "/"+nomeBanco, nomeUsuario, senhaUsuario);
        } catch (SQLException ex) {
            System.out.println("ERROOO");
            throw new RuntimeException(ex);
        }
       
        
    }
}
