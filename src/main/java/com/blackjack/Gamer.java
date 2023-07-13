package com.blackjack;

import java.util.ArrayList;
import java.util.List;

/* 게이머의 역할 : 카드를 받는다,카드를 확인한다, 카드를 공개한다, 카드를 더 받을지 결정한다..? */

public class Gamer implements Player{
    private List<Card> cards;

    public Gamer(){
        cards = new ArrayList<>();
    }
    @Override
    public void receiveCard(Card card){
        this.cards.add(card);
        this.showCards();
    }
    @Override
    public List<Card> openCards(){
        return this.cards;
    }

    @Override
    public void showCards(){
        StringBuilder sb = new StringBuilder();
        sb.append("게이머의 현재 보유 카드 목록 \n");

        for(Card card : cards){
            sb.append(card.toString());
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
