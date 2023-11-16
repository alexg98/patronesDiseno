package com.patrones.comportamiento.Observer;
import static java.lang.System.out;

import java.util.Observable;
import java.util.Scanner;

/**
 * Observador (en inglés: Observer) es un patrón de diseño de software que define una dependencia 
 * del tipo uno a muchos entre objetos, de manera que cuando uno de los objetos cambia su estado, 
 * notifica este cambio a todos los dependientes. Se trata de un patrón de comportamiento 
 * (existen de tres tipos: creación, estructurales y de comportamiento), por lo que está 
 * relacionado con algoritmos de funcionamiento y asignación de responsabilidades a clases y 
 * objetos.
 * @author alexg
 * https://es.wikipedia.org/wiki/Observer_(patr%C3%B3n_de_dise%C3%B1o)
 */
public class Observer {
	public static void main(String[] args) {
        out.println("Introducir Texto >");
        FuenteEvento fuenteEvento = new FuenteEvento();

        fuenteEvento.addObserver( (Observable obj, Object arg) -> {
            out.println("\nRespuesta recibida: " + arg);
        });

        new Thread(fuenteEvento).start();
    }
}


class FuenteEvento extends Observable implements Runnable {
    public void run() {
        while (true) {
            String respuesta = new Scanner(System.in).next();
            setChanged();
            notifyObservers(respuesta);
        }
    }
}