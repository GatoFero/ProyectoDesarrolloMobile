package com.example.preguntasrapidas.objetos.clases_padre;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.transition.AutoTransition;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.content.ContextCompat;

public class Card {

    //Attributes
    protected String cardUp;
    protected String cardDown = "cover";
    protected String stateCard = Card.STATE_NO_USABLE;
    protected float codeCard;
    protected ImageView container;
    protected Context context;

    //Constants
    public static final String STATE_USABLE = "usable";
    public static final String STATE_NO_USABLE = "no usable";

    //Elementos en juego o metodos
    public float positionY;
    public float positionX;
    protected boolean cola = false;

    public Card() {}

    public Card(Context context, ConstraintLayout parentLayout, String cardUp, float codeCard, boolean start, int width, int height, float initialPositionY, float initialPositionX, float positionY, float positionX) {
        this.context = context;
        this.cardUp = cardUp;
        this.codeCard = codeCard;
        this.positionY = positionY;
        this.positionX = positionX;

        float scale = context.getResources().getDisplayMetrics().density;
        int widthInPixels = (int) (width * scale + 0.5f);
        int heightInPixels = (int) (height * scale + 0.5f);

        this.container = new ImageView(context);
        this.container.setId(View.generateViewId());

        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(widthInPixels, heightInPixels);
        this.container.setLayoutParams(layoutParams);
        parentLayout.addView(this.container);

        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(parentLayout);
        constraintSet.connect(this.container.getId(), ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP, 0);
        constraintSet.connect(this.container.getId(), ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START, 0);
        constraintSet.connect(this.container.getId(), ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM, 0);
        constraintSet.connect(this.container.getId(), ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END, 0);

        constraintSet.setVerticalBias(this.container.getId(), initialPositionY);
        constraintSet.setHorizontalBias(this.container.getId(), initialPositionX);
        constraintSet.applyTo(parentLayout);

        if (start) {
            changeImageResource(cardUp);
        } else {
            changeImageResource(cardDown);
        }

        introduceCard(positionY, positionX);
    }

    //Methods essentials
    protected void changeImageResource(String resource) {
        int getImgResource = container.getResources().getIdentifier(resource, "drawable", container.getContext().getPackageName());
        Drawable drawable = ContextCompat.getDrawable(container.getContext(), getImgResource);
        container.setImageDrawable(drawable);
    }

    protected void updatePosition(float posY, float posX) {
        positionY = posY;
        positionX = posX;
    }

    public void forceCola(boolean force) {
        cola = force;
    }

    public boolean isCola() {
        return cola;
    }

    public void changeState(String newState) {
        stateCard = newState;
    }

    public float getCodeCard() {
        return codeCard;
    }

    // Methods interactive
    public void revealOrHideCard(boolean view) {
        if (stateCard.equals(Card.STATE_USABLE)) {
            ObjectAnimator animationGiro;
            if (view) {
                animationGiro = ObjectAnimator.ofFloat(container, "rotationY", 0, 180);
                animationGiro.setDuration(700);
                animationGiro.addListener((new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        changeImageResource(cardUp);
                    }
                }));
            } else {
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
        if (!cola) {
            updatePosition(posY, posX);
            cola = true;
            ConstraintLayout constraintLayout = (ConstraintLayout) container.getParent();
            ConstraintSet constraintSet = new ConstraintSet();
            constraintSet.clone(constraintLayout);

            constraintSet.setVerticalBias(container.getId(), posY);
            constraintSet.setHorizontalBias(container.getId(), posX);

            AutoTransition transition = new AutoTransition();
            transition.setDuration(800);
            transition.addListener(new Transition.TransitionListener() {

                @Override
                public void onTransitionStart(Transition transition) {}

                @Override
                public void onTransitionEnd(Transition transition) {
                    cola = false;
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
        } else {
            System.out.println("Espera crj");
        }
    }

    public void introduceCard(float posY, float posX) {
        if (!cola) {
            cola = true;
            updatePosition(posY, posX);
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
                public void onAnimationEnd(Animator animation) {
                    cola = false;
                }
            });
            animation.start();
        } else {
            System.out.println("Espera crj");
        }
    }

    private float frame_mover(float inicio, float fin, float fraccion) {
        return inicio + fraccion * (fin - inicio);
    }
}