
package mazesolver.entities.SolidEntity;

import java.awt.Graphics;
import MazeSolver.Handelar;
import mazesolver.entities.creatures.Creature;
import mazesolver.Graphics.Assets;
import mazesolver.tiles.Tile;


public class Enemy extends SolidEntity{
    private Creature creature;
     public Enemy(Handelar handelar, float x, float y) {
        super(handelar, x, y, Tile.TileWidth, Tile.TileHeight);
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
        	g.drawImage(Assets.zombie_down[0], (int) (x - handelar.getGameCamera().getxOffset()), (int) (y - handelar.getGameCamera().getyOffset()), width, height, null);
    }

}
