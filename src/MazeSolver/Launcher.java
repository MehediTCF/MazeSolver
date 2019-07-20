
package MazeSolver;

import mazesolver.audios.SimpleAudioPlayer;
import mazesolver.display.Display;



public class Launcher {
    public static void main(String[] args) {
      Game game= new Game("Maze Solver!",800,580);
        SimpleAudioPlayer.LoadSound();
        
        game.start();
    }
}
