package com.blackjack;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Card {
    /* 모양 : 하트,다이아,스페이드,클로버 */
    private String pattern;

    /* A =1,   */
    private String denomination;

    private int point;

    /* 반복문의 인덱스 */
    public Card(String pattern,int index){
        this.pattern = pattern;
        this.denomination = numberToDenomination(index);
        this.point = numberToPoint(index);
    }

    private int numberToPoint(int number) {
        if(number >= 11){
            return 10;
        }
        return number;
    }

    private String numberToDenomination(int number) {
        if(number == 1){
            return "A";
        } else if (number == 11) {
            return "J";
        } else if (number == 12) {
            return "Q";
        } else if (number == 13) {
            return "K";
        }
        return String.valueOf(number);
    }

    @Override
    public String toString(){
        return "Card{" + "pattern='" + pattern + "', denomination='" + denomination + "'}";
    }


}
