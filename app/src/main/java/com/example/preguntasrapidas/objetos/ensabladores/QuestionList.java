package com.example.preguntasrapidas.objetos.ensabladores;

import android.content.Context;
import android.graphics.Color;
import android.graphics.RenderEffect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.example.preguntasrapidas.TemaActivity;
import com.example.preguntasrapidas.objetos.basicos.FeedBack;
import com.example.preguntasrapidas.objetos.basicos.Result;
import com.example.preguntasrapidas.objetos.basicos.Score;
import com.example.preguntasrapidas.objetos.basicos.TimerQuestion;
import com.example.preguntasrapidas.objetos.clases_padre.Question;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class QuestionList implements Serializable {

    private final ArrayList<Question> questions = new ArrayList<>();
    private TextView actualQuestion;
    private TextView feedBackView;
    private TextView scoreView;

    private String response;
    private Button firstField;
    private Button secondField;
    private Button thirdField;
    private Button quarterField;
    private ImageView resourceView;

    private int count = 0;
    private boolean stateQuestion = false;
    private final TimerQuestion timer;
    private final Score score = new Score();
    private Result resultGame;

    private final FeedBack phrasesGood = new FeedBack();
    private final FeedBack phrasesBad = new FeedBack();
    private final FeedBack phrasesWait = new FeedBack();

    public final String COLOR_CORRECT = "#fabe25";
    public final String COLOR_INCORRECT = "#FB3452";
    public final String COLOR_DEFAULT = "#2dc2e3";

    public QuestionList(ArrayList<Question> questions, int cantQuestions, long time){
        timer = new TimerQuestion(time);
        Collections.shuffle(questions);
        for (int i = 0; i < cantQuestions; i++) {
            this.questions.add(questions.get(i));
        }
        phrasesGood.setPhrasesGood();
        phrasesBad.setPhrasesBad();
        phrasesWait.setPhrasesWait();
    }

    public void setOptionFields(Context context, TextView actualQuestion, TextView totalQuestions, TextView feedBackView, TextView scoreView,
                                Button firstField, Button secondField, Button thirdField, Button quarterField, ImageView resourceView,
                                QuestionList questionList, TextView timeView){

        timer.setQuestionList(questionList);
        timer.setTimeView(timeView);
        resultGame = new Result(context);
        this.actualQuestion = actualQuestion;
        this.feedBackView = feedBackView;
        this.scoreView = scoreView;
        totalQuestions.setText(String.valueOf(questions.size()));
        this.scoreView.setText(score.getScoreText());

        this.resourceView = resourceView;
        this.firstField = firstField;
        this.secondField = secondField;
        this.thirdField = thirdField;
        this.quarterField = quarterField;
        this.firstField.setOnClickListener(view -> {respondQuestion(firstField);});
        this.secondField.setOnClickListener(view -> {respondQuestion(secondField);});
        this.thirdField.setOnClickListener(view -> {respondQuestion(thirdField);});
        this.quarterField.setOnClickListener(view -> {respondQuestion(quarterField);});
        renderQuestion(count);
    }

    public void renderQuestion(int count) {
        if(count < questions.size()){
            timer.startTimer();
            setFeedbackViews(phrasesWait,COLOR_DEFAULT);
            firstField.setText(questions.get(count).getFirstOption());
            secondField.setText(questions.get(count).getSecondOption());
            thirdField.setText(questions.get(count).getThirdOption());
            quarterField.setText(questions.get(count).getQuarterOption());
            response = questions.get(count).getResponse();

            int resourceId = resourceView.getContext().getResources().getIdentifier(questions.get(count).getResource(), "drawable", resourceView.getContext().getPackageName());
            Drawable drawable = ContextCompat.getDrawable(resourceView.getContext(),resourceId);
            resourceView.setImageDrawable(drawable);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                resourceView.setRenderEffect(RenderEffect.createBlurEffect(50, 50, Shader.TileMode.MIRROR));
            }
            this.count++;
            actualQuestion.setText(String.valueOf(this.count));
        } else{
            sendResultActivity(resultGame.RESULT_COMPLETE,resultGame.COLOR_COMPLETE);
        }
        stateQuestion = false;
    }
    public void respondQuestion(Button responseOption){
        if(!stateQuestion){
            timer.cancelTimer();
            stateQuestion = true;
            String responseSelect = responseOption.getText().toString();
            if(responseSelect.equals(response)){
                setFeedbackViews(responseOption,phrasesGood,COLOR_CORRECT);
                score.sumScore(100);
                scoreView.setText(score.getScoreText());
            } else{
                setFeedbackViews(responseOption,phrasesBad,COLOR_INCORRECT);
            }
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    responseOption.setBackgroundColor(Color.parseColor(COLOR_DEFAULT));
                    renderQuestion(count);
                }
            },1200);
        }
    }
    public void setFeedbackViews(Button responseOption, FeedBack feedBack, String color){
        feedBackView.setTextColor(Color.parseColor(color));
        responseOption.setBackgroundColor(Color.parseColor(color));
        feedBackView.setText(feedBack.getRandomPhrase());
    }
    public void setFeedbackViews(FeedBack feedBack, String color){
        feedBackView.setTextColor(Color.parseColor(color));
        feedBackView.setText(feedBack.getRandomPhrase());
    }
    public void sendResultActivity(String stateGameResult, String colorStateGame){
        resultGame.chargeInfo(score.getScore(), stateGameResult, colorStateGame, TemaActivity.class);
        resultGame.saveResult();
        resultGame.goResult();
    }

    public int getCount() {
        return count;
    }
    public FeedBack getPhrasesBad() {
        return phrasesBad;
    }
    public void setStateQuestion(boolean stateQuestion) {
        this.stateQuestion = stateQuestion;
    }
}