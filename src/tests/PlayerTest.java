package tests;

import Entity.Player;
import main.GamePanel;
import main.KeyHandler;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {

    GamePanel gp = new GamePanel();
    KeyHandler keyH = new KeyHandler();

    @Test
    void testPlayerMoveUp() {
        Player player = new Player(gp, keyH);

        // Test if the player moves up
        keyH.upPressed = true;
        player.update();
        keyH.upPressed = false;
        assertEquals(1472, player.worldX);
        assertEquals(1340, player.worldY);
    }

    @Test
    void testPlayerMoveDown() {
        Player player = new Player(gp, keyH);

        // Test if the player moves down
        keyH.downPressed = true;
        player.update();
        keyH.downPressed = false;
        assertEquals(1472, player.worldX);
        assertEquals(1348, player.worldY);
    }

    @Test
    void testPlayerMoveLeft() {
        Player player = new Player(gp, keyH);

        // Test if the player moves left
        keyH.leftPressed = true;
        player.update();
        keyH.leftPressed = false;
        assertEquals(1468, player.worldX);
        assertEquals(1344, player.worldY);
    }

    @Test
    void testPlayerMoveRight() {
        Player player = new Player(gp, keyH);

        // Test if the player moves right
        keyH.rightPressed = true;
        player.update();
        keyH.rightPressed = false;
        assertEquals(1476, player.worldX);
        assertEquals(1344, player.worldY);
    }

    @Test
    void testPlayerMoveUpLeft() {
        Player player = new Player(gp, keyH);

        // Test if the player moves up and left
        keyH.upPressed = true;
        keyH.leftPressed = true;

        int newX = player.worldX - 3;
        int newY = player.worldY - 3;

        player.update();

        keyH.upPressed = false;
        keyH.leftPressed = false;

        assertEquals(newX, player.worldX);
        assertEquals(newY, player.worldY);
    }

    @Test
    void testPlayerMoveUpRight() {
        Player player = new Player(gp, keyH);

        // Test if the player moves up and right
        keyH.upPressed = true;
        keyH.rightPressed = true;

        int newX = player.worldX + 3;
        int newY = player.worldY - 3;

        player.update();

        keyH.upPressed = false;
        keyH.rightPressed = false;

        assertEquals(newX, player.worldX);
        assertEquals(newY, player.worldY);
    }

    @Test
    void testPlayerMoveDownLeft() {
        Player player = new Player(gp, keyH);

        // Test if the player moves down and left
        keyH.downPressed = true;
        keyH.leftPressed = true;

        int newX = player.worldX - 3;
        int newY = player.worldY + 3;

        player.update();

        keyH.downPressed = false;
        keyH.leftPressed = false;

        assertEquals(newX, player.worldX);
        assertEquals(newY, player.worldY);
    }

    @Test
    void testPlayerMoveDownRight() {
        Player player = new Player(gp, keyH);

        // Test if the player moves down and right
        keyH.downPressed = true;
        keyH.rightPressed = true;

        int newX = player.worldX + 3;
        int newY = player.worldY + 3;

        player.update();

        keyH.downPressed = false;
        keyH.rightPressed = false;

        assertEquals(newX, player.worldX);
        assertEquals(newY, player.worldY);
    }
}
