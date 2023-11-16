package com.patrones.comportamiento.TemplateMethod;
/**
 * En ingeniería de software, el patrón de método de la plantilla es un patrón de diseño de 
 * comportamiento que define el esqueleto de programa de un algoritmo en un método, llamado 
 * método de plantilla, el cual difiere algunos pasos a las subclases.1​ Permite redefinir ciertos 
 * pasos seguros de un algoritmo sin cambiar la estructura del algoritmo.2​ Este uso de "plantilla" 
 * no está relacionado a plantillas de C++.
 * @author alexg
 * https://es.wikipedia.org/wiki/Template_Method_(patr%C3%B3n_de_dise%C3%B1o)
 */
public class TemplateMethod {

}

/**
 * An abstract class that is common to several games in
 * which players play against the others, but only one is
 * playing at a given time.
 */

abstract class Game {
 /* Hook methods. Concrete implementation may differ in each subclass*/
    protected int playersCount;
    abstract void initializeGame();
    abstract void makePlay(int player);
    abstract boolean endOfGame();
    abstract void printWinner();

    /* A template method : */
    public final void playOneGame(int playersCount) {
        this.playersCount = playersCount;
        initializeGame();
        int j = 0;
        while (!endOfGame()) {
            makePlay(j);
            j = (j + 1) % playersCount;
        }
        printWinner();
    }
}

//Now we can extend this class in order 
//to implement actual games:

class Monopoly extends Game {

    /* Implementation of necessary concrete methods */
    void initializeGame() {
        // Initialize players
        // Initialize money
    }
    void makePlay(int player) {
        // Process one turn of player
    }
    boolean endOfGame() {
    	return false;
        // Return true if game is over 
        // according to Monopoly rules
    }
    void printWinner() {
        // Display who won
    }
    /* Specific declarations for the Monopoly game. */

    // ...
}

class Chess extends Game {

    /* Implementation of necessary concrete methods */
    void initializeGame() {
        // Initialize players
        // Put the pieces on the board
    }
    void makePlay(int player) {
        // Process a turn for the player
    }
    boolean endOfGame() {
    	return false;
        // Return true if in Checkmate or 
        // Stalemate has been reached
    }
    void printWinner() {
        // Display the winning player
    }
    /* Specific declarations for the chess game. */

    // ...
}