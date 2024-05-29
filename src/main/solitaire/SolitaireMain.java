package main.solitaire;

import main.solitaire.controller.SolitaireGameController;
import main.solitaire.gamemodes.napoleonstomb.NapoleonsTombController;
import main.solitaire.gamemodes.napoleonstomb.NapoleonsTombGame;
import main.solitaire.models.game.ISolitaireGame;
import main.solitaire.view.SolitaireView;

import javax.swing.*;
import java.awt.*;

/**
 * Solitaire Game, intended to implement specific game variants of Solitaire.
 * Currently implements Napoleon's Tomb.
 *
 * @author Gabriél Österwall
 * @mail gabosterwall@gmail.com
 * @since 2024-05-15
 */
public class SolitaireMain extends JFrame {

    public SolitaireMain() {
        // Model
        ISolitaireGame game = new NapoleonsTombGame(); // Game variant to play
        SolitaireView view = new SolitaireView(); // View
        SolitaireGameController controller = new NapoleonsTombController(game, view); // Controller for the game variant

        // Set general settings
        setTitle("Solitaire: " + game.getTitle());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        // Create buttons
        JButton restartButton = new JButton("Restart");
        JButton exitButton = new JButton("Exit");

        // Add actions for the buttons to perform
        restartButton.addActionListener(e -> controller.restartGame());
        exitButton.addActionListener(e -> controller.exitGame());

        // Add new JPanel to attach the buttons on, then add the panel to the frame
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(restartButton);
        buttonPanel.add(exitButton);

        // Add button-panel and view (game panel)
        add(buttonPanel, BorderLayout.NORTH);
        add(view);

        // Initialize game
        controller.initGame();
        setVisible(true);
    }

    /**
     *
     * @param args Not used
     */
    public static void main(String[] args){
        SwingUtilities.invokeLater(SolitaireMain::new);
    }
}
