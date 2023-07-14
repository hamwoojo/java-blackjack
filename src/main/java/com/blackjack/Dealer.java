package com.blackjack;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/* 딜러의 역할 : 추가로 카드를 받는다, 단 2카드의 합계가 16점 이하면 반드시 한장을 추가로 뽑고 17점 이상이면 받을 수 없다.
 * 카드를 오픈한다. 뽑은 카드를 소유한다.*/
public class Dealer implements Player {
    private static final String NAME = "딜러";
    private static final int CAN_RECEIVE_POINT = 16;

    private final List<Card> cards;
    private boolean turn;


    public Dealer() {
        this.cards = new ArrayList<>();
    }

    @Override
    public void receiveCard(Card card) {
        /* */
        if (this.isReceiveCard()) {
            this.cards.add(card);
            this.showCards();
        } else {
            System.out.println("카드의 합이 16이상입니다. 더이상 카드를 받을 수 없습니다.");
        }
    }

    private boolean isReceiveCard() {
        return getPointSum() <= CAN_RECEIVE_POINT;
    }

    private int getPointSum() {
        int sum = 0;
        for (Card card : cards) {
            sum += card.getDenomination().getPoint();
        }
        return sum;
    }

    @Override
    public List<Card> openCards() {
        return this.cards;
    }

    @Override
    public void turnOff() {
        this.setTurn(false);
    }

    @Override
    public void turnOn() {
        this.setTurn(true);
    }

    @Override
    public boolean isTurn() {
        return this.turn;
    }

    private void setTurn(boolean turn) {
        this.turn = turn;
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public void showCards() {
        StringBuilder sb = new StringBuilder();
        sb.append(getName() + "의 현재 보유 카드 목록 \n");
        sb.append(cards.stream().map(card -> card.toString()).collect(Collectors.joining("\n")));
        System.out.println(sb);
    }

}
