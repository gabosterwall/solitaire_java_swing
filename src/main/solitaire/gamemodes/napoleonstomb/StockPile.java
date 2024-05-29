package main.solitaire.gamemodes.napoleonstomb;

import main.solitaire.models.card.Card;
import main.solitaire.models.enums.Rank;
import main.solitaire.models.enums.Suit;
import main.solitaire.models.pile.Pile;

import java.awt.*;
import java.util.Collections;

public class StockPile extends Pile {

    public StockPile(int x, int y, int width, int height, int maxNumOfCard, Color backgroundColor, Color borderColor) {
        super(x, y, width, height, maxNumOfCard, backgroundColor, borderColor);
        initStockPile();
    }

    @Override
    public boolean isValidDropZone(Card card) {
        return false;
    }

    @Override
    public boolean isCardDraggable() {
        return false;
    }

    private void shuffleStockPile() {
        Collections.shuffle(pile);
    }

    private void initStockPile() {
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                addCard(new Card(rank, suit, getX(), getY(), getWidth(), getHeight()));
            }
        }
        shuffleStockPile();
    }

}
