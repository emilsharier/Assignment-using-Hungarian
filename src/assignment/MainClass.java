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
import javax.swing.filechooser.*;

class filechooser extends JFrame implements ActionListener {

    // Jlabel to show the files user selects 
    static JLabel l;
    static JLabel result;
    String path;
    Assignment obj;
    double cost;
    JFrame f;

    // a default constructor 
    filechooser() {
    }

    public static void main(String args[]) {
        // frame to contains GUI elements 
        
        filechooser ob = new filechooser();
        ob.f = new JFrame("file chooser");

        // set the size of the frame 
        ob.f.setSize(400, 400);

        // set the frame's visibility 
        ob.f.setVisible(true);

        ob.f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // button to open save dialog 
        // button to open open dialog 
        JButton button2 = new JButton("Choose file");

        JButton fetchData = new JButton("fetchData()");
        
        JButton fillZeros = new JButton("fillZeros()");
        JButton doCalculation = new JButton("doCalculation()");
        JButton assignZeros = new JButton("assignZeros()");
        
        JButton getCost = new JButton("getCost()");
        

        // make an object of the class filechooser 
        filechooser f1 = new filechooser();

        // add action listener to the button to capture user 
        // response on buttons 
        button2.addActionListener(f1);
        fillZeros.addActionListener(f1);
        fetchData.addActionListener(f1);
        doCalculation.addActionListener(f1);
        assignZeros.addActionListener(f1);
        getCost.addActionListener(f1);
            
        // make a panel to add the buttons and labels 
        JPanel p = new JPanel();

        // add buttons to the frame
        p.add(button2);
        p.add(fetchData);
        p.add(fillZeros);
        p.add(doCalculation);
        p.add(assignZeros);
        p.add(getCost);
        

        // set the label to its initial value 
        l = new JLabel("no file selected");
        // add panel to the frame 
        p.add(l);
        ob.f.add(p);

        ob.f.show();
    }

    public void actionPerformed(ActionEvent evt) {
        // if the user presses the save button show the save dialog 
        String com = evt.getActionCommand();

        switch (com) {
            case "Choose file":
                JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

                // invoke the showsOpenDialog function to show the save dialog 
                int r = j.showOpenDialog(null);

                // if the user selects a file 
                if (r == JFileChooser.APPROVE_OPTION) {
                    // set the label to the path of the selected file 
                    l.setText(j.getSelectedFile().getAbsolutePath());
                    path = j.getSelectedFile().getAbsolutePath();
                    obj = new Assignment(29, 29, path);
                } // if the user cancelled the operation 
                else {
                    l.setText("the user cancelled the operation");
                }
                break;

            case "fetchData()":
                obj.fetchData();
                obj.getData();
                break;

            case "fillZeros()":
                obj.fillZeros();
                obj.getCurrentMatrix();
                break;

            case "doCalculation()":
                obj.doCalculation();
                obj.getCurrentMatrix();
                break;

            case "assignZeros()":
                obj.assignZeros();
                obj.getCurrentMatrix();
                break;

            case "getCost()":
                cost = obj.getCost();
                JOptionPane.showMessageDialog(f, "The cost is " + String.valueOf(cost));
                break;

            default:
                break;
        }
    }
}
