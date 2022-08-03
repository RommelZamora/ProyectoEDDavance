package model;

import TDAs.BinaryTree;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
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
        
        this.datosJuego= new BinaryTree<>();
    }

    public Juego(String pathArchivoPreguntas, String pathArchivoRespuestas) {
        this.filePreguntas=new File(pathArchivoPreguntas);
        this.fileRespuestas=new File(pathArchivoRespuestas);
        
        this.txtRespuestas = fileRespuestas.getName();
        this.txtPreguntas = filePreguntas.getName();
        
        this.datosJuego= new BinaryTree<>();
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
            
            //System.out.println("--------RESPUESTAS:--------");
            while (respuesta != null) {
                mapa.get("Respuestas").add(respuesta);
                //System.out.println(respuesta);
                // read next line
                respuesta = readerRespuestas.readLine();
            }
            
            
            readerPreguntas.close();
            readerRespuestas.close();
            
        }catch(IOException e){
            System.out.println("No se pudo abrir los archivos: ");
	}
        
        return mapa;
    }
    
    public BinaryTree<JuegoDatos> crearArbol(Map<String, ArrayList<String>> mapaDatos){
        BinaryTree<JuegoDatos> arbol = new BinaryTree<>();
        Map<String, ArrayList<String>> mapaAnimales = new HashMap<>();
        
        for(String animal : mapaDatos.get("Respuestas")){
            String[] lista = animal.split(" ");
            for(int i=0; i<lista.length; i++){
                if(i==0){
                    mapaAnimales.put(lista[i],new ArrayList<>());
                }else{
                    mapaAnimales.get(lista[0]).add(lista[i]);
                }
            }
        }
        
        ArrayList<BinaryTree<JuegoDatos>> arregloArbolesBase = new ArrayList<>();
        
        
        
        
        System.out.println(mapaAnimales.toString());
        return arbol;
    }
    
    
    
    // CLSAE INTERNA USADA
    
    class JuegoDatos{
        private String pregunta;
        private ArrayList<String> animales;

        public JuegoDatos(String pregunta, String animales) {
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
        
        public void addAnimal(String animales){
            this.animales.add(animales);
        }
        
    }
    
}
