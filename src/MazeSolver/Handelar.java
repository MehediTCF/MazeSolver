
package MazeSolver;

import mazesolver.Graphics.GameCamera;
import mazesolver.input.KeyInput;
import mazesolver.input.MouseInput;
import mazesolver.state.Instruction;

import mazesolver.worlds.World;


public class Handelar {
    
	public Game game;
	private World world;
        private Instruction ins;
       
	
	public Handelar(Game game){
		this.game = game;
	}
	
	public GameCamera getGameCamera(){
		return game.getGameCamera();
	}
	
	public KeyInput getKeyManazer(){
		return game.getKeyManazer();
	}
        public MouseInput getMouseManazer(){
            return game.getMouseManazer();
        }
	
	public int getWidth(){
		return game.getWidth();
	}
	
	public int getHeight(){
		return game.getHeight();
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}

    public Instruction getInstruction() {
        return ins;
    }

    public void setInstruction(Instruction ins) {
        this.ins = ins;
    }
        
       
        
}
