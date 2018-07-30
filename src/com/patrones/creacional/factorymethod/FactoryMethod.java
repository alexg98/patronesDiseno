package com.patrones.creacional.factorymethod;

/**
 * En diseño de software, el patrón de diseño Factory Method consiste en utilizar una clase 
 * constructora (al estilo del Abstract Factory) abstracta con unos cuantos métodos definidos 
 * y otro(s) abstracto(s): el dedicado a la construcción de objetos de un subtipo de un tipo 
 * determinado. Es una simplificación del Abstract Factory, en la que la clase abstracta tiene 
 * métodos concretos que usan algunos de los abstractos; según usemos una u otra hija de esta 
 * clase abstracta, tendremos uno u otro comportamiento.
 * https://es.wikipedia.org/wiki/Factory_Method_(patr%C3%B3n_de_dise%C3%B1o)
 * @author alexg
 *
 */
public class FactoryMethod {

	public static void main(String args[]){
	    Creator aCreator;
	    aCreator = new ConcreteCreator();
	    Product producto = aCreator.factoryMethod();
	    producto.operacion();	    
	}
}
//Abstract creator<utility>
abstract class Creator{
    // Definimos método abstracto
    public abstract Product factoryMethod();
}

//Credor producto Tipo
class ConcreteCreator extends Creator{
    public Product factoryMethod() {
        return new ConcreteProduct();
    }
}
//Abstract Producto <utility>
interface Product{
    public void operacion();
}
//Producto Tipo
class ConcreteProduct implements Product{
    public void operacion(){
        System.out.println("Una operación de este producto");
    }
}
