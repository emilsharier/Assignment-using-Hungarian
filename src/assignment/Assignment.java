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
public class Assignment {

    /**
     * @param args the command line arguments
     */
    final String path;
    final Refractor obj;

    public Assignment(int row, int col, String str) {
        this.path = str;
        obj = new Refractor(row, col, path);
    }

    public void fetchData() {
        obj.insertData();
    }

    public void getData() {
        String[] column = obj.getColumn();
        String[][] temp = obj.fetchData();
        TableExample table = new TableExample(temp, column);
    }
    
    public void getCurrentMatrix () {
        String[] column = obj.getColumn();
        String[][] temp = obj.getMatrix();
        TableExample table = new TableExample(temp, column);
    }

    public void fillZeros() {
        obj.fillZeros();
    }

    public void doCalculation() {
        obj.doCalculation();
    }

    public void assignZeros() {
        obj.assigningZeros1();
        obj.assigningZeros2();
    }

    public double getCost() {
        obj.doAssignment();
        return obj.printCost();
    }
}
