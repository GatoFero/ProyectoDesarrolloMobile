package com.example.preguntasrapidas.objetos.basicos;

import java.io.Serializable;

public class Score implements Serializable {
    private int score;

    public Score(){
        this.score = 0;
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
    public String getScoreText(){
        return String.valueOf(getScore());
    }
}