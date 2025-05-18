package object;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class ObjChest extends SuperObject{

    public ObjChest() {
        name = "Chest";
        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResource("objects/Chest.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
