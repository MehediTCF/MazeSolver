
package mazesolver.entities.SolidEntity;

import MazeSolver.Handelar;
import mazesolver.entities.Entity;

public abstract class SolidEntity extends Entity{
    
    public SolidEntity(Handelar handelar, float x, float y, int width, int height) {
        super(handelar, x, y, width, height);
    }
    public boolean issolid(){
        return false;
    }
    
    @Override
    public void die() {
        
    }
    
}
