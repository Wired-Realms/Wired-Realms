package tests;

import main.GamePanel;
import org.junit.jupiter.api.Test;
import tile.TileManager;

import java.awt.image.BufferedImage;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class testGetTileImage {

    GamePanel gamePanel = new GamePanel();
    TileManager tileManager = new TileManager(gamePanel);

    @Test
    void testGetTileImage() {

        tileManager.getTileImage();

        // Check if the images are not null
        assert tileManager.tiles[0].image != null;
        assert tileManager.tiles[1].image != null;
        assert tileManager.tiles[2].image != null;

        // Check if the images are in the correct order

        assertInstanceOf(BufferedImage.class, tileManager.tiles[0].image, "Grass image should be a BufferedImage");
        assertInstanceOf(BufferedImage.class, tileManager.tiles[1].image, "Dirt image should be a BufferedImage");
        assertInstanceOf(BufferedImage.class, tileManager.tiles[2].image, "Fence image should be a BufferedImage");

        assertEquals("First tile should be Grass","Grass.png", tileManager.tiles[0].filename);
        assertEquals("Second tile should be Dirt","Dirt.png", tileManager.tiles[1].filename);
        assertEquals("Third tile should be Fence","Fence.png", tileManager.tiles[2].filename);
    }
}
