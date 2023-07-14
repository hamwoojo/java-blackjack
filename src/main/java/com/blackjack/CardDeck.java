package com.blackjack;

import lombok.Getter;

import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;
import java.util.stream.Collectors;

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
        cards = Arrays.stream(Card.Pattern.values())
                .flatMap(pattern -> Arrays.stream(Card.Denomination.values())
                        .map(denomination -> new Card(pattern,denomination)))
                        .collect(Collectors.toCollection(Stack::new));
        return cards;
    }
    public Card draw(){
        return this.cards.pop();
    }
    @Override
    public String toString() {
        return cards.stream().map(Card::toString).collect(Collectors.joining("\n"));
    }
}
