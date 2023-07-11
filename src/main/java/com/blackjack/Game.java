package com.blackjack;

public class Game {
    public void play(){
        System.out.println("==================== BlackJack Start ====================");
        Dealer dealer = new Dealer();
        Gamer gamer = new Gamer();
        Rule rule = new Rule();
        CardDeck cardDeck = new CardDeck();
    }
}
