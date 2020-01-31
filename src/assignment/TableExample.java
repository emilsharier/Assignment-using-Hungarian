/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

/**
 *
 * @author Emil
 */
import javax.swing.*;    
public class TableExample {    
    JFrame f;
    TableExample(String[][] str, String[] col){    
    f=new JFrame();    
    String data[][]=str;    
    String column[]={};         
    JTable jt=new JTable(data,col);    
    jt.setBounds(30,40,200,300);          
    JScrollPane sp=new JScrollPane(jt);    
    f.add(sp);          
    f.setSize(300,400);    
    f.setVisible(true);    
}       
}  