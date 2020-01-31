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
import java.awt.event.*;    
import java.io.*;   

public class FileChooser extends JFrame implements ActionListener{    
JMenuBar mb;    
JMenu file;    
JMenuItem open;    
JTextArea ta; 
String path;

FileChooser(){    
open=new JMenuItem("Open File");    
open.addActionListener(this);            
file=new JMenu("File");    
file.add(open);             
mb=new JMenuBar();    
mb.setBounds(0,0,800,20);    
mb.add(file);              
ta=new JTextArea(800,800);    
ta.setBounds(0,20,800,800);              
add(mb);    
add(ta);              
}    
public void actionPerformed(ActionEvent e) {    
if(e.getSource()==open){    
    JFileChooser fc=new JFileChooser();    
    int i=fc.showOpenDialog(this);    
    if(i==JFileChooser.APPROVE_OPTION){    
        File f=fc.getSelectedFile();    
        String filepath=f.getPath();    
        path = returnPath(filepath);            
    }    
}
}

public String returnPath (String path_) {
    return path_;
}

public String getPath () {
    return path;
}
}