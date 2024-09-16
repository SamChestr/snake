package sam.snake;
import java.util.Random;

public class PoisonFruit
 {
    Tile tile;
    Random random;
    int boardWidth, boardHeight, tileSize;

    public poison(int boardWidth, int boardHeight, int tileSize) {
        tile = new Tile(10, 10);
        random = new Random();

    }
}
