
package mazesolver.entities;

import java.awt.Graphics;
import java.awt.Rectangle;
import MazeSolver.Game;
import MazeSolver.Handelar;

public abstract class Entity {
    public float x;
    public float y;
    protected int width,height;
    protected Handelar handelar;
    protected int health;
    public static final int DEFAULT_HEALTH=10 ;
    protected Rectangle bounds;
    protected boolean active=true;
    public Entity(Handelar handelar,float x,float y,int width,int height) {
        this.handelar=handelar;
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
         health = DEFAULT_HEALTH; 
        bounds=new Rectangle(0,0,width,height);
        
    }
    public abstract void tick();
    
    public abstract void render(Graphics g);
    public abstract void die();
    
    public void hurt(int amt){
        health-=amt;
        if(health<=0){
            active=false;
            die();
        }
    }
    public boolean checkEntityColisions(float xOffset,float  yOffset){
        for(Entity e:handelar.getWorld().getEntityManazer().getEntities()){
           if(e.equals(this))
               continue;
           if(e.getColisionBounds(0f,0f).intersects(getColisionBounds(xOffset, yOffset)))
               return true;
        }
        return false;
    }
    public Rectangle getColisionBounds(float xOffset,float  yOffset){
        return new Rectangle((int)(x+bounds.x+xOffset),(int)(y+bounds.y+yOffset),bounds.width,bounds.height);
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    public int grtHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
    public boolean isactive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active= active;
    }
    
}
