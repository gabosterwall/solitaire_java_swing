package main.solitaire.gamemodes.napoleonstomb;

import main.solitaire.models.card.Card;
import main.solitaire.models.enums.Rank;
import main.solitaire.models.pile.Pile;

import java.awt.*;

public class ParkingPile extends Pile {

    public ParkingPile(int x, int y, int width, int height, int maxNumOfCard, Color backgroundColor, Color borderColor) {
        super(x, y, width, height, maxNumOfCard, backgroundColor, borderColor);
    }

    @Override
    public boolean isCardDraggable() {
        return true;
    }

    @Override
    public boolean isValidDropZone(Card card) {
        return (isEmpty() && card.getRank() == Rank.SIX);
    }
}
