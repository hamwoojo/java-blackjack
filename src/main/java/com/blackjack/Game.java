package com.blackjack;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Game {
    private static final int INIT_RECEIVE_CARD_COUNT = 2;
    private static final String STOP_RECEIVE_CARD = "0";
    public void play(){
        System.out.println("==================== BlackJack Start ====================");
        Scanner sc = new Scanner(System.in);

        Rule rule = new Rule();
        CardDeck cardDeck = new CardDeck();

        List<Player> players = Arrays.asList(new Gamer("hwj"),new Dealer());
        List<Player> initAfterPlayers = initPhase(players,cardDeck);
        List<Player> playingAfterPlayers = playingPhase(sc,cardDeck,initAfterPlayers);

        Player winner = rule.getWinner(playingAfterPlayers);
        System.out.println("승자는 " + winner.getName());

    }


    /* 시작에 항상 카드를 두 장씩 고정으로 받지만 i<2로 선언하는 for문으로 해버리면 매직넘버의 함정에 빠질 수 있다 */
    private List<Player> initPhase(List<Player> players, CardDeck cardDeck){
        System.out.println("딜러와 게이머가 카드를 두 장 뽑습니다.");
        for (int i = 1; i <= INIT_RECEIVE_CARD_COUNT; i++) {
            for (Player player : players) {
                Card card = cardDeck.draw();
                player.receiveCard(card);
            }
        }
        return players;
    }
    private List<Player> playingPhase(Scanner sc, CardDeck cardDeck, List<Player> players){
        List<Player> cardReceivePlayers;
        while(true){
            cardReceivePlayers = receiveCardAllPlayers(sc,cardDeck,players);
            if(isAllPlayerTurnOff(cardReceivePlayers)){
                break;
            }
        }
        return cardReceivePlayers;
    }

    private boolean isAllPlayerTurnOff(List<Player> players) {
        for (Player player : players) {
            if(player.isTurn()){
                return false;
            }
        }
        return true;
    }

    private boolean isReceiveCard(Scanner sc){
        System.out.println("카드를 계속 뽑으시겠습니까? 종료를 원하시면 0을 입력하세요.");
        return !STOP_RECEIVE_CARD.equals(sc.nextLine());
    }

    private List<Player> receiveCardAllPlayers(Scanner sc, CardDeck cardDeck, List<Player> players) {
        for (Player player : players) {
            System.out.println(player.getName()+"님 차례입니다.");

            if(isReceiveCard(sc)){
                Card card = cardDeck.draw();
                player.receiveCard(card);
                player.turnOn();
            }else{
                player.turnOff();
            }
        }
        return players;
    }


}
