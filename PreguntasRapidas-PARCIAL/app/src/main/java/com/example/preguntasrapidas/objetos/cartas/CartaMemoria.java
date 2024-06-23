package com.example.preguntasrapidas.objetos.cartas;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.example.preguntasrapidas.objetos.ensabladores.MesaMemoria;

public class CartaMemoria extends Carta{
    private MesaMemoria mesaMemoria;

    public CartaMemoria(String cardUp, float codeCard, ImageView container, boolean start, float positionY, float positionX, MesaMemoria mesaMemoria) {
        super(cardUp, codeCard, container, start, positionY, positionX);
        this.mesaMemoria = mesaMemoria;

        this.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(stateCard.equals("usable")){
                    mesaMemoria.makeMovement(CartaMemoria.this);
                }
            }
        });
    }
}
