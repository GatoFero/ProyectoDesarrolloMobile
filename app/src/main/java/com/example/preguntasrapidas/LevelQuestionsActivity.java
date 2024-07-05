package com.example.preguntasrapidas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.preguntasrapidas.objetos.ensabladores.QuestionList;
import com.example.preguntasrapidas.objetos.clases_padre.Question;

import java.util.ArrayList;

public class LevelQuestionsActivity extends AppCompatActivity {

    private  ArrayList<Question> questions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_level_questions);

        Bundle bundle = getIntent().getExtras();
        questions = (ArrayList<Question>) bundle.getSerializable("questionsSelect");

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.levelQuestionsList), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void selectDifficulty(View v) {
        Button difficultySelect = (Button) v;
        String difficulty = difficultySelect.getText().toString().toLowerCase();
        int cantQuestions = 0;
        long time = 0;
        switch (difficulty) {
            case "facil":
                cantQuestions = 10;
                time = 11000L;
                break;
            case "medio":
                cantQuestions = 15;
                time = 8000L;
                break;
            case "dificil":
                cantQuestions = 20;
                time = 6000L;
                break;
            case "infierno":
                cantQuestions = 30;
                time = 4000L;
                break;
        }
        assembleListQuestions(cantQuestions,time);
    }
    public void assembleListQuestions(int cantQuestions, long time){
            QuestionList questionsList = new QuestionList(questions, cantQuestions,time);
            Intent intent = new Intent(this, QuestionGameActivity.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("questionsList", questionsList);
            intent.putExtras(bundle);
            startActivity(intent);
    }
}