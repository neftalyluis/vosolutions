/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.neftaly.vosolutions;

import java.util.HashSet;

/**
 *
 * @author samas
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(Main.primeraQueRepite("MEMES"));
        System.out.println(Main.primeraQueRepite("ABCDA"));

    }

    public static Character primeraQueRepite(String palabra) {
        HashSet<Character> repite = new HashSet<>();
        char c = '\0';
        for (Character letra : palabra.toCharArray()) {
            if (repite.contains(letra)) {
                c = letra;
                break;
            } else {
                repite.add(letra);
            }
        }
        return c;
    }

    
    public static void cantidadIslas(int[][] mapa){
        
    }
    
    public static void permutacionesParentesis(int numero){
        
    }
}
