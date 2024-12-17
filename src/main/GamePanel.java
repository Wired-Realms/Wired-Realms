package main;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{

    // SCREEN SETTINGS
    final int originalTileSize = 16; // 16 x 16 tile
    final int scale = 3;
    final int tileSize = originalTileSize * scale; // 48 x 48 tile

    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol; // 768px
    final int screenHeight = tileSize * maxScreenRow; // 576px

    // FPS

    final int fps = 60;

    KeyHandler keyH = new KeyHandler();
    Thread gameThread;

    // Set player's default position
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;

    double speedMagnitude = Math.sqrt(Math.pow(playerSpeed, 2) + Math.pow(playerSpeed, 2));

    public GamePanel() {

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    // Constructor for the Thread where the thread is started
    // It automatically calls run() method
    public void startGameThread() {

        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        double drawInterval = 1000000000.0 / fps;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while(gameThread != null) {

            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;

            lastTime = currentTime;

            if (delta >= 1) {
                update();
                repaint();
                delta--;
            }
        }
    }

    public void update() {

        if (keyH.upPressed && keyH.leftPressed) {

            playerY -= (playerSpeed / Math.sqrt(2));
            playerX -= (playerSpeed / Math.sqrt(2));
        } else if (keyH.upPressed && keyH.rightPressed) {

            playerY -= (playerSpeed / Math.sqrt(2));
            playerX += (playerSpeed / Math.sqrt(2));
        } else if (keyH.downPressed && keyH.leftPressed) {

            playerY += (playerSpeed / Math.sqrt(2));
            playerX -= (playerSpeed / Math.sqrt(2));
        } else if (keyH.downPressed && keyH.rightPressed) {

            playerY += (playerSpeed / Math.sqrt(2));
            playerX += (playerSpeed / Math.sqrt(2));
        } else if (keyH.upPressed) {
            playerY -= playerSpeed;
        } else if (keyH.downPressed) {
            playerY += playerSpeed;
        } else if (keyH.leftPressed) {
            playerX -= playerSpeed;
        } else if (keyH.rightPressed) {
            playerX += playerSpeed;
        }
    }

    // Standard method to draw in JPanel
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.WHITE);
        g2.fillRect(playerX, playerY, tileSize, tileSize);
        g2.dispose();
    }
}
