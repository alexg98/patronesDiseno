package com.patrones.estructurales.bridge;

/**
 * El patrón Bridge, también conocido como Handle/Body, es una técnica usada en programación 
 * para desacoplar una abstracción de su implementación, de manera que ambas puedan ser modificadas 
 * independientemente sin necesidad de alterar por ello la otra.
 * Esto es, se desacopla una abstracción de su implementación para que puedan variar 
 * independientemente.
 * https://es.wikipedia.org/wiki/Bridge_(patr%C3%B3n_de_dise%C3%B1o)
 * @author alexg
 *
 */
interface Implementador {
    public abstract void operacion();
}
 
/** primera implementacion de Implementador **/
class ImplementacionA implements Implementador{
    public void operacion() {
        System.out.println("Esta es la implementacion A");
    }
}
/** segunda implementacion de Implementador **/
class ImplementacionB implements Implementador{
    public void operacion() {
        System.out.println("Esta es una implementacion de B");
    }
}
/** interfaz de abstracción **/
interface Abstraccion {
    public void operacion();
}
/** clase refinada que implementa la abstraccion **/
class AbstraccionRefinada implements Abstraccion{
    private Implementador implementador;
    public AbstraccionRefinada(Implementador implementador){
        this.implementador = implementador;
    }
    public void operacion(){
        implementador.operacion();
    }
}
/** aplicacion que usa el patrón Bridge **/
public class Bridge {
    public static void main(String[] args) {
        Abstraccion[] abstracciones = new Abstraccion[2];
        abstracciones[0] = new AbstraccionRefinada(new ImplementacionA());
        abstracciones[1] = new AbstraccionRefinada(new ImplementacionB());
        for(Abstraccion abstraccion:abstracciones)
            abstraccion.operacion();
    }
}
