package com.example.preguntasrapidas.objetos.ensabladores;

import android.content.Context;
import android.os.Handler;
import android.widget.TextView;

import com.example.preguntasrapidas.LevelMemoryActivity;
import com.example.preguntasrapidas.objetos.clases_padre.Card;
import com.example.preguntasrapidas.objetos.basicos.Position;
import com.example.preguntasrapidas.objetos.basicos.Result;
import com.example.preguntasrapidas.objetos.basicos.Score;
import com.example.preguntasrapidas.objetos.cartas.CardMemory;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class MemoryTable {

    //Objetos necesarios
    protected List<CardMemory> memoryCards;
    protected List<Position> positions;
    protected TextView intentsView;
    protected TextView scoreView;
    protected Score score = new Score();

    //Variables para los metodos de mesa
    protected int intents;
    protected int totalCouple;
    protected int counterGame = 1;
    protected int difficulty;
    private final Result resultGame;

    //Variables para manejar cartas
    protected CardMemory firstOptionCard;
    protected CardMemory secondOptionCard;
    private float codeSelect;


    //Constructor
    public MemoryTable(Context context, LinkedList<CardMemory> memoryCards, LinkedList<Position> positions, TextView intentsView, TextView scoreView, int intents, int difficulty) {
        this.memoryCards = memoryCards;
        this.positions = positions;
        this.intentsView = intentsView;
        this.scoreView = scoreView;
        this.intents = intents;
        this.difficulty = difficulty;
        resultGame = new Result(context);
    }

    //Set Game
    public void setIntents(){
        totalCouple = memoryCards.size()/2;
        intentsView.setText(String.valueOf(intents));
    }
    public void startGame(){
        changeStateCards(Card.STATE_USABLE);
        shuffleCards();
    }
    public void shuffleCards(){
        Collections.shuffle(positions);
        for (int i = 0; i < positions.size(); i++) {
            memoryCards.get(i).moveCard(positions.get(i).getPositionY(), positions.get(i).getPositionX());
        }
    }
    private void changeStateCards(String newState){
        for(CardMemory card : memoryCards){
            card.changeState(newState);
        }
    }
    private void removeCard(CardMemory cardRemove) {

        LinkedList<CardMemory> newCards = new LinkedList<>();
        LinkedList<Position> newPositions = new LinkedList<>();

        for (CardMemory card : memoryCards) {
            if (!card.equals(cardRemove)) {
                newCards.add(card);
            }
        }

        for (Position position : positions) {
            if ((position.getPositionY() == cardRemove.positionY) && (position.getPositionX() == cardRemove.positionX)) {
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
    public void makeMovement(CardMemory cardPlay){
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
    public void firstOption(CardMemory cardPlay){

        codeSelect = cardPlay.getCodeCard();
        int index = memoryCards.indexOf(cardPlay);
        firstOptionCard = memoryCards.get(index);
        firstOptionCard.revealOrHideCard(true);
        firstOptionCard.changeState(Card.STATE_NO_USABLE);
    }
    public void secondOption(CardMemory cardPlay){

        float totalCode = (cardPlay.getCodeCard() + codeSelect)/2;
        int index = memoryCards.indexOf(cardPlay);
        secondOptionCard = memoryCards.get(index);
        secondOptionCard.revealOrHideCard(true);
        changeStateCards(Card.STATE_NO_USABLE);

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
        changeStateCards(Card.STATE_USABLE);
        score.sumScore(50);
        scoreView.setText(String.valueOf(score.getScore()));

        if (totalCouple > 1){
            totalCouple--;
            if (difficulty > 1 && totalCouple != 1){
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        for(CardMemory card : memoryCards){
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
                firstOptionCard.changeState(Card.STATE_USABLE);
                secondOptionCard.changeState(Card.STATE_USABLE);
                firstOptionCard.revealOrHideCard(false);
                secondOptionCard.revealOrHideCard(false);
                changeStateCards(Card.STATE_NO_USABLE);
                end();
            }
            public void end(){
                changeStateCards(Card.STATE_USABLE);
            }
        },1000);
        if(intents == 0){
            sendResultActivity(resultGame.RESULT_INCOMPLETE, resultGame.COLOR_INCOMPLETE);
        }
    }
    private void sendResultActivity(String stateGameResult, String colorStateGame){
        resultGame.chargeInfo(score.getScore(), stateGameResult, colorStateGame, LevelMemoryActivity.class);
        resultGame.saveResult();
        resultGame.goResult();
    }
}