package main;

import object.ObjChest;
import object.ObjDoor;
import object.ObjKey;
import object.SuperObject;

public class AssetSetter {

    GamePanel gp;
    public AssetSetter(GamePanel gp) {
        this.gp = gp;
    }

    public void setObject() {
        gp.obj[0] = new ObjKey();
        gp.obj[0].worldX = gp.tileSize * 23;
        gp.obj[0].worldY = gp.tileSize * 19;

        gp.obj[1] = new ObjKey();
        gp.obj[1].worldX = gp.tileSize * 19;
        gp.obj[1].worldY = gp.tileSize * 40;

        gp.obj[2] = new ObjKey();
        gp.obj[2].worldX = gp.tileSize * 23;
        gp.obj[2].worldY = gp.tileSize * 29;

        gp.obj[3] = new ObjDoor();
        gp.obj[3].worldX = gp.tileSize * 23;
        gp.obj[3].worldY = gp.tileSize * 39;

        gp.obj[4] = new ObjDoor();
        gp.obj[4].worldX = gp.tileSize * 30;
        gp.obj[4].worldY = gp.tileSize * 39;

        gp.obj[5] = new ObjDoor();
        gp.obj[5].worldX = gp.tileSize * 30;
        gp.obj[5].worldY = gp.tileSize * 29;

        gp.obj[6] = new ObjChest();
        gp.obj[6].worldX = gp.tileSize * 10;
        gp.obj[6].worldY = gp.tileSize * 10;

        gp.obj[7] = new ObjChest();
        gp.obj[7].worldX = gp.tileSize * 10;
        gp.obj[7].worldY = gp.tileSize * 20;

        gp.obj[8] = new ObjChest();
        gp.obj[8].worldX = gp.tileSize * 10;
        gp.obj[8].worldY = gp.tileSize * 30;


    }
}
