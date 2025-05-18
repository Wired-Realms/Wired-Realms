package object;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class ObjDoor extends SuperObject {

    public ObjDoor() {
        name = "Door";
        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResource("objects/Door.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
