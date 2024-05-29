package main.solitaire.gamemodes.napoleonstomb;

import main.solitaire.controller.SolitaireGameController;
import main.solitaire.models.game.ISolitaireGame;
import main.solitaire.view.SolitaireView;

import java.awt.event.MouseEvent;

/**
 * Controller class for NapoleonsTomb solitaire game.
 */
public class NapoleonsTombController extends SolitaireGameController {

    /**
     * Constructs a new NapoleonsTombController.
     * @param game The ISolitaire game instance
     * @param view The SolitaireView instance
     */
    public NapoleonsTombController(ISolitaireGame game, SolitaireView view) {
        super(game, view);
    }

    /**
     * Initializes the game.
     */
    @Override
    public void initGame() {
        game.initGame();
        view.initView(game.getGamePiles());
        view.updateView();
    }

    /**
     * Restarts the game.
     */
    @Override
    public void restartGame() {
        game = new NapoleonsTombGame();
        initGame();
    }

    /**
     * Exits the game.
     */
    @Override
    public void exitGame() {
        System.out.println("Now exiting game...");
        System.exit(0);
    }

    /**
     * Handles mouse click event.
     * @param e The MouseEvent to be processed
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        game.handleMouseEvent(e);
        view.updateView();
    }

    /**
     * Handles mouse pressed event.
     * @param e The MouseEvent to be processed
     */
    @Override
    public void mousePressed(MouseEvent e) {
        game.handleMouseEvent(e);
        view.updateView();
        view.setMovingCard(game.getSelectedCard());
    }

    /**
     * Handles mouse dragged event.
     * @param e The MouseEvent to be processed
     */
    @Override
    public void mouseDragged(MouseEvent e) {
        game.handleMouseEvent(e);
        view.updateView();
        view.setMovingCard(game.getSelectedCard());
    }

    /**
     * Handles mouse released event.
     * @param e The MouseEvent to be processed
     */
    @Override
    public void mouseReleased(MouseEvent e) {
        game.handleMouseEvent(e);
        view.updateView();
        view.setMovingCard(game.getSelectedCard());

        // Check if the game has been won
        if (game.isGameWon()) {
            view.displayMessage("You Win!");
        }
    }
}