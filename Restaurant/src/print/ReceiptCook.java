///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package print;
//
///**
// *
// * @author STUDY fuckin HARD
// */
///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//import com.orsonpdf.PDFDocument;
//import gui.Login;
//import java.awt.Desktop;
//import java.awt.Graphics;
//import java.awt.Graphics2D;
//import java.awt.TextArea;
//import java.awt.print.PageFormat;
//import java.awt.print.Paper;
//import java.awt.print.Printable;
//import java.awt.print.PrinterException;
//import java.awt.print.PrinterJob;
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.OutputStreamWriter;
//import java.io.PrintWriter;
//import java.sql.Timestamp;
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.Formatter;
//import javafx.print.PageLayout;
//import javafx.scene.text.Text;
//import javafx.scene.text.TextFlow;
//import javax.swing.JOptionPane;
//import javax.swing.JTextField;
//import javax.swing.JTextPane;
//import restaurant.MyOrder;
//
///**
// *
// * @author STUDY fuckin HARD
// */
//public class ReceiptCook{
//    private String myPage = null;
//    private PrinterJob pj;
//    private MyOrder myo;
//    public ReceiptCook(MyOrder myo){
//        this.myo = myo;
//    }
//
//    public String printDetail(String name, int quantity, double price, String detail) {
//        String line1 = String.format("  %-15.15s %5d %10.2f %20s\n", name, quantity, price, detail);
//        return line1;
//    }
//
//    public String printUserDetail(String name, Timestamp time){ //ตอนจริงรับมาเป็น TimeStamp
//        time = myo.getDate(); //ดึงเวลาจาก database (เป็น format ของ sql)
//        Date date = new Date(time.getTime()); // แปลงจาก sql เป็น Date
//        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm"); // สร้าง Format ตามที่ต้องการ
//        String date_formated = formatter.format(date); //ได้วันเดือนปีตามที่ format ไว้
//        
//        String line1 = String.format("\n  %-15s %5s %10s\n", "", "User", name);
//        String line2 = String.format("  Date %-26s\n", date_formated);
//        return line1 + line2;
//    }
//
//    public String getMyReceipt(){
//        myPage = "";
//        for(int i=0; i<myo.getO().size(); i++){
//            myPage += printDetail(myo.getO().get(i).getName(), myo.getO().get(i).getQuantity(), myo.getO().get(i).getPrice(), myo.getO().get(i).getDetail());
//        }
////        myPage += printUserDetail(myo.getUser(), myo.getDate());
//        return myPage;
//    }
//    
////    public void saveReceipt() throws IOException{
////        FileOutputStream fout;
////        OutputStreamWriter oout;
////        PrintWriter p;
////        try {
////            fout = new FileOutputStream("receiptCook.dat");
////            oout = new OutputStreamWriter(fout);
////            p = new PrintWriter(oout);
////            p.println(getMyReceipt());
////            p.close();
////            oout.close();
////            fout.close();
////        } catch(IOException ex) {
////            System.out.println(ex.toString());
////        }
////        File file = new File("receiptCook.dat");
////        Desktop desktop = Desktop.getDesktop();
////        if(file.exists()) desktop.open(file);
////    }
//}
