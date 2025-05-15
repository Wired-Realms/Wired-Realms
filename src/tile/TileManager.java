package tile;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.*;
import java.util.Objects;

public class TileManager {

    GamePanel gp;
    public Tile[] tiles;
    public int[][] mapTileNum;

    public TileManager(GamePanel gp) {
        this.gp = gp;
        tiles = new Tile[10];
        mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];

        getTileImage();
        loadMap("/maps/map01.txt");
    }

    public void getTileImage () {

        try {
            tiles[0] = new Tile();
            tiles[0].image = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResource("tile/Grass.png")));
            tiles[0].filename = "Grass.png";

            tiles[1] = new Tile();
            tiles[1].image = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResource("tile/Dirt.png")));
            tiles[1].filename = "Dirt.png";

            tiles[2] = new Tile();
            tiles[2].image = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResource("tile/Fence_Horizontal.png")));
            tiles[2].filename = "Fence_Horizontal.png";
            tiles[2].collision = true;

            tiles[3] = new Tile();
            tiles[3].image = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResource("tile/Fence_Corner_Up_Left.png")));
            tiles[3].filename = "Fence_Corner_Up_Left.png";
            tiles[3].collision = true;

            tiles[4] = new Tile();
            tiles[4].image = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResource("tile/Fence_Corner_Up_Right.png")));
            tiles[4].filename = "Fence_Corner_Up_Right.png";
            tiles[4].collision = true;

            tiles[5] = new Tile();
            tiles[5].image = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResource("tile/Fence_Corner_Down_Left.png")));
            tiles[5].filename = "Fence_Corner_Down_Left.png";
            tiles[5].collision = true;

            tiles[6] = new Tile();
            tiles[6].image = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResource("tile/Fence_Corner_Down_Right.png")));
            tiles[6].filename = "Fence_Corner_Down_Right.png";
            tiles[6].collision = true;

        } catch (IOException e) {
            e.printStackTrace((PrintWriter) PrintWriter.nullWriter());
        }
    }

    public void loadMap(String filePath) {

        try {
            InputStream is = getClass().getResourceAsStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while (col < gp.maxWorldCol && row < gp.maxWorldRow) {
                String line = br.readLine();

                while (col < gp.maxWorldCol) {

                    String[] numbers = line.split(" ");

                    int num = Integer.parseInt(numbers[col]);
                    mapTileNum[col][row] = num;
                    col++;
                }
                if(col == gp.maxWorldCol) {
                    col = 0;
                    row++;
                }
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2) {

        int worldCol = 0;
        int worldRow = 0;

        while (worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow) {

            int tileNum = mapTileNum[worldCol][worldRow];

            int worldX = worldCol * gp.getTileSize();
            int worldY = worldRow * gp.getTileSize();
            int screenX = worldX - gp.player.worldX + gp.player.screenX;
            int screenY = worldY - gp.player.worldY + gp.player.screenY;

            if (worldX + gp.getTileSize() > gp.player.worldX - gp.player.screenX &&
                worldX - gp.getTileSize() < gp.player.worldX + gp.player.screenX &&
                worldY + gp.getTileSize() > gp.player.worldY - gp.player.screenY &&
                worldY - gp.getTileSize() < gp.player.worldY + gp.player.worldY) {

                g2.drawImage(tiles[tileNum].image, screenX, screenY, gp.getTileSize(), gp.getTileSize(), null);
            }
            worldCol++;

            if (worldCol == gp.maxWorldCol) {
                worldCol = 0;
                worldRow++;
            }
        }
    }
}
