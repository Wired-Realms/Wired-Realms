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
        assertEquals(100, player.x);
        assertEquals(96, player.y);
    }

    @Test
    void testPlayerMoveDown() {
        Player player = new Player(gp, keyH);

        // Test if the player moves down
        keyH.downPressed = true;
        player.update();
        keyH.downPressed = false;
        assertEquals(100, player.x);
        assertEquals(104, player.y);
    }

    @Test
    void testPlayerMoveLeft() {
        Player player = new Player(gp, keyH);

        // Test if the player moves left
        keyH.leftPressed = true;
        player.update();
        keyH.leftPressed = false;
        assertEquals(96, player.x);
        assertEquals(100, player.y);
    }

    @Test
    void testPlayerMoveRight() {
        Player player = new Player(gp, keyH);

        // Test if the player moves right
        keyH.rightPressed = true;
        player.update();
        keyH.rightPressed = false;
        assertEquals(104, player.x);
        assertEquals(100, player.y);
    }

    @Test
    void testPlayerMoveUpLeft() {
        Player player = new Player(gp, keyH);

        // Test if the player moves up and left
        keyH.upPressed = true;
        keyH.leftPressed = true;
        player.update();
        keyH.upPressed = false;
        keyH.leftPressed = false;
        double diagonalSpeed = player.speed / Math.sqrt(2);
        double newX = 100 - diagonalSpeed;
        double newY = 100 - diagonalSpeed;
        assertEquals((int)newX, player.x);
        assertEquals((int)newY, player.y);
    }

    @Test
    void testPlayerMoveUpRight() {
        Player player = new Player(gp, keyH);

        // Test if the player moves up and right
        keyH.upPressed = true;
        keyH.rightPressed = true;
        player.update();
        keyH.upPressed = false;
        keyH.rightPressed = false;
        double diagonalSpeed = player.speed / Math.sqrt(2);
        double newX = 100 + diagonalSpeed;
        double newY = 100 - diagonalSpeed;
        assertEquals((int)newX, player.x);
        assertEquals((int)newY, player.y);
    }

    @Test
    void testPlayerMoveDownLeft() {
        Player player = new Player(gp, keyH);

        // Test if the player moves down and left
        keyH.downPressed = true;
        keyH.leftPressed = true;
        player.update();
        keyH.downPressed = false;
        keyH.leftPressed = false;
        double diagonalSpeed = player.speed / Math.sqrt(2);
        double newX = 100 - diagonalSpeed;
        double newY = 100 + diagonalSpeed;
        assertEquals((int)newX, player.x);
        assertEquals((int)newY, player.y);
    }

    @Test
    void testPlayerMoveDownRight() {
        Player player = new Player(gp, keyH);

        // Test if the player moves down and right
        keyH.downPressed = true;
        keyH.rightPressed = true;
        player.update();
        keyH.downPressed = false;
        keyH.rightPressed = false;
        double diagonalSpeed = player.speed / Math.sqrt(2);
        double newX = 100 + diagonalSpeed;
        double newY = 100 + diagonalSpeed;
        assertEquals((int)newX, player.x);
        assertEquals((int)newY, player.y);
    }
}
