 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author STUDY fuckin HARD
 */
public class Database {
    private Connection conn;
    private String dbuser;
    private String dbpassw;
    private String dbName;
    private String url;
 
    public Database(){
        dbuser = "root";
        dbpassw = "apple";
        dbName = "restaurant";
        url = "jdbc:mysql://localhost:3306/restaurant";
        
    }
    public Connection getConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        
        try{
            conn = (Connection) DriverManager.getConnection(url, dbuser, dbpassw);
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        return conn;
    }
    
}
