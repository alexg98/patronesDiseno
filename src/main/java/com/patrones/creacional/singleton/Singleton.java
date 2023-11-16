package com.patrones.creacional.singleton;
/**
 * En ingeniería de software, singleton o instancia única es un patrón de diseño que permite 
 * restringir la creación de objetos pertenecientes a una clase o el valor de un tipo a un único 
 * objeto.
 * Su intención consiste en garantizar que una clase sólo tenga una instancia y proporcionar 
 * un punto de acceso global a ella.
 * El patrón singleton se implementa creando en nuestra clase un método que crea una instancia 
 * del objeto sólo si todavía no existe alguna. Para asegurar que la clase no puede ser 
 * instanciada nuevamente se regula el alcance del constructor (con modificadores de acceso 
 * como protegido o privado).
 * @author alexg
 * https://es.wikipedia.org/wiki/Singleton
 */
public class Singleton {
    private static final Singleton INSTANCE = new Singleton();

    // El constructor privado no permite que se genere un constructor por defecto.
    // (con mismo modificador de acceso que la definición de la clase) 
    private Singleton() {}

    public static Singleton getInstance() {
        return INSTANCE;
    }
}
