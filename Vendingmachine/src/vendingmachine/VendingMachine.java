/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileReader;
import java.io.FileWriter;

/**
 *
 * @author Tim
 */
public class VendingMachine {


    boolean isOn = true;
    int machineNumber = 1;
    int[] dispenserQuantity = new int[10];
    Dispenser[] DA = new Dispenser[10];
    double subtotal=0;
    
    
    public void addToSubtotal(double d) {
        subtotal = subtotal+d;
    }
    
    public double getSubtotal(){
            return subtotal;
    }
    public boolean checkAvailablity(int c) {
        if ((DA[c].getQuantity() > 0)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkMoney(double m, int c) {
        if ((DA[c].getPrice() <= m)) {
            return true;
        } else {
            return false;
        }
    }

    public void turnOff() {
        isOn = false;
    }

    public void setMachineNumber(int mNumber) {
        machineNumber = mNumber;

    }

    public String getMachineNumber() {
        if (machineNumber == 1) {
            return "dispenserQuantity1";
        }
        return "dispenserQuantity2";

    }

    public void loadInventory() throws IOException {

        FileReader fin = new FileReader(getMachineNumber());
        Scanner src = new Scanner(fin);
        int x = 0;
        while (src.hasNextLine()) {
            if (src.hasNextInt()) {
                dispenserQuantity[x] = src.nextInt();
                x++;
            } else {
                break;
            }
        }
        fin.close();
        Dispenser d0 = new Dispenser();
        Dispenser d1 = new Dispenser();
        Dispenser d2 = new Dispenser();
        Dispenser d3 = new Dispenser();
        Dispenser d4 = new Dispenser();
        Dispenser d5 = new Dispenser();
        Dispenser d6 = new Dispenser();
        Dispenser d7 = new Dispenser();
        Dispenser d8 = new Dispenser();
        Dispenser d9 = new Dispenser();

        DA[0] = d0;
        DA[1] = d1;
        DA[2] = d2;
        DA[3] = d3;
        DA[4] = d4;
        DA[5] = d5;
        DA[6] = d6;
        DA[7] = d7;
        DA[8] = d8;
        DA[9] = d9;

        for (int i = 0; i < 10; i++) {
            DA[i].setSnackType(i);
            DA[i].setQuantity(dispenserQuantity[i]);
            DA[i].setPrice();
            DA[i].setName();
        }
    }
}










       