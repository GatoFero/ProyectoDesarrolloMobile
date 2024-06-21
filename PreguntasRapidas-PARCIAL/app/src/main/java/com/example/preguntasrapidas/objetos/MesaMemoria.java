package com.example.preguntasrapidas.objetos;

import android.os.Handler;
import android.widget.TextView;

import com.example.preguntasrapidas.objetos.cartas.CartaMemoria;

import java.util.ArrayList;
import java.util.Collections;

public class MesaMemoria {

    //Objetos necesarios
    private ArrayList<CartaMemoria> cartasMemoria;
    private ArrayList<Posicion> posicionesMesa;
    private TextView verIntentos;
    private TextView verPuntos;
    private Score puntos = new Score(0);

    //Variables para los metodos de mesa
    private int intentos;
    private int cantidadPares;
    private int contadorJugada = 1;
    private String estadoMesa = "sin iniciar";
    private int dificultad;

    //Variables para manejar cartas
    private int indexPrimeraOpcion;
    private int codigoPrimeraOpcion;

    //Constructor
    public MesaMemoria(ArrayList<CartaMemoria> cartasMemoria, ArrayList<Posicion> posicionesMesa, TextView verPuntos, TextView verIntentos, int intentos, int dificultad){
        this.cartasMemoria = cartasMemoria;
        this.posicionesMesa = posicionesMesa;
        this.verPuntos = verPuntos;
        this.verIntentos = verIntentos;
        this.intentos = intentos;
        this.dificultad = dificultad;
    }

    //Metodo para barajar cartas y establecer variables
    public void barajar_cartas(){
        Collections.shuffle(posicionesMesa);
        for (int i= 0; i < posicionesMesa.size(); i++){
            cartasMemoria.get(i).posicionar_carta(posicionesMesa.get(i).posicionY, posicionesMesa.get(i).posicionX);
        }
        if (estadoMesa.equals("sin iniciar")){
            cambiarEstadoCartas("usable");
            estadoMesa = "en juego";
        }
    }
    public void establecer_medidas_nivel(){
        cantidadPares = cartasMemoria.size()/2;
        verIntentos.setText(String.valueOf(intentos));
    }

    //Manejo de comparacion de cartas
    public void realizar_jugada(CartaMemoria cartaJugada){
        if(intentos != 0){
            switch (contadorJugada) {
                case 1:
                    primera_opcion(cartaJugada);
                    contadorJugada++;
                    break;
                case 2:
                    obtener_resultado(cartaJugada);
                    contadorJugada--;
                    break;
            }
        }
    }

    //Comparacion de cartas
    public void primera_opcion(CartaMemoria primeraOpcion){

        codigoPrimeraOpcion = primeraOpcion.codigoCarta;
        indexPrimeraOpcion = cartasMemoria.indexOf(primeraOpcion);

        cartasMemoria.get(indexPrimeraOpcion).revelar_carta();
        cartasMemoria.get(indexPrimeraOpcion).cambiar_estado_usabilidad("no usable");
    }
    public void obtener_resultado(CartaMemoria segundaOpcion){

        int indexSegundaOpcion = cartasMemoria.indexOf(segundaOpcion);
        cartasMemoria.get(indexSegundaOpcion).revelar_carta();

        cambiarEstadoCartas("no usable");

        float resultado = (float) (codigoPrimeraOpcion + segundaOpcion.codigoCarta) / 2;

        if (resultado == codigoPrimeraOpcion) {
            cartas_pares_encontradas(indexSegundaOpcion);
        } else {
            cartas_impares_encontradas(indexSegundaOpcion);
        }
    }
    private void cartas_pares_encontradas(int indexSegundaOpcion){

        cambiarEstadoCartas("usable");
        verPuntos.setText(String.valueOf(puntos.sumarScore(50)));
        cartasMemoria.get(indexPrimeraOpcion).cambiar_estado_usabilidad("jugada");
        cartasMemoria.get(indexSegundaOpcion).cambiar_estado_usabilidad("jugada");

        if (cantidadPares > 1){
            cantidadPares--;
            if (dificultad > 1 && cantidadPares != 1){
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        for(CartaMemoria carta : cartasMemoria){
                            carta.forzar_cola(false);
                        }
                        barajar_cartas();
                    }
                },700);
            }
        }
        else {
            cantidadPares--;
        }
    }
    private void cartas_impares_encontradas(int indexSegundaOpcion){
        intentos -= 1;
        verIntentos.setText(String.valueOf(intentos));
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                cartasMemoria.get(indexPrimeraOpcion).cambiar_estado_usabilidad("usable");
                cartasMemoria.get(indexSegundaOpcion).cambiar_estado_usabilidad("usable");
                cartasMemoria.get(indexPrimeraOpcion).ocultar_carta();
                cartasMemoria.get(indexSegundaOpcion).ocultar_carta();
                cambiarEstadoCartas("usable");
            }
        },1400);
    }

    //Establecer el uso de cartas
    private void cambiarEstadoCartas(String estadoActual){
        for (CartaMemoria carta : cartasMemoria){
            carta.cambiar_estado_usabilidad(estadoActual);
        }
    }
}