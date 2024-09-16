package sam.snake;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class SnakeGame extends JPanel implements ActionListener, KeyListener {

    int boardWidth;
    int boardHeight;
    int tileSize = 25;

    // Snake
    Tile snakeHead;
    ArrayList<Tile> snakeBody;

    // Poison Fruit 
    Tile poison;

    // Food
    Food food1, food2;

    // game logic
    Timer gameLoop;
    int velocityX;
    int velocityY;
    boolean gameOver = false;

    SnakeGame(int boardWidth, int boardHeight) {
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        setPreferredSize(new Dimension(this.boardWidth, this.boardHeight));
        setBackground(Color.black);
        addKeyListener(this);
        setFocusable(true);

        snakeHead = new Tile(5, 5);
        snakeBody = new ArrayList<Tile>();

        food1 = new Food(boardHeight, boardWidth, tileSize);
        food1.placeFood();

        food2 = new Food(boardHeight, boardWidth, tileSize);
        food2.placeFood();

        velocityX = 0;
        velocityY = 0;

        gameLoop = new Timer(100, this);
        gameLoop.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        // grid
        // g.setColor(Color.DARK_GRAY);
        // for (int i = 0; i < boardWidth/tileSize; i++) {
        // (x1, y1, x2, y2)
        // g.drawLine(i*tileSize, 0, i*tileSize, boardHeight);
        // g.drawLine(0, i*tileSize, boardWidth, i*tileSize);
        // }

        // Food
        g.setColor(Color.red);
        g.fillRect(food1.tile.x * tileSize, food1.tile.y * tileSize, tileSize, tileSize);
        g.fillRect(food2.tile.x * tileSize, food2.tile.y * tileSize, tileSize, tileSize);

        //poison
        g.setColor(Color.pink);
        g.fillRect(poison.tile.x * tileSize, poison.tile.y * tileSize, tileSize, tileSize);

        // Snake Head
        g.setColor(Color.green);
        g.fillRect(snakeHead.x * tileSize, snakeHead.y * tileSize, tileSize, tileSize);

        // Snake Body
        for (int i = 0; i < snakeBody.size(); i++) {
            Tile snakePart = snakeBody.get(i);
            g.fillRect(snakePart.x * tileSize, snakePart.y * tileSize, tileSize, tileSize);
        }

        // Score
        g.setFont(new Font("Arial", Font.PLAIN, 16));
        if (gameOver) {
            g.setColor(Color.red);
            g.drawString("Game over: " + String.valueOf(snakeBody.size()), tileSize - 16, tileSize);
        } else {
            g.drawString("Score: " + String.valueOf(snakeBody.size()), tileSize - 16, tileSize);
        }
    }

    public boolean collision(Tile tile1, Tile tile2) {
        return tile1.x == tile2.x && tile1.y == tile2.y;
    }

    public void move() {
        // eat Food
        if (collision(snakeHead, food1.tile)) {
            snakeBody.add(new Tile(food1.tile.x, food1.tile.y));
            food1.placeFood();
        }

        if (collision(snakeHead, food2.tile)) {
            snakeBody.add(new Tile(food2.tile.x, food2.tile.y));
            food2.placeFood();
        }


        // Snake body
        for (int i = snakeBody.size() - 1; i >= 0; i--) {
            Tile snakePart = snakeBody.get(i);
            if (i == 0) {
                snakePart.x = snakeHead.x;
                snakePart.y = snakeHead.y;
            } else {
                Tile prevSnakePart = snakeBody.get(i - 1);
                snakePart.x = prevSnakePart.x;
                snakePart.y = prevSnakePart.y;
            }
        }

        // Snake Head
        snakeHead.x += velocityX;
        snakeHead.y += velocityY;

        // game over
        for (int i = 0; i < snakeBody.size(); i++) {
            Tile snakePart = snakeBody.get(i);
            // collide with the snake head
            if (collision(snakeHead, snakePart)) {
                gameOver = true;
            }
        }

        if (snakeHead.x * tileSize < 0 || snakeHead.x * tileSize > boardWidth ||
                snakeHead.y * tileSize < 0 || snakeHead.y * tileSize > boardHeight) {
            gameOver = true;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        move();
        repaint();
        if (gameOver) {
            gameLoop.stop();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (((e.getKeyCode() == KeyEvent.VK_UP) || (e.getKeyCode() == KeyEvent.VK_W)) && velocityY != 1) {
            velocityX = 0;
            velocityY = -1;
        } else if (((e.getKeyCode() == KeyEvent.VK_DOWN) || (e.getKeyCode() == KeyEvent.VK_S)) && velocityY != -1) {
            velocityX = 0;
            velocityY = 1;
        } else if (((e.getKeyCode() == KeyEvent.VK_LEFT) || (e.getKeyCode() == KeyEvent.VK_A)) && velocityX != 1) {
            velocityX = -1;
            velocityY = 0;
        } else if (((e.getKeyCode() == KeyEvent.VK_RIGHT) || (e.getKeyCode() == KeyEvent.VK_D)) && velocityX != -1) {
            velocityX = 1;
            velocityY = 0;
        }
    }

    // Do not need
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}