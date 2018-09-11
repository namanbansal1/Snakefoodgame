

import CLASSES.*;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

// jUnit tests for Snake class
public class SnakeTest {
    private Snake testSnake;

    @Before
    public void runBefore() {
        testSnake = new Snake(new Cell(SnakeGame.BOARD_ROWS / 2, SnakeGame.BOARD_COLS / 2));
    }



    @Test
    public void testConstructor() {
        assertEquals(1, testSnake.length());
        assertFalse(testSnake.canGrow());
    }

    @Test
    public void testMoveRight() {
        setSnakeDirection(testSnake, Direction.RIGHT);
        testSnake.move();
        assertEquals(new Cell(SnakeGame.BOARD_ROWS / 2, SnakeGame.BOARD_COLS / 2 + 1), testSnake.getPosition());
    }


    @Test
    public void testMoveLeft() {
        setSnakeDirection(testSnake, Direction.LEFT);
        testSnake.move();
        assertEquals(new Cell(SnakeGame.BOARD_ROWS / 2, SnakeGame.BOARD_COLS / 2 - 1), testSnake.getPosition());
    }


    @Test
    public void testMoveUp() {
        setSnakeDirection(testSnake, Direction.UP);
        testSnake.move();
        assertEquals(new Cell(SnakeGame.BOARD_ROWS / 2 - 1, SnakeGame.BOARD_COLS / 2), testSnake.getPosition());
    }

    @Test
    public void testMoveDown() {
        setSnakeDirection(testSnake, Direction.DOWN);
        testSnake.move();
        assertEquals(new Cell(SnakeGame.BOARD_ROWS / 2 + 1, SnakeGame.BOARD_COLS / 2), testSnake.getPosition());
    }

    @Test

    public void testRotateLeftCaseDown() {

        setSnakeDirection(testSnake, Direction.DOWN);
        testSnake.move();
        assertEquals(new Cell(SnakeGame.BOARD_ROWS / 2 + 1, SnakeGame.BOARD_COLS / 2),
                testSnake.getPosition());
        setSnakeDirection(testSnake, Direction.RIGHT);
        testSnake.move();
        assertEquals(new Cell(SnakeGame.BOARD_ROWS / 2 + 1, SnakeGame.BOARD_COLS / 2 + 1),
                testSnake.getPosition());
    }
//......................................................................................................

    @Test
    public void testRotateRight() {
        setSnakeDirection2(testSnake, Direction.RIGHT);
        testSnake.move();
        assertEquals(new Cell(SnakeGame.BOARD_ROWS / 2, SnakeGame.BOARD_COLS / 2 + 1),
                testSnake.getPosition());

    }


    @Test
    public void testRotateRight2() {
        setSnakeDirection2(testSnake, Direction.LEFT);
        testSnake.move();
        assertEquals(new Cell(SnakeGame.BOARD_ROWS / 2, SnakeGame.BOARD_COLS / 2 - 1),
                testSnake.getPosition());
    }


    @Test
    public void testRotateRight3() {
        setSnakeDirection2(testSnake, Direction.UP);
        testSnake.move();
        assertEquals(new Cell(SnakeGame.BOARD_ROWS / 2 - 1, SnakeGame.BOARD_COLS / 2),
                testSnake.getPosition());
    }

    @Test
    public void testRotateRight4() {
        setSnakeDirection2(testSnake, Direction.DOWN);
        testSnake.move();
        assertEquals(new Cell(SnakeGame.BOARD_ROWS / 2 + 1, SnakeGame.BOARD_COLS / 2),
                testSnake.getPosition());
    }

    @Test
    public void testRotateRightCaseDown() {

        setSnakeDirection2(testSnake, Direction.DOWN);
        testSnake.move();
        assertEquals(new Cell(SnakeGame.BOARD_ROWS / 2 + 1, SnakeGame.BOARD_COLS / 2),
                testSnake.getPosition());
        setSnakeDirection2(testSnake,Direction.RIGHT); //error?
        testSnake.move();
        assertEquals(new Cell(SnakeGame.BOARD_ROWS / 2+1, SnakeGame.BOARD_COLS / 2 + 1),
                testSnake.getPosition());



    }


        //............................................................................................

        @Test
        public void testMoveBody () {
            setSnakeDirection(testSnake, Direction.RIGHT);
            growBodyByTwo();
            testSnake.move();
            assertEquals(new Cell(SnakeGame.BOARD_ROWS / 2, SnakeGame.BOARD_COLS / 2 + 3), testSnake.getPosition());

            List<Cell> body = testSnake.getBodyPositions();
            assertEquals(2, body.size());
            assertEquals(new Cell(SnakeGame.BOARD_ROWS / 2, SnakeGame.BOARD_COLS / 2 + 2), body.get(0));
            assertEquals(new Cell(SnakeGame.BOARD_ROWS / 2, SnakeGame.BOARD_COLS / 2 + 1), body.get(1));
        }

        @Test
        public void testGrowOnFeed () {
            Food food = new Food(testSnake.getPosition(), Snake.NUTRITION_TO_GROW);
            testSnake.eat(food);
            assertEquals(1, testSnake.length());
            assertTrue(testSnake.canGrow());

            testSnake.move();
            assertEquals(2, testSnake.length());
            assertFalse(testSnake.canGrow());
        }


        // EFFECTS: rotate snake until it is facing in direction d

    private void setSnakeDirection(Snake snake, Direction d) {
        while (snake.getDirection() != d)
            snake.rotateLeft();
    }

    // EFFECTS: rotate snake until it is facing in direction d
    private void setSnakeDirection2(Snake snake, Direction d) {
        while (snake.getDirection() != d)
            snake.rotateRight(); //error
    }

    // MODIFIES: this
    // EFFECTS:  get snake to eat enough food so that its body has length 2
    private void growBodyByTwo() {
        Food food = new Food(testSnake.getPosition(), 2 * Snake.NUTRITION_TO_GROW);
        testSnake.eat(food);
        testSnake.move();
        testSnake.move();
    }

}