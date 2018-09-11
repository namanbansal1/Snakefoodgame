
import CLASSES.Cell;
import CLASSES.Food;
import CLASSES.SnakeGame;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

// jUnit tests for Food class
public class FoodTest {
    private Food testFood;
    private Food testfood1;

    @Before
    public void runBefore() {
        testFood = new Food(new Cell(SnakeGame.BOARD_ROWS / 2, SnakeGame.BOARD_COLS / 2));
        testfood1 = new Food((new Cell(SnakeGame.BOARD_ROWS / 2, SnakeGame.BOARD_COLS / 2)), 25);

    }

    @Test
    public void testConstructor() {
        assertEquals(testFood.INITIAL_NUTRITIONAL_VALUE, testFood.getNutritionalValue());
        assertEquals((new Cell(SnakeGame.BOARD_ROWS / 2, SnakeGame.BOARD_COLS / 2)), testFood.getPosition());

    }

    @Test

    public void testConstructor2() {


        assertEquals((new Cell(SnakeGame.BOARD_ROWS / 2, SnakeGame.BOARD_COLS / 2)), testfood1.getPosition());
        assertEquals(25, testfood1.getNutritionalValue());


    }


    @Test

    public void testDecay1() {

        testFood.decay();
        testFood.decay();
        testFood.decay();
        testFood.decay();
        testFood.decay();
        testFood.decay();
        testFood.decay();
        testFood.decay();
        testFood.decay();
        testFood.decay();
        assertEquals(0, testFood.getNutritionalValue());
        testFood.decay();
        assertEquals(0, testFood.getNutritionalValue());

    }

    @Test

    public void testDecay2(){

        testfood1.decay();
        testfood1.decay();
        assertEquals(5,testfood1.getNutritionalValue());
        testfood1.decay();
        assertEquals(0,testfood1.getNutritionalValue());

    }
}