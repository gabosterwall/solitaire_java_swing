package main.solitaire.gamemodes.napoleonstomb;

import main.solitaire.models.card.Card;
import main.solitaire.models.enums.Rank;
import main.solitaire.models.pile.Pile;

import java.awt.*;

public class SevenPile extends Pile {

    public SevenPile(int x, int y, int width, int height, int maxNumOfCard, Color backgroundColor, Color borderColor) {
        super(x, y, width, height, maxNumOfCard, backgroundColor, borderColor);
    }

    @Override
    public boolean isCardDraggable() {
        return false;
    }

    @Override
    public boolean isValidDropZone(Card card) {
        if (isEmpty() && card.getRank() == Rank.SEVEN) {
            return true;
        } else if (!isEmpty()) {
            if (viewTopCard().getRank() == Rank.SEVEN && card.getRank() == Rank.EIGHT) {
                return true;
            } else if (viewTopCard().getRank() == Rank.EIGHT && card.getRank() == Rank.NINE) {
                return true;
            } else if (viewTopCard().getRank() == Rank.NINE && card.getRank() == Rank.TEN) {
                return true;
            } else if (viewTopCard().getRank() == Rank.TEN && card.getRank() == Rank.JACK) {
                return true;
            } else if (viewTopCard().getRank() == Rank.JACK && card.getRank() == Rank.QUEEN) {
                return true;
            } else {
                return viewTopCard().getRank() == Rank.QUEEN && card.getRank() == Rank.KING;
            }
        }
        return false;
    }
}
