package com.patrones.comportamiento.Iterador;

/**
 * En diseño de software, el patrón de diseño Iterador, define una interfaz que declara los 
 * métodos necesarios para acceder secuencialmente a un grupo de objetos de una colección. 
 * Algunos de los métodos que podemos definir en la interfaz Iterador son:
 * Primero(), Siguiente(), HayMas() y ElementoActual().
 * Este patrón de diseño permite recorrer una estructura de datos sin que sea necesario 
 * conocer la estructura interna de la misma.
 * https://es.wikipedia.org/wiki/Iterador_(patr%C3%B3n_de_dise%C3%B1o)
 * @author alexg
 *
 */
public class Iterador {
	public static void main(String argv[]) {
		Vector2 vector = new Vector2(5);

		//Creación del iterador
		IteradorVector iterador = vector.iterador();

		//Recorrido con el iterador
		while (iterador.hasNext())
			System.out.println(iterador.next());    	    	
	}
}

//Iterador
class Vector2 {
	public int[] _datos;

	public Vector2(int valores){ 
		_datos = new int[valores];
		for (int i = 0; i < _datos.length; i++){
			_datos[i] = 0; 
		}
	}    

	public int getValor(int pos){ 
		return _datos[pos]; 
	}

	public void setValor(int pos, int valor){ 
		_datos[pos] = valor; 
	}

	public int dimension(){ 
		return _datos.length; 
	}

	public IteradorVector iterador(){
		return new IteradorVector(this); 
	}
}
//Lista abstracta
class IteradorVector{
	private int[] _vector;
	private int _posicion;

	public IteradorVector(Vector2 vector) {
		_vector = vector._datos;
		_posicion = 0;
	}

	public boolean hasNext(){
		if (_posicion < _vector.length) 
			return true;
		else
			return false;
	}

	public Object next(){
		int valor = _vector[_posicion];
		_posicion++;
		return valor;
	}
}