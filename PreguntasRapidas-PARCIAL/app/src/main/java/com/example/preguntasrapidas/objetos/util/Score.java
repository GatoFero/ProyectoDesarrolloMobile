package com.example.preguntasrapidas.objetos.util;

import java.io.Serializable;

public class Score implements Serializable {
    private int score;

    public Score(int score){
        this.score = score;
    }
    public void sumScore(int increase){
        score = score + increase;
    }
    public void subtractScore(int decrease){
        score = score - decrease;
    }
    public int getScore() {
        return score;
    }
}