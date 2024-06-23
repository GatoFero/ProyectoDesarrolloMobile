package com.example.preguntasrapidas.objetos.cartas;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.transition.AutoTransition;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.widget.ImageView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

public class Carta {

    //Attributes
    protected String cardUp;
    protected String cardDown = "cover";
    protected boolean start;
    protected String stateCard = "no usable";
    protected float codeCard;
    protected ImageView container;

    //Elementos en juego o metodos
    protected float positionY;
    protected float positionX;
    protected boolean cola =  false;


    public Carta(){}
    public Carta(String cardUp, float codeCard, ImageView container, boolean start, float positionY, float positionX){
        this.cardUp = cardUp;
        this.codeCard = codeCard;
        this.container = container;
        this.positionY = positionY;
        this.positionX = positionX;

        if(start){
            changeImageResource(cardUp);
        } else{
            changeImageResource(cardDown);
        }

        introduceCard(positionY, positionX);
    }

    //Methods essentials
    protected void changeImageResource(String resource){

        int getImgResource = container.getResources().getIdentifier(resource, "drawable", container.getContext().getPackageName());
        container.setImageResource(getImgResource);
    }
    protected void updatePosition(float posY, float posX){
        positionY = posY;
        positionX = posX;
    }
    public void forceCola(boolean force){
        cola = force;
    }
    public boolean isCola() {
        return cola;
    }

    public void changeState(String newState){
        stateCard = newState;
    }
    public float getCodeCard() {
        return codeCard;
    }
    public float getPositionY() {
        return positionY;
    }
    public float getPositionX() {
        return positionX;
    }

    // Methods interactive
    public void revealOrHideCard(boolean view){

        if(stateCard.equals("usable")){
            ObjectAnimator animationGiro;
            if(view){
                animationGiro = ObjectAnimator.ofFloat(container, "rotationY", 0, 180);
                animationGiro.setDuration(700);
                animationGiro.addListener((new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        changeImageResource(cardUp);
                    }
                }));
            } else{
                animationGiro = ObjectAnimator.ofFloat(container, "rotationY", 180, 0);
                animationGiro.setDuration(700);
                animationGiro.addListener((new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        changeImageResource(cardDown);
                    }
                }));
            }
            animationGiro.start();
        }
    }
    public void moveCard(float posY, float posX) {

        if (!cola){
            cola = true;
            ConstraintLayout constraintLayout = (ConstraintLayout) container.getParent();
            ConstraintSet constraintSet = new ConstraintSet();
            constraintSet.clone(constraintLayout);

            constraintSet.setVerticalBias(container.getId(), posY);
            constraintSet.setHorizontalBias(container.getId(), posX);

            AutoTransition transition = new AutoTransition();
            transition.setDuration(800);
            transition.addListener(new Transition.TransitionListener(){

                @Override
                public void onTransitionStart(Transition transition) {}

                @Override
                public void onTransitionEnd(Transition transition) {
                    cola = false;
                    updatePosition(posY, posX);
                }

                @Override
                public void onTransitionCancel(Transition transition) {
                    cola = false;
                }

                @Override
                public void onTransitionPause(Transition transition) {}

                @Override
                public void onTransitionResume(Transition transition) {}
            });

            TransitionManager.beginDelayedTransition(constraintLayout, transition);
            constraintSet.applyTo(constraintLayout);
        }
        else{
            System.out.println("Espera crj");
        }
    }
    public void introduceCard(float posY, float posX) {

        if (!cola) {
            cola = true;
            ConstraintLayout.LayoutParams position = (ConstraintLayout.LayoutParams) container.getLayoutParams();
            ValueAnimator animation = ValueAnimator.ofFloat(0, 1);

            animation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    float valor = (float) animation.getAnimatedValue();
                    position.verticalBias = frame_mover(position.verticalBias, posY, valor);
                    position.horizontalBias = frame_mover(position.horizontalBias, posX, valor);

                    container.setLayoutParams(position);
                }
            });
            animation.setDuration(3500);

            animation.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {cola = false;
                }
            });
            animation.start();
            updatePosition(posY, posX);
        } else {
            System.out.println("Espera crj");
        }
    }
    private float frame_mover(float inicio, float fin, float fraccion) {
        return inicio + fraccion * (fin - inicio);
    }
}
