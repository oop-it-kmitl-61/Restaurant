/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package print;

import com.orsonpdf.PDFDocument;
import gui.Login;
import java.awt.Desktop;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.TextArea;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;
import javafx.print.PageLayout;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import restaurant.MyOrder;

/**
 *
 * @author STUDY fuckin HARD
 */
public class Receipt{
    private String myPage = null;
    private PrinterJob pj;
    private MyOrder myo;
    public Receipt(MyOrder myo){
        this.myo = myo;
    }

    public String printTitle(int table){
        String line1 = String.format("  %-10s%-11s%11s\n", "", "Happy Cafe'", "");
        String line2 = String.format("  %-32s\n\n", "Contact 0617689874(โม)");
        String line3 = String.format("  %-10s%02d\n", "Table", table);
        String line4 = String.format("  %-15s %5s %10s\n", "Item", "Qty", "Price");
        String line5 = String.format("  %-15s %5s %10s\n", "----", "---", "-----");
        String out = line1 + line2 + line3 + line4 + line5;
        return out;
    }
    public String printDetail(String name, int quantity, double price) {
        String line1 = String.format("  %-15.15s %5d %10.2f\n", name, quantity, price);
        return line1;
    }
    public String printTotal(double price, double price_vat, double price_include_vat, double received, double changed) {
        String line1 = String.format("  %-15.15s %5.5s %10.5s\n", "---------------", "----------", "------------");
        String line2 = String.format("  %-15s %5s %10.2f\n", "Total", "", price);
//        String line3 = String.format("  %-15s %5s %10s\n", "", "", "-----");
        String line4 = String.format("  %-15s %5s %10s\n", "Vat", "7%:", price_vat);
        String line5 = String.format("  %-15s %5s %10s\n", "", "", "-----");
        String line6 = String.format("  %-15s %5s %10.2f\n", "Total", "", price_include_vat);
        String line7 = String.format("  %-15.15s %5.5s %10.5s\n", "---------------", "----------", "------------");
        String line8 = String.format("  %-15s %5s %10.2f\n", "Received", "", received);
        String line9 = String.format("  %-15s %5s %10s\n", "", "", "-----");
        String line10 = String.format("  %-15s %5s %10.2f\n", "Change", "", changed);
        String out = line1 + line2 + line4 + line5 + line6 + line7 + line8 + line9 + line10;
        return out;
    }
    public String printUserDetail(String name, Timestamp time){ //ตอนจริงรับมาเป็น TimeStamp
        time = myo.getDate(); //ดึงเวลาจาก database (เป็น format ของ sql)
        Date date = new Date(time.getTime()); // แปลงจาก sql เป็น Date
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm"); // สร้าง Format ตามที่ต้องการ
        String date_formated = formatter.format(date); //ได้วันเดือนปีตามที่ format ไว้
        
        String line1 = String.format("\n  %-15s %5s %10s\n", "", "User", name);
        String line2 = String.format("  Date %-26s\n", date_formated);
        return line1 + line2;
    }
    public String printDetailEx(String name, int quantity, double price, String detail) {
        String line1 = String.format("  %-15.15s %5d %10.2f %-15s\n", name, quantity, price, detail);
        return line1;
    }

    public String getMyReceipt(){
        myPage = printTitle(myo.getTableNumber());
        for(int i=0; i<myo.getO().size(); i++){
            myPage += printDetail(myo.getO().get(i).getName(), myo.getO().get(i).getQuantity(), myo.getO().get(i).getPrice());
        }
        myPage += printTotal(myo.getPriceTotal(), myo.getPrice_vat(), myo.getPrice_include_vat(), myo.getReceive(), myo.getChange());
        myPage += printUserDetail(myo.getUser(), myo.getDate());
        myPage += String.format("%32.32s\n", "----------------------------");
        myPage += printTitle(myo.getTableNumber());
        for(int i=0; i<myo.getO().size(); i++){
            myPage += printDetailEx(myo.getO().get(i).getName(), myo.getO().get(i).getQuantity(), myo.getO().get(i).getPrice(), myo.getO().get(i).getDetail());
        }
        return myPage;
    }
    
    public void saveReceipt() throws IOException{
        FileOutputStream fout;
        OutputStreamWriter oout;
        PrintWriter p;
        try {
            fout = new FileOutputStream("receipt.dat");
            oout = new OutputStreamWriter(fout);
            p = new PrintWriter(oout);
            p.println(getMyReceipt());
            p.close();

        } catch(IOException ex) {
            System.out.println(ex.toString());
        }
        File file = new File("receipt.dat");
        Desktop desktop = Desktop.getDesktop();
        if(file.exists()){
            desktop.open(file);
        }
    }
}
