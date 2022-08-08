package Main;

import model.Juego;

/**
 *
 * @author Grupo 8
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String dir = System.getProperty("user.dir")+"\\src\\main\\java\\demoArchivos\\";
        Juego juego = new Juego(dir+"preguntas.txt", dir+"respuestas.txt");
        juego.play();
    }
    
}
