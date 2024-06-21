package com.example.preguntasrapidas.objetos;

import java.io.Serializable;

public class Pregunta implements Serializable {
    public String recurso;
    public String primeraOpcion;
    public String segundaOpcion;
    public String terceraOpcion;
    public String cuartaOpcion;
    public String respuesta;

    public Pregunta(String recurso, String primeraOpcion, String segundaOpcion, String terceraOpcion, String cuartaOpcion, String respuesta){
        this.recurso = recurso;
        this.primeraOpcion = primeraOpcion;
        this.segundaOpcion = segundaOpcion;
        this.terceraOpcion = terceraOpcion;
        this.cuartaOpcion = cuartaOpcion;
        this.respuesta = respuesta;
    }
}