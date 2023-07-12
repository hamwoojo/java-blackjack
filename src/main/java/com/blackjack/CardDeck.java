package com.blackjack;

import java.util.LinkedList;
import java.util.List;

public class CardDeck {

    private static final String[] PATTERNS = {"spade","heart","diamond","club"};
    /* A, 2~10, J Q K */
    private static final int CARD_COUNT = 13;

    /* ArrayList는 카드를 draw 했을 떄 해당 인덱스의 언스턴스를 제거하고 다시 카피를 하기 때문에 앞 뒤 노드와 연결되어있는 링크드리스트에 비해 제거의 성능이 좋지 못하다. */
    private List<Card> cards;

    public Card getCard(){
        return null;
    }

    /* 생성자는 실행 시키는 역할이지 비즈니스 로직을 알 필요는 없다. */
    public CardDeck(){
        cards = generateCards();
    }

    private List<Card> generateCards(){
        List<Card> cards = new LinkedList<>();

        for (String pattern : PATTERNS) {
            for (int i = 1; i <= CARD_COUNT; i++) {
                String denomination = this.numberToDenomination(i);
                Card card = new Card(pattern,denomination);
                cards.add(card);
            }
        }
        return cards;
    }

    private String numberToDenomination(int number) {
        if(number == 1){
            return "A";
        } else if (number == 11) {
            return "J";
        } else if (number == 12) {
            return "Q";
        } else if (number == 13) {
            return "K";
        }
        return String.valueOf(number);
    }

    public Card draw(){
        Card selectedCard = getRandomCard();
        cards.remove(selectedCard);
        return selectedCard;
    }

    private Card getRandomCard() {
        int size = cards.size();
        int select = (int)(Math.random()*size);
        return cards.get(select);
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
