package com.example.preguntasrapidas.objetos.cartas;

import android.content.Context;
import android.view.View;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.preguntasrapidas.objetos.clases_padre.Carta;
import com.example.preguntasrapidas.objetos.ensabladores.MesaMemoria;

public class CartaMemoria extends Carta {

    private MesaMemoria mesaGame;
    public CartaMemoria(Context context, ConstraintLayout parentLayout, String cardUp, float codeCard, boolean start, int width, int height, float initialPositionY, float initialPositionX, float positionY, float positionX) {
        super(context, parentLayout, cardUp, codeCard, start, width, height, initialPositionY, initialPositionX, positionY, positionX);
    }
    public void setMesaGame(MesaMemoria mesa){
        mesaGame = mesa;
        setActionCard();
    }
    private void setActionCard(){
        this.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(stateCard.equals("usable")){
                    mesaGame.makeMovement(CartaMemoria.this);
                }
            }
        });
    }
}
