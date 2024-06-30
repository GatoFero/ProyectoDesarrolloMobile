package com.example.preguntasrapidas;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.example.preguntasrapidas.objetos.util.Score;




public class ResultadoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        Bundle getResult = getIntent().getExtras();
        int getScore = getResult.getInt("score");
        TextView score = findViewById(R.id.puntos);
        score.setText(String.valueOf(getScore));


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.juegoppt), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return WindowInsetsCompat.CONSUMED;
        });
    }

    public void translator(View v){
        Button translateActivity = (Button) v;
        String translateActivitySelect = translateActivity.getText().toString().toLowerCase();
        Intent transferActivity = new Intent();
        switch (translateActivitySelect){
            case "nivel":
                transferActivity = new Intent(ResultadoActivity.this,NivelCartasMemoriaActivity.class);
                break;
            case "juegos":
                transferActivity = new Intent(ResultadoActivity.this,JuegosActivity.class);
                break;
            case "inicio":
                transferActivity = new Intent(ResultadoActivity.this,MainActivity.class);
                break;
        }
        startActivity(transferActivity);
    }
}
