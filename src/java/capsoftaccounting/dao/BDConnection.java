/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capsoftaccounting.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author informatica
 */
public class BDConnection {
    public static Connection getConnection()  {
        Connection connection;
        
            String databaseNetworkPath = "jdbc:ucanaccess:////192.168.0.4/etc/Player.accdb";
       
            
         String msAccDB = "D:/desenvolvimento/msacess/Player.accdb";
         String dbURL = "jdbc:ucanaccess://" + msAccDB; 
   
       
        
        
        try {
            //Class.forName(driver);
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            connection = DriverManager.getConnection(dbURL); 
            System.out.println(">>>>>>>Conexao bem sucessidada");
        } catch  (ClassNotFoundException | SQLException ex) {
            System.err.println("Erro na conexao com a base de dados: " + ex.getMessage());
            return null;
        }
        return connection;
    }

    public static void closeConnection(Connection conn){
        close(conn, null, null);    
    }
    
     public static void closeConnection(Connection conn, PreparedStatement ps){
        close(conn, ps, null);    
    }
     
      public static void closeConnection(Connection conn, PreparedStatement ps, ResultSet rs){
        close(conn, ps, rs);    
    }
    
    
    private static void close(Connection conn, PreparedStatement ps, ResultSet rs) {

        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }

        } catch (SQLException ex) {
            System.err.println("Erro ao desalocar recurso: "+ex.getMessage());
        }

    }

}
