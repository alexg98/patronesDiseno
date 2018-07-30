package com.patrones.creacional.prototype;
/**
 * El patrón de diseño prototipo tiene como finalidad crear nuevos objetos clonando una instancia 
 * creada previamente. Este patrón especifica la clase de objetos a crear mediante la clonación de 
 * un prototipo que es una instancia ya creada. La clase de los objetos que servirán de prototipo 
 * deberá incluir en su interfaz la manera de solicitar una copia, que será desarrollada luego por 
 * las clases concretas de prototipos.
 * https://es.wikipedia.org/wiki/Prototipo_(patr%C3%B3n_de_dise%C3%B1o)
 */
import java.util.HashMap;

public class Prototype {
	static public void main(String[] args) {
		FactoriaPrototipo factoria = new FactoriaPrototipo();
		Producto producto = (Producto) factoria.create("producto 1");
		System.out.println ("Este es el objeto creado: " + producto);
	}
}
//Image
//Los productos deben implementar esta interface
interface Producto extends Cloneable {
	Object clone();
	// Aquí van todas las operaciones comunes a los productos que genera la factoría
}

//ImageOne
//Un ejemplo básico de producto
class UnProducto implements Producto {
	private int atributo;

	public UnProducto(int atributo) {
		this.atributo = atributo;
	}

	public Object clone() {
		return new UnProducto(this.atributo);
	}

	public String toString() {
		return ((Integer)atributo).toString();
	}
}

//ImageHander
//La clase encargada de generar objetos a partir de los prototipos
class FactoriaPrototipo {
	private HashMap mapaObjetos;
	private String nombrePorDefecto;

	public FactoriaPrototipo() {
		mapaObjetos = new HashMap();
		// Se incluyen en el mapa todos los productos prototipo
		mapaObjetos.put("producto 1", new UnProducto(1));
	}

	public Object create() {
		return create(nombrePorDefecto);
	}

	public Object create(String nombre) {
		nombrePorDefecto = nombre;
		Producto objeto = (Producto)mapaObjetos.get(nombre);
		return objeto != null ? objeto.clone() : null;
	}
}