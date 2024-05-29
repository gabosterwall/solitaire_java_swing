package main.solitaire.controller;

import main.solitaire.models.game.ISolitaireGame;
import main.solitaire.view.SolitaireView;

import java.awt.event.MouseAdapter;

/**
 * Abstract class representing a controller for a solitaire game.
 */
public abstract class SolitaireGameController extends MouseAdapter {
   protected ISolitaireGame game; // Model
   protected SolitaireView view; // View

   /**
    * Constructs a new SolitaireGameController with the given game variant and view.
    * @param game A ISolitaire game instance
    * @param view A SolitaireView instance
    */
   public SolitaireGameController(ISolitaireGame game, SolitaireView view) {
      this.game = game;
      this.view = view;
      view.addMouseListener(this);
      view.addMouseMotionListener(this);
   }

   /**
    * Initializes the game.
    */
   public abstract void initGame();

   /**
    * Restarts the game.
    */
   public abstract void restartGame();

   /**
    * Exits the game.
    */
   public abstract void exitGame();
}