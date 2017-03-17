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
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(Main.primeraQueRepite("MEMES"));
        System.out.println(Main.primeraQueRepite("ABCDA"));
        Main.permutacionesParentesis(4);
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

    public static void permutacionesParentesis(int numero) {
        permutacion("", numero, numero);
    }

    private static void permutacion(String cadena, int izquierda, int derecha) {
        if (izquierda > derecha) {
            return;
        }

        if (izquierda == 0 && derecha == 0) {
            System.out.println(cadena);
            return;
        }

        if (izquierda > 0) {
            permutacion(cadena + "(", izquierda - 1, derecha);
        }

        if (derecha > 0) {
            permutacion(cadena + ")", izquierda, derecha - 1);
        }
    }

}
