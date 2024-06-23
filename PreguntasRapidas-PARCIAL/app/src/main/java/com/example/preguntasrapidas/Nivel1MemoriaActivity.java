package com.example.preguntasrapidas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.preguntasrapidas.objetos.cartas.CartaMemoria;
import com.example.preguntasrapidas.objetos.ensabladores.MesaMemoria;
import com.example.preguntasrapidas.objetos.util.Posicion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;

public class Nivel1MemoriaActivity extends AppCompatActivity {

    private ImageView primeraCard;
    private ImageView segundaCard;
    private ImageView terceraCard;
    private ImageView cuartaCard;
    private ImageView quintaCard;
    private ImageView sextaCard;
    private ImageView septimaCard;
    private ImageView octavaCard;
    private TextView iniciarNivel1;
    private LinkedList<CartaMemoria> cartas = new LinkedList<>();
    private LinkedList<Posicion> posiciones = new LinkedList<>();
    private TextView intentos;
    private TextView scoreMemoria;
    private MesaMemoria mesa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_nivel1_memoria);

        ImageButton backfiveButton = findViewById(R.id.imbBackfive);

        backfiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Nivel1MemoriaActivity.this, NivelCartasMemoriaActivity.class);
                startActivity(intent);
                finish();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.juegoppt), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        primeraCard = findViewById(R.id.nivel1_primeraCard);
        segundaCard = findViewById(R.id.nivel1_segundaCard);
        terceraCard = findViewById(R.id.nivel1_terceraCard);
        cuartaCard = findViewById(R.id.nivel1_cuartaCard);
        quintaCard = findViewById(R.id.nivel1_quintaCard);
        sextaCard = findViewById(R.id.nivel1_sextaCard);
        septimaCard = findViewById(R.id.nivel1_septimaCard);
        octavaCard = findViewById(R.id.nivel1_octavaCard);
        intentos = findViewById(R.id.intentos);
        scoreMemoria = findViewById(R.id.scoreMemoria);
        iniciarNivel1 = findViewById(R.id.iniciarNivel1);

        mesa = new MesaMemoria(cartas, posiciones, intentos, scoreMemoria, 7, 1);

       setUpMesa();

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                if (!cartas.get(0).isCola()){
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mesa.setIntents();
                            iniciarNivel1.setText("Toca Para Empezar");
                        }
                    });
                    cancel();
                }
            }
        }, 0, 1000);

        iniciarNivel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean cola = false;

                for(CartaMemoria cartaMemoria : cartas){
                    if(!cartaMemoria.isCola()){
                        cola = true;
                        break;
                    }
                }
                if (cola){
                    mesa.startGame();
                    ((ViewGroup) v.getParent()).removeView(v);
                }
            }
        });
    }
    private void setUpMesa(){

        cartas.add(new CartaMemoria("card1", 1, primeraCard,
                false, 0.471f, 0.498f, mesa));
        cartas.add(new CartaMemoria("card1", 1, segundaCard,
                false,0.471f, 0.498f, mesa));
        cartas.add(new CartaMemoria("card2", 2, terceraCard,
                false,0.471f, 0.498f, mesa));
        cartas.add(new CartaMemoria("card2", 2, cuartaCard,
                false,0.471f, 0.498f, mesa));
        cartas.add(new CartaMemoria("card3", 3, quintaCard,
                false,0.471f, 0.498f, mesa));
        cartas.add(new CartaMemoria("card3", 3, sextaCard,
                false,0.471f, 0.498f, mesa));
        cartas.add(new CartaMemoria("card4", 4, septimaCard,
                false,0.471f, 0.498f, mesa));
        cartas.add(new CartaMemoria("card4", 4, octavaCard,
                false,0.471f, 0.498f, mesa));

        posiciones.add(new Posicion(0.219f, 0.093f));
        posiciones.add(new Posicion(0.219f, 0.498f));
        posiciones.add(new Posicion(0.219f, 0.89f));
        posiciones.add(new Posicion(0.471f, 0.093f));
        posiciones.add(new Posicion(0.471f, 0.498f));
        posiciones.add(new Posicion(0.471f, 0.89f));
        posiciones.add(new Posicion(0.719f, 0.279f));
        posiciones.add(new Posicion(0.719f, 0.697f));

    }
}