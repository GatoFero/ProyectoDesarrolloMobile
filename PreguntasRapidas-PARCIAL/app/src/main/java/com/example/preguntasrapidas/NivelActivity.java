package com.example.preguntasrapidas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.preguntasrapidas.objetos.ensabladores.ListaPregunta;
import com.example.preguntasrapidas.objetos.clases_padre.Pregunta;

import java.util.ArrayList;

public class NivelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_nivel);

        ImageButton backtwoButton = findViewById(R.id.imbBacktwo);

        backtwoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NivelActivity.this, TemaActivity.class);
                startActivity(intent);
                finish();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.juegoppt), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    private int numeroPreguntas;
    private int tiempo;
    public void seleccionarDificultad(View v) {
        Button presionado = (Button) v;
        String dificultadSeleccionada = presionado.getText().toString().toLowerCase();

        switch (dificultadSeleccionada) {
            case "facil":
                numeroPreguntas = 10;
                tiempo = 7;
                break;
            case "medio":
                numeroPreguntas = 15;
                tiempo = 5;
                break;
            case "dificil":
                numeroPreguntas = 20;
                tiempo = 3;
                break;
            case "infierno":
                numeroPreguntas = 30;
                tiempo = 2;
                break;
        }
    }
    public void iniciarPartida(View v){
        if (numeroPreguntas > 0){
            Bundle bundle = getIntent().getExtras();
            ArrayList<Pregunta> preguntasListas = (ArrayList<Pregunta>) bundle.getSerializable("prepararPreguntas");
            ListaPregunta listaPartida = new ListaPregunta(preguntasListas, numeroPreguntas, tiempo);

            Intent intent = new Intent(this, PreguntasJuegoActivity.class);
            Bundle bundle1 = new Bundle();
            bundle1.putSerializable("preguntasEnJuego", listaPartida);
            intent.putExtras(bundle1);

            startActivity(intent);
        }
    }
}