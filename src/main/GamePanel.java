package main;

import Entity.Player;
import object.SuperObject;
import tile.TileManager;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{

    // SCREEN SETTINGS
    final int originalTileSize = 16; // 16 x 16 tile
    final int scale = 4;
    final int tileSize = originalTileSize * scale; // 64 x 64 tile

    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol; // 768px
    final int screenHeight = tileSize * maxScreenRow; // 576px

    // WORLD SETTINGS
    public final int maxWorldCol = 50;
    public final int maxWorldRow = 50;
    public final int worldWidth = tileSize * maxWorldCol; // 800px
    public final int worldHeight = tileSize * maxWorldRow; // 800px

    // FPS

    final int fps = 60;

    public KeyHandler keyH = new KeyHandler();
    Thread gameThread;

    public CollisionChecker cChecker = new CollisionChecker(this);
    public Player player = new Player(this, keyH);
    TileManager tileManager = new TileManager(this);

    public SuperObject[] obj = new SuperObject[10];
    public AssetSetter aSetter = new AssetSetter(this);

    public GamePanel() {

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void setUpGame() {

        aSetter.setObject();
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
        player.update();
    }

    // Standard method to draw in JPanel
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        // tile
        tileManager.draw(g2);
        // objects
        for (int i = 0; i < obj.length; i++) {
            if (obj[i] != null) {
                obj[i].draw(g2, this);
            }
        }
        // player
        player.draw(g2);

        g2.dispose();
    }

    public int getTileSize() {
        return tileSize;
    }

    public int getMaxScreenCol() {
        return maxScreenCol;
    }

    public int getMaxScreenRow() {
        return maxScreenRow;
    }

    public int getScreenWidth() {
        return screenWidth;
    }

    public int getScreenHeight() {
        return screenHeight;
    }
}
