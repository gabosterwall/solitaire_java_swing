package main.solitaire.models.pile;

import main.solitaire.models.card.Card;

import java.awt.*;
import java.util.Stack;

/**
 * Represents an abstract Pile for any Solitaire game, providing common functionalities
 * and properties for different types of piles.
 */
public abstract class Pile {
    private final int x, y; // Coordinates

    private final int width, height; // Width and height of the pile
    private final int maxNumOfCards;
    private final Color backgroundColor, borderColor; // Colors
    protected final Stack<Card> pile; // Stack of cards

    /**
     * Constructs a Pile object with the specified parameters.
     *
     * @param x               The x-coordinate of the pile
     * @param y               The y-coordinate of the pile
     * @param width           The width of the pile
     * @param height          The height of the pile
     * @param maxNumOfCards   The maximum number of cards the pile can hold
     * @param backgroundColor The background color of the pile
     * @param borderColor     The border color of the pile
     */
    public Pile(int x, int y, int width, int height, int maxNumOfCards, Color backgroundColor, Color borderColor) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.maxNumOfCards = maxNumOfCards;
        this.backgroundColor = backgroundColor;
        this.borderColor = borderColor;
        this.pile = new Stack<>();
    }

    /**
     * Sets the provided card with the pile's coordinates, then adding it to the pile.
     * @param card The card to add
     */
    public void addCard(Card card) {
        card.setLocation(getX(), getY());
        pile.push(card);
    }

    /**
     * Checks whether the pile is full or not.
     * @return true if full, else false
     */
    public boolean isPileFull() {
        return pile.size() == maxNumOfCards;
    }

    /**
     * Determines whether a card can be released on pile or not
     */
    public abstract boolean isValidDropZone(Card card);

    /**
     * Determines whether a card can be moved/dragged from the pile
     * @return true if a card can be moved from pile, else false
     */
    public abstract boolean isCardDraggable();


    /**
     * Checks if a mouse event point (x,y coordinates) is within the pile's dimension or not.
     * @param mouseX The mouse events x-coordinate
     * @param mouseY The mouse events y-coordinate
     * @return True is mouse point is within pile, else false
     */
    public boolean containsPoint(int mouseX, int mouseY) {
        return mouseX >= x && mouseX <= x + width && mouseY >= y && mouseY <= y + height;
    }

    /**
     * Gets the pile's x-coordinate.
     * @return Pile x-coordinate
     */
    public int getX() {
        return this.x;
    }

    /**
     * Gets the pile's y-coordinate.
     * @return Pile y-coordinate
     */
    public int getY() {
        return this.y;
    }

    /**
     * Gets pile width.
     * @return pile width
     */
    public int getWidth() {
        return this.width;
    }

    /**
     * Gets pile height.
     * @return Pile height
     */
    public int getHeight() {
        return this.height;
    }

    /**
     * Gets pile background color.
     * @return Pile background color
     */
    public Color getBackgroundColor() {
        return this.backgroundColor;
    }

    /**
     * Gets pile border color
     * @return Pile border color
     */
    public Color getBorderColor() {
        return this.borderColor;
    }

    /**
     * Gets pile top card.
     * @return Top card from pile
     */
    public Card getTopCard() {
        return pile.pop();
    }

    /**
     * Gets pile top card without removing it from the stack.
     * @return Top card from pile
     */
    public Card viewTopCard() {
        return pile.peek();
    }

    /**
     * Checks if pile is empty.
     * @return true if pile is empty, else false
     */
    public boolean isEmpty() {
        return pile.isEmpty();
    }

}
