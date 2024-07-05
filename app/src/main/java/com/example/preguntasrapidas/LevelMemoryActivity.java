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

public class LevelMemoryActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_nivel_cartas_memoria);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.nivelesMemory), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ImageButton backthreeButton = findViewById(R.id.imbBackthree);
        backthreeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LevelMemoryActivity.this, JuegosActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
    public void difficultyMemory(View v){
        int cantCards = 0;
        int cantIntents = 0;
        int rangeDifficulty = 0;
        int levelSelect = 0;

        int width = 100;
        int height = 125;
        Button buttonSelect = (Button) v;
        String level  = buttonSelect.getText().toString().toLowerCase();
        switch (level){
            case "nivel 1":
                cantCards = 6;
                levelSelect = 1;
                cantIntents = 6;
                rangeDifficulty = 1;
                break;
            case "nivel 2":
                cantCards = 8;
                levelSelect = 2;
                cantIntents = 5;
                rangeDifficulty = 1;
                break;
            case "nivel 3":
                cantCards = 12;
                levelSelect = 3;
                cantIntents = 7;
                rangeDifficulty = 1;
                break;
            case "nivel 4":
                cantCards = 16;
                levelSelect = 4;
                cantIntents = 8;
                rangeDifficulty = 2;
                width = 70;
                height = 88;
                break;
            case "nivel 5":
                cantCards = 20;
                levelSelect = 5;
                cantIntents = 10;
                rangeDifficulty = 2;
                width = 70;
                height = 88;
                break;
            case "nivel 6":
                cantCards = 24;
                levelSelect = 6;
                cantIntents = 12;
                rangeDifficulty = 2;
                width = 70;
                height = 88;
                break;
        }
        Bundle sendParameter = new Bundle();
        sendParameter.putInt("cantCards", cantCards);
        sendParameter.putInt("levelSelect", levelSelect);
        sendParameter.putInt("cantIntents", cantIntents);
        sendParameter.putInt("rangeDifficulty", rangeDifficulty);
        sendParameter.putInt("ancho", width);
        sendParameter.putInt("alto", height);

        Intent intent = new Intent(LevelMemoryActivity.this, MemoryGameActivity.class);
        intent.putExtras(sendParameter);
        startActivity(intent);
    }
}