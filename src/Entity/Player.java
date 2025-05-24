package Entity;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

public class Player extends Entity{

    GamePanel gamePanel;
    KeyHandler keyH;

    public final int screenX;
    public final int screenY;

    int hasKeys = 0; // Number of keys player has

    public Player(GamePanel gamePanel, KeyHandler keyH) {
        this.gamePanel = gamePanel;
        this.keyH = keyH;

        screenX = gamePanel.getScreenWidth() / 2 - gamePanel.getTileSize() / 2;
        screenY = gamePanel.getScreenHeight() / 2 - gamePanel.getTileSize() / 2;

        solidArea = new Rectangle();
        // Start position of collision area top left corner
        solidArea.x = 16;
        solidArea.y = 24;
        // Width and height of collision area
        solidArea.width = 32;
        solidArea.height = 28;
        // 4 pixels from left and right
        // 6 pixels from top
        // 3 pixels from bottom

        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {
        worldX = gamePanel.getTileSize() * 23;
        worldY = gamePanel.getTileSize() * 21;
        speed = 4;
        diagonalSpeed = 3;
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
            e.printStackTrace((PrintWriter) PrintWriter.nullWriter());
        }
    }

    public void update() {

        if (keyH.leftPressed || keyH.rightPressed || keyH.upPressed || keyH.downPressed) {

            if (keyH.upPressed && keyH.leftPressed) {
                direction = "up_left";
            } else if (keyH.upPressed && keyH.rightPressed) {
                direction = "up_right";
            } else if (keyH.downPressed && keyH.leftPressed) {
                direction = "down_left";
            } else if (keyH.downPressed && keyH.rightPressed) {
                direction = "down_right";
            } else if (keyH.upPressed) {
                direction = "up";
            } else if (keyH.downPressed) {
                direction = "down";
            } else if (keyH.leftPressed) {
                direction = "left";
            } else if (keyH.rightPressed) {
                direction = "right";
            }

            // Check tile collision
            collisionOn = false;
            gamePanel.cChecker.CheckTile(this);

            // Check object collision
            int objIndex = gamePanel.cChecker.checkObject(this, true);
            pickUpObject(objIndex);
            // Collision False => Move Player
            if (collisionOn == false) {

                switch (direction) {
                    case "up":
                        worldY -= speed;
                        break;
                    case "down":
                        worldY += speed;
                        break;
                    case "left":
                        worldX -= speed;
                        break;
                    case "right":
                        worldX += speed;
                        break;
                    case "up_left":
                        worldY -= diagonalSpeed;
                        worldX -= diagonalSpeed;
                        break;
                    case "up_right":
                        worldY -= diagonalSpeed;
                        worldX += diagonalSpeed;
                        break;
                    case "down_left":
                        worldY += diagonalSpeed;
                        worldX -= diagonalSpeed;
                        break;
                    case "down_right":
                        worldY += diagonalSpeed;
                        worldX += diagonalSpeed;
                        break;
                    default:
                        break;

                }
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

    public void pickUpObject(int index) {
        // If player picks up an object
        if (index == -1) {
            return; // No object to pick up
        }

        String objName = gamePanel.obj[index].name;
        switch (objName) {
            case "Key":
                hasKeys++;
                gamePanel.obj[index] = null; // Remove the object from the game
                System.out.println("Picked up a key! Total keys: " + hasKeys);
                break;
            case "Door":
                if (hasKeys > 0) {
                    gamePanel.obj[index] = null; // Remove the object from the game
                    hasKeys--;
                    System.out.println("Opened a door! Remaining keys: " + hasKeys);
                } else {
                    System.out.println("No keys to open the door!");
                }
                break;
            default:
                System.out.println("Picked up: " + objName);
                break;
        }
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
            case "left", "up_left", "down_left":
                if (spriteNum == 1) {
                    image = left1;
                }
                if (spriteNum == 2) {
                    image = left2;
                }
                break;
            case "right", "up_right", "down_right":
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

        g2.drawImage(image, screenX, screenY, gamePanel.getTileSize(), gamePanel.getTileSize(), null);
    }
}
