package com.example.preguntasrapidas.objetos.cartas;

import android.content.Context;
import android.view.View;
import android.widget.ImageButton;

import com.example.preguntasrapidas.objetos.MesaMemoria;

public class CartaMemoria extends Carta{
    private MesaMemoria mesaMemoria;
    public CartaMemoria(Context context,  String cartaRevelada, int codigoCarta, ImageButton boton, int iniciacion, float posicionY, float posicionX, MesaMemoria mesaMemoria) {
        super(context,cartaRevelada, codigoCarta, boton, iniciacion, posicionY, posicionX);
        this.mesaMemoria = mesaMemoria;

        this.boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (estadoCarta.equals("usable")){
                    mesaMemoria.realizar_jugada(CartaMemoria.this);
                }
            }
        });
    }
}
