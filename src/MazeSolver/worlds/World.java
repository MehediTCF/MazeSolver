
package mazesolver.worlds;

import java.awt.Graphics;
import javax.swing.SizeRequirements;
import MazeSolver.Game;
import MazeSolver.Handelar;
import mazesolver.entities.EntityManazer;
import mazesolver.entities.SolidEntity.Enemy;
import mazesolver.entities.SolidEntity.Tree;
import mazesolver.entities.creatures.Player;

import mazesolver.tiles.Tile;
import mazesolver.utils.Utils;

public class World {
    private Handelar handelar;
    private int width,height;
    private int spawnX, spawnY;
    private int [][]tiles;
    private EntityManazer entityManazer;

    public EntityManazer getEntityManazer() {
        return entityManazer;
    }
    
    public World(Handelar handelar,String path) {
        this.handelar=handelar;
        entityManazer=new EntityManazer(handelar,new Player(handelar, 100, 100));
        //entityManazer.addEntity(new Enemy(handelar, 800,45));
         entityManazer.addEntity(new Tree(handelar, 150,100));
         entityManazer.addEntity(new Tree(handelar, 765,124));
         entityManazer.addEntity(new Tree(handelar, 969,633));
         entityManazer.addEntity(new Tree(handelar, 899,1094));
         entityManazer.addEntity(new Tree(handelar, 1473,1595));
         entityManazer.addEntity(new Tree(handelar, 1350,1067));
         entityManazer.addEntity(new Tree(handelar, 2126,1313));
         entityManazer.addEntity(new Tree(handelar, 2262,1576));
         entityManazer.addEntity(new Tree(handelar, 2178,635));
         entityManazer.addEntity(new Tree(handelar, 2689,190));
         entityManazer.addEntity(new Tree(handelar, 2824,1030));
         entityManazer.addEntity(new Tree(handelar, 2850,150));
         entityManazer.addEntity(new Tree(handelar, 2262,1576));
         entityManazer.addEntity(new Tree(handelar, 3517,380));
         entityManazer.addEntity(new Tree(handelar, 3658,1583));
         entityManazer.addEntity(new Tree(handelar, 1740,1584));
         entityManazer.addEntity(new Tree(handelar, 1996,968));
         
          
        loadworld(path);
        entityManazer.getPlayer().setX(spawnX);
         entityManazer.getPlayer().setY(spawnY);
    }

    
    public void tick() {
        entityManazer.tick();
    }
    public void render(Graphics g) {
        int xStart = (int) Math.max(0, handelar.getGameCamera().getxOffset() / Tile.TileWidth);
		int xEnd = (int) Math.min(width, (handelar.getGameCamera().getxOffset() + handelar.getWidth()) / Tile.TileWidth + 1);
		int yStart = (int) Math.max(0, handelar.getGameCamera().getyOffset() / Tile.TileHeight);
		int yEnd = (int) Math.min(height, (handelar.getGameCamera().getyOffset() + handelar.getHeight()) / Tile.TileHeight + 1);
		
        for(int y=yStart;y<yEnd;y++) {
            for(int x=xStart;x<xEnd;x++) {
                getTile(x,y).render(g,(int)(x*Tile.TileWidth-handelar.getGameCamera().getxOffset()),
                        (int)(y*Tile.TileHeight-handelar.getGameCamera().getyOffset()));
           
            }
        }
        entityManazer.render(g);
    }
    
  
    public Tile getTile(int x,int y) {
        if(x<0||x>=width||y<0||y>=height)
            return Tile.grassTile;
        Tile t=Tile.tiles[tiles[x][y]];
        if(t==null)
        return Tile.dirtTile;
        return t;
    }
 
    private void loadworld(String path) {
       
       String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);
		
		tiles = new int[width][height];
		for(int y = 0;y < height;y++){
			for(int x = 0;x < width;x++){
				tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);
			}
		}
       
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
    
    
}
