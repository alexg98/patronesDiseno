package com.patrones.estructurales.decorator;
/**
 * El patrón Decorator responde a la necesidad de añadir dinámicamente funcionalidad a un Objeto. 
 * Esto nos permite no tener que crear sucesivas clases que hereden de la primera incorporando 
 * la nueva funcionalidad, sino otras que la implementan y se asocian a la primera.
 * https://es.wikipedia.org/wiki/Decorator_(patr%C3%B3n_de_dise%C3%B1o)
 * @author alexg
 *
 */
//Componente visual
abstract class Componente{
	abstract public void operacion();
}
//Vista de texto
class ComponenteConcreto extends Componente{
	public void operacion(){
		System.out.println("ComponenteConcreto.operacion()");
	}
}
//Decorador
abstract class Decorador extends Componente{
	private Componente componente;

	public Decorador(Componente componente){
		this.componente = componente;
	}

	public void operacion(){
		componente.operacion();
	}
}
//Decorador desplazamiento
class DecoradorConcretoA extends Decorador{
	private String propiedadAnadida;

	public DecoradorConcretoA(Componente componente){
		super(componente);
	}

	public void operacion(){
		super.operacion();
		this.propiedadAnadida = "Nueva propiedad";
		System.out.println("DecoradorConcretoA.operacion()");
	}
}
//Decorador borde
class DecoradorConcretoB extends Decorador{
	public DecoradorConcretoB(Componente componente){
		super(componente);
	}

	public void operacion(){
		super.operacion();
		comportamientoAnadido();
		System.out.println("DecoradorConcretoB.operacion()");
	}

	public void comportamientoAnadido(){
		System.out.println("Comportamiento B añadido");
	}
}

public class Decorator{
	public static void main(String[] args){
		ComponenteConcreto c = new ComponenteConcreto();
		DecoradorConcretoA d1 = new DecoradorConcretoA(c);
		DecoradorConcretoB d2 = new DecoradorConcretoB(d1);
		d2.operacion();//output: "DecoradorConcretoB.operacion() "
	}
}
