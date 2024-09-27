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
    public boolean twoFood = true;
    private int boardWidth, boardHeight, tileWidth, tileHeight;
    private JButton button;

    Settings(JPanel cards) {

        button = new JButton();
        button.setBounds(250, 100, 100, 50);
        button.addActionListener(this);
        button.setText("ONE FRUIT");
        this.setLayout(null);
        this.cards = cards;
        this.add(button);
        boardWidth = 600;
        boardHeight = 600;
        tileWidth = 25;
        tileHeight = 25;
        setPreferredSize(new Dimension(boardWidth, boardHeight));
        setBackground(Color.WHITE);
        addKeyListener(this);
        setFocusable(true);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        g.setFont(new Font("Arial", Font.PLAIN, 40));
        g.setColor(Color.BLACK);
        g.drawString("SETTINGS", 200, 50);
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
                setBackground(Color.green);
                CardLayout layout = (CardLayout) (cards.getLayout());
                layout.show(cards, "GAMEBOARD");
                cards.transferFocus();
                button.setText("TWO FRUIT");
                twoFood = false;
            } else if (twoFood == false) {
                setBackground(Color.white);
                CardLayout layout = (CardLayout) (cards.getLayout());
                layout.show(cards, "GAMEBOARD");
                cards.transferFocus();
                button.setText("ONE FRUIT");
                twoFood = true;
            }

        }
        repaint();
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
