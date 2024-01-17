package xo;
import java.util.Scanner;

public class UserPlayer extends Player {
    private final Scanner scanner;

    public UserPlayer(char symbol) {
        super(symbol);
        scanner = new Scanner(System.in);
    }

    public void run() {
    }
}
