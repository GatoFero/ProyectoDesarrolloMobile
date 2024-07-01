package com.example.preguntasrapidas.objetos.util;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.preguntasrapidas.ResultadoActivity;

import java.io.Serializable;

public class Resultado implements Serializable {
    private final transient Context context;
    private int score;
    private String gameResult;
    private String colorResult;
    private Class<?> returnLevel;
    private final transient Intent resultActivity;
    private final transient Bundle contInfo = new Bundle();

    public final transient String RESULT_COMPLETE = "Completado";
    public final transient String RESULT_INCOMPLETE = "Incompleto";
    public final transient String COLOR_COMPLETE = "#46DC1D";
    public final transient String COLOR_INCOMPLETE = "#FD4141";

    public Resultado(Context context){
        this.context = context;
        this.resultActivity = new Intent(context, ResultadoActivity.class);
    }
    public void chargeInfo(int score, String gameResult, String colorResult, Class<?> returnLevel){
        this.score = score;
        this.gameResult = gameResult;
        this.colorResult = colorResult;
        this.returnLevel = returnLevel;
    }
    public void goResult(){
        new Handler().postDelayed(() -> context.startActivity(resultActivity),1600);
    }
    public void saveResult(){
        contInfo.putSerializable("infoResult", this);
        resultActivity.putExtras(contInfo);
    }
    public int getScore() {
        return score;
    }
    public String getGameResult() {
        return gameResult;
    }
    public String getColorResult() {
        return colorResult;
    }
    public Class<?> getReturnLevel() {
        return returnLevel;
    }
}