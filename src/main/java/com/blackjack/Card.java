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

    /* 인자를 추가한 생성자를 사용한 이유는 pattern과 denomination을 필수임을 강제하기 위해서이다. */
    public Card(String pattern, String denomination){
        this.pattern = pattern;
        this.denomination = denomination;
    }
    @Override
    public String toString(){
        return "Card{" + "pattern='" + pattern + ", denomination='" + denomination + '}';
    }


}
