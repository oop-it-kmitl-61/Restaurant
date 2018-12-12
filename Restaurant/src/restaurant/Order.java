/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant;

/**
 *
 * @author STUDY fuckin HARD
 */
// เป็น เมนูของ Order
public class Order {
    private int quantity;
    private String name;
    private double price;
    private double price_each;
    private String detail;
    public Order(int quantity, String name, double price_each, double price, String detail){
        this.quantity = quantity;
        this.name = name;
        this.price = price;
        this.price_each = price_each;
        this.detail = detail;
    }
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public double getPrice_each() {
        return price_each;
    }

    public void setPrice_each(double price_each) {
        this.price_each = price_each;
    }
    public String getDetail() {
        return detail;
    }
    public void setDetail(String detail) {
        this.detail = detail;
    }
}
