
package mazesolver.Graphics;


import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class Image {
    public static BufferedImage loadImage(String path) {
        try {
            return ImageIO.read(Image.class.getResource(path));
        } catch (IOException ex) {
            Logger.getLogger(Image.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(1);
        }
        return null;
    }

   
}
