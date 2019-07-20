
package mazesolver.tiles;

import java.awt.image.BufferedImage;
import mazesolver.Graphics.Assets;


public class EnemyTile extends Tile {
    
   public EnemyTile(int id) {
		super(Assets.zombie_left, id);
	}
	
	
   @Override
	public boolean issolid(){
		return true;
	}
    
}
