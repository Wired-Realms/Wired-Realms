package tests;

import org.junit.jupiter.api.Test;

public class MainTest {

    PlayerTest playerTest = new PlayerTest();
    TestGetTileImage tileImageTest = new TestGetTileImage();
    TestGetObject objectTest = new TestGetObject();

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

    @Test
    public void testObjectImage() {

        objectTest.setUp();
        objectTest.checkGetObjectImage();
    }
}
