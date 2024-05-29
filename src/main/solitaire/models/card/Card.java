package main.solitaire.models.card;

import main.solitaire.models.enums.Rank;
import main.solitaire.models.enums.Suit;

/**
 * Represents a playing card with a rank and suit.
 */
public class Card {
    private final Rank rank; // rank
    private final Suit suit; // Suit
    private int x, y; // Coordinates
    private final int width; // Width
    private final int height; // Height
    private boolean isFacingUp; // Indicates whether the card is facing up or not

    /**
     * Constructs a new Card object with the specified rank, suit, position, width, and height.
     *
     * @param rank   the rank of the card
     * @param suit   the suit of the card
     * @param x      the x-coordinate position of the card
     * @param y      the y-coordinate position of the card
     * @param width  the width of the card
     * @param height the height of the card
     */
    public Card(Rank rank, Suit suit, int x, int y, int width, int height) {
        this.rank = rank;
        this.suit = suit;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.isFacingUp = false;
    }

    /**
     * Gets the rank of the card.
     *
     * @return the rank of the card
     */
    public Rank getRank() {
        return rank;
    }

    /**
     * Gets the suit of the card.
     *
     * @return the suit of the card
     */
    public Suit getSuit() {
        return suit;
    }

    /**
     * Gets x-coordinate of the card.
     *
     * @return the x-coordinate of the card
     */
    public int getX() {
        return this.x;
    }

    /**
     * Gets y-coordinate of the card.
     *
     * @return the y-coordinate of the card
     */
    public int getY() {
        return this.y;
    }

    /**
     * Sets the new location of the card to the specified coordinates.
     *
     * @param x the new x-coordinate of the card
     * @param y the new y-coordinate of the card
     */
    public void setLocation(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Gets the width of the card.
     *
     * @return the width of the card
     */
    public int getWidth() {
        return this.width;
    }

    /**
     * Gets the height of the card.
     *
     * @return the height of the card
     */
    public int getHeight() {
        return this.height;
    }

    /**
     * Checks whether the card is facing up or not.
     *
     * @return true if the card is facing up, else false
     */
    public boolean isFacingUp(){
        return isFacingUp;
    }

    /**
     * Flips the card, changing its facing direction.
     */
    public void flipCard(){
        this.isFacingUp = !isFacingUp;
    }

}
