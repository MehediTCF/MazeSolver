
package mazesolver.state;

import java.awt.Graphics;
import MazeSolver.Handelar;
import mazesolver.entities.creatures.Player;
import mazesolver.Graphics.Assets;
import mazesolver.tiles.Tile;
import mazesolver.worlds.World;

public class GameState extends State{

    private World world;
    public static int  level=3;
    public Player player;
   
   
    
    public GameState(Handelar handelar){
        super(handelar);
        
        
//        if(level==3)
            world =new World(handelar,"src/res/world/world3.txt");
         handelar.setWorld(world);
       
      
       handelar.getGameCamera().move(100,200);
    }
    

    @Override
    public void tick() {
        world.tick();
      
    }
    

    @Override
    public void render(Graphics g) {
        
       world.render(g);
       
    
       
     
    }
    
    
}
