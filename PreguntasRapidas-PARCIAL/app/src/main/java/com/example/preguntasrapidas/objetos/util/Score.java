package com.example.preguntasrapidas.objetos.util;

import java.io.Serializable;

public class Score implements Serializable {
    private int puntos;

    public Score(int puntos){
        this.puntos = puntos;
    }
    public void sumarScore(int aumento){
        puntos = puntos + aumento;
    }
    public void restarPuntos(int restar){
        puntos = puntos - restar;
    }
    public int getPuntos() {
        return puntos;
    }
}
