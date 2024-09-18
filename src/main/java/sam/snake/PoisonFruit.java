package sam.snake;
import java.util.Random;

public class PoisonFruit
 {
    Tile tile;
    Random random;
    int boardWidth, boardHeight, tileSize;

    public PoisonFruit(int boardWidth, int boardHeight, int tileSize) {
        tile = new Tile(10, 10);
        random = new Random();

        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        this.tileSize = tileSize;
        
        placePoisonFruit();
    }

    public void placePoisonFruit(){
        tile.x = random.nextInt(boardWidth/tileSize); 
        tile.y = random.nextInt(boardHeight/tileSize);
        
    }

}
