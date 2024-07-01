package com.example.preguntasrapidas.objetos.ensabladores;

import android.content.Context;
import android.os.Handler;
import android.widget.TextView;

import com.example.preguntasrapidas.NivelCartasMemoriaActivity;
import com.example.preguntasrapidas.objetos.clases_padre.Carta;
import com.example.preguntasrapidas.objetos.util.Posicion;
import com.example.preguntasrapidas.objetos.util.Resultado;
import com.example.preguntasrapidas.objetos.util.Score;
import com.example.preguntasrapidas.objetos.cartas.CartaMemoria;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class MesaMemoria {

    //Objetos necesarios
    protected List<CartaMemoria> memoryCards;
    protected List<Posicion> positions;
    protected TextView intentsView;
    protected TextView scoreView;
    protected Score score = new Score(0);

    //Variables para los metodos de mesa
    protected int intents;
    protected int totalCouple;
    protected int counterGame = 1;
    protected int difficulty;
    private final Resultado resultGame;

    //Variables para manejar cartas
    protected CartaMemoria firstOptionCard;
    protected CartaMemoria secondOptionCard;
    private float codeSelect;


    //Constructor
    public MesaMemoria(Context context, LinkedList<CartaMemoria> memoryCards, LinkedList<Posicion> positions, TextView intentsView, TextView scoreView, int intents, int difficulty) {
        this.memoryCards = memoryCards;
        this.positions = positions;
        this.intentsView = intentsView;
        this.scoreView = scoreView;
        this.intents = intents;
        this.difficulty = difficulty;
        resultGame = new Resultado(context);
    }

    //Set Game
    public void setIntents(){
        totalCouple = memoryCards.size()/2;
        intentsView.setText(String.valueOf(intents));
    }
    public void startGame(){
        changeStateCards(Carta.STATE_USABLE);
        shuffleCards();
    }
    public void shuffleCards(){
        Collections.shuffle(positions);
        for (int i = 0; i < positions.size(); i++) {
            memoryCards.get(i).moveCard(positions.get(i).posicionY, positions.get(i).posicionX);
        }
    }
    private void changeStateCards(String newState){
        for(CartaMemoria card : memoryCards){
            card.changeState(newState);
        }
    }
    private void removeCard(CartaMemoria cardRemove) {

        LinkedList<CartaMemoria> newCards = new LinkedList<>();
        LinkedList<Posicion> newPositions = new LinkedList<>();

        for (CartaMemoria card : memoryCards) {
            if (!card.equals(cardRemove)) {
                newCards.add(card);
            }
        }

        for (Posicion position : positions) {
            if ((position.posicionY == cardRemove.positionY) && (position.posicionX == cardRemove.positionX)) {
                System.out.println("Se removio");
            } else{
                newPositions.add(position);
            }
        }

        positions.clear();
        positions.addAll(newPositions);
        memoryCards.clear();
        memoryCards.addAll(newCards);
    }

    //Comparative Manager
    public void makeMovement(CartaMemoria cardPlay){
        if(intents != 0){
            switch (counterGame) {
                case 1:
                    firstOption(cardPlay);
                    counterGame++;
                    break;
                case 2:
                    secondOption(cardPlay);
                    counterGame--;
                    break;
            }
        }
    }
    public void firstOption(CartaMemoria cardPlay){

        codeSelect = cardPlay.getCodeCard();
        int index = memoryCards.indexOf(cardPlay);
        firstOptionCard = memoryCards.get(index);
        firstOptionCard.revealOrHideCard(true);
        firstOptionCard.changeState(Carta.STATE_NO_USABLE);
    }
    public void secondOption(CartaMemoria cardPlay){

        float totalCode = (cardPlay.getCodeCard() + codeSelect)/2;
        int index = memoryCards.indexOf(cardPlay);
        secondOptionCard = memoryCards.get(index);
        secondOptionCard.revealOrHideCard(true);
        changeStateCards(Carta.STATE_NO_USABLE);

        if (totalCode == codeSelect) {
            correctCouple();
        } else {
            incorrectCouple();
        }
    }

    //Comparative
    private void correctCouple(){

        removeCard(firstOptionCard);
        removeCard(secondOptionCard);
        changeStateCards(Carta.STATE_USABLE);
        score.sumScore(50);
        scoreView.setText(String.valueOf(score.getScore()));

        if (totalCouple > 1){
            totalCouple--;
            if (difficulty > 1 && totalCouple != 1){
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        for(CartaMemoria card : memoryCards){
                            card.forceCola(false);
                        }
                        shuffleCards();
                    }
                },700);
            }
        }
        else{
            sendResultActivity(resultGame.RESULT_COMPLETE,resultGame.COLOR_COMPLETE);
        }
    }
    private void incorrectCouple(){

        intents--;
        intentsView.setText(String.valueOf(intents));
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                firstOptionCard.changeState(Carta.STATE_USABLE);
                secondOptionCard.changeState(Carta.STATE_USABLE);
                firstOptionCard.revealOrHideCard(false);
                secondOptionCard.revealOrHideCard(false);
                changeStateCards(Carta.STATE_NO_USABLE);
                end();
            }
            public void end(){
                changeStateCards(Carta.STATE_USABLE);
            }
        },1000);
        if(intents == 0){
            sendResultActivity(resultGame.RESULT_INCOMPLETE, resultGame.COLOR_INCOMPLETE);
        }
    }
    private void sendResultActivity(String stateGameResult, String colorStateGame){
        resultGame.chargeInfo(score.getScore(),stateGameResult,colorStateGame, NivelCartasMemoriaActivity.class);
        resultGame.saveResult();
        resultGame.goResult();
    }
}