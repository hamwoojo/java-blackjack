package com.blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/* 게이머의 역할 : 카드를 받는다,카드를 확인한다, 카드를 공개한다, 카드를 더 받을지 결정한다..? */

public class Gamer implements Player {
    private final List<Card> cards;
    private boolean turn;

    private final String name;

    public Gamer(String name) {
        this.cards = new ArrayList<>();
        this.name = name;
    }

    @Override
    public void receiveCard(Card card) {
        this.cards.add(card);
        this.showCards();
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
        return this.name;
    }

    @Override
    public void showCards() {
        StringBuilder sb = new StringBuilder();
        sb.append(name + "의 현재 보유 카드 목록 \n");
        sb.append(cards.stream().map(card -> card.toString()).collect(Collectors.joining("\n")));

        System.out.println(sb);
    }
}
