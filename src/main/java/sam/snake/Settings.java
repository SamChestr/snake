package sam.snake;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.JButton;

public class Settings extends JPanel implements KeyListener, ActionListener {

    private final JPanel cards;
    private int boardWidth, boardHeight, tileWidth, tileHeight;
    private JButton button;

    Settings(JPanel cards) {

        button = new JButton();
        button.setBounds(200, 100, 100, 50);

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
