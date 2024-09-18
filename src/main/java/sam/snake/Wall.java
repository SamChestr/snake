package sam.snake;

import java.util.LinkedList;

public class Wall {
    LinkedList<Tile> tiles = new LinkedList<Tile>();
    private int boardWidth;
    private int boardHeight;
    private int tileSize;
    public Wall(int boardWidth, int boardHeight, int tileSize) {

        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        this.tileSize = tileSize;
        //Top Wall
        for(int x = 0; x < boardWidth/tileSize; x++){
            tiles.add(new Tile(x, 0));
        }
        //bottom Wall
        for(int x = 0; x < boardWidth/tileSize; x++){
            tiles.add(new Tile(x, boardHeight/tileSize-1));
        }
        //left Wall
        for(int y = 0; y < boardWidth/tileSize; y++){
            tiles.add(new Tile(0, y));
        }
        //right Wall
        for(int y = 0; y < boardWidth/tileSize; y++){
            tiles.add(new Tile(boardWidth/tileSize-1, y));
        }
    }

}
