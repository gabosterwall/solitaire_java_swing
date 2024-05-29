package main.solitaire.view;

import main.solitaire.models.card.Card;
import main.solitaire.models.pile.Pile;

import java.awt.*;

/**
 * SolitaireView-helper for Pile, providing methods to draw the background, border and top card
 */
public class PileView {

    private final CardView cardView;

    /**
     * Constructs a PileView object
     */
    public PileView() {
        this.cardView = new CardView();
    }

    /**
     * Draws the graphical representation of a provided Pile.
     *
     * @param g the Graphics obj context to paint on
     * @param pile the Pile to draw
     */
    public void draw(Graphics g, Pile pile) {
        // Background
        g.setColor(pile.getBackgroundColor());
        g.fillRect(pile.getX(), pile.getY(), pile.getWidth(), pile.getHeight());

        // Border
        g.setColor(pile.getBorderColor());
        g.drawRect(pile.getX(), pile.getY(), pile.getWidth(), pile.getHeight());

        // Top card, if any
        if (!pile.isEmpty()){
            Card topCard = pile.viewTopCard();
            cardView.draw(g, topCard);
        }
    }
}
