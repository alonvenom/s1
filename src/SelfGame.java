package xo;

public class SelfGame extends Game {
	 private final SelfPlayer selfPlayer;

	    public SelfGame() {
	        super();
	        selfPlayer = new SelfPlayer(currentPlayer.getSymbol());
	    }

		@Override
		public void playGame() {
			 while (true) {
		            try {
		                Thread.sleep(500);
		            } catch (InterruptedException e) {
		                e.printStackTrace();
		            }

		            if (currentPlayer.getSymbol() == 'X') {
		                selfPlayer.run();
		            }

		            printBoard();

		            if (checkWin()) {
		                System.out.println("Player " + currentPlayer.getSymbol() + " wins!");
		                break;
		            } else if (isBoardFull()) {
		                System.out.println("The board is full. It's a draw!");
		                break;
		            }

		            switchPlayer();
		        }
		    }

		    @Override
		    public int[][] getFreeCells() {
		        int[][] freeCells = new int[gameBoard.length * gameBoard[0].length][2];
		        int index = 0;
		        for (int i = 0; i < gameBoard.length; i++) {
		            for (int j = 0; j < gameBoard[i].length; j++) {
		                if (gameBoard[i][j] == '-') {
		                    freeCells[index][0] = i;
		                    freeCells[index][1] = j;
		                    index++;
		                }
		            }
		        }
		        return freeCells;
		    }

		    private boolean isBoardFull() {
		        for (char[] row : gameBoard) {
		            for (char cell : row) {
		                if (cell == '-') {
		                    return false;
		                }
		            }
		        }
		        return true;
		    }
		    private void switchPlayer() {
		        currentPlayer = (currentPlayer.getSymbol() == 'X') ? new Player('O') : new Player('X');
		    }

}
