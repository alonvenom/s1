package xo;
import java.util.Random;
	import java.util.Scanner;
	abstract class Game {
	    
		protected char[][] gameBoard;
	    protected Player currentPlayer;

	    public Game() {
	        gameBoard = new char[5][5];
	        currentPlayer = new Player('X');
	        initializeBoard();
	    }

	public void printBoard() {
		System.out.println("Current Board:");
        for (char[] row : gameBoard) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
	
	 public Player getTurn() {
	        return currentPlayer;
	    }
	 private void initializeBoard() {
	        for (int i = 0; i < gameBoard.length; i++) {
	            for (int j = 0; j < gameBoard[i].length; j++) {
	                gameBoard[i][j] = '-';
	            }
	        }
	    }
	    public abstract void playGame();
	    public abstract int[][] getFreeCells();

}
