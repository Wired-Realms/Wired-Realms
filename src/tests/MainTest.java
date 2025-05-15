package tests;

import org.junit.jupiter.api.Test;

public class MainTest {

    PlayerTest playerTest = new PlayerTest();
    TestGetTileImage tileImageTest = new TestGetTileImage();

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

    @Test
    public void testTileImage() {
        tileImageTest.checkGetTileImage();
    }
}
