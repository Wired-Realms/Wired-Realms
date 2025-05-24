package tests;

import main.GamePanel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestCollision {

    private GamePanel gamePanel;

    @BeforeEach
    void setUp() {
        gamePanel = new GamePanel();
        // Default player configuration for every scenario
        gamePanel.player.setDefaultValues();
        gamePanel.player.speed = 16;
        gamePanel.player.diagonalSpeed = 16;
    }

    @Test
    void checkPlayerBox() {
        assertAll("player solid area",
                () -> assertEquals(16, gamePanel.player.solidArea.x),
                () -> assertEquals(24, gamePanel.player.solidArea.y),
                () -> assertEquals(32, gamePanel.player.solidArea.width),
                () -> assertEquals(28, gamePanel.player.solidArea.height)
        );
    }

    @Test
    void checkPlayerCollision() {
        // cardinal
        assertCollidesWhenMoving("left");
        reposition(23, 21);
        assertCollidesWhenMoving("right");

        reposition(22, 22);
        assertCollidesWhenMoving("up");
        reposition(22, 22);
        assertCollidesWhenMoving("down");

        // Diagonal movement
        reposition(23, 21);
        assertCollidesWhenMoving("up_left");
        reposition(23, 21);
        assertCollidesWhenMoving("up_right");

        reposition(23, 22);
        assertCollidesWhenMoving("down_left");
        reposition(23, 22);
        assertCollidesWhenMoving("down_right");
    }

    // Helper methods
    private void assertCollidesWhenMoving(String direction) {
        prepareKeys(direction, true);
        gamePanel.player.direction = direction;

        gamePanel.player.update();
        gamePanel.cChecker.CheckTile(gamePanel.player);

        assertTrue(gamePanel.player.collisionOn, () -> "Expected collision when moving " + direction);

        // reset pentru următoarea direcţie
        prepareKeys(direction, false);
        gamePanel.player.collisionOn = false;
    }

    private void prepareKeys(String direction, boolean pressed) {
        switch (direction) {
            case "left" -> gamePanel.keyH.leftPressed = pressed;
            case "right" -> gamePanel.keyH.rightPressed = pressed;
            case "up" -> gamePanel.keyH.upPressed = pressed;
            case "down" -> gamePanel.keyH.downPressed = pressed;
            case "up_left" -> {
                gamePanel.keyH.upPressed = pressed;
                gamePanel.keyH.leftPressed = pressed;
            }
            case "up_right" -> {
                gamePanel.keyH.upPressed = pressed;
                gamePanel.keyH.rightPressed = pressed;
            }
            case "down_left" -> {
                gamePanel.keyH.downPressed = pressed;
                gamePanel.keyH.leftPressed = pressed;
            }
            case "down_right" -> {
                gamePanel.keyH.downPressed = pressed;
                gamePanel.keyH.rightPressed = pressed;
            }
        }
    }

    private void reposition(int tileX, int tileY) {
        gamePanel.player.setDefaultValues();
        gamePanel.player.speed = 16;
        gamePanel.player.diagonalSpeed = 12;
        gamePanel.player.worldX = gamePanel.getTileSize() * tileX;
        gamePanel.player.worldY = gamePanel.getTileSize() * tileY;
    }
}
