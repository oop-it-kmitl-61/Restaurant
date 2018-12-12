/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import restaurant.User;

/**
 *
 * @author STUDY fuckin HARD
 */
public class UserController{
    Database db;
    Connection conn;
    PreparedStatement pst;
    public UserController(){
        db = new Database();
        conn = db.getConnection();
    }
    public int createAccount(User u){ //สร้าง accout ใหม่
        int res = 0;
        String sql = "";
        
        try{
            sql = "INSERT INTO log_in(uname, pwd, roles, name, surname, email) VALUES(?, ?, ?, ?, ?, ?)";
            pst = (PreparedStatement) conn.prepareStatement(sql);
            pst.setString(1, u.getUname());
            pst.setString(2, u.getPwd());
            pst.setString(3, u.getRoles());
            pst.setString(4, u.getName());
            pst.setString(5, u.getSurname());
            pst.setString(6, u.getEmail());
            res = pst.executeUpdate();
            conn.close();
            pst.close();
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        
        return res;
    }
    public boolean checkLogin(User u){ // Check การ Login
        String sql = "";
        try{
            sql = "SELECT * FROM log_in WHERE uname=? and pwd=? and roles=?";
            pst = (PreparedStatement) conn.prepareCall(sql);
            pst.setString(1, u.getUname());
            pst.setString(2, u.getPwd());
            pst.setString(3, u.getRoles());
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                conn.close();
                pst.close();
                return true;
            }
            else{
                return false;
            }
    
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return false;
    }
    
    public ArrayList<User> getAllUser(){ //ดึงข้อมูลจาก DataBase ทั้งหมด
        ArrayList<User> user = new ArrayList<User>();
        String sql = "";
        try{
            sql = "SELECT * FROM restaurant.log_in";
            PreparedStatement pst = (PreparedStatement) conn.prepareCall(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                String username = rs.getString(1);
                String password = rs.getString(2);
                String role = rs.getString(3);
                String realname = rs.getString(4);
                String surname = rs.getString(5);
                String email = rs.getString(6);
      
                User temp = new User();
                temp.setUname(username);
                temp.setPwd(password);
                temp.setRoles(role);
                temp.setName(realname);
                temp.setSurname(surname);
                temp.setEmail(email);
                user.add(temp);
            }
            pst.close();
            return user;
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error while getting data from Database", "Error", JOptionPane.ERROR_MESSAGE);       
        }
        return user;
    }
    
    public int deleteUser(String username){//User
        String sql = "";
        int res = 0;
        try {
            sql = "Delete from log_in where uname = ?";
            PreparedStatement pst = (PreparedStatement) conn.prepareStatement(sql);
            pst.setString(1, username);
            res = pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return res;
    }
    public int editUser(String username, String name, String surname, String email){
        String sql = "";
        int res = 0;
        try {
            sql = "UPDATE log_in set name = ?, surname = ?, email = ? where uname = ?";
            PreparedStatement pst = (PreparedStatement) conn.prepareStatement(sql);
            pst.setString(1, name);
            pst.setString(2, surname);
            pst.setString(3, email);
            pst.setString(4, username);
            res = pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
}
