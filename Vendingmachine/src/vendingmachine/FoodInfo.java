/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine;

/**
 *
 * @author Tim
 */
public class FoodInfo {

    String snickersN = "Snickers", doritosN = "Doritos", sunchipsN = "Sunchips",
            mmN = "M&Ms", milkywayN = "Milkway", cokeN = "Coke",
            spriteN = "Sprite", fantaN = "Fanta", mountaindewN = "Mountaindew",
            dietcokeN = "DietCoke";
    double snickersP = 1, doritosP = 2, sunchipsP = 1.50, mmP = .50, milkywayP = .75,
            cokeP = 1, spriteP = 1, fantaP = 1.50, mountaindewP = 1.25, dietcokeP = .85;
    // Price per unit
    int snickersC = 300, doritosC = 350, sunchipsC = 200, mmC = 250, milkywayC = 175,
            cokeC = 300, spriteC = 250, fantaC = 275, mountaindewC = 325, dietcokeC = 0;
    //Calories per unit

    double getPrice(int snackType) {
        if (snackType == 1) {
            return snickersP;
        } else if (snackType == 2) {
            return doritosP;

        } else if (snackType == 3) {
            return sunchipsP;

        } else if (snackType == 4) {
            return mmP;

        } else if (snackType == 5) {
            return milkywayP;

        } else if (snackType == 6) {
            return cokeP;

        } else if (snackType == 7) {
            return spriteP;

        } else if (snackType == 8) {
            return fantaP;

        } else if (snackType == 9) {
            return mountaindewP;

        } else {
            return dietcokeP;
        }
    }

    int getNutrition(int snackType) {
        if (snackType == 1) {
            return snickersC;
        } else if (snackType == 2) {
            return doritosC;

        } else if (snackType == 3) {
            return sunchipsC;

        } else if (snackType == 4) {
            return mmC;

        } else if (snackType == 5) {
            return milkywayC;

        } else if (snackType == 6) {
            return cokeC;

        } else if (snackType == 7) {
            return spriteC;

        } else if (snackType == 8) {
            return fantaC;

        } else if (snackType == 9) {
            return mountaindewC;

        } else {
            return dietcokeC;
        }
    }
    String getName(int snackType) {
        if (snackType == 1) {
            return snickersN;
        } else if (snackType == 2) {
            return doritosN;

        } else if (snackType == 3) {
            return sunchipsN;

        } else if (snackType == 4) {
            return mmN;

        } else if (snackType == 5) {
            return milkywayN;

        } else if (snackType == 6) {
            return cokeN;

        } else if (snackType == 7) {
            return spriteN;

        } else if (snackType == 8) {
            return fantaN;

        } else if (snackType == 9) {
            return mountaindewN;

        } else {
            return dietcokeN;
        }
    }
}
