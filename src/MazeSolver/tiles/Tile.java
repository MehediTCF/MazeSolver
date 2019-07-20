
package mazesolver.tiles;


import java.awt.Graphics;
import java.awt.image.BufferedImage;
import mazesolver.entities.SolidEntity.Tree;

public class Tile {
  public static Tile[] tiles = new Tile[256];
	public static Tile grassTile = new GrassTile(0);
	public static Tile dirtTile = new DirtTile(1);
	public static Tile rockTile = new RockTile(2);
        public static Tile enemytile = new EnemyTile(5);
        public static Tile enemyup = new EnemyUp(6);
        public static Tile NextTile = new NextLevel(4);
        public static Tile HomeTile = new home(7);
       
       
        
        public static final int TileWidth=64,TileHeight=64;
   
        
    protected BufferedImage texture;
    protected final int id;
    
    public Tile(BufferedImage texture,int id) {
        this.texture=texture;
        this.id=id;
        tiles[id]=this;
    }
    
    public void tick() {
        
    }
    public void render(Graphics g,int x,int y){
        g.drawImage(texture, x, y, TileWidth, TileHeight, null);
    }
    public boolean issolid() {
         return false;
    }
    public int getid() {
        return id;
    }
}
