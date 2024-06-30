package com.example.preguntasrapidas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class JuegosActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_juegos);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.juegoppt), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }

    public void iniciarPreguntasFoto(View v){
        Intent intent = new Intent(this, TemaActivity.class);
        startActivity(intent);
    }
    public void iniciarJuegoMemoria(View v){
        Intent intent = new Intent(this, NivelCartasMemoriaActivity.class);
        startActivity(intent);
    }

    public void iniciarJuegoPpt(View v){
        Intent intent = new Intent(this, JuegoPpt.class);
        startActivity(intent);
    }
}