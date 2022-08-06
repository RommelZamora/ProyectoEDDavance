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
    
    //Abre los archivos de preguntas y respuestas para devolver un mapa con el formato: <"Preguntas":[ArrayList<String>], "Respuestas":[ArrayList<String>]>
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
            
            while (pregunta != null) {
                mapa.get("Preguntas").add(pregunta);
                pregunta = readerPreguntas.readLine();
            }
            
            while (respuesta != null) {
                mapa.get("Respuestas").add(respuesta);
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
        
        //Primero convierte la lista de respuestas en un mapa con el formato: <"Animal 1":["Si", "No", "Si"].....>
        
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
        
        //El arbol se crea desde arriba, con la primera pregunta y una lista con todos los animales que son posibles respuestas
        BinaryTree<JuegoDatos> arbol = new BinaryTree<>(new JuegoDatos(mapaDatos.get("Preguntas").get(0)));
        
        //Iterador para recorrer el mapa de animales con sus respuestas respectivas
        Iterator<Map.Entry<String, ArrayList<String>>> itr = mapaAnimales.entrySet().iterator();
        while(itr.hasNext()){
            Map.Entry<String, ArrayList<String>> entry = itr.next();
            arbol.getRootContent().addAnimal(entry.getKey());
            
            //Utiliza un contador y un nodo viajero para poder crear los hijos que sean necesarios dentro del arbol
            // o recorrerlos si ya estan creados
            BinaryTree<JuegoDatos> temp=arbol;
            int cont=0;
            
            for(String siNo : entry.getValue()){
                cont++;
                if(cont==mapaDatos.get("Preguntas").size()){
                    if(siNo.toUpperCase().equals("SI")){
                        if(temp.hasLeft()){
                            temp=temp.getLeft();
                            temp.getRootContent().addAnimal(entry.getKey());
                        }else{
                            temp.setLeft(new BinaryTree<>(new JuegoDatos("Hoja de respuesta "+entry.getKey())));
                            temp=temp.getLeft();
                            temp.getRootContent().addAnimal(entry.getKey());
                        }
                    }else{
                        if(temp.hasRight()){
                            temp=temp.getRight();
                            temp.getRootContent().addAnimal(entry.getKey());
                        }else{
                            temp.setRight(new BinaryTree<>(new JuegoDatos("Hoja de respuesta "+entry.getKey())));
                            temp=temp.getRight();
                            temp.getRootContent().addAnimal(entry.getKey());
                        }
                    }
                }else{
                    if(siNo.toUpperCase().equals("SI")){
                        if(temp.hasLeft()){
                            temp=temp.getLeft();
                            temp.getRootContent().addAnimal(entry.getKey());
                        }else{
                            temp.setLeft(new BinaryTree<>(new JuegoDatos(mapaDatos.get("Preguntas").get(cont))));
                            temp=temp.getLeft();
                            temp.getRootContent().addAnimal(entry.getKey());
                        }
                    }else{
                        if(temp.hasRight()){
                            temp=temp.getRight();
                            temp.getRootContent().addAnimal(entry.getKey());
                        }else{
                            temp.setRight(new BinaryTree<>(new JuegoDatos(mapaDatos.get("Preguntas").get(cont))));
                            temp=temp.getRight();
                            temp.getRootContent().addAnimal(entry.getKey());
                        }
                    }
                }
                
            }
            
        }
        
        //LOS ANIMALES QUE SE ENCUENTRAN EN LA LISTA SON LA RESPUESTAS A LA PREGUNTA DEL NODO PADRE, 
        //SI ES SI O NO DEPENDE DE SI ES HIJO IZQ OR DER
        
        return arbol;
    }
    
    
}
