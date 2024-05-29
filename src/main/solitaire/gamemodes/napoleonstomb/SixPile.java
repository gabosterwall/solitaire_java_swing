package main.solitaire.gamemodes.napoleonstomb;

import main.solitaire.models.card.Card;
import main.solitaire.models.enums.Rank;
import main.solitaire.models.pile.Pile;

import java.awt.*;

public class SixPile extends Pile {
    private static final int SIX_PILE_MAX_NUM_OF_CARDS = 24;
    public SixPile(int x, int y, int width, int height, int maxNumOfCard, Color backgroundColor, Color borderColor) {
        super(x, y, width, height, maxNumOfCard, backgroundColor, borderColor);

    }

    public boolean isPileFull() {
        return pile.size() == SIX_PILE_MAX_NUM_OF_CARDS;
    }

    @Override
    public boolean isCardDraggable() {
        return false;
    }

    @Override
    public boolean isValidDropZone(Card card) {
        if (isEmpty() && card.getRank() == Rank.SIX) {
            return true;
        } else if (!isEmpty()) {
            if (viewTopCard().getRank() == Rank.SIX && card.getRank() == Rank.FIVE) {
                return true;
            } else if (viewTopCard().getRank() == Rank.FIVE && card.getRank() == Rank.FOUR) {
                return true;
            } else if (viewTopCard().getRank() == Rank.FOUR && card.getRank() == Rank.THREE) {
                return true;
            } else if (viewTopCard().getRank() == Rank.THREE && card.getRank() == Rank.TWO) {
                return true;
            } else if (viewTopCard().getRank() == Rank.TWO && card.getRank() == Rank.ACE) {
                return true;
            } else {
                return viewTopCard().getRank() == Rank.ACE && card.getRank() == Rank.SIX;
            }
        }
        return false;
    }
}
