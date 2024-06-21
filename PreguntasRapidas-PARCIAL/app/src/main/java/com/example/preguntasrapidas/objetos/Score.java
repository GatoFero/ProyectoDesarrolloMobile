package com.example.preguntasrapidas.objetos;

import java.io.Serializable;

public class Score implements Serializable {
    public int puntos;

    public Score(int puntos){
        this.puntos = puntos;
    }
    public int sumarScore(int aumento){
        puntos = puntos + aumento;
        return puntos;
    }
    public int restarPuntos(int restar){
        puntos = puntos - restar;
        return puntos;
    }

    public int getPuntos() {
        return puntos;
    }
}
