/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;

/**
 *
 * @author STUDY fuckin HARD
 */
public class Menu {
    private String menuID;
    private String name;
    private double price;

    
    public Menu(String menuID, String name, double price){
        this.menuID = menuID;
        this.name = name;
        this.price = price;
    }
    public String getMenuID() {
        return menuID;
    }

    public void setMenuID(String menuID) {
        this.menuID = menuID;
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
}
