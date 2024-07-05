package com.example.preguntasrapidas.objetos.cartas;

import android.content.Context;
import android.view.View;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.preguntasrapidas.objetos.clases_padre.Card;
import com.example.preguntasrapidas.objetos.ensabladores.MemoryTable;

public class CardMemory extends Card {

    private MemoryTable mesaGame;
    public CardMemory(Context context, ConstraintLayout parentLayout, String cardUp, float codeCard, boolean start, int width, int height, float initialPositionY, float initialPositionX, float positionY, float positionX) {
        super(context, parentLayout, cardUp, codeCard, start, width, height, initialPositionY, initialPositionX, positionY, positionX);
    }
    public void setMesaGame(MemoryTable mesa){
        mesaGame = mesa;
        setActionCard();
    }
    private void setActionCard(){
        this.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(stateCard.equals("usable")){
                    mesaGame.makeMovement(CardMemory.this);
                }
            }
        });
    }
}
