package com.example.preguntasrapidas.objetos.basicos;

import com.example.preguntasrapidas.objetos.ensabladores.QuestionList;

import java.io.Serializable;

public class TimerQuestion extends Timer implements Serializable {

    private QuestionList questionList;

    public TimerQuestion(long time) {
        super(time);
    }
    public void setQuestionList(QuestionList questionList){
        this.questionList = questionList;
    }
    @Override
    public void finishTimerAction(){
        questionList.setFeedbackViews(questionList.getPhrasesBad(),questionList.COLOR_INCORRECT);
        questionList.setStateQuestion(true);
    }
    @Override
    public void timerReturn(){
        this.cancelTimer();
        questionList.renderQuestion(questionList.getCount());
    }
}
