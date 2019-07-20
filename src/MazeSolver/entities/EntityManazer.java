
package mazesolver.entities;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Comparator;
import MazeSolver.Handelar;
import mazesolver.entities.creatures.Player;

public class EntityManazer {
    private Handelar handelar;
    private Player player;
    private ArrayList<Entity> entities;
    
    private Comparator<Entity> renderSort=new Comparator<Entity>() {
        @Override
        public int compare(Entity a, Entity b) {
         if(a.getY()+a.getHeight()<b.getY()+b.getHeight())
             return -1;
         return 1;
        }
    };
    
    public EntityManazer(Handelar handelar,Player player) {
        this.handelar=handelar;
        this. player=player;
        entities=new ArrayList<>();
        addEntity(player);
    }
    public void tick(){
        for(int i=0;i<entities.size();i++) {
           Entity  e=entities.get(i);
           e.tick();
           if(!e.isactive())
               entities.remove(e);
       }
     entities.sort(renderSort);
    }
   public void render(Graphics g) {
       for(Entity e:entities){
           e.render(g);
       }
      
   }

   public void addEntity(Entity e) {
       entities.add(e);
   }
    public Handelar getHandelar() {
        return handelar;
    }

    public void setHandelar(Handelar handelar) {
        this.handelar = handelar;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public ArrayList<Entity> getEntities() {
        return entities;
    }

    public void setEntities(ArrayList<Entity> entities) {
        this.entities = entities;
    }
   
}
