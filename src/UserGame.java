package xo;

public class UserGame extends Game {
	 private final UserPlayer userPlayer;

	    public UserGame() {
	        super();
	        userPlayer = new UserPlayer(currentPlayer.getSymbol());
	    }

		@Override
		public void playGame() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public int[][] getFreeCells() {
			// TODO Auto-generated method stub
			return null;
		}

}
