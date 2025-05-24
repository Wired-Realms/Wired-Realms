package tests;

import main.GamePanel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestGetObject {

    GamePanel gamePanel = new GamePanel();
    int num_obj = 9; // MAY CHANGE
    int num_keys = 3; // MAY CHANGE
    int num_doors = 3; // MAY CHANGE
    int num_chests = 3; // MAY CHANGE

    @BeforeEach
    void setUp() {
        // Set up the game panel before each test
        gamePanel.setUpGame();
    }

    // Test to check if the object images are loaded correctly
    @Test
    void checkGetObjectImage() {
        // Check objects
        for (int i = 0; i < num_obj; i++) {
            assert gamePanel.obj[i] != null : "Object " + i + " should not be null";
        }

        // Check if the images are in the correct order
        assert gamePanel.obj[0].name.equals("Key");
        assert gamePanel.obj[1].name.equals("Key");
        assert gamePanel.obj[2].name.equals("Key");
        assert gamePanel.obj[3].name.equals("Door");
        assert gamePanel.obj[4].name.equals("Door");
        assert gamePanel.obj[5].name.equals("Door");
        assert gamePanel.obj[6].name.equals("Chest");
        assert gamePanel.obj[7].name.equals("Chest");
        assert gamePanel.obj[8].name.equals("Chest");
    }

    @Test
    void testObjectCollision() {
        // Check if the objects have collision set correctly
        assert !gamePanel.obj[0].collision : "Key should not have collision";
        assert !gamePanel.obj[1].collision : "Key should not have collision";
        assert !gamePanel.obj[2].collision : "Key should not have collision";
        assert gamePanel.obj[3].collision : "Door should have collision";
        assert gamePanel.obj[4].collision : "Door should have collision";
        assert gamePanel.obj[5].collision : "Door should have collision";
        assert gamePanel.obj[6].collision : "Chest should have collision";
        assert gamePanel.obj[7].collision : "Chest should have collision";
        assert gamePanel.obj[8].collision : "Chest should have collision";

        // Check if the player interacts with the objects correctly

        for (int i = 0; i < num_obj; i++) {
            // check up direction
            setUpPlayer(gamePanel.obj[i].worldX, gamePanel.obj[i].worldY + 2, "up");
            int index = gamePanel.cChecker.checkObject(gamePanel.player, true);
            assert index == i : "Player should interact with Object at index " + i;

            // check down direction
            setUpPlayer(gamePanel.obj[i].worldX, gamePanel.obj[i].worldY - 2, "down");
            index = gamePanel.cChecker.checkObject(gamePanel.player, true);
            assert index == i : "Player should interact with Object at index " + i + " when moving down";

            // check left direction
            setUpPlayer(gamePanel.obj[i].worldX + 2, gamePanel.obj[i].worldY, "left");
            index = gamePanel.cChecker.checkObject(gamePanel.player, true);
            assert index == i : "Player should interact with Object at index " + i + " when moving left";

            // check right direction
            setUpPlayer(gamePanel.obj[i].worldX - 2, gamePanel.obj[i].worldY, "right");
            index = gamePanel.cChecker.checkObject(gamePanel.player, true);
            assert index == i : "Player should interact with Object at index " + i + " when moving right";

            // check up-left direction
            setUpPlayer(gamePanel.obj[i].worldX + 2, gamePanel.obj[i].worldY + 2, "up_left");
            index = gamePanel.cChecker.checkObject(gamePanel.player, true);
            assert index == i : "Player should interact with Object at index " + i + " when moving up-left";

            // check up-right direction
            setUpPlayer(gamePanel.obj[i].worldX - 2, gamePanel.obj[i].worldY + 2, "up_right");
            index = gamePanel.cChecker.checkObject(gamePanel.player, true);
            assert index == i : "Player should interact with Object at index " + i + " when moving up-right";

            // check down-left direction
            setUpPlayer(gamePanel.obj[i].worldX + 2, gamePanel.obj[i].worldY - 2, "down_left");
            index = gamePanel.cChecker.checkObject(gamePanel.player, true);
            assert index == i : "Player should interact with Object at index " + i + " when moving down-left";

            // check down-right direction
            setUpPlayer(gamePanel.obj[i].worldX - 2, gamePanel.obj[i].worldY - 2, "down_right");
            index = gamePanel.cChecker.checkObject(gamePanel.player, true);
            assert index == i : "Player should interact with Object at index " + i + " when moving down-right";
        }

    }

    @Test
    public void testPickUpObject() {
        // Test if the player can pick up objects correctly
        for (int i = 0; i < num_keys; i++) {
            setUpPlayer(gamePanel.obj[i].worldX, gamePanel.obj[i].worldY, "up");
            int index = gamePanel.cChecker.checkObject(gamePanel.player, true);
            gamePanel.player.pickUpObject(index);
            assert gamePanel.obj[index] == null : "Object at index " + index + " should be picked up";
        }

        // Test if the player can interact with doors
        for (int i = 0; i < 3; i++) {
            setUpPlayer(gamePanel.obj[i + num_keys].worldX, gamePanel.obj[i + num_keys].worldY, "up");
            int index = gamePanel.cChecker.checkObject(gamePanel.player, true);
            gamePanel.player.pickUpObject(index);
            assert gamePanel.obj[index] == null : "Object at index " + index + " should disappear after interaction";
        }
    }

    public void setUpPlayer(int x, int y, String direction) {
        // Set up the player position and direction
        gamePanel.player.worldX = x;
        gamePanel.player.worldY = y;
        gamePanel.player.direction = direction;

    }

    // Add test for position of objects later
}
