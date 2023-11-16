package com.patrones.estructurales.composite;
/**
 * El patrón Composite sirve para construir objetos complejos a partir de otros más simples y 
 * similares entre sí, gracias a la composición recursiva y a una estructura en forma de árbol.
 * Esto simplifica el tratamiento de los objetos creados, ya que al poseer todos ellos una 
 * interfaz común, se tratan todos de la misma manera. Dependiendo de la implementación, 
 * pueden aplicarse procedimientos al total o una de las partes de la estructura compuesta como 
 * si de un nodo final se tratara, aunque dicha parte esté compuesta a su vez de muchas otras. 
 * Un claro ejemplo de uso extendido de este patrón se da en los entornos de programación 2D para 
 * aplicaciones gráficas. Un videojuego puede contener diferentes capas "layers" de sprites 
 * (como una capa de enemigos) pudiéndose invocar un método que actúe sobre toda esta capa de sprites a la vez (por ejemplo, para ocultarlos, darles un filtro de color etc.).
 * 
 * https://es.wikipedia.org/wiki/Composite_(patr%C3%B3n_de_dise%C3%B1o)
 */
import java.util.ArrayList;

//grafico
abstract class Componente{
	protected String nombre;
	public Componente (String nombre){
		this.nombre = nombre;
	}
	abstract public void agregar(Componente c);
	abstract public void eliminar(Componente c);
	abstract public void mostrar(int profundidad);
}
//circulo
class Compuesto extends Componente {
	private ArrayList<Componente> hijo = new ArrayList<Componente>();
	public Compuesto (String name){
		super(name);
	}
	@Override
	public void agregar(Componente componente){
		hijo.add(componente);
	}
	@Override
	public void eliminar(Componente componente){
		hijo.remove(componente);
	}
	@Override
	public void mostrar(int profundidad) {
		System.out.println(nombre + " nivel: " + profundidad);
		for (int i = 0; i < hijo.size(); i++) {
			hijo.get(i).mostrar(profundidad + 1);
		}
	}
}
//Cuadrado
class Hoja extends Componente
{
	public Hoja (String nombre){
		super(nombre);
	}
	public void agregar(Componente c){
		System.out.println("no se puede agregar la hoja");
	}
	public void eliminar(Componente c){
		System.out.println("no se puede quitar la hoja");
	}
	public void mostrar(int depth){
		System.out.println('-' + "" + nombre);
	}
}

public class Composite{
	public static void main(String[] args){
		Compuesto raiz = new Compuesto("root");
		raiz.agregar(new Hoja("hoja A"));
		raiz.agregar(new Hoja("hoja B"));
		Compuesto comp = new Compuesto("compuesto X");
		comp.agregar(new Hoja("hoja XA"));
		comp.agregar(new Hoja("hoja XB"));
		raiz.agregar(comp);
		raiz.agregar(new Hoja("hoja C"));
		Hoja l = new Hoja("hoja D");
		raiz.agregar(l);
		raiz.eliminar(l);
		raiz.mostrar(1);
	}
}