package com.blackjack;

import java.util.Scanner;

public class Game {
    public void play(){
        System.out.println("==================== BlackJack Start ====================");
        Scanner sc = new Scanner(System.in);

        Dealer dealer = new Dealer();
        Gamer gamer = new Gamer();
        Rule rule = new Rule();
        CardDeck cardDeck = new CardDeck();

        initPhase(gamer,dealer,cardDeck);
        playingPhase(sc,cardDeck,gamer);
    }


    /* 시작에 항상 카드를 두 장씩 고정으로 받지만 i<2로 선언하는 for문으로 해버리면 매직넘버의 함정에 빠질 수 있다 */
    private static final int INIT_RECEIVE_CARD_COUNT = 2;
    private void initPhase(Gamer gamer,Dealer dealer, CardDeck cardDeck){
        System.out.println("딜러와 게이머가 카드를 두 장 뽑습니다.");
        for (int i = 0; i < INIT_RECEIVE_CARD_COUNT; i++) {
            Card card = cardDeck.draw();
            gamer.receiveCard(card);

            Card dealerCard = cardDeck.draw();
            dealer.receiveCard(dealerCard);
        }
    }
    private void playingPhase(Scanner sc, CardDeck cardDeck, Gamer gamer){
        String gamerInput;
        while(true){
            System.out.println("카드를 계속 뽑으시겠습니까? 종료를 원하시면 0을 입력하세요.");
            gamerInput = sc.nextLine();

            /* equals를 쓸때는 절대 null이 될수 없는 값을 앞에다 두면 NullPointException을 방지할 수 있다 */
            if("0".equals(gamerInput)){
                break;
            }
            /* 객체 지향에서 gamer는 card가 어떤식으로 본인에게 오는지 알필요가 없다 게이머는 그저 카드를 받는 본인의 역할에 충신하면 될뿐 */
            Card card = cardDeck.draw();
            gamer.receiveCard(card);
        }
    }
}
