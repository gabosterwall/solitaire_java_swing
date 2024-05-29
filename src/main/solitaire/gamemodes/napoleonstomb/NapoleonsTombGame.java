package main.solitaire.gamemodes.napoleonstomb;

import main.solitaire.models.card.Card;
import main.solitaire.models.game.ISolitaireGame;
import main.solitaire.models.pile.Pile;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents the Napoleon's Tomb solitaire game.
 */
public class NapoleonsTombGame implements ISolitaireGame {

    // Property constants
    private static final int PILE_WIDTH = 90;
    private static final int PILE_HEIGHT = 120;
    private static final int PILE_GAP = 40;
    private static final Color PILE_BACKGROUND_COLOR = new Color(5, 98, 30);
    private static final Color PILE_BORDER_COLOR = new Color(2, 58, 15);

    // Pile maximum number of cards to hold
    private static final int SEVEN_PILE_MAX_NUM_OF_CARDS = 7;
    private static final int SIX_PILE_MAX_NUM_OF_CARDS = 24;
    private static final int DISCARD_PILE_MAX_NUM_OF_CARDS = 52;
    private static final int STOCK_PILE_MAX_NUM_OF_CARDS = DISCARD_PILE_MAX_NUM_OF_CARDS;
    private static final int RESERVE_PILE_MAX_NUM_OF_CARDS = 1;
    private static final int PARKING_PILE_MAX_NUM_OF_CARDS = RESERVE_PILE_MAX_NUM_OF_CARDS;

    // Coordinate constants
    private static final int CENTER_X = 600;
    private static final int CENTER_Y = 300;
    private static final int SIX_PILE_X = CENTER_X - (PILE_WIDTH / 2);
    private static final int SIX_PILE_Y = CENTER_Y - (PILE_HEIGHT / 2);
    private static final int STOCK_PILE_X = SIX_PILE_X + (2 * PILE_WIDTH) + (2 * PILE_GAP);
    private static final int STOCK_PILE_Y = SIX_PILE_Y - (PILE_HEIGHT / 2) - PILE_GAP;
    private static final int DISCARD_PILE_X = SIX_PILE_X;
    private static final int DISCARD_PILE_Y = SIX_PILE_Y + (2 * PILE_HEIGHT) + (2 * PILE_GAP);
    private static final int PARKING_PILE_X = STOCK_PILE_X;
    private static final int PARKING_PILE_Y = SIX_PILE_Y + (PILE_HEIGHT / 2);

    // Fields
    private final String gameTitle;

    private final java.util.List<Pile> gamePiles;

    private final java.util.List<Pile> winPiles;

    private Pile stockPile, discardPile;

    private Card selectedCard;
    private Pile sourcePile;

    private boolean isGameWon;
    private int gameRoundCounter;

    /**
     * Constructs a new instance of NapoleonsTombGame.
     */
    public NapoleonsTombGame() {
        this.gameTitle = "Napoleon's Tomb";
        this.gamePiles = new ArrayList<>();
        this.winPiles = new ArrayList<>();
        this.isGameWon = false;
        this.gameRoundCounter = 1;
    }

