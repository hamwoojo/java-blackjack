package com.blackjack;

import lombok.Getter;

import java.util.Collections;
import java.util.Stack;

@Getter
public class CardDeck {

    private static final int CARD_COUNT = 13;
    private Stack<Card> cards;

    /* 생성자는 실행 시키는 역할이지 비즈니스 로직을 알 필요는 없다. */
    public CardDeck(){
        cards = generateCards();
        Collections.shuffle(cards);
    }

    private Stack<Card> generateCards(){
        Stack<Card> cards = new Stack<>();
        for (Card.Pattern pattern : Card.Pattern.values()) {
            for(Card.Denomination denomination : Card.Denomination.values()){
                Card card = new Card(pattern,denomination);
                cards.push(card);
            }
        }
        return cards;
    }
    public Card draw(){
        return this.cards.pop();
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for(Card card : cards){
            sb.append(card.toString());
            sb.append("\n");
        }

        return sb.toString();
    }
}
