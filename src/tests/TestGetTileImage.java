package tests;

import main.GamePanel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tile.TileManager;

import java.awt.image.BufferedImage;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestGetTileImage {

    GamePanel gamePanel = new GamePanel();
    TileManager tileManager = new TileManager(gamePanel);

    @Test
    void checkGetTileImage() {

        tileManager.getTileImage();

        // Check if the images are not null
        assert tileManager.tiles[0].image != null;
        assert tileManager.tiles[1].image != null;
        assert tileManager.tiles[2].image != null;
        assert tileManager.tiles[3].image != null;
        assert tileManager.tiles[4].image != null;
        assert tileManager.tiles[5].image != null;
        assert tileManager.tiles[6].image != null;

        // Check if the images are in the correct order

        assertInstanceOf(BufferedImage.class, tileManager.tiles[0].image, "Grass image should be a BufferedImage");
        assertInstanceOf(BufferedImage.class, tileManager.tiles[1].image, "Dirt image should be a BufferedImage");
        assertInstanceOf(BufferedImage.class, tileManager.tiles[2].image, "Fence_Horizontal image should be a BufferedImage");
        assertInstanceOf(BufferedImage.class, tileManager.tiles[3].image, "Fence_Corner_Up_Left image should be a BufferedImage");
        assertInstanceOf(BufferedImage.class, tileManager.tiles[4].image, "Fence_Corner_Up_Right image should be a BufferedImage");
        assertInstanceOf(BufferedImage.class, tileManager.tiles[5].image, "Fence_Corner_Down_Left image should be a BufferedImage");
        assertInstanceOf(BufferedImage.class, tileManager.tiles[6].image, "Fence_Corner_Down_Right image should be a BufferedImage");

        Assertions.assertEquals("Grass.png", tileManager.tiles[0].filename, "First tile should be Grass");
        Assertions.assertEquals("Dirt.png", tileManager.tiles[1].filename, "Second tile should be Dirt");
        Assertions.assertEquals("Fence_Horizontal.png", tileManager.tiles[2].filename, "Third tile should be Fence");
        Assertions.assertEquals("Fence_Corner_Up_Left.png", tileManager.tiles[3].filename, "Fourth tile should be Fence_Corner_Up_Left");
        Assertions.assertEquals("Fence_Corner_Up_Right.png", tileManager.tiles[4].filename, "Fifth tile should be Fence_Corner_Up_Right");
        Assertions.assertEquals("Fence_Corner_Down_Left.png", tileManager.tiles[5].filename, "Sixth tile should be Fence_Corner_Down_Left");
    }
}
