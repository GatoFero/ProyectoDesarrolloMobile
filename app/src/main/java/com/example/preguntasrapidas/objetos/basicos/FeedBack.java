package com.example.preguntasrapidas.objetos.basicos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FeedBack implements Serializable {

    private final List<String> phrases = new ArrayList<>();
    Random phrasesRandom = new Random();

    public FeedBack(){

    }

    public void setPhrasesGood(){
        phrases.add("Bien Jugado!");
        phrases.add("Bien Hecho!");
        phrases.add("Felicidades!");
        phrases.add("Impresionante!");
        phrases.add("Fantástico!");
        phrases.add("Te Has Lucido");
        phrases.add("Sigue Así");
        phrases.add("Maravilloso!");
        phrases.add("Excelente Respuesta");
        phrases.add("Perfecto!");
    }
    public void setPhrasesBad() {
        phrases.add("Sigue Intentando!");
        phrases.add("No Te Desanimes");
        phrases.add("Sigue Adelante.");
        phrases.add("No Te Rindas");
        phrases.add("Puedes Mejorar");
        phrases.add("No Te Preocupes");
        phrases.add("Es solo un Contratiempo");
        phrases.add("Vamos por la Siguiente");
        phrases.add("Estás Progresando");
        phrases.add("La Próxima es la Buena");
    }
    public void setPhrasesWait() {
        phrases.add("Con Calma");
        phrases.add("Tómate tu tiempo");
        phrases.add("Cabeza Fría");
        phrases.add("Cuando estés listo");
        phrases.add("Esperamos tu respuesta");
    }
    public String getRandomPhrase(){
        int phrase = phrasesRandom.nextInt(phrases.size());
        return phrases.get(phrase);
    }
}
