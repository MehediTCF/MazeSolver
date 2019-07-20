
package mazesolver.entities.SolidEntity;

import java.awt.Graphics;
import MazeSolver.Handelar;
import mazesolver.Graphics.Assets;
import mazesolver.tiles.Tile;


public class Tree  extends SolidEntity{
    

    public Tree(Handelar handelar, float x, float y) {
        super(handelar, x, y, Tile.TileWidth, Tile.TileHeight*2);
                bounds.x = 10;
		bounds.y = (int) (height / 1.5f);
		bounds.width = width - 20;
		bounds.height = (int) (height - height / 1.5f);
    }

    @Override
    public void tick() {
        
    }
     @Override
    public void die() {
       
    }

    @Override
    public void render(Graphics g) {
        	g.drawImage(Assets.tree, (int) (x - handelar.getGameCamera().getxOffset()), (int) (y - handelar.getGameCamera().getyOffset()), width, height, null);
    }

   
    
}
