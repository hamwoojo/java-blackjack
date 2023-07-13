package com.blackjack;

import java.util.List;

/* 딜러와 게이머는 같은 일을 하는 코드가 대부분이며 이 공통점을 묶어 단순화 하는 것을 추상화라고 한다 */
public interface Player {
    void receiveCard(Card card);
    void showCards();
    List<Card> openCards();

    void turnOff();
    void turnOn();
    boolean isTurn();

    String getName();
}
