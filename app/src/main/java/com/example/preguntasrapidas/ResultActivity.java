package com.example.preguntasrapidas;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.preguntasrapidas.objetos.basicos.Result;


public class ResultActivity extends AppCompatActivity {

    private Result result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        Bundle getResult = getIntent().getExtras();
        result = (Result) getResult.getSerializable("infoResult");

        TextView scoreView = findViewById(R.id.puntos);
        scoreView.setText(String.valueOf(result.getScore()));

        TextView resultView = findViewById(R.id.resultadoGame);
        resultView.setText(result.getGameResult());
        resultView.setTextColor(Color.parseColor(result.getColorResult()));

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
                transferActivity = new Intent(ResultActivity.this,result.getReturnLevel());
                break;
            case "juegos":
                transferActivity = new Intent(ResultActivity.this,JuegosActivity.class);
                break;
            case "inicio":
                transferActivity = new Intent(ResultActivity.this,MainActivity.class);
                break;
        }
        startActivity(transferActivity);
    }
}