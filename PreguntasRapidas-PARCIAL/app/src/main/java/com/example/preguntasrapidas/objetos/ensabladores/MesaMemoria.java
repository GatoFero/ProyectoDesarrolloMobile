package com.example.preguntasrapidas.objetos.ensabladores;

import android.os.Handler;
import android.util.Log;
import android.widget.TextView;

import com.example.preguntasrapidas.objetos.util.Posicion;
import com.example.preguntasrapidas.objetos.Score;
import com.example.preguntasrapidas.objetos.cartas.CartaMemoria;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class MesaMemoria {

    //Objetos necesarios
    protected LinkedList<CartaMemoria> memoryCards;
    protected LinkedList<Posicion> positions;
    protected TextView intentsView;
    protected TextView scoreView;
    protected Score score = new Score(0);

    //Variables para los metodos de mesa
    protected int intents;
    protected int totalCouple;
    protected int counterGame = 1;
    protected int difficulty;

    //Variables para manejar cartas
    protected CartaMemoria firstOptionCard;
    protected CartaMemoria secondOptionCard;
    private float codeSelect;


    //Constructor
    public MesaMemoria(LinkedList<CartaMemoria> memoryCards, LinkedList<Posicion> positions, TextView intentsView, TextView scoreView, int intents, int difficulty) {
        this.memoryCards = memoryCards;
        this.positions = positions;
        this.intentsView = intentsView;
        this.scoreView = scoreView;
        this.intents = intents;
        this.difficulty = difficulty;
    }

    //Set Game
    public void setIntents(){
        totalCouple = memoryCards.size()/2;
        intentsView.setText(String.valueOf(intents));
    }
    public void startGame(){
        changeStateCards("usable");
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
        firstOptionCard.changeState("no usable");
    }
    public void secondOption(CartaMemoria cardPlay){

        float totalCode = (cardPlay.getCodeCard() + codeSelect)/2;
        int index = memoryCards.indexOf(cardPlay);
        secondOptionCard = memoryCards.get(index);
        secondOptionCard.revealOrHideCard(true);
        changeStateCards("no usable");

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
        changeStateCards("usable");
        score.sumarScore(50);
        scoreView.setText(String.valueOf(score.puntos));

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
    }
    private void incorrectCouple(){

        intents--;
        intentsView.setText(String.valueOf(intents));
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                firstOptionCard.changeState("usable");
                secondOptionCard.changeState("usable");
                firstOptionCard.revealOrHideCard(false);
                secondOptionCard.revealOrHideCard(false);
                changeStateCards("no usable");
                end();
            }
            public void end(){
                changeStateCards("usable");
            }
        },1000);
    }
}