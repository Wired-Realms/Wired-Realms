package tests;

import main.GamePanel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestGetObject {

    GamePanel gamePanel = new GamePanel();
    int num_obj = 9; // MAY CHANGE

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

    // Add test for position of objects later
}
