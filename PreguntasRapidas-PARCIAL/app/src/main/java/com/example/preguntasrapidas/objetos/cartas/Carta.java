package com.example.preguntasrapidas.objetos.cartas;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.transition.AutoTransition;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.widget.ImageButton;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

public class Carta {
    //Principales atributos
    private String cartaArriba;
    private String cartaAbajo = "cover";
    private int iniciacion;
    protected String estadoCarta = "no usable";
    public int codigoCarta;
    protected ImageButton boton;

    //Elementos en juego o metodos
    public float posicionY;
    public float posicionX;
    public boolean cola =  false;


    public Carta(Context context, String cartaArriba, int codigoCarta, ImageButton boton, int iniciacion, float posicionY, float posicionX){
        this.cartaArriba = cartaArriba;
        this.codigoCarta = codigoCarta;
        this.boton = boton;
        this.posicionY = posicionY;
        this.posicionX = posicionX;
        this.iniciacion = iniciacion;

        if(iniciacion == 0){
            int setCover = context.getResources().getIdentifier(cartaAbajo, "drawable", context.getPackageName());
            boton.setBackgroundResource(setCover);
        } else if(iniciacion == 1){
            int setCover = context.getResources().getIdentifier(cartaArriba, "drawable", context.getPackageName());
            boton.setBackgroundResource(setCover);
        }

        if(posicionX != 0 && posicionY != 0){
            presentar_carta(posicionY, posicionX);
        }
    }

    //Estados de carta
    public void cambiar_estado_usabilidad(String usabilidad){
        estadoCarta = usabilidad;
    }
    public String estado(){
        return estadoCarta;
    }

    //Metodos de Juego
    public void revelar_carta() {
        if (estadoCarta.equals("usable")){
            ObjectAnimator animacionGiro = ObjectAnimator.ofFloat(boton, "rotationY", 0, 180);
            animacionGiro.setDuration(700);

            animacionGiro.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    int setCarta = boton.getResources().getIdentifier(cartaArriba, "drawable", boton.getContext().getPackageName());
                    boton.setBackgroundResource(setCarta);
                }
            });
            animacionGiro.start();
        }
    }
    public void ocultar_carta(){
        if (estadoCarta.equals("usable")){
            ObjectAnimator animacionGiro = ObjectAnimator.ofFloat(boton, "rotationY", 180, 0);
            animacionGiro.setDuration(700);

            animacionGiro.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    int setCarta = boton.getResources().getIdentifier(cartaAbajo, "drawable", boton.getContext().getPackageName());
                    boton.setBackgroundResource(setCarta);
                }
            });
            animacionGiro.start();
        }
    }

    //Mover cards
    public void forzar_cola(boolean cambiarCola){
        cola = cambiarCola;
    }
    public void presentar_carta(float posY, float posX) {

        if (cola) {
            System.out.println("Espera crj");
        } else {
            cola = true;
            ConstraintLayout.LayoutParams posicicion = (ConstraintLayout.LayoutParams) boton.getLayoutParams();
            ValueAnimator animacion = ValueAnimator.ofFloat(0, 1);

            animacion.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    float valor = (float) animation.getAnimatedValue();
                    posicicion.verticalBias = frame_mover(posicicion.verticalBias, posY, valor);
                    posicicion.horizontalBias = frame_mover(posicicion.horizontalBias, posX, valor);

                    boton.setLayoutParams(posicicion);
                }
            });
            animacion.setDuration(3500);

            animacion.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {cola = false;
                    }
                });
            animacion.start();
            actualizar_posicion(posY, posX);
        }

    }

    private float frame_mover(float inicio, float fin, float fraccion) {
        return inicio + fraccion * (fin - inicio);
    }
    public void posicionar_carta(float posY, float posX) {

        if (cola){
            System.out.println("Espera crj");
        }
        else{
            cola = true;
            ConstraintLayout constraintLayout = (ConstraintLayout) boton.getParent();
            ConstraintSet constraintSet = new ConstraintSet();
            constraintSet.clone(constraintLayout);

            constraintSet.setVerticalBias(boton.getId(), posY);
            constraintSet.setHorizontalBias(boton.getId(), posX);

            AutoTransition transition = new AutoTransition();
            transition.setDuration(800);
            transition.addListener(new Transition.TransitionListener(){

                @Override
                public void onTransitionStart(Transition transition) {}

                @Override
                public void onTransitionEnd(Transition transition) {
                    cola = false;
                    actualizar_posicion(posY, posX);
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
    }
    protected void actualizar_posicion(float posY, float posX){
        posicionY = posY;
        posicionX = posX;
    }
}
