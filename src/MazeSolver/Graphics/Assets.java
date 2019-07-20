
package mazesolver.Graphics;

import java.awt.image.BufferedImage;

public class Assets {
    private static final int width=32,height=32;
    public static BufferedImage stone,tree,dirt,grass,rock,mazerunner,zombie_left,zombie_up,winner,gameover,Nextlevel,home,mazeinstruction;
    public static BufferedImage[] player_down, player_up, player_left, player_right,zombie_down,zombie_right;
      public static BufferedImage[] btn_start,instruction,exit;
      
    public static void init() {
        SpriteSheet sheet=new SpriteSheet(Image.loadImage("/tectures/sheet.png"));
                SpriteSheet rabitdown=new SpriteSheet(Image.loadImage("/tectures/rabit_forword.png"));
                SpriteSheet rabitup=new SpriteSheet(Image.loadImage("/tectures/rabit_upword.png"));
                SpriteSheet rabitleft=new SpriteSheet(Image.loadImage("/tectures/rabit_left.png"));
                SpriteSheet rabitright=new SpriteSheet(Image.loadImage("/tectures/rabit_right.png"));
                SpriteSheet stone3=new SpriteSheet(Image.loadImage("/tectures/stone2.png"));
                SpriteSheet grass1=new SpriteSheet(Image.loadImage("/tectures/grass.png"));
                SpriteSheet maze=new SpriteSheet(Image.loadImage("/tectures/finalmenu.png"));
                SpriteSheet ZombieLeft=new SpriteSheet(Image.loadImage("/tectures/zombieleft.png"));
                SpriteSheet ZombieUP=new SpriteSheet(Image.loadImage("/tectures/zombieup.png"));
                  SpriteSheet Menu=new SpriteSheet(Image.loadImage("/tectures/menu.png"));
                  SpriteSheet Winner=new SpriteSheet(Image.loadImage("/tectures/winner1.png"));
                  SpriteSheet Loser=new SpriteSheet(Image.loadImage("/tectures/gameover.png"));
                  SpriteSheet nextlevel=new SpriteSheet(Image.loadImage("/tectures/nextlevel.png"));
                   SpriteSheet Home=new SpriteSheet(Image.loadImage("/tectures/jj.jpg"));
                   SpriteSheet Ins=new SpriteSheet(Image.loadImage("/tectures/mazerunner2.jpg"));
           
                 
             

        tree=sheet.crop(0, 0, width, height*2);
        dirt=sheet.crop(width, 0, width, height);
        grass=grass1.crop(0, 0, 50, 50);
        stone=stone3.crop(0, 0,450,450);
        rock=sheet.crop(0, 0, width, height*3);
        mazerunner=maze.crop(0, 0,800,580);
                player_down = new BufferedImage[2];
		player_up = new BufferedImage[2];
		player_left = new BufferedImage[2];
		player_right = new BufferedImage[2];
                zombie_down = new BufferedImage[2];
		
		
		zombie_right = new BufferedImage[2];
                player_down[0] = rabitdown.crop(0, 0, 32, 48);
		player_down[1] = rabitdown.crop(130,0,32,48);
		player_up[0] = rabitup.crop(0, 0, 32, 48);
		player_up[1] = rabitup.crop(130,0,32,48);
		player_right[0] = rabitright.crop(0, 0, 32, 48);
		player_right[1] = rabitright.crop(160, 0, 32, 48);
		player_left[0] = rabitleft.crop(0, 0, 32, 48);
		player_left[1] = rabitleft.crop(160, 0, 32, 48);
                  zombie_down[0] = sheet.crop(width*4, height*3, width, height);
		zombie_down[1] = sheet.crop(width*5, height*3, width, height);
		
		zombie_right[0] = sheet.crop(width*4, height*4, width, height);
		zombie_right[1] = sheet.crop(width*5, height*4, width, height);
                zombie_left=ZombieLeft.crop(0,0,64,68);
                zombie_up=ZombieUP.crop(0,0,68,64);
		
       
        
		btn_start = new BufferedImage[2];
                instruction=new BufferedImage[2];
                exit=new BufferedImage[2];
		btn_start[0]=Menu.crop(0,0, 80, 27);
                btn_start[1]=Menu.crop(100,0, 80, 27);
                instruction[0]=Menu.crop(0,130, 80, 27);
                instruction[1]=Menu.crop(100,130, 80, 27);
                exit[0]=Menu.crop(0,160, 80, 20);
                exit[1]=Menu.crop(100,160, 80, 20);
                winner=Winner.crop(0, 0, 800, 600);
                gameover=Loser.crop(0, 0, 800, 600);
                Nextlevel=nextlevel.crop(0, 0, 590, 245);
                home=Home.crop(500, 200, 1500, 2000);
                mazeinstruction=Ins.crop(0, 0, 800,600);
		
		
        
    }
}
