package mx.uam.azc.modelo;

import java.util.Random;

/**
 * Clase que genera una cadena de caracteres aleatoria
 * 
 * @author Zelzin Marcela Márquez Navarrete
 * @author Ernesto García Maldonado
 * @version 1.0
 */
public class Sal {
    
    //Total de letras que se van a generar aleatoriamente
    private final int TOTAL_NUMEROS = 32;
    
    /**
     * Método para generar un cadena de caracteres aleatoria
     * @return cadena aleatoria
     */
    public String generarSal() {
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < TOTAL_NUMEROS; i++) {
            char letra = (char) generarNumeroAleatorio();
            sb.append(letra);
        }
        
        String str = sb.toString();
        
        return str;
    }
    
    /**
     * Método que genera un número aleatorio entre el 48 y el 126 del código ASCII
     * @return número aleatorio
     */
    public int generarNumeroAleatorio() {
        Random rnd = new Random();
        int numAleatorio = (int) (rnd.nextDouble() * 79 + 48);

        return numAleatorio;
    }
}
