package com.example.preguntasrapidas;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.preguntasrapidas.objetos.ensabladores.ListaPregunta;
import com.example.preguntasrapidas.objetos.util.Score;

public class PreguntasJuegoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_preguntas_juego);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.juegoppt), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        primeraOpcion = findViewById(R.id.btnPrimeraOpcion);
        segundaOpcion = findViewById(R.id.btnSegundaOpcion);
        terceraOpcion = findViewById(R.id.btnTerceraOpcion);
        cuartaOpcion = findViewById(R.id.btnCuartaOpcion);
        foto = findViewById(R.id.imgFoto);
        tiempoView = findViewById(R.id.txvTiempo);
        scoreView = findViewById(R.id.resultadoGame);
        preguntaActual = findViewById(R.id.txvIndicador);
        totalPreguntas = findViewById(R.id.txvTotalPreguntas);

        capturarPreguntas();
    }

    public ListaPregunta preguntasEnEjecucion;
    public void capturarPreguntas(){
        Bundle bundle = getIntent().getExtras();
        preguntasEnEjecucion = (ListaPregunta) bundle.getSerializable("preguntasEnJuego");
        totalPreguntas.setText(String.valueOf(preguntasEnEjecucion.definirTotal()));
        sistemaPreguntas();
    }

    private ImageView foto;
    private int contador = 0;
    private Button primeraOpcion;
    private Button segundaOpcion;
    private Button terceraOpcion;
    private Button cuartaOpcion;
    public String respuesta;
    public int tiempo;
    public TextView tiempoView;
    private Handler handler = new Handler();
    private Handler handler1 = new Handler();
    private TextView preguntaActual;
    private TextView totalPreguntas;
    public void sistemaPreguntas(){
        if(handler != null) {
            handler.removeCallbacksAndMessages(null);
        }

        if(contador < preguntasEnEjecucion.definirTotal()) {
            respuesta = preguntasEnEjecucion.mostrarFotoPreguntas(contador, primeraOpcion,segundaOpcion,terceraOpcion,cuartaOpcion, foto);
            tiempo = preguntasEnEjecucion.definirTiempo();
            contador++;
            preguntaActual.setText(String.valueOf(contador));
            iniciarCronometro(tiempoView, tiempo);
        }else {

            Intent intent = new Intent(this, ResultadoActivity.class);
            intent.putExtra("score", score);
            startActivity(intent);
            finish();
        }
    }

    public void iniciarCronometro(TextView verTiempo, int cuentaInicial) {
        if(handler == null) {
            handler = new Handler();
        } else {
            handler.removeCallbacksAndMessages(null); // Detiene el temporizador si está en ejecución
        }

        handler.postDelayed(new Runnable() {
            int tiempoRestante = cuentaInicial;

            @Override
            public void run() {
                verTiempo.setText(String.valueOf(tiempoRestante));
                tiempoRestante--;

                if (tiempoRestante >= 0) {
                    handler.postDelayed(this, 1000);
                } else {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                        foto.setRenderEffect(null);
                    }
                    tiempoView.setText("Tiempo Agotado");
                    handler1.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            sistemaPreguntas();
                        }
                    }, 800);
                }
            }
        }, 0);
    }


    private Score score = new Score(0);
    private TextView scoreView;
    public void comprobarPregunta(View v){
        Button botonPresionado = (Button) v;
        int colorPresionado = Color.parseColor("#fabe25");
        botonPresionado.setBackgroundColor(colorPresionado);
        String respuestaHecha = botonPresionado.getText().toString();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            foto.setRenderEffect(null);
        }

        if (respuestaHecha.equals(respuesta)){
            if(contador < preguntasEnEjecucion.definirTotal()) {
                score.sumScore(100);
                scoreView.setText(String.valueOf(score.getScore()));
                tiempoView.setText("Respuesta Correcta");

                    handler1.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            botonPresionado.setBackgroundColor(Color.parseColor("#2dc2e3"));
                            sistemaPreguntas();
                        }
                    }, 800);
            }
        }
        else {
            tiempoView.setText("Respuesta Incorrecta");
            handler1.postDelayed(new Runnable() {
                @Override
                public void run() {
                    botonPresionado.setBackgroundColor(Color.parseColor("#2dc2e3"));
                    sistemaPreguntas();
                }
            }, 800);
        }
    }
}