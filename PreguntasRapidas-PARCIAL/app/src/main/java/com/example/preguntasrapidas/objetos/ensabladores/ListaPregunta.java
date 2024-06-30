package com.example.preguntasrapidas.objetos.ensabladores;

import android.graphics.RenderEffect;
import android.graphics.Shader;
import android.os.Build;
import android.os.Handler;
import android.widget.Button;
import android.widget.ImageView;

import com.example.preguntasrapidas.objetos.clases_padre.Pregunta;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class ListaPregunta implements Serializable {
    private transient Handler handler;
    private ArrayList<Pregunta> preguntas;
    private int dificultad;
    private int tiempo;

    public ListaPregunta(ArrayList<Pregunta> lista, int dificultad, int tiempo) {
        this.dificultad = dificultad;
        this.tiempo = tiempo;
        this.handler = new Handler();
        this.preguntas = new ArrayList<>();
        Collections.shuffle(lista);
        int cantidadSeleccionada = Math.min(dificultad, lista.size());
        for (int i = 0; i < cantidadSeleccionada; i++) {
            this.preguntas.add(lista.get(i));
        }
        lista.retainAll(this.preguntas);
    }

    public String mostrarFotoPreguntas(int contador, Button primerCampo, Button segundoCampo, Button terceroCampo, Button cuartoCampo, ImageView foto) {

        primerCampo.setText(preguntas.get(contador).primeraOpcion);
        segundoCampo.setText(preguntas.get(contador).segundaOpcion);
        terceroCampo.setText(preguntas.get(contador).terceraOpcion);
        cuartoCampo.setText(preguntas.get(contador).cuartaOpcion);

        int resourceId = foto.getContext().getResources().getIdentifier(preguntas.get(contador).recurso, "drawable", foto.getContext().getPackageName());
        foto.setImageResource(resourceId);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            foto.setRenderEffect(RenderEffect.createBlurEffect(50, 50, Shader.TileMode.MIRROR));
        }

        return preguntas.get(contador).respuesta;
    }
    public void responderPregunta(ImageView foto){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            foto.setRenderEffect(null);
        }
    }
    public int definirTiempo(){
        return tiempo;
    }
    public int definirTotal(){
        return dificultad;
    }
}