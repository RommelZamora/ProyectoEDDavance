/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ec.edu.espol.avanceproyectoedd2p;

import TDAs.BinaryTree;
import Util.TreePrinter;
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
        BinaryTree<String> arbol = juego.crearArbol();
        TreePrinter.print2D(arbol);
        
    }
    
}
