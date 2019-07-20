
package mazesolver.Graphics;

import MazeSolver.Game;
import MazeSolver.Handelar;
import mazesolver.entities.Entity;
import mazesolver.tiles.Tile;

public class GameCamera {
    private float xOffset,yOffset;
    private Handelar handelar;
    
    public GameCamera(Handelar handelar,float xOffset,float yOffset) {
        this.xOffset=xOffset;
        this.yOffset=yOffset;
        this.handelar=handelar;
    }
    public void CheckBlanckSpace(){
        if(xOffset<0) {
            xOffset=0;
        }
        else if(xOffset>handelar.getWorld().getWidth()*Tile.TileWidth-handelar.getWidth()){
           xOffset=handelar.getWorld().getWidth()*Tile.TileWidth-handelar.getWidth(); 
        }
        if(yOffset<0) {
            yOffset=0;
        }
         else if(yOffset>handelar.getWorld().getHeight()*Tile.TileHeight-handelar.getHeight()){
           yOffset=handelar.getWorld().getHeight()*Tile.TileHeight-handelar.getHeight(); 
        }
        
    }

    public void move(float xAmt,float yAmt) {
        xOffset+=xAmt;
        yOffset+=yAmt;
    }
    public void centerOnEntity(Entity e) {
        xOffset=e.getX()-handelar.getWidth()/2+e.getWidth()/2;
        yOffset=e.getY()-handelar.getHeight()/2+e.getHeight()/2;
        CheckBlanckSpace();
    }
    public float getxOffset() {
        return xOffset;
    }

    public void setxOffset(float xOffset) {
        this.xOffset = xOffset;
    }

    public float getyOffset() {
        return yOffset;
    }

    public void setyOffset(float yOffset) {
        this.yOffset = yOffset;
    }
}