    /**
     * Initializes the first round of the game.
     */
    private void initPiles() {
        // Top Left corner
        Pile topLeftPile = new SevenPile(SIX_PILE_X - PILE_WIDTH - PILE_GAP, SIX_PILE_Y - PILE_HEIGHT - PILE_GAP, PILE_WIDTH, PILE_HEIGHT, SEVEN_PILE_MAX_NUM_OF_CARDS, PILE_BACKGROUND_COLOR, PILE_BORDER_COLOR);
        gamePiles.add(topLeftPile);
        winPiles.add(topLeftPile);

        // Top right corner
        Pile topRightPile = new SevenPile(SIX_PILE_X + PILE_WIDTH + PILE_GAP, SIX_PILE_Y - PILE_HEIGHT - PILE_GAP, PILE_WIDTH, PILE_HEIGHT, SEVEN_PILE_MAX_NUM_OF_CARDS, PILE_BACKGROUND_COLOR, PILE_BORDER_COLOR);
        gamePiles.add(topRightPile);
        winPiles.add(topRightPile);

        // Bottom left corner
        Pile bottomLeftPile = new SevenPile(SIX_PILE_X - PILE_WIDTH - PILE_GAP, SIX_PILE_Y + PILE_HEIGHT + PILE_GAP, PILE_WIDTH, PILE_HEIGHT, SEVEN_PILE_MAX_NUM_OF_CARDS, PILE_BACKGROUND_COLOR, PILE_BORDER_COLOR);
        gamePiles.add(bottomLeftPile);
        winPiles.add(bottomLeftPile);

        // Bottom right corner
        Pile bottomRightPile = new SevenPile(SIX_PILE_X + PILE_WIDTH + PILE_GAP, SIX_PILE_Y + PILE_HEIGHT + PILE_GAP, PILE_WIDTH, PILE_HEIGHT, SEVEN_PILE_MAX_NUM_OF_CARDS, PILE_BACKGROUND_COLOR, PILE_BORDER_COLOR);
        gamePiles.add(bottomRightPile);
        winPiles.add(bottomLeftPile);

        // Top
        gamePiles.add(new ReservePile(SIX_PILE_X, SIX_PILE_Y - PILE_HEIGHT - PILE_GAP, PILE_WIDTH, PILE_HEIGHT, RESERVE_PILE_MAX_NUM_OF_CARDS, PILE_BACKGROUND_COLOR, PILE_BORDER_COLOR));
        // Right
        gamePiles.add(new ReservePile(SIX_PILE_X + PILE_WIDTH + PILE_GAP, SIX_PILE_Y, PILE_WIDTH, PILE_HEIGHT, RESERVE_PILE_MAX_NUM_OF_CARDS, PILE_BACKGROUND_COLOR, PILE_BORDER_COLOR));
        // Left
        gamePiles.add(new ReservePile(SIX_PILE_X - PILE_WIDTH - PILE_GAP, SIX_PILE_Y, PILE_WIDTH, PILE_HEIGHT, RESERVE_PILE_MAX_NUM_OF_CARDS, PILE_BACKGROUND_COLOR, PILE_BORDER_COLOR));
        // Bottom
        gamePiles.add(new ReservePile(SIX_PILE_X, SIX_PILE_Y + PILE_HEIGHT + PILE_GAP, PILE_WIDTH, PILE_HEIGHT, RESERVE_PILE_MAX_NUM_OF_CARDS, PILE_BACKGROUND_COLOR, PILE_BORDER_COLOR));

        // Center
        Pile centerPile = new SixPile(SIX_PILE_X, SIX_PILE_Y, PILE_WIDTH, PILE_HEIGHT, SIX_PILE_MAX_NUM_OF_CARDS, PILE_BACKGROUND_COLOR, PILE_BORDER_COLOR);
        gamePiles.add(centerPile);
        winPiles.add(centerPile);

        // Stock pile
        stockPile = new StockPile(STOCK_PILE_X, STOCK_PILE_Y, PILE_WIDTH, PILE_HEIGHT, STOCK_PILE_MAX_NUM_OF_CARDS, PILE_BACKGROUND_COLOR, PILE_BORDER_COLOR);
        gamePiles.add(stockPile);

        // Discard pile
        discardPile = new DiscardPile(DISCARD_PILE_X, DISCARD_PILE_Y, PILE_WIDTH, PILE_HEIGHT, DISCARD_PILE_MAX_NUM_OF_CARDS, PILE_BACKGROUND_COLOR, PILE_BORDER_COLOR);
        gamePiles.add(discardPile);

        // Parking pile
        gamePiles.add(new ParkingPile(PARKING_PILE_X, PARKING_PILE_Y, PILE_WIDTH, PILE_HEIGHT, PARKING_PILE_MAX_NUM_OF_CARDS, PILE_BACKGROUND_COLOR, PILE_BORDER_COLOR));
    }

    /**
     * Gets title of game variant
     * @return Title of the game variant
     */
    @Override
    public String getTitle() {
        return gameTitle;
    }

    /**
     * Initializes the game (indirect the first round of the game)
     */
    @Override
    public void initGame() {
        initPiles();
    }

