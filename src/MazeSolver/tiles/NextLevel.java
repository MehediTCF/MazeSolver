
package mazesolver.tiles;

import java.awt.image.BufferedImage;
import mazesolver.Graphics.Assets;


public class NextLevel extends Tile {

    public NextLevel(BufferedImage texture, int id) {
        super(texture, id);
    }
     public NextLevel( int id) {
        super(Assets.Nextlevel, id);
    }
}
