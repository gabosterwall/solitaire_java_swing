package main.solitaire.view;

import main.solitaire.models.card.Card;
import main.solitaire.models.pile.Pile;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * Represents the graphical interface for the Solitaire game, extending the JPanel class.
 */
public class SolitaireView extends JPanel {
    private static final Color BACKGROUND_COLOR = new Color(8, 112, 32);
    private final PileView pileView; // Helper for displaying piles and their top cards
    private final CardView cardView; // Helper for displaying cards
    private List<Pile> pilesToDisplay;
    private Card movingCard;

    /**
     * Constructs a SolitaireView object
     */
    public SolitaireView() {
        setBackground(BACKGROUND_COLOR);
        this.pileView = new PileView();
        this.cardView = new CardView();
    }

    /**
     * Paint the components of the Solitaire game.
     *
     * @param g The Graphics obj context to paint on
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Pile pile : pilesToDisplay) {
            pileView.draw(g, pile);
        }

        if (movingCard != null) {
            cardView.draw(g, movingCard);
        }
    }

    /**
     * Initializes the view with the provided list of piles.
     *
     * @param pilesToDisplay The list of piles to display
     */
    public void initView(List<Pile> pilesToDisplay) {
        this.pilesToDisplay = pilesToDisplay;
    }

    /**
     * Sets the card currently being moved.
     *
     * @param movingCard The card currently being moved
     */
    public void setMovingCard(Card movingCard) {
        this.movingCard = movingCard;
    }

    /**
     * Triggers a repaint of all the components.
     */
    public void updateView() {
        repaint();
    }

    /**
     * Displays a message to the player with a dialog box.
     *
     * @param message The message to be displayed
     *
     */
    public void displayMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
}
