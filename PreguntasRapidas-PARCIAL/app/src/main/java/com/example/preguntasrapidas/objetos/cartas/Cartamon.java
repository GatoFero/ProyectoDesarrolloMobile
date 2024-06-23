package com.example.preguntasrapidas.objetos.cartas;

import android.content.Context;
import android.widget.ImageView;

public class Cartamon extends Carta{

    public Cartamon() {
    }

    public Cartamon(String cardUp, float codeCard, ImageView container, boolean start, float positionY, float positionX) {
        super(cardUp, codeCard, container, start, positionY, positionX);
    }
}
