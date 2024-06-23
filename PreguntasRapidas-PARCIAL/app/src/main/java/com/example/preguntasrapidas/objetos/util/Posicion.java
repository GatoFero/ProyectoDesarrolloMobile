package com.example.preguntasrapidas.objetos.util;

public class Posicion {
    private final float posicionX;
    private final float posicionY;

    public Posicion(float posY, float posX){
        this.posicionY = posY;
        this.posicionX = posX;
    }
    public float getPosicionX() {
        return posicionX;
    }

    public float getPosicionY() {
        return posicionY;
    }
}
