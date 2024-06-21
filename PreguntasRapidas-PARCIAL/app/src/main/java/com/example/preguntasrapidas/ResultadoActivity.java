package com.example.preguntasrapidas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import  com.example.preguntasrapidas.objetos.Score;




public class ResultadoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        Score score = (Score) getIntent().getSerializableExtra("score");
        int tiempoRestante = getIntent().getIntExtra("tiempoRestante", 0);

        TextView scoreView = findViewById(R.id.txvPuntaje);
        Button reiniciarButton = findViewById(R.id.btnReiniciar);
        Button gameButton = findViewById(R.id.btnJuego);
        Button themeButton = findViewById(R.id.btnCategoria);

        // Configurar los textos
        if (score != null) {
            scoreView.setText("Puntuación: " + score.getPuntos());
        } else {
            scoreView.setText("Puntuación: 0");
        }



        gameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResultadoActivity.this, JuegosActivity.class);
                startActivity(intent);
                finish();
            }
        });

        themeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResultadoActivity.this, TemaActivity.class);
                startActivity(intent);
                finish();
            }
        });

        reiniciarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResultadoActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.juegoppt), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return WindowInsetsCompat.CONSUMED;
        });
    }
}
