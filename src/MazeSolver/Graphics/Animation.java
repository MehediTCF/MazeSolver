
package mazesolver.Graphics;

import java.awt.image.BufferedImage;

public class Animation {
    private int speed,index;
    private long lasttime,timer;
    private BufferedImage[] frames;
    
    public Animation(int speed,BufferedImage[] frames) {
        this.speed=speed;
        this.frames=frames;
        timer=0;
        index=0;
        lasttime=System.currentTimeMillis();
    }
    
    public void tick(){
        timer+=System.currentTimeMillis()-lasttime;
        lasttime=System.currentTimeMillis();
        if(timer>speed){
            index++;
            timer=0;
            if(index>=frames.length){
                index=0;
            }
        }
    }
    public BufferedImage getCurrentFrame(){
        return frames[index];
    }
}
