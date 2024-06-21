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

public class Nivel2MemoriaActivity extends AppCompatActivity {

    private ImageButton card1;
    private ImageButton card2;
    private ImageButton card3;
    private ImageButton card4;
    private ImageButton card5;
    private ImageButton card6;
    private ImageButton card7;
    private ImageButton card8;
    private ImageButton card9;
    private ImageButton card10;
    private ImageButton card11;
    private ImageButton card12;
    private ImageButton card13;
    private ImageButton card14;
    private ImageButton card15;
    private ImageButton card16;
    private TextView iniciarNivel2;
    private ArrayList<Posicion> posiciones = new ArrayList<>();
    private ArrayList<CartaMemoria> cartas = new ArrayList<>();
    private TextView intentos2;
    private TextView scoreMemoria2;
    private MesaMemoria mesa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_nivel2_memoria);

        ImageButton backsixButton = findViewById(R.id.imbBacksix);

        backsixButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Nivel2MemoriaActivity.this, NivelCartasMemoriaActivity.class);
                startActivity(intent);
                finish();
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.juegoppt), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        card1 = findViewById(R.id.card1);
        card2 = findViewById(R.id.card2);
        card3 = findViewById(R.id.card3);
        card4 = findViewById(R.id.card4);
        card5 = findViewById(R.id.card5);
        card6 = findViewById(R.id.card6);
        card7 = findViewById(R.id.card7);
        card8 = findViewById(R.id.card8);
        card9 = findViewById(R.id.card9);
        card10 = findViewById(R.id.card10);
        card11 = findViewById(R.id.card11);
        card12 = findViewById(R.id.card12);
        card13 = findViewById(R.id.card13);
        card14 = findViewById(R.id.card14);
        card15 = findViewById(R.id.card15);
        card16 = findViewById(R.id.card16);
        iniciarNivel2 = findViewById(R.id.iniciarNivel2);
        intentos2 = findViewById(R.id.intentos2);
        scoreMemoria2 = findViewById(R.id.scoreMemoria2);

        mesa = new MesaMemoria(cartas,posiciones,scoreMemoria2,intentos2,5,2);
        preparar_mesa();

        new Timer().schedule(new TimerTask() {
            @Override
            public void run(){
                if(!cartas.get(0).cola){
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            iniciarNivel2.setText("Toca Para Empezar");
                            mesa.establecer_medidas_nivel();
                        }
                    });
                    cancel();
                }
            }
        },0,1000);

        iniciarNivel2.setOnClickListener(new View.OnClickListener() {
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

    public void preparar_mesa(){

        cartas.add(new CartaMemoria(this,"card1", 1, card1, 0,0.471f, 0.498f, mesa));
        cartas.add(new CartaMemoria(this,"card1", 1, card2, 0,0.471f, 0.498f, mesa));
        cartas.add(new CartaMemoria(this,"card2", 2, card3, 0,0.471f, 0.498f, mesa));
        cartas.add(new CartaMemoria(this,"card2", 2, card4, 0,0.471f, 0.498f, mesa));
        cartas.add(new CartaMemoria(this,"card3", 3, card5, 0,0.471f, 0.498f, mesa));
        cartas.add(new CartaMemoria(this,"card3", 3, card6, 0,0.471f, 0.498f, mesa));
        cartas.add(new CartaMemoria(this,"card4", 4, card7, 0,0.471f, 0.498f, mesa));
        cartas.add(new CartaMemoria(this,"card4", 4, card8, 0,0.471f, 0.498f, mesa));
        cartas.add(new CartaMemoria(this,"card5", 5, card9, 0,0.471f, 0.498f, mesa));
        cartas.add(new CartaMemoria(this,"card5", 5, card10, 0,0.471f, 0.498f, mesa));
        cartas.add(new CartaMemoria(this,"card6", 6, card11, 0,0.471f, 0.498f, mesa));
        cartas.add(new CartaMemoria(this,"card6", 6, card12, 0,0.471f, 0.498f, mesa));
        cartas.add(new CartaMemoria(this,"card7", 7, card13, 0,0.471f, 0.498f, mesa));
        cartas.add(new CartaMemoria(this,"card7", 7, card14, 0,0.471f, 0.498f, mesa));
        cartas.add(new CartaMemoria(this,"card8", 8, card15, 0,0.471f, 0.498f, mesa));
        cartas.add(new CartaMemoria(this,"card8", 8, card16, 0,0.471f, 0.498f, mesa));

        posiciones.add(new Posicion(0.21f, 0.075f));
        posiciones.add(new Posicion(0.21f, 0.356f));
        posiciones.add(new Posicion(0.21f, 0.637f));
        posiciones.add(new Posicion(0.21f, 0.918f));

        posiciones.add((new Posicion(0.407f, 0.075f)));
        posiciones.add(new Posicion(0.407f, 0.356f));
        posiciones.add(new Posicion(0.407f, 0.637f));
        posiciones.add(new Posicion(0.407f, 0.918f));

        posiciones.add((new Posicion(0.6f, 0.075f)));
        posiciones.add(new Posicion(0.6f, 0.356f));
        posiciones.add(new Posicion(0.6f, 0.637f));
        posiciones.add(new Posicion(0.6f, 0.918f));

        posiciones.add((new Posicion(0.795f, 0.075f)));
        posiciones.add(new Posicion(0.795f, 0.356f));
        posiciones.add(new Posicion(0.795f, 0.637f));
        posiciones.add(new Posicion(0.795f, 0.918f));
    }
}