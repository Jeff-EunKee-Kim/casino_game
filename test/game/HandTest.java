package game;

import deck.Card;
import deck.Deck;
import deck.Hand;
import org.junit.jupiter.api.Test;
import roulette.Color;
import roulette.Wheel;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Vincent Sinfuego
 */
public class HandTest{

    @Test
    public void testHandCreation(){
        Deck deck = new Deck();
        Hand hand = new Hand();
        assertEquals(0, hand.handSize());
    }

    @Test
    public void testAddCard(){
        Card card = new Card();
        Hand hand = new Hand();
        hand.addCard(card);
        assertEquals(1, hand.handSize());
    }
}