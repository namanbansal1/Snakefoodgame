package CLASSES;

import CLASSES.Cell;

// Represents food.
public class Food {
    public static final int DECAY_AMOUNT = 10;
    public static final int INITIAL_NUTRITIONAL_VALUE = 100;
    private Cell position; // the position of food
    private int nutritionalValue; // the nutritional value of food

    // EFFECTS: food has INITIAL_NUTRITIONAL_VALUE and is located at given cell
    public Food(Cell position1) {
        nutritionalValue= INITIAL_NUTRITIONAL_VALUE;
        position=position1;
    }

    // EFFECTS: food has given nutritional value and is located at given cell
    public Food(Cell position2, int nutritionalValu) {
        position= position2;
        nutritionalValue=nutritionalValu+nutritionalValue;
    }

    public Cell getPosition() {
        return position;
    }

    // MODIFIES: this
    // EFFECTS:  reduces nutritional value of food by DECAY_AMOUNT while maintaining a minimum
    //           nutritional value of zero
    public void decay() {

        nutritionalValue=nutritionalValue-DECAY_AMOUNT;
        if(nutritionalValue < 0)
            nutritionalValue=0;
    }


    public int getNutritionalValue() {
        return nutritionalValue;
    }
}
