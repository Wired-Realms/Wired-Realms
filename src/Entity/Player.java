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
        direction = "none";
    }

    public void getPlayerImage() {

        try {

            defaultPlayer = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().
                    getResource("player/player.png")));
            up1 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().
                    getResource("player/PlayerUp1.png")));
            up2 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().
                    getResource("player/PlayerUp2.png")));
            down1 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().
                    getResource("player/PlayerDown1.png")));
            down2 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().
                    getResource("player/PlayerDown2.png")));
            left1 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().
                    getResource("player/PlayerLeft1.png")));
            left2 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().
                    getResource("player/PlayerLeft2.png")));
            right1 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().
                    getResource("player/PlayerRight1.png")));
            right2 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().
                    getResource("player/PlayerRight2.png")));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {

        if (keyH.leftPressed || keyH.rightPressed || keyH.upPressed || keyH.downPressed) {

            double diagonalSpeed = speed / Math.sqrt(2);
            if (keyH.upPressed && keyH.leftPressed) {
                direction = "left";
                y -= diagonalSpeed;
                x -= diagonalSpeed;
            } else if (keyH.upPressed && keyH.rightPressed) {
                direction = "right";
                y -= diagonalSpeed;
                x += diagonalSpeed;
            } else if (keyH.downPressed && keyH.leftPressed) {
                direction = "left";
                y += diagonalSpeed;
                x -= diagonalSpeed;
            } else if (keyH.downPressed && keyH.rightPressed) {
                direction = "right";
                y += diagonalSpeed;
                x += diagonalSpeed;
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

            spriteCounter++;
            if (spriteCounter > 12) {
                if (spriteNum == 1) {
                    spriteNum = 2;
                } else if (spriteNum == 2) {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        }
//        else if (!keyH.downPressed && !keyH.upPressed && !keyH.leftPressed && !keyH.rightPressed) {
//            direction = "none";
//        }
    }

    public void draw(Graphics2D g2) {

        BufferedImage image = null;

//        image = defaultPlayer;
        switch (direction) {
            case "down":
                if (spriteNum == 1) {
                    image = down1;
                }
                if (spriteNum == 2) {
                    image = down2;
                }
                break;
            case "up":
                if (spriteNum == 1) {
                    image = up1;
                }
                if (spriteNum == 2) {
                    image = up2;
                }
                break;
            case "left":
                if (spriteNum == 1) {
                    image = left1;
                }
                if (spriteNum == 2) {
                    image = left2;
                }
                break;
            case "right":
                if (spriteNum == 1) {
                    image = right1;
                }
                if (spriteNum == 2) {
                    image = right2;
                }
                break;
            case "none":
                image = defaultPlayer;
                break;
        }

        g2.drawImage(image, x, y, gamePanel.getTileSize(), gamePanel.getTileSize(), null);
    }
}
