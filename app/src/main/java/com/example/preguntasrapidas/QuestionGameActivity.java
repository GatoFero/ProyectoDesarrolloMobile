package com.example.preguntasrapidas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.preguntasrapidas.objetos.ensabladores.QuestionList;

public class QuestionGameActivity extends AppCompatActivity {

    private QuestionList questionList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_question_game);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.juegoppt), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        firstField = findViewById(R.id.firstField);
        secondField = findViewById(R.id.secondField);
        thirdField = findViewById(R.id.thirdField);
        quarterField = findViewById(R.id.quarterField);
        resource = findViewById(R.id.resource);
        actualQuestion = findViewById(R.id.actualQuestion);
        totalQuestion = findViewById(R.id.totalQuestions);
        scoreView = findViewById(R.id.scoreView);
        timeView = findViewById(R.id.timeView);
        feedBack = findViewById(R.id.feedBack);

        Bundle charge = getIntent().getExtras();
        questionList = (QuestionList) charge.getSerializable("questionsList");
        setQuestionsGame();
    }

    public Button firstField;
    public Button secondField;
    public Button thirdField;
    public Button quarterField;
    public ImageView resource;
    public TextView actualQuestion;
    public TextView totalQuestion;
    public TextView scoreView;
    public TextView timeView;
    public TextView feedBack;

    private void setQuestionsGame(){
        questionList.setOptionFields(this,actualQuestion,totalQuestion,feedBack,scoreView,firstField,secondField,thirdField,quarterField,resource,questionList,timeView);
    }
}