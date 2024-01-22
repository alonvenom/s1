//sindi koifan 211657481 alon cohen 319039707

package xo;

import java.util.Random;

import xo.Game.PlayerType;

public class SelfPlayer extends Player {
    public SelfPlayer(PlayerType playerType) {
        super(playerType);
    }

    @Override
    public void makeMove(Game game) {
    	boolean check=true;
        try {
            Thread.sleep(500); // Simulate some processing time
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int[][] freeCells = game.getFreeCells();
        if (freeCells.length > 0) {
        	
            Random random = new Random();
            int index = random.nextInt(freeCells.length);
            int row = freeCells[index][0];
            int col = freeCells[index][1];
        	
            game.getGameBoard()[row][col] = (playerType == PlayerType.X) ? 'X' : 'O';
            game.printBoard();
        }
    }
}