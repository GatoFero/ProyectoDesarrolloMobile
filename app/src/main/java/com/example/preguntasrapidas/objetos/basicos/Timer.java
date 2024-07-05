package com.example.preguntasrapidas.objetos.basicos;

import android.os.CountDownTimer;
import android.os.Handler;
import android.widget.TextView;

import java.io.Serializable;

public class Timer implements Serializable {

    protected final long time;
    protected long timeCopy;
    protected CountDownTimer timerRecoil;
    protected TextView timeView;

    public Timer(long time) {
        this.time = time;
        this.timeCopy = time;
    }

    public void setTimeView(TextView timeView){
       this.timeView = timeView;
    }
    public void startTimer(){
        timerRecoil = new CountDownTimer(time,1000) {
            @Override
            public void onTick(long l) {
                timeCopy = l;
                updateTimeView();
            }

            @Override
            public void onFinish() {
                timeView.setText("0");
                finishTimerAction();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        timerReturn();
                    }
                },1200);

            }
        }.start();
    }
    protected void updateTimeView(){
        int timeUpdate = (int) (timeCopy/1000);
        timeView.setText(String.valueOf(timeUpdate));
    }
    protected void finishTimerAction(){}
    protected void timerReturn(){

    }
    public void cancelTimer(){
        timeCopy = time;
        timerRecoil.cancel();
    }
}