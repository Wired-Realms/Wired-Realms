package tests;

import org.junit.jupiter.api.Test;

public class MainTest {

    PlayerTest playerTest = new PlayerTest();

    @Test
    public void testPlayer() {
        playerTest.testPlayerMoveUp();
        playerTest.testPlayerMoveDown();
        playerTest.testPlayerMoveLeft();
        playerTest.testPlayerMoveRight();
        playerTest.testPlayerMoveUpLeft();
        playerTest.testPlayerMoveUpRight();
        playerTest.testPlayerMoveDownLeft();
        playerTest.testPlayerMoveDownRight();
    }
}
