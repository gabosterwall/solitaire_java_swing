package main.solitaire.view;

import main.solitaire.models.card.Card;
import main.solitaire.models.enums.Rank;
import main.solitaire.models.enums.Suit;

import javax.swing.*;
import java.awt.*;

/**
 * SolitaireView-helper for a Card, providing methods to draw a card with its image, dimensions and location.
 */
public class CardView {

    // Constant with img-folder path
    private static final String IMAGE_DIRECTORY = "img/";

    /**
     * Draws the provided Card
     *
     * @param g the Graphics obj context to paint on
     * @param card the Card to draw
     */
    public void draw(Graphics g, Card card) {
        ImageIcon imageIcon = getImageIcon(card);
        imageIcon.paintIcon(null, g, card.getX(), card.getY());
    }

    /**
     * Retrieves the ImageIcon for the provided Card.
     *
     * @param card the Card to retrieve the ImageIcon for
     * @return the ImageIcon representing the card
     */
    private ImageIcon getImageIcon(Card card) {
        String fileName = card.isFacingUp() ? getImageFileName(card.getRank(), card.getSuit()) : "b2fv.gif";

        ImageIcon imageIcon = new ImageIcon(IMAGE_DIRECTORY + fileName);
        Image imageToScale = imageIcon.getImage();

        return new ImageIcon(imageToScale.getScaledInstance(card.getWidth(), card.getHeight(), Image.SCALE_SMOOTH));
    }

    /**
     * Constructs the filename of the image for the card with the provided Rank and Suit.
     *
     * @param rank the Rank of the card
     * @param suit the Suit of the card
     * @return the filename of the card image
     */
    private String getImageFileName(Rank rank, Suit suit) {
        return suit.toString().toLowerCase() + "_of_" + rank.toString().toLowerCase() + ".gif";
    }
}
