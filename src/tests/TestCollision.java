package tests;

import main.GamePanel;
import main.KeyHandler;
import org.junit.jupiter.api.Test;

public class TestCollision {

    GamePanel gamePanel = new GamePanel();

    @Test
    void checkPlayerBox() {
        assert gamePanel.player.solidArea.x == 16 : "Player solid area x should be 16";
        assert gamePanel.player.solidArea.y == 24 : "Player solid area y should be 24";

        assert gamePanel.player.solidArea.width == 32 : "Player solid area width should be 32";
        assert gamePanel.player.solidArea.height == 28 : "Player solid area height should be 28";
    }

    @Test
    void checkPlayerCollision() {

        // Check left
        gamePanel.player.setDefaultValues();
        gamePanel.player.speed = 16;

        assert gamePanel.player.worldX == gamePanel.getTileSize() * 23 : "Player worldX should be 1472";
        assert gamePanel.player.worldY == gamePanel.getTileSize() * 21 : "Player worldY should be 1344";

        assert gamePanel.player.speed == 16 : "Player speed should be 16";
        assert gamePanel.player.direction.equals("none") : "Player direction should be none";

        gamePanel.player.direction = "left";
        gamePanel.keyH.leftPressed = true;

        // Moves 16 pixels to the left
        gamePanel.player.update();

        // Player should collide with a tile
        gamePanel.cChecker.CheckTile(gamePanel.player);
        assert gamePanel.player.collisionOn == true : "Player collisionOn should be true";
        gamePanel.keyH.leftPressed = false;

        // Check Right
        gamePanel.player.setDefaultValues();
        gamePanel.player.speed = 16;

        assert gamePanel.player.worldX == gamePanel.getTileSize() * 23 : "Player worldX should be 1472";
        assert gamePanel.player.worldY == gamePanel.getTileSize() * 21 : "Player worldY should be 1344";

        assert gamePanel.player.speed == 16 : "Player speed should be 16";
        assert gamePanel.player.direction.equals("none") : "Player direction should be none";

        gamePanel.player.direction = "right";
        gamePanel.keyH.rightPressed = true;

        // Moves 16 pixels to the right
        gamePanel.player.update();
        // Player should collide with a tile
        gamePanel.cChecker.CheckTile(gamePanel.player);
        assert gamePanel.player.collisionOn == true : "Player collisionOn should be true";
        gamePanel.keyH.rightPressed = false;

        // Check Up
        gamePanel.player.setDefaultValues();
        gamePanel.player.speed = 16;
        gamePanel.player.worldX = gamePanel.getTileSize() * 22;
        gamePanel.player.worldY = gamePanel.getTileSize() * 22;

        assert gamePanel.player.worldX == gamePanel.getTileSize() * 22 : "Player worldX should be 1472";
        assert gamePanel.player.worldY == gamePanel.getTileSize() * 22 : "Player worldY should be 1344";

        assert gamePanel.player.speed == 16 : "Player speed should be 16";
        assert gamePanel.player.direction.equals("none") : "Player direction should be none";

        gamePanel.player.direction = "up";
        gamePanel.keyH.upPressed = true;

        // Moves 16 pixels up
        gamePanel.player.update();
        // Player should collide with a tile
        gamePanel.cChecker.CheckTile(gamePanel.player);
        assert gamePanel.player.collisionOn == true : "Player collisionOn should be true";
        gamePanel.keyH.upPressed = false;

        // Check Down
        gamePanel.player.setDefaultValues();
        gamePanel.player.speed = 16;
        gamePanel.player.worldX = gamePanel.getTileSize() * 22;
        gamePanel.player.worldY = gamePanel.getTileSize() * 22;

        assert gamePanel.player.worldX == gamePanel.getTileSize() * 22 : "Player worldX should be 1472";
        assert gamePanel.player.worldY == gamePanel.getTileSize() * 22 : "Player worldY should be 1344";

        assert gamePanel.player.speed == 16 : "Player speed should be 16";
        assert gamePanel.player.direction.equals("none") : "Player direction should be none";

        gamePanel.player.direction = "down";
        gamePanel.keyH.downPressed = true;

        // Moves 16 pixels down
        gamePanel.player.update();
        // Player should collide with a tile
        gamePanel.cChecker.CheckTile(gamePanel.player);
        assert gamePanel.player.collisionOn == true : "Player collisionOn should be true";
        gamePanel.keyH.downPressed = false;

        // Check Up Left
        gamePanel.player.setDefaultValues();
        gamePanel.player.speed = 16;
        gamePanel.player.diagonalSpeed = 16;

        assert gamePanel.player.worldX == gamePanel.getTileSize() * 23 : "Player worldX should be 1472";
        assert gamePanel.player.worldY == gamePanel.getTileSize() * 21 : "Player worldY should be 1344";

        assert gamePanel.player.speed == 16 : "Player speed should be 16";
        assert gamePanel.player.diagonalSpeed == 16 : "Player diagonal speed should be 12";
        assert gamePanel.player.direction.equals("none") : "Player direction should be none";

        gamePanel.player.direction = "up_left";
        gamePanel.keyH.upPressed = true;
        gamePanel.keyH.leftPressed = true;

        // Moves 16 pixels up and left
        gamePanel.player.update();
        // Player should collide with a tile
        gamePanel.cChecker.CheckTile(gamePanel.player);
        assert gamePanel.player.collisionOn == true : "Player collisionOn should be true";
        gamePanel.keyH.upPressed = false;
        gamePanel.keyH.leftPressed = false;

        // Check Up Right
        gamePanel.player.setDefaultValues();
        gamePanel.player.speed = 16;
        gamePanel.player.diagonalSpeed = 16;

        assert gamePanel.player.worldX == gamePanel.getTileSize() * 23 : "Player worldX should be 1472";
        assert gamePanel.player.worldY == gamePanel.getTileSize() * 21 : "Player worldY should be 1344";

        assert gamePanel.player.speed == 16 : "Player speed should be 16";
        assert gamePanel.player.diagonalSpeed == 16 : "Player diagonal speed should be 12";
        assert gamePanel.player.direction.equals("none") : "Player direction should be none";

        gamePanel.player.direction = "up_right";
        gamePanel.keyH.upPressed = true;
        gamePanel.keyH.rightPressed = true;

        // Moves 16 pixels up and right
        gamePanel.player.update();
        // Player should collide with a tile
        gamePanel.cChecker.CheckTile(gamePanel.player);
        assert gamePanel.player.collisionOn == true : "Player collisionOn should be true";
        gamePanel.keyH.upPressed = false;
        gamePanel.keyH.rightPressed = false;

        // Check Down Left
        gamePanel.player.setDefaultValues();
        gamePanel.player.speed = 16;
        gamePanel.player.diagonalSpeed = 16;

        gamePanel.player.worldY = gamePanel.getTileSize() * 22;

        assert gamePanel.player.worldX == gamePanel.getTileSize() * 23 : "Player worldX should be 1472";
        assert gamePanel.player.worldY == gamePanel.getTileSize() * 22 : "Player worldY should be 1344";

        assert gamePanel.player.speed == 16 : "Player speed should be 16";
        assert gamePanel.player.diagonalSpeed == 16 : "Player diagonal speed should be 12";
        assert gamePanel.player.direction.equals("none") : "Player direction should be none";

        gamePanel.player.direction = "down_left";
        gamePanel.keyH.downPressed = true;
        gamePanel.keyH.leftPressed = true;

        // Moves 16 pixels down and left
        gamePanel.player.update();
        // Player should collide with a tile
        gamePanel.cChecker.CheckTile(gamePanel.player);
        assert gamePanel.player.collisionOn == true : "Player collisionOn should be true";
        gamePanel.keyH.downPressed = false;
        gamePanel.keyH.leftPressed = false;

        // Check Down Right
        gamePanel.player.setDefaultValues();
        gamePanel.player.speed = 16;
        gamePanel.player.diagonalSpeed = 16;

        gamePanel.player.worldY = gamePanel.getTileSize() * 22;

        assert gamePanel.player.worldX == gamePanel.getTileSize() * 23 : "Player worldX should be 1472";
        assert gamePanel.player.worldY == gamePanel.getTileSize() * 22 : "Player worldY should be 1344";

        assert gamePanel.player.speed == 16 : "Player speed should be 16";
        assert gamePanel.player.diagonalSpeed == 16 : "Player diagonal speed should be 12";
        assert gamePanel.player.direction.equals("none") : "Player direction should be none";

        gamePanel.player.direction = "down_right";
        gamePanel.keyH.downPressed = true;
        gamePanel.keyH.rightPressed = true;

        // Moves 16 pixels down and right
        gamePanel.player.update();
        // Player should collide with a tile
        gamePanel.cChecker.CheckTile(gamePanel.player);
        assert gamePanel.player.collisionOn == true : "Player collisionOn should be true";
        gamePanel.keyH.downPressed = false;
        gamePanel.keyH.rightPressed = false;
    }
}
