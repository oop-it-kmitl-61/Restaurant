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
import menu.Menu;

/**
 *
 * @author STUDY fuckin HARD
 */
public class MenuController {
//    ArrayList<Menu> menu = new ArrayList<Menu>();
    Database db;
    Connection conn;
    public MenuController(){
        db = new Database();
        conn = db.getConnection();
    }
    public int insertMenu(String dbName, String menuID, String name, double price){ //เพิ่มเมนูอาหารใหม่
        String sql = "";
        int res = 0;
        try {
            sql = "Insert into " + dbName + " (menuID, MenuName, price) VALUES(?, ?, ?)";
            PreparedStatement pst = (PreparedStatement) conn.prepareStatement(sql);
            pst.setString(1, menuID);
            pst.setString(2, name);
            pst.setDouble(3, price);
            res = pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
    
    public ArrayList<Menu> getDrinkMenu(){//นำเมนูที่เก็บใน Database ออกมาเก็บเป็น arraylist
        String sql = "";
        ArrayList<Menu> myMenu = new ArrayList<Menu>();
        try {
            sql = "SELECT * FROM restaurant.food_drink";
            PreparedStatement pst = (PreparedStatement) conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                Menu temp = new Menu(rs.getString(1), rs.getString(2), rs.getDouble(3));
                myMenu.add(temp);
            }
            pst.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error while get Drink menu", "Error", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return myMenu;
    }
    
    public ArrayList<Menu> getMainMenu(){//นำเมนูที่เก็บใน Database ออกมาเก็บเป็น arraylist
        String sql = "";
        ArrayList<Menu> myMenu = new ArrayList<Menu>();
        try {
            sql = "SELECT * FROM restaurant.food_main";
            PreparedStatement pst = (PreparedStatement) conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                Menu temp = new Menu(rs.getString(1), rs.getString(2), rs.getDouble(3));
                myMenu.add(temp);
            }
            pst.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error while get Main menu", "Error", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return myMenu;
    }
    
    public ArrayList<Menu> getSnackMenu(){//นำเมนูที่เก็บใน Database ออกมาเก็บเป็น arraylist
        String sql = "";
        ArrayList<Menu> myMenu = new ArrayList<Menu>();
        try {
            sql = "SELECT * FROM restaurant.food_snack";
            PreparedStatement pst = (PreparedStatement) conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                Menu temp = new Menu(rs.getString(1), rs.getString(2), rs.getDouble(3));
                myMenu.add(temp);
            }
            pst.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error while get snack menu", "Error", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return myMenu;
    }
    
    public int deleteMenu(String dbName, String menuID){//ลบเมนูอาหาร
        String sql = "";
        int res = 0;
        try {
            sql = "Delete from " + dbName +" where menuID = ?";
            PreparedStatement pst = (PreparedStatement) conn.prepareStatement(sql);
            pst.setString(1, menuID);
            res = pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return res;
    }
    public int editMenu(String dbName, String menuID, String MenuName, double price){
        String sql = "";
        int res = 0;
        try {
            sql = "UPDATE " + dbName + " set MenuName = ?, price = ? where menuID = ?";
            PreparedStatement pst = (PreparedStatement) conn.prepareStatement(sql);
            pst.setString(1, MenuName);
            pst.setDouble(2, price);
            pst.setString(3, menuID);
            res = pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
}
