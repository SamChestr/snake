package sam.snake;
import java.util.Random;

public class Food {
    
    Tile tile;
    Random random;
    int boardWidth, boardHeight, tileSize;

    public Food(int boardWidth, int boardHeight, int tileSize){

        tile = new Tile(10, 10);
        random = new Random();

        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        this.tileSize = tileSize;
    }

    public void placeFood(){
        tile.x = random.nextInt(boardWidth/tileSize); //600/25 = 24
        tile.y = random.nextInt(boardHeight/tileSize);
        System.out.println("boardWidth = " + boardWidth + " tileSize = " + tileSize + " tile.x = " + tile.x);
    }

}
