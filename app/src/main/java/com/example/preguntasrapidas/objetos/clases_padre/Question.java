package com.example.preguntasrapidas.objetos.clases_padre;

import java.io.Serializable;

public class Question implements Serializable {
    private final String resource;
    private final String firstOption;
    private final String secondOption;
    private final String thirdOption;
    private final String quarterOption;
    private final String response;

    public Question(String resource, String firstOption, String secondOption, String thirdOption, String quarterOption, String response){
        this.resource = resource;
        this.firstOption = firstOption;
        this.secondOption = secondOption;
        this.thirdOption = thirdOption;
        this.quarterOption = quarterOption;
        this.response = response;
    }
    public String getResource() {
        return resource;
    }
    public String getFirstOption() {
        return firstOption;
    }
    public String getSecondOption() {
        return secondOption;
    }
    public String getThirdOption() {
        return thirdOption;
    }
    public String getQuarterOption() {
        return quarterOption;
    }
    public String getResponse() {
        return response;
    }
}