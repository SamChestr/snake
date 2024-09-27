package sam.snake;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.JButton;

public class Settings extends JPanel implements KeyListener, ActionListener {

    private final JPanel cards;
    public boolean twoFood = false;
    public boolean poisonOff = true;
    private int boardWidth, boardHeight, tileWidth, tileHeight;
    private JButton button;
    // Poison Pill Button
    private JButton plague;

    Settings(JPanel cards) {

        button = new JButton();
        button.setBounds(190, 100, 100, 50);
        button.addActionListener(this);
        button.setText("TWO FRUIT");

        plague = new JButton();
        plague.setBounds(310, 100, 100, 50);
        plague.addActionListener(this);
        plague.setText("POISON OFF");
        this.setLayout(null);
        this.cards = cards; 
        this.add(button);
        this.add(plague);
        boardWidth = 600;
        boardHeight = 600;
        tileWidth = 25;
        tileHeight = 25;
        setPreferredSize(new Dimension(boardWidth, boardHeight));
        setBackground(Color.black);
        addKeyListener(this);
        setFocusable(true);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        g.setFont(new Font("Arial", Font.PLAIN, 60));
        g.setColor(Color.GREEN);
        g.drawString("SETTINGS", 150, 60);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Switch Settings To Game
        switch (e.getKeyCode()) {
            case KeyEvent.VK_ESCAPE:
                CardLayout layout = (CardLayout) (cards.getLayout()); // Gets the card layout so you can change the
                                                                      // layout
                
                layout.show(cards, "SNAKEGAME");
                cards.transferFocus();
                break;
                
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == button) {
            if (twoFood) {
                CardLayout layout = (CardLayout) (cards.getLayout());
                layout.show(cards, "GAMEBOARD");
                cards.transferFocus();
                button.setText("ONE FRUIT");
                twoFood = false;
            } else if (twoFood == false) {
                CardLayout layout = (CardLayout) (cards.getLayout());
                layout.show(cards, "GAMEBOARD");
                cards.transferFocus();
                button.setText("TWO FRUIT");
                twoFood = true;
            }

        }
        
        if (e.getSource() == plague) {
            if (poisonOff) {
                CardLayout layout = (CardLayout) (cards.getLayout());
                layout.show(cards, "GAMEBOARD");
                cards.transferFocus();
                plague.setText("POISON ON");
                poisonOff = false;
            } else if (poisonOff == false) {
                CardLayout layout = (CardLayout) (cards.getLayout());
                layout.show(cards, "GAMEBOARD");
                cards.transferFocus();
                plague.setText("POISON OFF");
                poisonOff = true;
            }

        }
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Not Needed
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Not Needed

    }

}
