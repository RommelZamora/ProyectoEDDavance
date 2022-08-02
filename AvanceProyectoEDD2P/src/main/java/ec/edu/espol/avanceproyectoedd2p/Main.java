/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ec.edu.espol.avanceproyectoedd2p;

import java.util.ArrayList;
import java.util.Map;
import model.Juego;

/**
 *
 * @author Rommel Zamora
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String dir = System.getProperty("user.dir")+"\\src\\main\\java\\demoArchivos\\";
        
        Juego juego = new Juego(dir+"preguntas.txt", dir+"respuestas.txt");
        
        Map<String, ArrayList<String>> mapa = juego.obtenerDatos();
        System.out.println(mapa);
        
        System.out.println("\n-----------Arbol Creado-----------\n");
        //System.out.println(mapa.get("Respuestas").toString());
        //System.out.println(juego.crearArbol(mapa).preOrderTraversalRecursive().toString());
        
        //Iterator<Map.Entry<String, Integer>> itr = mapa.entrySet().iterator();
        //while(itr.hasNext()){
        //    Map.Entry<String, Integer> entry = itr.next();
        //    System.out.println(entry.getKey() + "|" + entry.getValue());
        //}
        
        
        
        juego.crearArbol(mapa);
    }
    
}
