package com.example.preguntasrapidas.objetos.util;

public class Posicion {
    public float posicionY;
    public float posicionX;
    public float posicionX2;

    public Posicion(float posY, float posX){
        this.posicionY = posY;
        this.posicionX = posX;
    }

    public Posicion(float posicionY, float posicionX, float posicionX2) {
        this.posicionY = posicionY;
        this.posicionX = posicionX;
        this.posicionX2 = posicionX2;
    }
}
