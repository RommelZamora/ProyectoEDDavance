/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ec.edu.espol.avanceproyectoedd2p;

import TDAs.BinaryTree;
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
        
//        Map<String, ArrayList<String>> mapa = juego.obtenerDatos();
//        juego.obtenerDatos();
//        BinaryTree<JuegoDatos> arbol = juego.crearArbol(mapa);
        
//        
        System.out.println("\n-------------ARBOL-------------\n");
        System.out.println("Arbol (nivel 1): "+arbol.getRootContent());
        
        System.out.println("\nArbol Hijo izq (nivel 2): "+arbol.getLeft().getRootContent());
        System.out.println("Arbol Hijo der (nivel 2): "+arbol.getRight().getRootContent());
        
        System.out.println("\nArbol Hijo izq del hijo izq (nivel 3): "+arbol.getLeft().getLeft().getRootContent());
        System.out.println("Arbol Hijo der del hijo izq (nivel 3): "+arbol.getLeft().getRight().getRootContent());
        
        System.out.println("\nArbol Hijo izq del hijo der (nivel 3): "+arbol.getRight().getLeft().getRootContent());
        System.out.println("Arbol Hijo der del hijo der (nivel 3): "+arbol.getRight().getRight().getRootContent());
        
        System.out.println("\nArbolFinal Hijo Izquierdo del hijo izquierdo del hijo izquierdo (nivel4): "+arbol.getLeft().getLeft().getLeft().getRootContent().toString());
        //El arbol no tiene un nodo como hijo derecho del hijo izq del hijo izq, por lo que no va a aparecer si se lo intenta mostrar.
        //System.out.println("ArbolFinal Hijo Derecho del hijo izquierdo del hijo izquierdo (nivel4): "+arbol.getLeft().getLeft().getRight().getRootContent().toString());
        
        System.out.println("\nArbolFinal Hijo Izquierdo del hijo derecho del hijo izquierdo (nivel4): "+arbol.getLeft().getRight().getLeft().getRootContent().toString());
        //El arbol no tiene un nodo como hijo derecho del hijo der del hijo izq, por lo que no va a aparecer si se lo intenta mostrar.
        //System.out.println("ArbolFinal Hijo Derecho del hijo derecho del hijo izquierdo (nivel4): "+arbol.getLeft().getRight().getRight().getRootContent().toString());
        
        //El arbol no tiene un nodo como hijo izq del hijo izq del hijo der, por lo que no va a aparecer si se lo intenta mostrar.
        //System.out.println("\nArbolFinal Hijo Izquierdo del hijo izquierdo del hijo derecho (nivel4): "+arbol.getRight().getLeft().getLeft().getRootContent().toString());
        System.out.println("ArbolFinal Hijo Derecho del hijo izquierdo del hijo derecho (nivel4): "+arbol.getRight().getLeft().getRight().getRootContent().toString());
        
        //El arbol no tiene un nodo como hijo izq del hijo der del hijo der, por lo que no va a aparecer si se lo intenta mostrar.
        //System.out.println("\nArbolFinal Hijo Izquierdo del hijo derecho del hijo derecho (nivel4): "+arbol.getRight().getRight().getLeft().getRootContent().toString());
        System.out.println("ArbolFinal Hijo Derecho del hijo derecho del hijo derecho (nivel4): "+arbol.getRight().getRight().getRight().getRootContent().toString());
 
    }
    
}
