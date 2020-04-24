package game;

import blackjack.Card;
import blackjack.Deck;
import blackjack.Hand;
import blackjack.blackJackHand;
import enums.Rank;
import enums.Suit;
import org.junit.jupiter.api.Test;

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

    @Test
    public void testBJHandTotal(){
        Card card = new Card(Rank.ACE, Suit.DIAMONDS);
        Card card2 = new Card(Rank.JACK, Suit.CLUBS);
        Card card3 = new Card(Rank.THREE, Suit.DIAMONDS);
        Card card4 = new Card(Rank.NINE, Suit.HEARTS);
        blackJackHand hand = new blackJackHand();
        hand.addCard(card);
        hand.addCard(card2);
        hand.addCard(card3);
        hand.addCard(card4);
        assertEquals(4, hand.handSize());
        assertEquals(23, hand.getPoints());
    }
}