/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine;

/**
 *
 * @author Tim
 */
public class Dispenser {

    int quantity;
    int snackType;
    double price;
    int calories;
    String name;
    double salesTotal;
    
    
    public void addToSalesTotal(double d) {
        salesTotal = salesTotal+d;
    }
    
    FoodInfo fI = new FoodInfo();

    public void setQuantity(int q) {
        quantity = q;
    }

    public int getQuantity() {
        return quantity;
    }
   

    public void setSnackType(int s) {
        snackType = s;
    }

    public void setPrice() {
        price = fI.getPrice(snackType);
    }
    
    public void setNutrition() {
        calories = fI.getNutrition(snackType);
    }
    
    public void setName() {
        name = fI.getName(snackType);
    }
    
    public double getPrice() {
        return price;
    }
    
    public int getNutrition() {
        return calories;
    }
    
    public String getName() {
        return name;
    }
}
