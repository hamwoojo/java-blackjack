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

        List<Player> players = Arrays.asList(new Gamer(),new Dealer());

        initPhase(players,cardDeck);
        playingPhase(sc,cardDeck,players);
    }


    /* 시작에 항상 카드를 두 장씩 고정으로 받지만 i<2로 선언하는 for문으로 해버리면 매직넘버의 함정에 빠질 수 있다 */
    private void initPhase(List<Player> players,CardDeck cardDeck){
        System.out.println("딜러와 게이머가 카드를 두 장 뽑습니다.");
        for (int i = 1; i <= INIT_RECEIVE_CARD_COUNT; i++) {
            for (Player player : players) {
                Card card = cardDeck.draw();
                player.receiveCard(card);
            }
        }
    }
    private void playingPhase(Scanner sc, CardDeck cardDeck, List<Player> players){

        while(true){
            boolean isAllPlayerTurnOff = receiveCardAllPlayers(sc,cardDeck,players);
            if(isAllPlayerTurnOff){
                break;
            }
        }
    }

    private boolean isReceiveCard(Scanner sc){
        System.out.println("카드를 계속 뽑으시겠습니까? 종료를 원하시면 0을 입력하세요.");
        return !STOP_RECEIVE_CARD.equals(sc.nextLine());
    }

    private boolean receiveCardAllPlayers(Scanner sc, CardDeck cardDeck, List<Player> players) {
        boolean isAllPlayerTurnOff = true;

        for (Player player : players) {
            if(isReceiveCard(sc)){
                Card card = cardDeck.draw();
                player.receiveCard(card);
                isAllPlayerTurnOff = false;
            }else{
                isAllPlayerTurnOff = true;
            }
        }
        return isAllPlayerTurnOff;
    }


}
