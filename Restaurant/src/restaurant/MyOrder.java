/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant;

import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author STUDY fuckin HARD
 */
//เป็นคลาสที่รวมเมนูของ Order
public class MyOrder{
    private ArrayList<Order> o = new ArrayList<Order>();
    private double price_include_vat;
    private double price_vat;
    private double priceTotal;
    private String user;
    private double receive;
    private double change;
    private Timestamp date;
    private int tableNumber;
    public double getPrice_vat() {
        DecimalFormat df = new DecimalFormat(".##");
        double out = Double.parseDouble(df.format(getPriceTotal()*vat));
        return out;
    }
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Date date) {
        java.sql.Timestamp sqlTime = new java.sql.Timestamp(date.getTime());
        this.date = sqlTime;
    }
    public double getReceive() {
        return receive;
    }

    public void setReceive(double receive) {
        this.receive = receive;
    }

    public double getChange() {
        return change;
    }

    public void setChange(double change) {
        this.change = change;
    }
            
    final double vat = 0.07;
    public void addFood(Order o){
        this.o.add(o);
    }
    public void showFood(){
        for(int i=0; i<o.size(); i++){
            System.out.println(o.get(i).getQuantity() + " " + o.get(i).getName() + " " + o.get(i).getPrice_each() + " " + o.get(i).getPrice());
        }
    }
    public void setPrice_include_vat(double price_include_vat) {
        double result = price_include_vat + getPrice_vat();
        this.price_include_vat = Math.round(result);
    }
    public double getPrice_include_vat() {
        return price_include_vat;
    }
    
    public double getPriceTotal() {
        return priceTotal;
    }

    public void setPriceTotal(double priceTotal) {
        this.priceTotal = priceTotal;
    }
    public ArrayList<Order> getO() {
        return o;
    }
    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }
    public int getTableNumber() {
        return tableNumber;
    }
    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }
}
