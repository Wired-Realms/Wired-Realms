package Entity;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Player extends Entity{

    GamePanel gamePanel;
    KeyHandler keyH;

    public Player(GamePanel gamePanel, KeyHandler keyH) {
        this.gamePanel = gamePanel;
        this.keyH = keyH;

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {
        x = 100;
        y = 100;
        speed = 4;
        direction = "down";
    }

    public void getPlayerImage() {

        try {

            defaultPlayer = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().
                    getResource("player/player.png")));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {
        if (keyH.upPressed && keyH.leftPressed) {

            y -= (speed / Math.sqrt(2));
            x -= (speed / Math.sqrt(2));
        } else if (keyH.upPressed && keyH.rightPressed) {

            y -= (speed / Math.sqrt(2));
            x += (speed / Math.sqrt(2));
        } else if (keyH.downPressed && keyH.leftPressed) {

            y += (speed / Math.sqrt(2));
            x -= (speed / Math.sqrt(2));
        } else if (keyH.downPressed && keyH.rightPressed) {

            y += (speed / Math.sqrt(2));
            x += (speed / Math.sqrt(2));
        } else if (keyH.upPressed) {
            direction = "up";
            y -= speed;
        } else if (keyH.downPressed) {
            direction = "down";
            y += speed;
        } else if (keyH.leftPressed) {
            direction = "left";
            x -= speed;
        } else if (keyH.rightPressed) {
            direction = "right";
            x += speed;
        }
    }

    public void draw(Graphics2D g2) {

        BufferedImage image = null;

        switch (direction) {
            case "down":
                image = defaultPlayer;
                break;
        }

        g2.drawImage(image, x, y, gamePanel.getTileSize(), gamePanel.getTileSize(), null);
//        g2.setColor(Color.WHITE);
//        g2.fillRect(x, y, gamePanel.getTileSize(), gamePanel.getTileSize());
    }
}
