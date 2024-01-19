//sindi koifan 211657481 alon cohen 319039707

package xo;

public abstract class Player {
    protected char symbol;

    public Player(char symbol) {
        this.symbol = symbol;
    }

    public abstract void makeMove(Game game);

	public char getSymbol() {
		return symbol;
	}
}
