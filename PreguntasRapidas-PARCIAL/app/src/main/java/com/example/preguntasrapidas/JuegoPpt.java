package com.example.preguntasrapidas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;


public class JuegoPpt extends AppCompatActivity {

    private TextView txvResultado;
    private ImageButton imbPiedra;
    private ImageButton imbPapel;
    private ImageButton imbTijera;
    private Button btnResultado;
    private String jugadorUno;
    private String maquina;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ppt);


        txvResultado = findViewById(R.id.txvResultado);
        imbPiedra = findViewById(R.id.imbPiedra);
        imbPapel = findViewById(R.id.imbPapel);
        imbTijera = findViewById(R.id.imbTijera);
        btnResultado = findViewById(R.id.btnResultado);

        btnResultado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {mostrarResultado();}
        });

        imbTijera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {accionarJuego("Tijera");}
        });

        imbPiedra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {accionarJuego("Piedra");}
        });

        imbPapel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {accionarJuego("Papel");}
        });

        btnResultado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {mostrarResultado();}
        });

        ImageButton backfourButton = findViewById(R.id.imbBackfour);

        backfourButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(JuegoPpt.this, JuegosActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    private void accionarJuego(String jugadorUno){
        this.jugadorUno = jugadorUno;
        String[] elecciones = {"Piedra", "Papel", "Tijera"};
        this.maquina = elecciones[new Random().nextInt(elecciones.length)];
        txvResultado.setText("Elegiste: " + jugadorUno);
    }

    private void mostrarResultado(){
        String resultado;
        if (jugadorUno == null || maquina == null){
            txvResultado.setText("Elige tu opción");
            return;
        }
        if (jugadorUno.equals(maquina)){
            resultado = "Empatados";
        } else if (jugadorUno.equals("Piedra") && maquina.equals("Tijera")
                || jugadorUno.equals("Tijera") && maquina.equals("Papel")
                || jugadorUno.equals("Papel") && maquina.equals("Piedra")){
            resultado = "Ganaste";
        } else {
            resultado = "Perdiste";
        }

        txvResultado.setText("Elegiste " + jugadorUno + "\nMaquina eligió: " + maquina + "\n" + resultado);
    }
}
