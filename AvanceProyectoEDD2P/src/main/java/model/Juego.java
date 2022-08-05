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
import java.util.Stack;

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
        
        //PRIMERA OPCION (NO HA FUNCIONADO)
        
//        Stack<BinaryTree<JuegoDatos>> pilaArbol = new Stack<>();
//        for(String pregunta : mapaDatos.get("Preguntas")){
//            pilaArbol.push(new BinaryTree<>(new JuegoDatos(pregunta)));
//        }
//        
//        pilaArbol.push(new BinaryTree<>(new JuegoDatos("Hoja")));
//        
//        while(pilaArbol.size()>1){
//            BinaryTree<JuegoDatos> variable1 = pilaArbol.pop();
//            BinaryTree<JuegoDatos> variable2 = pilaArbol.pop();
//            
//            variable2.setLeft(variable1);
//            variable2.setRight(variable1);
//            
//            pilaArbol.push(variable2);
//        }
//        
//        BinaryTree<JuegoDatos> arbolFinal = pilaArbol.pop();
//        
//        System.out.println("-----------------ARBOL ANTES DE LLENAR DATOS-----------------");
//        System.out.println("\nArbolFinal (nivel1): "+arbolFinal.getRootContent().toString());
//        System.out.println("\nArbolFinal Hijo Izquierdo (nivel2): "+arbolFinal.getLeft().getRootContent().toString());
//        System.out.println("ArbolFinal Hijo Derecho (nivel2): "+arbolFinal.getRight().getRootContent().toString());
//        
//        System.out.println("\nArbolFinal Hijo Izquierdo del hijo izquierdo (nivel3): "+arbolFinal.getLeft().getLeft().getRootContent().toString());
//        System.out.println("ArbolFinal Hijo Derecho del hijo izquierdo (nivel3): "+arbolFinal.getLeft().getRight().getRootContent().toString());
//        
//        System.out.println("\nArbolFinal Hijo Izquierdo del hijo Derecho (nivel3): "+arbolFinal.getRight().getLeft().getRootContent().toString());
//        System.out.println("ArbolFinal Hijo Derecho del hijo Derecho (nivel3): "+arbolFinal.getRight().getRight().getRootContent().toString());
//        
//        System.out.println("\nArbolFinal Hijo Izquierdo del hijo izquierdo del hijo izquierdo (nivel4): "+arbolFinal.getLeft().getLeft().getLeft().getRootContent().toString());
//        System.out.println("ArbolFinal Hijo Derecho del hijo izquierdo del hijo izquierdo (nivel4): "+arbolFinal.getLeft().getLeft().getRight().getRootContent().toString());
//        
//        System.out.println("\nArbolFinal Hijo Izquierdo del hijo derecho del hijo izquierdo (nivel4): "+arbolFinal.getLeft().getRight().getLeft().getRootContent().toString());
//        System.out.println("ArbolFinal Hijo Derecho del hijo derecho del hijo izquierdo (nivel4): "+arbolFinal.getLeft().getRight().getRight().getRootContent().toString());
//        
//        System.out.println("\nArbolFinal Hijo Izquierdo del hijo izquierdo del hijo derecho (nivel4): "+arbolFinal.getRight().getLeft().getLeft().getRootContent().toString());
//        System.out.println("ArbolFinal Hijo Derecho del hijo izquierdo del hijo derecho (nivel4): "+arbolFinal.getRight().getLeft().getRight().getRootContent().toString());
//        
//        System.out.println("\nArbolFinal Hijo Izquierdo del hijo derecho del hijo derecho (nivel4): "+arbolFinal.getRight().getRight().getLeft().getRootContent().toString());
//        System.out.println("ArbolFinal Hijo Derecho del hijo derecho del hijo derecho (nivel4): "+arbolFinal.getRight().getRight().getRight().getRootContent().toString());
//        
//        
//        
//        
//        //------------------------FALTA AGREGAR LOS ANIMALES AL ARBOL------------------------
//        System.out.println("----------BREAK---------");
//        Iterator<Map.Entry<String, ArrayList<String>>> itr = mapaAnimales.entrySet().iterator();
//        while(itr.hasNext()){
//            Map.Entry<String, ArrayList<String>> entry = itr.next();
//            arbolFinal.getRootContent().addAnimal(entry.getKey());
//            
//            System.out.println(entry.getKey() + "|" + entry.getValue());
//            
//            BinaryTree<JuegoDatos> temp = arbolFinal;
//            
//            for(String siNo : entry.getValue()){
//                if(siNo.equals("si")){
//                    System.out.println("AFIRMATIVO");
//                    //temp=temp.getLeft();
//                    //temp.getRootContent().getAnimales().add(entry.getKey());
//                }else{
//                    System.out.println("NEGATIVO");
//                    //temp=temp.getRight();
//                    //temp.getRootContent().getAnimales().add(entry.getKey());
//                }
//
//            }
//        }
//        
//        
//        System.out.println(arbolFinal.getLeft().getRootContent().toString());
//        
//        
//        //------------------------PARA PROBAR CIERTAS COSAS------------------------
//        System.out.println("\nMapa Animales: "+mapaAnimales.toString());
//        
//        System.out.println("-----------------ARBOL DESPUES DE LLENAR DATOS-----------------");
//        System.out.println("\nArbolFinal (nivel1): "+arbolFinal.getRootContent().toString());
//        System.out.println("\nArbolFinal Hijo Izquierdo (nivel2): "+arbolFinal.getLeft().getRootContent().toString());
//        System.out.println("ArbolFinal Hijo Derecho (nivel2): "+arbolFinal.getRight().getRootContent().toString());
//        
//        System.out.println("\nArbolFinal Hijo Izquierdo del hijo izquierdo (nivel3): "+arbolFinal.getLeft().getLeft().getRootContent().toString());
//        System.out.println("ArbolFinal Hijo Derecho del hijo izquierdo (nivel3): "+arbolFinal.getLeft().getRight().getRootContent().toString());
//        
//        System.out.println("\nArbolFinal Hijo Izquierdo del hijo Derecho (nivel3): "+arbolFinal.getRight().getLeft().getRootContent().toString());
//        System.out.println("ArbolFinal Hijo Derecho del hijo Derecho (nivel3): "+arbolFinal.getRight().getRight().getRootContent().toString());
//        
//        System.out.println("\nArbolFinal Hijo Izquierdo del hijo izquierdo del hijo izquierdo (nivel4): "+arbolFinal.getLeft().getLeft().getLeft().getRootContent().toString());
//        System.out.println("ArbolFinal Hijo Derecho del hijo izquierdo del hijo izquierdo (nivel4): "+arbolFinal.getLeft().getLeft().getRight().getRootContent().toString());
//        
//        System.out.println("\nArbolFinal Hijo Izquierdo del hijo derecho del hijo izquierdo (nivel4): "+arbolFinal.getLeft().getRight().getLeft().getRootContent().toString());
//        System.out.println("ArbolFinal Hijo Derecho del hijo derecho del hijo izquierdo (nivel4): "+arbolFinal.getLeft().getRight().getRight().getRootContent().toString());
//        
//        System.out.println("\nArbolFinal Hijo Izquierdo del hijo izquierdo del hijo derecho (nivel4): "+arbolFinal.getRight().getLeft().getLeft().getRootContent().toString());
//        System.out.println("ArbolFinal Hijo Derecho del hijo izquierdo del hijo derecho (nivel4): "+arbolFinal.getRight().getLeft().getRight().getRootContent().toString());
//        
//        System.out.println("\nArbolFinal Hijo Izquierdo del hijo derecho del hijo derecho (nivel4): "+arbolFinal.getRight().getRight().getLeft().getRootContent().toString());
//        System.out.println("ArbolFinal Hijo Derecho del hijo derecho del hijo derecho (nivel4): "+arbolFinal.getRight().getRight().getRight().getRootContent().toString());
//        
        
