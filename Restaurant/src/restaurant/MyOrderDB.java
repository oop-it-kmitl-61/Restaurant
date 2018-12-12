/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant;

import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *
 * @author STUDY fuckin HARD
 */
// เก็บ Array ของแต่ละ Order
public class MyOrderDB {
    private ArrayList<OrderedDB> odb = new ArrayList<OrderedDB>();

    public void setOdb(ArrayList<OrderedDB> odb) {
        this.odb = odb;
    }
    private double price_include_vat;
    private double priceTotal;
    private String user;
    private int orderID;
    private Timestamp date;
    
    public MyOrderDB(int orderID, ArrayList<OrderedDB> odb, double priceTotal, double price_include_vat, Timestamp date, String user) {
        this.price_include_vat = price_include_vat;
        this.priceTotal = priceTotal;
        this.user = user;
        this.orderID = orderID;
        this.date = date;
        this.odb = odb;
    }
    public ArrayList<OrderedDB> getOdb() {
        return odb;
    }

    public double getPrice_include_vat() {
        return price_include_vat;
    }

    public double getPriceTotal() {
        return priceTotal;
    }

    public String getUser() {
        return user;
    }

    public int getOrderID() {
        return orderID;
    }

    public Timestamp getDate() {
        return date;
    }
}
