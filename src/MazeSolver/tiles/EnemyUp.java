
package mazesolver.tiles;

import mazesolver.Graphics.Assets;


public class EnemyUp extends Tile {
    public EnemyUp(int id) {
		super(Assets.zombie_up, id);
	}
	
	
   @Override
	public boolean issolid(){
		return true;
	}
}
