
package mazesolver.entities.creatures;

import java.awt.Graphics;
import MazeSolver.Game;
import MazeSolver.Handelar;
import mazesolver.entities.Entity;
import mazesolver.Graphics.Assets;
import mazesolver.tiles.Tile;

public abstract class Creature extends Entity{

   
   public static final float DEFAULT_SPEED = 3.0f;
   public static final int DEFAULT_CREATURE_WIDTH = 64,DEFAULT_CREATURE_HEIGHT = 64;
    
   
	protected float speed;
	protected float xMove, yMove;
        
    public Creature(Handelar handelar,float x, float y, int width, int height) {
        super(handelar,x, y,width, height);
      
		speed = DEFAULT_SPEED;
		xMove = 0;
		yMove = 0;
    }
    public void move(){
        if(!checkEntityColisions(xMove, 0f))
		      moveX();
        if(!checkEntityColisions(0f, yMove))
                      moveY();
        
		
	}
   public void moveX(){
		if(xMove > 0){//Moving right
			int tx = (int) (x + xMove + bounds.x + bounds.width) / Tile.TileWidth;
			
			if(!CollisionTile(tx, (int) (y + bounds.y) / Tile.TileHeight) &&
					!CollisionTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TileHeight)){
				x += xMove;
			}
                        else{
                            x=tx*Tile.TileWidth-bounds.x-bounds.width-1;
                        }
		}else if(xMove < 0){//Moving left
			int tx = (int) (x + xMove + bounds.x) / Tile.TileWidth;
			
			if(!CollisionTile(tx, (int) (y + bounds.y) / Tile.TileHeight) &&
					!CollisionTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TileHeight)){
				x += xMove;
			}
                        else{
                            x=tx*Tile.TileWidth+Tile.TileWidth-bounds.x;
                        }
		}
	}
    public void moveY(){
		if(yMove < 0){//Up
			int ty = (int) (y + yMove + bounds.y) / Tile.TileHeight;
			
			if(!CollisionTile((int) (x + bounds.x) / Tile.TileWidth, ty) &&
					!CollisionTile((int) (x + bounds.x + bounds.width) / Tile.TileWidth, ty)){
				y += yMove;
			}
                        else{
                            y=ty*Tile.TileHeight+Tile.TileHeight-bounds.y;
                        }
		}else if(yMove > 0){//Down
			int ty = (int) (y + yMove + bounds.y + bounds.height) / Tile.TileHeight;
			
			if(!CollisionTile((int) (x + bounds.x) / Tile.TileWidth, ty) &&
					!CollisionTile((int) (x + bounds.x + bounds.width) / Tile.TileWidth, ty)){
				y += yMove;
			}
                        else{
                             y=ty*Tile.TileHeight-bounds.y-bounds.height-1;
                        }
		}
	}
    protected boolean CollisionTile(int x,int y) {
        return handelar.getWorld().getTile(x, y).issolid();
    }

    public float getxMove() {
        return xMove;
    }

    public void setxMove(float xMove) {
        this.xMove = xMove;
    }

    public float getyMove() {
        return yMove;
    }

    public void setyMove(float yMove) {
        this.yMove = yMove;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }
    
    
    @Override
    public void tick(){
        
    }
    @Override
    public void render(Graphics g) {
        //if(x>200&&y>=300)
           // g.drawImage(Assets.winner, 0, 0, null);
    }
   @Override
    public void die(){
        
    }

    
}
