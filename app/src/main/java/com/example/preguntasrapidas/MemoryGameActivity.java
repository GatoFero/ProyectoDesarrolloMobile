package com.example.preguntasrapidas;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.preguntasrapidas.objetos.cartas.CardMemory;
import com.example.preguntasrapidas.objetos.ensabladores.MemoryTable;
import com.example.preguntasrapidas.objetos.basicos.Position;

import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MemoryGameActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_partida_memoria);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.partidaMemoria), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Bundle parameters = getIntent().getExtras();
        cantCards = parameters.getInt("cantCards");
        levelSelect = parameters.getInt("levelSelect");
        cantIntents = parameters.getInt("cantIntents");
        difficulty = parameters.getInt("rangeDifficulty");
        width = parameters.getInt("ancho");
        height = parameters.getInt("alto");

        container = findViewById(R.id.partidaMemoria);
        intents = findViewById(R.id.intentos);
        scoreMemory = findViewById(R.id.scoreMemoria);
        startLevel = findViewById(R.id.iniciarNivel1);

        setMesaGame();

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                if (!cards.get(0).isCola()){
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mesa.setIntents();
                            startLevel.setText("Toca Para Empezar");
                        }
                    });
                    cancel();
                }
            }
        }, 0, 1000);

        startLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean cola = false;

                for(CardMemory cartaMemoria : cards){
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

    private TextView startLevel;
    private TextView intents;
    private TextView scoreMemory;
    private ConstraintLayout container;

    private int cantCards;
    private int levelSelect;
    private int cantIntents;
    private int difficulty;
    private int width;
    private int height;
    private LinkedList<CardMemory> cards;
    private LinkedList<Position> positionsMesa;
    private MemoryTable mesa;
    private void setMesaGame(){
        positionsMesa = setPositionsMesa(levelSelect);
        cards = setCardsMesa(cantCards,width,height);
        mesa = new MemoryTable(this,cards,positionsMesa,intents,scoreMemory,cantIntents,difficulty);
        for(CardMemory card : cards){
            card.setMesaGame(mesa);
        }
    }
    private LinkedList<CardMemory> setCardsMesa(int cantCardsMemory, int width, int height){
        List<Position> initialPositions = positionsMesa;
        LinkedList<CardMemory> cards = new LinkedList<>();
        int controller = initialPositions.size()-1;
        for(int i = 0; i < cantCardsMemory/2; i++){
            cards.add(new CardMemory(this,container,"card"+(i+1),i+1,
                    false,width, height,
                    initialPositions.get(i).getPositionY(), initialPositions.get(i).getPositionX(),0.471f,0.498f));
            cards.add(new CardMemory(this,container,"card"+(i+1),i+1,
                    false,width, height,
                    initialPositions.get((controller-i)).getPositionY(),initialPositions.get((controller-i)).getPositionX(),0.471f,0.498f));
        }
        return cards;
    }
    private LinkedList<Position> setPositionsMesa(int levelSelect){
        LinkedList<Position> positionsMesa = new LinkedList<>();
        switch (levelSelect){
            case 1:
                setFirstMesa(positionsMesa);
                break;
            case 2:
                setSecondMesa(positionsMesa);
                break;
            case 3:
                setThirdMesa(positionsMesa);
                break;
            case 4:
                setQuarterMesa(positionsMesa);
                break;
            case 5:
                setFifthMesa(positionsMesa);
                break;
            case 6:
                setSixthMesa(positionsMesa);
                break;
        }
        return positionsMesa;
    }
    private void setFirstMesa(List<Position> positionsMesa){
        positionsMesa.add(new Position(0.272f,0.311f));
        positionsMesa.add(new Position(0.272f,0.707f));
        positionsMesa.add(new Position(0.485f,0.311f));
        positionsMesa.add(new Position(0.485f,0.707f));
        positionsMesa.add(new Position(0.698f,0.311f));
        positionsMesa.add(new Position(0.698f,0.707f));
    }
    private void setSecondMesa(List<Position> positionsMesa){
        positionsMesa.add(new Position(0.272f,0.122f));
        positionsMesa.add(new Position(0.272f,0.501f));
        positionsMesa.add(new Position(0.272f,0.881f));
        positionsMesa.add(new Position(0.485f,0.122f));
        positionsMesa.add(new Position(0.485f,0.501f));
        positionsMesa.add(new Position(0.485f,0.881f));
        positionsMesa.add(new Position(0.698f,0.308f));
        positionsMesa.add(new Position(0.698f,0.704f));
    }
    private void setThirdMesa(List<Position> positionsMesa){
        positionsMesa.add(new Position(0.165f,0.125f));
        positionsMesa.add(new Position(0.165f,0.504f));
        positionsMesa.add(new Position(0.165f,0.884f));

        positionsMesa.add(new Position(0.378f,0.125f));
        positionsMesa.add(new Position(0.378f,0.504f));
        positionsMesa.add(new Position(0.378f,0.884f));

        positionsMesa.add(new Position(0.591f,0.125f));
        positionsMesa.add(new Position(0.591f,0.504f));
        positionsMesa.add(new Position(0.591f,0.884f));

        positionsMesa.add(new Position(0.804f,0.125f));
        positionsMesa.add(new Position(0.804f,0.504f));
        positionsMesa.add(new Position(0.804f,0.884f));
    }
    private void setQuarterMesa(List<Position> positionsMesa){
        positionsMesa.add(new Position(0.28f,0.123f));
        positionsMesa.add(new Position(0.28f,0.378f));
        positionsMesa.add(new Position(0.28f,0.624f));
        positionsMesa.add(new Position(0.28f,0.879f));

        positionsMesa.add(new Position(0.446f,0.123f));
        positionsMesa.add(new Position(0.446f,0.378f));
        positionsMesa.add(new Position(0.446f,0.624f));
        positionsMesa.add(new Position(0.446f,0.879f));

        positionsMesa.add(new Position(0.609f,0.123f));
        positionsMesa.add(new Position(0.609f,0.378f));
        positionsMesa.add(new Position(0.609f,0.624f));
        positionsMesa.add(new Position(0.609f,0.879f));

        positionsMesa.add(new Position(0.776f,0.123f));
        positionsMesa.add(new Position(0.776f,0.378f));
        positionsMesa.add(new Position(0.776f,0.624f));
        positionsMesa.add(new Position(0.776f,0.879f));
    }
    private void setFifthMesa(List<Position> positionsMesa){
        positionsMesa.add(new Position(0.12f,0.123f));
        positionsMesa.add(new Position(0.12f,0.879f));

        positionsMesa.add(new Position(0.28f,0.123f));
        positionsMesa.add(new Position(0.28f,0.378f));
        positionsMesa.add(new Position(0.28f,0.624f));
        positionsMesa.add(new Position(0.28f,0.879f));

        positionsMesa.add(new Position(0.446f,0.123f));
        positionsMesa.add(new Position(0.446f,0.378f));
        positionsMesa.add(new Position(0.446f,0.624f));
        positionsMesa.add(new Position(0.446f,0.879f));

        positionsMesa.add(new Position(0.609f,0.123f));
        positionsMesa.add(new Position(0.609f,0.378f));
        positionsMesa.add(new Position(0.609f,0.624f));
        positionsMesa.add(new Position(0.609f,0.879f));

        positionsMesa.add(new Position(0.776f,0.123f));
        positionsMesa.add(new Position(0.776f,0.378f));
        positionsMesa.add(new Position(0.776f,0.624f));
        positionsMesa.add(new Position(0.776f,0.879f));

        positionsMesa.add(new Position(0.937f,0.123f));
        positionsMesa.add(new Position(0.937f,0.879f));
    }
    private void setSixthMesa(List<Position> positionsMesa){
        positionsMesa.add(new Position(0.12f,0.123f));
        positionsMesa.add(new Position(0.12f,0.378f));
        positionsMesa.add(new Position(0.12f,0.624f));
        positionsMesa.add(new Position(0.12f,0.879f));

        positionsMesa.add(new Position(0.28f,0.123f));
        positionsMesa.add(new Position(0.28f,0.378f));
        positionsMesa.add(new Position(0.28f,0.624f));
        positionsMesa.add(new Position(0.28f,0.879f));

        positionsMesa.add(new Position(0.446f,0.123f));
        positionsMesa.add(new Position(0.446f,0.378f));
        positionsMesa.add(new Position(0.446f,0.624f));
        positionsMesa.add(new Position(0.446f,0.879f));

        positionsMesa.add(new Position(0.609f,0.123f));
        positionsMesa.add(new Position(0.609f,0.378f));
        positionsMesa.add(new Position(0.609f,0.624f));
        positionsMesa.add(new Position(0.609f,0.879f));

        positionsMesa.add(new Position(0.776f,0.123f));
        positionsMesa.add(new Position(0.776f,0.378f));
        positionsMesa.add(new Position(0.776f,0.624f));
        positionsMesa.add(new Position(0.776f,0.879f));

        positionsMesa.add(new Position(0.937f,0.123f));
        positionsMesa.add(new Position(0.937f,0.378f));
        positionsMesa.add(new Position(0.937f,0.624f));
        positionsMesa.add(new Position(0.937f,0.879f));
    }
}