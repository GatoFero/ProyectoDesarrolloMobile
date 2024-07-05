package com.example.preguntasrapidas.objetos.basicos;

public class Position {
    private final float positionY;
    private final float positionX;

    public Position(float posY, float posX){
        this.positionY = posY;
        this.positionX = posX;
    }
    public float getPositionY() {
        return positionY;
    }
    public float getPositionX() {
        return positionX;
    }
}
