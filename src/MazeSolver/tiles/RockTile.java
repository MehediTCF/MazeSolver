
package mazesolver.tiles;

import mazesolver.Graphics.Assets;


    
public class RockTile extends Tile {

	public RockTile(int id) {
		super(Assets.stone, id);
	}
	
	
	public boolean issolid(){
		return true;
	}

}
