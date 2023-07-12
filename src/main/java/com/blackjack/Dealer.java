package com.blackjack;

import java.util.List;


/* 딜러의 역할 : 추가로 카드를 받는다, 단 2카드의 합계가 16점 이하면 반드시 한장을 추가로 뽑고 17점 이상이면 받을 수 없다.
* 카드를 오픈한다. 뽑은 카드를 소유한다.*/
public class Dealer {
    private List<Card> cards;
    private static int MaxCount = 16;

    public void receiveCard(Card card){

    }
    public List<Card> openCards(){
        return null;
    }

}
