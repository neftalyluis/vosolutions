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
        System.out.println(Main.primeraQueRepite("MEMES"));
        System.out.println(Main.primeraQueRepite("ABCDA"));
        Main.permutacionesParentesis(4);
        int M[][] = new int[][]{
            {1, 1, 0, 0, 0},
            {0, 1, 0, 0, 1},
            {1, 0, 0, 1, 1},
            {0, 0, 0, 0, 0}
        };
        Main.cantidadIslas(M);
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

    public static void cantidadIslas(int[][] mapa) {
        int columnas = mapa.length;
        int filas = mapa[0].length;
        boolean casillasVisitadas[][] = new boolean[columnas][filas];
        int total = 0;
        for (int i = 0; i < columnas; i++) {
            for (int j = 0; j < filas; j++) {
                if (mapa[i][j] == 1 && !casillasVisitadas[i][j]) {
                    dfs(mapa, i, j, casillasVisitadas, filas, columnas);
                }
            }
        }
        System.out.println(total);
    }

    private static void dfs(int[][] mapa, int columna, int fila, boolean[][] visitados, int totalFilas, int totalColumnas) {
        final int filaAdyacente[] = new int[]{-1, 1, 0, 0};
        final int columnaAdyacente[] = new int[]{0, 0, -1, 1};

        visitados[columna][fila] = true;

        for (int i = 0; i < 4; i++) {
            if (enRangoNoVisitado(columna, fila, mapa, visitados, totalFilas, totalColumnas)) {
                dfs(mapa, columna + columnaAdyacente[i], fila + filaAdyacente[i], visitados, totalFilas, totalColumnas);
            }

        }

    }

    private static boolean enRangoNoVisitado(int columna, int fila, int mapa[][], boolean visitado[][], int totalFila, int totalColumna) {
        return (fila >= 0) && (fila < totalFila)
                && (columna >= 0) && (columna < totalColumna)
                && (mapa[columna][fila] == 1 && !visitado[columna][fila]);
    }
}