// SEGUNDA OPCION (TERMINADA)
//LOS ANIMALES QUE SE ENCUENTRAN EN LA LISTA SON LA RESPUESTAS A LA PREGUNTA DEL NODO PADRE, SI ES SI O NO DEPENDE DE SI ES HIJO IZQ OR DER
        
        System.out.println(mapaAnimales);
        
        BinaryTree<JuegoDatos> arbol = new BinaryTree<>(new JuegoDatos(mapaDatos.get("Preguntas").get(0)));
        
        
        Iterator<Map.Entry<String, ArrayList<String>>> itr = mapaAnimales.entrySet().iterator();
        while(itr.hasNext()){
            Map.Entry<String, ArrayList<String>> entry = itr.next();
            System.out.println(entry.getKey() + "|" + entry.getValue());
            arbol.getRootContent().addAnimal(entry.getKey());
            
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
        
        System.out.println("\n-------------Inicia el arbol-------------\n");
        System.out.println("Arbol (nivel 1): "+arbol.getRootContent());
        
        System.out.println("\nArbol Hijo izq (nivel 2): "+arbol.getLeft().getRootContent());
        System.out.println("Arbol Hijo der (nivel 2): "+arbol.getRight().getRootContent());
        
        System.out.println("\nArbol Hijo izq del hijo izq (nivel 3): "+arbol.getLeft().getLeft().getRootContent());
        System.out.println("Arbol Hijo der del hijo izq (nivel 3): "+arbol.getLeft().getRight().getRootContent());
        
        System.out.println("\nArbol Hijo izq del hijo der (nivel 3): "+arbol.getRight().getLeft().getRootContent());
        System.out.println("Arbol Hijo der del hijo der (nivel 3): "+arbol.getRight().getRight().getRootContent());
        
        System.out.println("\nArbolFinal Hijo Izquierdo del hijo izquierdo del hijo izquierdo (nivel4): "+arbol.getLeft().getLeft().getLeft().getRootContent().toString());
        //System.out.println("ArbolFinal Hijo Derecho del hijo izquierdo del hijo izquierdo (nivel4): "+arbol.getLeft().getLeft().getRight().getRootContent().toString());
        
        System.out.println("\nArbolFinal Hijo Izquierdo del hijo derecho del hijo izquierdo (nivel4): "+arbol.getLeft().getRight().getLeft().getRootContent().toString());
        //System.out.println("ArbolFinal Hijo Derecho del hijo derecho del hijo izquierdo (nivel4): "+arbol.getLeft().getRight().getRight().getRootContent().toString());
        
        //System.out.println("\nArbolFinal Hijo Izquierdo del hijo izquierdo del hijo derecho (nivel4): "+arbol.getRight().getLeft().getLeft().getRootContent().toString());
        System.out.println("ArbolFinal Hijo Derecho del hijo izquierdo del hijo derecho (nivel4): "+arbol.getRight().getLeft().getRight().getRootContent().toString());
        
        //System.out.println("\nArbolFinal Hijo Izquierdo del hijo derecho del hijo derecho (nivel4): "+arbol.getRight().getRight().getLeft().getRootContent().toString());
        System.out.println("ArbolFinal Hijo Derecho del hijo derecho del hijo derecho (nivel4): "+arbol.getRight().getRight().getRight().getRootContent().toString());
 
        
        
        return arbol;
    }
    
    
    
    // CLSAE INTERNA USADA
    
    class JuegoDatos{
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
    
}