    @Override
    public void handleMouseEvent(MouseEvent e) {
        int mouseX = e.getX();
        int mouseY = e.getY();

        switch (e.getID()) {
            case MouseEvent.MOUSE_CLICKED:
                handleMouseClicked(mouseX, mouseY);
                checkSecondRound();
                break;
            case MouseEvent.MOUSE_PRESSED:
                handleMousePressed(mouseX, mouseY);
                break;
            case MouseEvent.MOUSE_DRAGGED:
                handleMouseDragged(mouseX, mouseY);
                break;
            case MouseEvent.MOUSE_RELEASED:
                handleMouseReleased(mouseX, mouseY);
                checkRoundWon();
                break;
        }
    }

    /**
     * Handles mouse click events.
     * @param mouseX The x-coordinate of the mouse click
     * @param mouseY The y-coordinate of the mouse click
     */
    private void handleMouseClicked(int mouseX, int mouseY) {
        if (!stockPile.isEmpty() && stockPile.containsPoint(mouseX, mouseY)) {
            Card topCard = stockPile.getTopCard();
            topCard.flipCard();
            topCard.setLocation(discardPile.getX(), discardPile.getY());
            discardPile.addCard(topCard);
        }
    }

    /**
     * Handles mouse press events.
     * @param mouseX The x-coordinate of the mouse press
     * @param mouseY The y-coordinate of the mouse press
     */
    private void handleMousePressed(int mouseX, int mouseY) {
        // Check if the press is on any card in any pile
        for (Pile pile : gamePiles) {
            if (!pile.isEmpty() && pile.isCardDraggable() && pile.containsPoint(mouseX, mouseY)) {
                selectedCard = pile.getTopCard();
                sourcePile = pile;
                // Set the center position of the selected card to the mouse position
                selectedCard.setLocation(mouseX - (selectedCard.getWidth() / 2), mouseY - (selectedCard.getHeight() / 2));
                break;
            }
        }
    }

    /**
     * Handles mouse drag events.
     * @param mouseX The x-coordinate of the mouse drag
     * @param mouseY The y-coordinate of the mouse drag
     */
    private void handleMouseDragged(int mouseX, int mouseY) {
        if (selectedCard != null) {
            selectedCard.setLocation(mouseX - (selectedCard.getWidth() / 2), mouseY - (selectedCard.getHeight() / 2));
        }
    }

    /**
     * Handles mouse release events.
     * @param mouseX The x-coordinate of the mouse release
     * @param mouseY The y-coordinate of the mouse release
     */
    private void handleMouseReleased(int mouseX, int mouseY) {
        if (selectedCard != null) {
            boolean cardHasDropped = false;
            for (Pile pile : gamePiles) {
                if (pile.containsPoint(mouseX, mouseY) && pile.isValidDropZone(selectedCard) && !pile.isPileFull()) {
                    pile.addCard(selectedCard);
                    cardHasDropped = true;
                    break;
                }
            }
            if (!cardHasDropped) {
                // If the release is not on a valid drop zone, return the card to its source pile
                sourcePile.addCard(selectedCard);
            }
            sourcePile = null; // Reset source pile
            selectedCard = null; // Reset selected card
        }
    }

    /**
     * Gets the list of game piles.
     * @return The list of game piles
     */
    @Override
    public List<Pile> getGamePiles() {
        return gamePiles;
    }

    /**
     * Gets the selected card.
     * @return The selected card
     */
    @Override
    public Card getSelectedCard() {
        return selectedCard;
    }

    /**
     * Checks if the game is won.
     * @return True if the game is won, else false
     */
    @Override
    public boolean isGameWon()  {
        return isGameWon;
    }

    /**
     * Checks if a round has been won.
     */
    private void checkRoundWon() {
        if (stockPile.isEmpty()) {
            int countFullPiles = 0;

            for (Pile pile : winPiles) {
                if ((pile instanceof SixPile && pile.isPileFull()) || (pile instanceof SevenPile && pile.isPileFull())) {
                    countFullPiles++;
                }
            }

            if (countFullPiles == 5) {
                isGameWon = true;
            }
        }
    }

    /**
     * Checks if the game should proceed to the second round.
     */
    private void checkSecondRound() {
        if (stockPile.isEmpty() && gameRoundCounter == 1) {
            initLastRound();
            gameRoundCounter++;
        }
    }

    /**
     * Initializes the last (second) round of the game.
     */
    private void initLastRound() {
        while (!discardPile.isEmpty()) {
            Card card = discardPile.getTopCard();
            card.flipCard();
            stockPile.addCard(card);
        }
    }
}