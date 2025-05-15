package main;

import Entity.Entity;

public class CollisionChecker {

    GamePanel gp;
    public CollisionChecker(GamePanel gp) {
        this.gp = gp;
    }

    public void CheckTile(Entity entity) {

        // Get entity's coordinates
        int entityLeftWorldX = entity.worldX + entity.solidArea.x;
        int entityRightWorldX = entity.worldX + entity.solidArea.x + entity.solidArea.width;
        int entityTopWorldY = entity.worldY + entity.solidArea.y;
        int entityBottomWorldY = entity.worldY + entity.solidArea.y + entity.solidArea.height;

        // Get entity's coordinates in tile
        int entityLeftCol = entityLeftWorldX / gp.tileSize;
        int entityRightCol = entityRightWorldX / gp.tileSize;
        int entityTopRow = entityTopWorldY / gp.tileSize;
        int entityBottomRow = entityBottomWorldY / gp.tileSize;

        int tileNum1, tileNum2;

        switch (entity.direction) {
            case "up":
                entityTopRow = (entityTopWorldY - entity.speed) / gp.tileSize;
                tileNum1 = gp.tileManager.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.tileManager.mapTileNum[entityRightCol][entityTopRow];

                if (gp.tileManager.tiles[tileNum1].collision == true ||
                        gp.tileManager.tiles[tileNum2].collision == true) {
                    entity.collisionOn = true;
                }
                break;
            case "down":
                entityBottomRow = (entityBottomWorldY + entity.speed) / gp.tileSize;
                tileNum1 = gp.tileManager.mapTileNum[entityLeftCol][entityBottomRow];
                tileNum2 = gp.tileManager.mapTileNum[entityRightCol][entityBottomRow];

                if (gp.tileManager.tiles[tileNum1].collision == true ||
                        gp.tileManager.tiles[tileNum2].collision == true) {
                    entity.collisionOn = true;
                }
                break;
            case "left":
                entityLeftCol = (entityLeftWorldX - entity.speed) / gp.tileSize;
                tileNum1 = gp.tileManager.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.tileManager.mapTileNum[entityLeftCol][entityBottomRow];

                if (gp.tileManager.tiles[tileNum1].collision == true ||
                        gp.tileManager.tiles[tileNum2].collision == true) {
                    entity.collisionOn = true;
                }
                break;
            case "right":
                entityRightCol = (entityRightWorldX + entity.speed) / gp.tileSize;
                tileNum1 = gp.tileManager.mapTileNum[entityRightCol][entityTopRow];
                tileNum2 = gp.tileManager.mapTileNum[entityRightCol][entityBottomRow];

                if (gp.tileManager.tiles[tileNum1].collision == true ||
                        gp.tileManager.tiles[tileNum2].collision == true) {
                    entity.collisionOn = true;
                }
                break;
            case "up_left":
                entityTopRow = (entityTopWorldY - 3) / gp.tileSize;
                entityLeftCol = (entityLeftWorldX - 3) / gp.tileSize;
                tileNum1 = gp.tileManager.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.tileManager.mapTileNum[entityRightCol][entityTopRow];

                if (gp.tileManager.tiles[tileNum1].collision == true ||
                        gp.tileManager.tiles[tileNum2].collision == true) {
                    entity.collisionOn = true;
                }
                break;
            case "up_right":
                entityTopRow = (entityTopWorldY - 3) / gp.tileSize;
                entityRightCol = (entityRightWorldX + 3) / gp.tileSize;
                tileNum1 = gp.tileManager.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.tileManager.mapTileNum[entityRightCol][entityTopRow];

                if (gp.tileManager.tiles[tileNum1].collision == true ||
                        gp.tileManager.tiles[tileNum2].collision == true) {
                    entity.collisionOn = true;
                }
                break;
            case "down_left":
                entityBottomRow = (entityBottomWorldY + 3) / gp.tileSize;
                entityLeftCol = (entityLeftWorldX - 3) / gp.tileSize;
                tileNum1 = gp.tileManager.mapTileNum[entityLeftCol][entityBottomRow];
                tileNum2 = gp.tileManager.mapTileNum[entityRightCol][entityBottomRow];

                if (gp.tileManager.tiles[tileNum1].collision == true ||
                        gp.tileManager.tiles[tileNum2].collision == true) {
                    entity.collisionOn = true;
                }
                break;
            case "down_right":
                entityBottomRow = (entityBottomWorldY + 3) / gp.tileSize;
                entityRightCol = (entityRightWorldX + 3) / gp.tileSize;
                tileNum1 = gp.tileManager.mapTileNum[entityLeftCol][entityBottomRow];
                tileNum2 = gp.tileManager.mapTileNum[entityRightCol][entityBottomRow];

                if (gp.tileManager.tiles[tileNum1].collision == true ||
                        gp.tileManager.tiles[tileNum2].collision == true) {
                    entity.collisionOn = true;
                }
                break;
            default:
                break;
        }
    }
}
