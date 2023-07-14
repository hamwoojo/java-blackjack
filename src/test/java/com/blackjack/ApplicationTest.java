package com.blackjack;


import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ApplicationTest{

    @Test
    public void test_카드덱생성(){
        CardDeck cardDeck = new CardDeck();
        List<Card> cards = cardDeck.getCards();
        assertThat(cards.get(0).getPattern(), is(Card.Pattern.SPADE));
        assertThat(cards.get(13).getPattern(), is(Card.Pattern.HEART));

        for (Card card : cards) {
            System.out.println(card.toString());
        }
    }
}