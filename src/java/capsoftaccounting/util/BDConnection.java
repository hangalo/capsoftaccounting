/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capsoftaccounting.util;

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
        
        //*jdbc:ucanaccess:////servername/sharename/foldername/Database1.accdb;showSchema=true*/
        
         
      //String msAccDB = "C:/Users/viceeconomo/Documents/NetBeansProjects/capsoftaccounting/msacess/MX-M900.MDB";
      //String msAccDB = "C:\\Pacioli Project\\test\\Accounts\\MX-M900.MDB";
    String msAccDB = "\\\\192.168.0.68\\economo generale\\Italsoft00\\XP-MACRO\\XP-DATI\\XP-M900\\MX-M900.MDB";
         
   //  String serverPath ="192.168.0.164";
   //   String msAccDB = "/Public/db_capitolari/Capitolari2018.accdb";
   ///String dbURL = "jdbc:ucanaccess:////"+serverPath + msAccDB; 
       
               
         String dbURL = "jdbc:ucanaccess:////"+msAccDB; 
         System.out.println("DbURL "+dbURL);
   
             
        
        try {
            //Class.forName(driver);
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            connection = DriverManager.getConnection(dbURL); 
            System.out.println(">>>>>>>Sucess");
        } catch  (ClassNotFoundException | SQLException ex) {
            System.err.println("Error: " + ex.fillInStackTrace());
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
