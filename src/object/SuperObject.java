package object;

import main.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SuperObject {

    public BufferedImage image;
    public String name;
    public boolean collision = false;
    public int worldX, worldY;

    public void draw(Graphics2D g2, GamePanel gp) {
        // draw the object
        int screenX = worldX - gp.player.worldX + gp.player.screenX;
        int screenY = worldY - gp.player.worldY + gp.player.screenY;

        if (worldX + gp.getTileSize() > gp.player.worldX - gp.player.screenX &&
                worldX - gp.getTileSize() < gp.player.worldX + gp.player.screenX &&
                worldY + gp.getTileSize() > gp.player.worldY - gp.player.screenY &&
                worldY - gp.getTileSize() < gp.player.worldY + gp.player.worldY) {

            g2.drawImage(image, screenX, screenY, gp.getTileSize(), gp.getTileSize(), null);
        }
    }
}
