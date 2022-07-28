/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import TDAs.BinaryTree;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author CltControl
 */
public class Juego {
    private String txtRespuestas;
    private String txtPreguntas;
    
    private File filePreguntas;
    private File fileRespuestas;
    
    private BinaryTree<JuegoDatos> datosJuego;
    
    public Juego(File preguntas, File respuestas){
        this.filePreguntas = preguntas;
        this.fileRespuestas = respuestas;
        
        this.txtPreguntas = filePreguntas.getName();
        this.txtRespuestas = fileRespuestas.getName();
        
        this.datosJuego= new BinaryTree<JuegoDatos>();
    }

    public Juego(String pathArchivoPreguntas, String pathArchivoRespuestas) {
        this.filePreguntas=new File(pathArchivoPreguntas);
        this.fileRespuestas=new File(pathArchivoRespuestas);
        
        this.txtRespuestas = fileRespuestas.getName();
        this.txtPreguntas = filePreguntas.getName();
        
        this.datosJuego= new BinaryTree<JuegoDatos>();
    }
    
    public Map<String, ArrayList<String>> obtenerDatos(){
        HashMap<String, ArrayList<String>> mapa = new HashMap<>();
        mapa.put("Preguntas",new ArrayList<>());
        mapa.put("Respuestas",new ArrayList<>());
        
        
        BufferedReader readerPreguntas;
        BufferedReader readerRespuestas;
        
        try{
            readerPreguntas= new BufferedReader(new FileReader(filePreguntas));
            readerRespuestas= new BufferedReader(new FileReader(fileRespuestas));
            
            String pregunta = readerPreguntas.readLine();
            String respuesta = readerRespuestas.readLine();
            
            //System.out.println("--------PREGUNTAS:--------");
            while (pregunta != null) {
                mapa.get("Preguntas").add(pregunta);
                //System.out.println(pregunta);
                // read next line
                pregunta = readerPreguntas.readLine();
            }
            
            //System.out.println("--------Respuestas:--------");
            while (respuesta != null) {
                mapa.get("Respuestas").add(respuesta);
                //System.out.println(respuesta);
                // read next line
                respuesta = readerRespuestas.readLine();
            }
            
            
            readerPreguntas.close();
            readerRespuestas.close();
            
        }catch(Exception e){
            System.out.println("No se pudo abrir los archivos: ");
	}
        
        System.out.println(mapa.toString());
        
        return mapa;
    }
    
    
    
    // CLSAE INTERNA USADA
    
    class JuegoDatos{
        private String pregunta;
        private boolean respuesta;

        public JuegoDatos(String pregunta) {
            this.pregunta = pregunta;
            this.respuesta=true;
        }

        public String getPregunta() {
            return pregunta;
        }

        public boolean getRespuesta() {
            return respuesta;
        }

        public void setPregunta(String pregunta) {
            this.pregunta = pregunta;
        }

        public void setRespuesta(boolean respuesta) {
            this.respuesta = respuesta;
        }
        
        
        
    
    }
    
}
