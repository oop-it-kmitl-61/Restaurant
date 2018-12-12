/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.mysql.jdbc.PreparedStatement;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import restaurant.MyOrder;
import restaurant.MyOrderDB;
import restaurant.OrderedDB;

        

/**
 *
 * @author STUDY fuckin HARD
 */
public class OrderController{
    Database db;
    Connection conn;
    public OrderController(){
        db = new Database();
        conn = db.getConnection();
        
    }
    
    public int insertOrder(MyOrder myo){ //เพิ่ม Order ลงใน Database
        Gson gson = new Gson();
        String myJson = gson.toJson(myo.getO());
        int res = 0;
        String sql = "";
        
        try{
            sql = "INSERT INTO order_foods(detail, price_total, price_include_vat, orderDate, user) VALUES(cast(? as json), ?, ?, ?, ?)";
            PreparedStatement pst = (PreparedStatement) conn.prepareStatement(sql);
            pst.setString(1, myJson);
            pst.setDouble(2, myo.getPriceTotal());
            pst.setDouble(3, myo.getPrice_include_vat());
            pst.setTimestamp(4, myo.getDate());
            pst.setString(5, myo.getUser());
            res = pst.executeUpdate();
            conn.close();
            pst.close();
            
        }
        catch(SQLException ex){
            System.out.println(ex);
        }
        
        return res;
    }

    public ArrayList<MyOrderDB> getDataDB(){ //ดึงข้อมูลจาก DataBase ทั้งหมด
        ArrayList<MyOrderDB> myoDB = new ArrayList<MyOrderDB>();
        Gson gson = new Gson();
        String sql = "";
        try{
            sql = "SELECT * FROM restaurant.order_foods";
            PreparedStatement pst = (PreparedStatement) conn.prepareCall(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                int orderID = rs.getInt(1);
                Type orderedDBType = new TypeToken<ArrayList<OrderedDB>>(){}.getType(); //ดึง Type
                ArrayList<OrderedDB> oDB = gson.fromJson(rs.getString(2), orderedDBType); // ดึงค่าจาก json มาเก็บในรูปแบบ arraylist เหมือนเดิม
                double priceTotal = rs.getDouble(3);
                double price_include_vat = rs.getDouble(4);
                Timestamp date = rs.getTimestamp(5);
                String user = rs.getString(6);
                MyOrderDB temp = new MyOrderDB(orderID, oDB, priceTotal, price_include_vat, date, user);
                myoDB.add(temp);
            }
            pst.close();
            return myoDB;
        }
        catch(JsonSyntaxException | SQLException ex){
            JOptionPane.showMessageDialog(null, "Error while getting data from Database", "Error", JOptionPane.ERROR_MESSAGE);       
        }
        return myoDB;
    }
}