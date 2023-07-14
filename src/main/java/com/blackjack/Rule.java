package com.blackjack;

import java.util.Comparator;
import java.util.List;

public class Rule {
    public Player getWinner(List<Player> players) {

        Player highestPlayer = players.stream()
                .max(Comparator.comparing((player -> getPointSum(player.openCards()))))
                .orElse(null);

        return highestPlayer;
    }

    private int getPointSum(List<Card> cards) {
        return cards.stream().mapToInt(card -> card.getDenomination().getPoint()).sum();
    }

}
