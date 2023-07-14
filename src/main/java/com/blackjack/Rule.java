package com.blackjack;

import java.util.List;

public class Rule {
    public Player getWinner(List<Player> players) {
        Player highestPlayer = null;
        int highestPoint = 0;

        for (Player player : players) {
            int playerPointSum = getPointSum(player.openCards());
            if (playerPointSum > highestPoint) {
                highestPoint = playerPointSum;
                highestPlayer = player;
            }
        }
        return highestPlayer;
    }

    private int getPointSum(List<Card> cards) {
        int pointSum = 0;
        for (Card card : cards) {
            pointSum += card.getDenomination().getPoint();
        }
        return pointSum;
    }

}
