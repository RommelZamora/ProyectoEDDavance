/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Rommel Zamora
 */
public class JuegoDatos {
    
    private String pregunta;
    private ArrayList<String> animales;
    private String textoOutput="";

    public JuegoDatos(String pregunta) {
        this.pregunta = pregunta;
        this.animales = new ArrayList<>();
    }

    public String getPregunta() {
        return pregunta;
    }

    public ArrayList<String> getAnimales() {
        return animales;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public void setAnimales(ArrayList<String> animales) {
        this.animales = animales;
    }

    public void addAnimal(String animal){
        this.animales.add(animal);

        if(this.animales.size()>1){
            this.textoOutput="Los animales que cumplen con el enunciado son: ";
        }else{
            this.textoOutput="El animal que cumple con el enunciado es: ";
        }
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("JuegoDatos{");
        sb.append("pregunta=").append(pregunta);
        sb.append(", textOutput=").append(textoOutput);
        sb.append(", animales=").append(animales);
        sb.append('}');
        return sb.toString();
    }
    
}
