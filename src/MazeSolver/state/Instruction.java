
package mazesolver.state;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import MazeSolver.Handelar;
import MazeSolver.Game;
import mazesolver.Graphics.Assets;
import static mazesolver.Graphics.Assets.mazerunner;

import mazesolver.ui.UIManager;



public class Instruction  extends State {
   protected State ins;
   private UIManager uiManager;
   public Game game;
   
 
 
     
  
   public String str="Instruction";
   public String str1="Use W to move the rabit up";
   public String str2="Use S to move the rabit down";
   public String str3="Use A to move the rabit left";
   public String str4="Use D to move the rabit right";
   public String str5="Remove all the obstacles";
   public String str6="use arows to remove obstacle";
   public String str7="press enter to play the game";
   
   // private Object handelar;
   
    public Instruction(Handelar hendelar) {
        super(hendelar);
     
    }

    @Override
    public void tick() {
      
    }

   
    @Override
    public void render(Graphics g) {
       if(hendelar.getKeyManazer().quit)
         State.setState(hendelar.getGame().gamestate);
           
            
		
                        
                      
       
        
     
        g.drawImage(Assets.mazeinstruction, 0, 0, null);
     Font font=new Font("arial", Font.ITALIC, 80);
     g.setFont(font);
        g.setColor(Color.red);
        
    g.drawString(str,100, 100);
    Font font1=new Font("arial", Font.ITALIC, 40);
     g.setFont(font1);
        g.setColor(Color.RED);
    g.drawString(str1,100, 150);
    g.drawString(str2,100, 200);
    g.drawString(str3,100, 250);
    g.drawString(str4,100, 300);
    g.drawString(str5,100, 350);
    g.drawString(str6,100, 400);
    g.drawString(str7,100, 450);
      //uiobject.hovering=false;
  
    }
   
    
}
