
package mazesolver.entities.creatures;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.AccessibleRole;
import MazeSolver.Game;
import MazeSolver.Handelar;
import mazesolver.entities.Entity;
import mazesolver.Graphics.Animation;
import mazesolver.Graphics.Assets;
import mazesolver.state.GameState;
import mazesolver.state.State;

public class Player extends Creature{
  
private Animation animUp,animDown,animLeft,animRight;
private long lastAttackTimer,attackCooldown=10,attackTimer=attackCooldown;

    private long elapsedMS;
    private long fastestMS;
    private long startTime;
    private String formattedTime = "00:00:000";
    
   

    public Player(Handelar handelar,float x, float y) {
        super(handelar,x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
        
              
        bounds.x=22;
        bounds.y=44;
        bounds.width=19;
        bounds.height=19;
        animDown = new Animation(500, Assets.player_down);
		animUp = new Animation(500, Assets.player_up);
		animLeft = new Animation(500, Assets.player_left);
		animRight = new Animation(500, Assets.player_right);
    
              
                  startTime = System.nanoTime();
              
          
               
    }
   
    
    
    

    @Override
    public void tick() {
      
        
         // Time
        elapsedMS = ( System.nanoTime() - startTime ) / 1000000;
       formattedTime =formatTime(elapsedMS);
        
      
        
                animDown.tick();
		animUp.tick();
		animRight.tick();
		animLeft.tick();
		getInput();
		move();
                handelar.getGameCamera().centerOnEntity(this);
                checkAttacks();
	}
@Override
    public void die(){
        System.out.println("you lose");
    }
    private void checkAttacks() {
			attackTimer += System.currentTimeMillis() - lastAttackTimer;
			lastAttackTimer = System.currentTimeMillis();
			if(attackTimer < attackCooldown)
				return;
			Rectangle cb=getColisionBounds(0, 0);
			Rectangle ar=new Rectangle();
		
		int arSize=20;
		ar.width=arSize;
		ar.height=arSize;
		if(handelar.getKeyManazer().aUp){
			ar.x = cb.x + cb.width / 2 - arSize / 2;
			ar.y = cb.y - arSize;
		}else if(handelar.getKeyManazer().aDown){
			ar.x = cb.x + cb.width / 2 - arSize / 2;
			ar.y = cb.y + cb.height;
		}else if(handelar.getKeyManazer().aLeft){
			ar.x = cb.x - arSize;
			ar.y = cb.y + cb.height / 2 - arSize / 2;
		}else if(handelar.getKeyManazer().aRight){
			ar.x = cb.x + cb.width;
			ar.y = cb.y + cb.height / 2 - arSize / 2;
		}else{
			return;
		}
		
		attackTimer = 0;
		
		for(Entity e : handelar.getWorld().getEntityManazer().getEntities()){
			if(e.equals(this))
				continue;
			if(e.getColisionBounds(0, 0).intersects(ar)){
				e.hurt(1);
				return;
		
		
		
	}
		}
		}

    private void getInput(){
		xMove = 0;
		yMove = 0;
		
		if(handelar.getKeyManazer().up)
			yMove = -speed;
		if(handelar.getKeyManazer().down)
			yMove = speed;
		if(handelar.getKeyManazer().left)
			xMove = -speed;
		if(handelar.getKeyManazer().right)
			xMove = speed;
                
                   
                
	}
     private String formatTime(long millis){
       
        String formattedTime ;
        
        String hourFormat = "";
        int hours = (int) (millis / 3600000);
        if(hours >= 1){
            millis -= hours * 3600000;
            if(hours < 10){
                hourFormat = "0" + hours;
            }
            else{
                hourFormat = "" + hours;
            }
            hourFormat += ":";
        }
        
        String minuteFormat;
        int minutes = (int)(millis / 60000);
        if(minutes >= 1){
            millis -= minutes * 60000;
            if(minutes < 10){
                minuteFormat = "0" + minutes;
            }
            else{
                minuteFormat = "" + minutes;
            }
        }
        else{
            minuteFormat = "00:";
        }
        
        String secondFormat;
        int seconds = (int)(millis / 1000);
        if(seconds >= 1){
            millis -= seconds * 1000;
            if(seconds < 10){
                secondFormat = "0" + seconds;
            }
            else{
                secondFormat = "" + seconds;
            }
        }
        else{
            secondFormat = "00:";
        }
        
        String milliFormat;
        if(millis <= 99){
            milliFormat = "" + millis;
        }
        else if(millis > 9){
            milliFormat = "0" + millis;
        }
        else{
            milliFormat = "00" + millis;
        }
        
        formattedTime = hourFormat + minuteFormat + ":" + secondFormat + ":" + milliFormat;
        if(minutes>= 3){
            //System.exit(1);
                State.setState(handelar.getGame().gameOver);
            
        }
        
        return formattedTime;
        
    }

    
 
    
    @Override
    public void render(Graphics g) {
        g.drawImage(getCurrentAnimationFrame(), (int) (x-handelar.getGameCamera().getxOffset()), (int)(y-handelar.getGameCamera().getyOffset()) ,width,height, null);
      
         
           
         Font font1=new Font("arial", Font.ITALIC, 30);
     g.setFont(font1);
        g.setColor(Color.RED);
          g.drawString("time::"+formattedTime, width, width);
          if(x>3830&&y>=1660)
             g.drawImage(Assets.winner, 0, 0,null);
          
          
            
    }
    private BufferedImage getCurrentAnimationFrame(){
		if(xMove < 0){
			return animLeft.getCurrentFrame();
		}else if(xMove > 0){
			return animRight.getCurrentFrame();
		}else if(yMove < 0){
			return animUp.getCurrentFrame();
		}else{
			return animDown.getCurrentFrame();
		}
	}
    
    
}
