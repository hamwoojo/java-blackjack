package com.blackjack;

import lombok.Getter;

import java.util.Collections;
import java.util.Stack;

@Getter
public class CardDeck {

    private static final int CARD_COUNT = 13;

    /* List 인터페이스를 활용하면 ArrayList LinkedList 둘다 허용 가능 */
    private Stack<Card> cards;

    /* 생성자는 실행 시키는 역할이지 비즈니스 로직을 알 필요는 없다. */
    public CardDeck(){
        cards = generateCards();
        Collections.shuffle(cards);
    }

    /* ArrayList는 카드를 draw 했을 떄 해당 인덱스의 언스턴스를 제거하고 다시 카피를 하기 때문에 앞 뒤 노드와 연결되어있는 링크드리스트에 비해 제거의 성능이 좋지 못하다. */
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
