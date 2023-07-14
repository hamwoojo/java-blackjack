package com.blackjack;


import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ApplicationTest{

    private CardDeck cardDeck;
    private List<Card> cards;
    private Rule rule;

    @Before
    public void setup(){
        cardDeck = new CardDeck();
        cards = cardDeck.getCards();
        rule = new Rule();
    }
    @Test
    public void test_카드패턴비교(){
        assertThat(cards.get(0).getPattern(), is(Card.Pattern.SPADE));
        assertThat(cards.get(13).getPattern(), is(Card.Pattern.HEART));

        for (Card card : cards) {
            System.out.println(card.toString());
        }
    }

    @Test
    public void test_카드끗수비교(){
        assertThat(cards.get(0).getDenomination(),is(Card.Denomination.ACE));
        assertThat(cards.get(0).getDenomination().getPoint(),is(1));
    }

    @Test
    public void test_Stack확인(){
        assertThat(cardDeck.getCards().size(),is(52));
        cardDeck.draw();
        assertThat(cardDeck.getCards().size(),is(51));
        cardDeck.draw();
        assertThat(cardDeck.getCards().size(),is(50));
        cardDeck.draw();
        assertThat(cardDeck.getCards().size(),is(49));
    }

    @Test
    public void rule_Stream테스트(){
        List<Player> players = Arrays.asList(new Gamer("hwj"),new Dealer());

        players.get(0).receiveCard(new Card(Card.Pattern.HEART, Card.Denomination.JACK));
        players.get(0).receiveCard(new Card(Card.Pattern.SPADE, Card.Denomination.JACK));

        players.get(1).receiveCard(new Card(Card.Pattern.HEART, Card.Denomination.FIVE));
        players.get(1).receiveCard(new Card(Card.Pattern.CLUB, Card.Denomination.KING));

        Player winner = rule.getWinner(players);

        assertThat(winner.getName(),is("hwj"));
    }
}