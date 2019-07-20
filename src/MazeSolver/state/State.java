
package mazesolver.state;

import com.sun.glass.ui.EventLoop;
import java.awt.Graphics;
import MazeSolver.Game;
import MazeSolver.Handelar;

public abstract class State {
   
	private static State currentState = null;
	
	public static void setState(State state){
		currentState = state;
	}
	
	public static State getState(){
		return currentState;
	}
        protected Handelar hendelar;
        
        public State (Handelar hendelar) {
            this.hendelar=hendelar;
        }
    public abstract void tick();
    
    public abstract void render(Graphics g);
}
