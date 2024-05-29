package main.solitaire.models.game;

import main.solitaire.models.card.Card;
import main.solitaire.models.pile.Pile;

import java.awt.event.MouseEvent;
import java.util.List;

/**
 * Interface for the game of Solitaire, providing common functionalities and properties
 * for different variations of the game.
 */
public interface ISolitaireGame {
    /**
     * Gets the game variant's title.
     * @return Title of game variant
     */
    String getTitle();

    /**
     * Initializes the game.
     */
    void initGame();

    /**
     * Handles the mouse events from the controller class.
     * @param e The specific mouse event obj
     */
    void handleMouseEvent(MouseEvent e);

    /**
     * Gets all the game's piles to display on the view.
     * @return List of game piles
     */
    List<Pile> getGamePiles();

    /**
     * Gets the selected card, i.e., the card that is moving/being dragged.
     * @return The selected card
     */
    Card getSelectedCard();

    /**
     * Checks if the game has been won or not.
     * @return True if game won, else false
     */
    boolean isGameWon();
}

