package object;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class ObjKey extends SuperObject{

    public ObjKey() {
        name = "Key";
        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResource("objects/Key.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
