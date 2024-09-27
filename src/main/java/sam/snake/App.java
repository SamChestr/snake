package sam.snake;

import javax.swing.*;
import java.awt.CardLayout;

public class App { 
    public static void main(String[] args) throws Exception{
        int boardWidth = 600;
        int boardHeight = boardWidth;

        JFrame frame = new JFrame ("Snake");
        frame.setSize(boardWidth, boardHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel cards = new JPanel(new CardLayout());
        Settings settings = new Settings(cards);
        cards.add(settings,"SETTINGS");


        SnakeGame snakeGame = new SnakeGame(settings, boardWidth, boardHeight, cards);
        cards.add(snakeGame, "SNAKEGAME");
        frame.add(cards);
        //snakeGame.requestFocus();
        frame.setVisible(true);
        CardLayout layout = (CardLayout) (cards.getLayout());
        layout.show(cards, "SNAKEGAME");
        cards.transferFocus();
    }

}