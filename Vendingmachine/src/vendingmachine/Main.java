package vendingmachine;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    private static VendingMachine currentMachine;

    public static void main(String[] args) throws IOException {
        double total;
        VendingMachine v1 = new VendingMachine();
        VendingMachine v2 = new VendingMachine();
        Random RNG = new Random();



        v1.setMachineNumber(1);
        v1.loadInventory();
        v2.setMachineNumber(2);
        v2.loadInventory();
//        Loads up the vending machines

        while (v1.isOn || v2.isOn) {
            try {
                int machineChoice = RNG.nextInt(2) + 1;
                double preclientMoney = Math.round((RNG.nextDouble() * 2 + .50) * 100);
                double clientMoney = preclientMoney / 100;
                int clientSelection = RNG.nextInt(10);
                int machineOffChance = RNG.nextInt(20) + 1;
                int clientArrivalChance = RNG.nextInt(4) + 1;
                double preclientChange;
                double clientChange;


                if (v1.isOn == false) {
                    currentMachine = v2;
                } else if (v2.isOn == false) {
                    currentMachine = v1;
                } else if (machineChoice == 1) {
                    currentMachine = v1;
                } else {
                    currentMachine = v2;
                }


                System.out.println("Client arrived at Vending machine " + machineChoice);
                Thread.sleep(1);

                if (!currentMachine.checkAvailablity(clientSelection)) {
                    System.out.println("Out of stock on item "
                            + currentMachine.DA[clientSelection].getName() + " in Vending Machine " + machineChoice);

                } else if (currentMachine.checkMoney(clientMoney, clientSelection)) {
                    preclientChange = Math.round((clientMoney - currentMachine.DA[clientSelection].getPrice()) * 100);
                    clientChange = preclientChange / 100;
                    currentMachine.DA[clientSelection].quantity--;
                    System.out.println("Purchased "
                            + currentMachine.DA[clientSelection].getName() + " from Vending Machine " + machineChoice);
                    System.out.println("Entered " + clientMoney + ". The cost was "
                            + currentMachine.DA[clientSelection].getPrice() + ". Change is "
                            + clientChange + ".");
                    currentMachine.addToSubtotal(currentMachine.DA[clientSelection].getPrice());
                    currentMachine.DA[clientSelection].addToSalesTotal(currentMachine.DA[clientSelection].getPrice());
                } else {
                    System.out.println("Not enough money for " + currentMachine.DA[clientSelection].getName()
                            + ". Need " + currentMachine.DA[clientSelection].getPrice() + ", entered: " + clientMoney);
                }
                System.out.println();
                if (machineOffChance == 20) {
                    currentMachine.turnOff();
                    System.out.println("Vending Machine " + machineChoice + " has turned off.");
                }
                System.out.println();

                Thread.sleep(clientArrivalChance);
            } catch (InterruptedException ie) {
            }

        }
        System.out.println("All Vending Machines Off. Calculating total sales and current inventory.");
        total = v1.getSubtotal() + v2.getSubtotal();
        DateFormat dateFormat = new SimpleDateFormat(" MM dd yyyy");
        Date date = new Date();

        PrintWriter outputStream = null;
        String fileName = "VendingReport" + dateFormat.format(date) + ".txt";
        try {
            outputStream = new PrintWriter(fileName);
        } catch (FileNotFoundException e) {

            System.out.println("Error opening the file "
                    + fileName);
            System.exit(0);
        }
        outputStream.println("Total money made from both machines: $" + total);
        outputStream.println();
        outputStream.println("Vending Machine 1: $" + total);
        for (int i = 0; i < 10; i++) {
            outputStream.println(v1.DA[i].getName() + " left: " + v1.DA[i].getQuantity() + ". Sales total: " + v1.DA[i].salesTotal);
        }
        outputStream.println("Subtotal from Vending machine 1: $" + v1.getSubtotal());

        outputStream.println();
        outputStream.println("Vending Machine 2: $" + total);
        for (int i = 0; i < 10; i++) {
            outputStream.println(v2.DA[i].getName() + " left: " + v2.DA[i].getQuantity() + ". Sales total: " + v2.DA[i].salesTotal);
        }
        outputStream.println("Subtotal from Vending machine 2: $" + v2.getSubtotal());
        outputStream.close();
        
        
        fileName = "dispenserQuantity1";
        try {
            outputStream = new PrintWriter(fileName);
        } catch (FileNotFoundException e) {

            System.out.println("Error opening the file "
                    + fileName);
            System.exit(0);
        }
        
        
        for (int i = 0; i < 10; i++) {
            outputStream.println(v1.DA[i].getQuantity());
        }
        
        outputStream.close();
        
        
        fileName = "dispenserQuantity2";
        try {
            outputStream = new PrintWriter(fileName);
        } catch (FileNotFoundException e) {

            System.out.println("Error opening the file "
                    + fileName);
            System.exit(0);
        }
        
        
        for (int i = 0; i < 10; i++) {
            outputStream.println(v2.DA[i].getQuantity());
        }
        
        outputStream.close();

    }
}
