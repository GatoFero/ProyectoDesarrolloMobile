package com.example.preguntasrapidas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.preguntasrapidas.objetos.cartas.CartaMemoria;
import com.example.preguntasrapidas.objetos.MesaMemoria;
import com.example.preguntasrapidas.objetos.Posicion;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Nivel1MemoriaActivity extends AppCompatActivity {

    private ImageButton primeraCard;
    private ImageButton segundaCard;
    private ImageButton terceraCard;
    private ImageButton cuartaCard;
    private ImageButton quintaCard;
    private ImageButton sextaCard;
    private ImageButton septimaCard;
    private ImageButton octavaCard;
    private TextView iniciarNivel1;
    private ArrayList<CartaMemoria> cartas = new ArrayList<>();
    private ArrayList<Posicion> posiciones = new ArrayList<>();
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

        mesa = new MesaMemoria(cartas, posiciones, scoreMemoria, intentos, 7, 1);

        preparar_mesa();

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                if (!cartas.get(0).cola){
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            iniciarNivel1.setText("Toca Para Empezar");
                            mesa.establecer_medidas_nivel();
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
                    if(!cartaMemoria.cola){
                        cola = true;
                        break;
                    }
                }
                if (cola){
                    mesa.barajar_cartas();
                    ((ViewGroup) v.getParent()).removeView(v);
                }
            }
        });
    }
    private void preparar_mesa(){

        cartas.add(new CartaMemoria(this,"card1", 1, primeraCard,
        0, 0.471f, 0.498f, mesa));
        cartas.add(new CartaMemoria(this,"card1", 1, segundaCard,
        0,0.471f, 0.498f, mesa));
        cartas.add(new CartaMemoria(this,"card2", 2, terceraCard,
        0,0.471f, 0.498f, mesa));
        cartas.add(new CartaMemoria(this,"card2", 2, cuartaCard,
        0,0.471f, 0.498f, mesa));
        cartas.add(new CartaMemoria(this,"card3", 3, quintaCard,
        0,0.471f, 0.498f, mesa));
        cartas.add(new CartaMemoria(this,"card3", 3, sextaCard,
        0,0.471f, 0.498f, mesa));
        cartas.add(new CartaMemoria(this,"card4", 4, septimaCard,
        0,0.471f, 0.498f, mesa));
        cartas.add(new CartaMemoria(this,"card4", 4, octavaCard,
        0,0.471f, 0.498f, mesa));

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