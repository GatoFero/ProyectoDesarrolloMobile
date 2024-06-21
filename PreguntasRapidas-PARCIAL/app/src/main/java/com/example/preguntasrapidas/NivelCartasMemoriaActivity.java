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

public class NivelCartasMemoriaActivity extends AppCompatActivity {

    private Button nivel1;
    private Button nivel2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_nivel_cartas_memoria);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.juegoppt), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        nivel1 = findViewById(R.id.btnNivel1);
        nivel2 = findViewById(R.id.btnNivel2);

        nivel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NivelCartasMemoriaActivity.this, Nivel1MemoriaActivity.class);
                startActivity(intent);
            }
        });
        nivel2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NivelCartasMemoriaActivity.this, Nivel2MemoriaActivity.class);
                startActivity(intent);
            }
        });


        ImageButton backthreeButton = findViewById(R.id.imbBackthree);

        backthreeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NivelCartasMemoriaActivity.this, JuegosActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}