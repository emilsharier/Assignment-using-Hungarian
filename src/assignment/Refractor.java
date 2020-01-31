/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

import java.util.Scanner;
import java.util.Arrays;
import java.text.DecimalFormat;

/**
 *
 * @author Emil
 */
public class Refractor {

    String path;
    double dataset[][];
    double temp_dataset[][];
    int row, col;
    int i, j;
    double temp;
    int size;
    double small, cost;
    double a[];
    double assignment[][];
    int assignment2[][];
    DecimalFormat df;
    ReadFile obj;
    Scanner sc;

    public Refractor(int rows, int column, String str) {
        path = str;
        sc = new Scanner(System.in);
        df = new DecimalFormat("#.0000");

        row = rows;
        col = column;
        if (row >= col) {
            size = row;
        } else {
            size = col;
        }

        cost = 0;
        a = new double[size];
        dataset = new double[size][size];
        temp_dataset = new double[size][size];
        assignment2 = new int[size][size];
        obj = new ReadFile();
    }

    public void insertData() {
        dataset = obj.getData(path, size);
        for (i = 0; i < size; i++) {
            for (j = 0; j < size; j++) {
                temp_dataset[i][j] = dataset[i][j];
            }
        }
    }
    
    public String[][] getMatrix () {
        String[][] temp = new String[size][size];
        for(i=0;i<size;i++){
            for(j=0;j<size;j++){
                temp[i][j] = String.valueOf(dataset[i][j]);
            }
        }
        
        return temp;
    }

    public String[][] fetchData() {
        String[][] stringData = obj.getStringData(path, size);
        return stringData;
    }

    public String[] getColumn() {
        String[] temp = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29"};
        return temp;
    }

    public void fillZeros() {
        if (row > col) {
            for (i = col; i < row; i++) {
                for (j = 0; j < row; j++) {
                    dataset[j][i] = 0;
                }
            }
        } else if (col > row) {
            for (i = row; i < col; i++) {
                for (j = 0; j < col; j++) {
                    dataset[i][j] = 0;
                }
            }
        }
    }

    public void printDataSet() {
        for (i = 0; i < size; i++) {
            System.out.println();
            for (j = 0; j < size; j++) {
                System.out.print(dataset[i][j] + " ");
            }
        }
        System.out.println();
    }

    public void doCalculation() {
        for (i = 0; i < size; i++) {
            for (j = i + 1; j < size; j++) {
                temp = (double) (Math.abs((dataset[i][j] - dataset[j][i])));
                temp = Double.valueOf(df.format(temp));
                dataset[i][j] = temp;
                dataset[j][i] = temp;
            }
        }
    }

    public void assigningZeros1() {
        for (i = 0; i < size; i++) {
            for (j = 0; j < size; j++) {
                a[j] = dataset[i][j];
            }
            Arrays.sort(a);
            small = a[0];
            System.out.println("Smallest in row " + i + " is " + small);
            for (j = 0; j < size; j++) {
                dataset[i][j] = Math.abs(dataset[i][j] - small);
            }
        }
    }

    public void assigningZeros2() {
        int counter = 0;
        for (i = 0; i < size; i++) {
            counter = 0;
            for (j = 0; j < size; j++) {
                if (dataset[i][j] == 0.0) {
                    continue;
                }
                a[counter] = dataset[i][j];
                counter++;
            }
            Arrays.sort(a);

            small = a[0];
            System.out.println("\nSecond smallest in row " + i + " is " + small);
            for (j = 0; j < size; j++) {
                if (dataset[i][j] == 0) {
                    continue;
                }
                temp = (double) (Math.abs(dataset[i][j] - small));
                temp = Double.valueOf(df.format(temp));
                dataset[i][j] = temp;
            }
        }
    }

    public void doAssignment() {
        HungarianAlgorithm ha = new HungarianAlgorithm(dataset);
        assignment = ha.findOptimalAssignment();
        System.out.println("The obtained result is ");

        for (i = 0; i < size; i++) {
            assignment2[i][1] = (int) assignment[i][1];
            assignment2[i][0] = (int) assignment[i][0];
            System.out.print((assignment2[i][1] + 1) + " " + (assignment2[i][0] + 1) + "\n");
        }
    }

    public double printCost() {
        cost = 0;
        for (i = 0; i < size; i++) {
            temp = temp_dataset[assignment2[i][1]][assignment2[i][0]];
            temp = Double.valueOf(df.format(temp));
            cost += temp;
            cost = Double.valueOf(df.format(cost));
//            System.out.println("\n" + temp);
//            System.out.println("Cost is " + cost);
        }
        cost /= 5.3;
        System.out.println("The cost is " + cost);
        return cost;
    }
}
