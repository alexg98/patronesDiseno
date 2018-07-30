package com.patrones.comportamiento.memento;
import java.util.ArrayList;
/**
 * Memento, es un patrón de diseño cuya finalidad es almacenar el estado de un objeto 
 * (o del sistema completo) en un momento dado de manera que se pueda restaurar en ese punto de 
 * manera sencilla. Para ello se mantiene almacenado el estado del objeto para un instante de 
 * tiempo en una clase independiente de aquella a la que pertenece el objeto 
 * (pero sin romper la encapsulación), de forma que ese recuerdo permita que el objeto 
 * sea modificado y pueda volver a su estado anterior.
 *
 */
public class Memento<T> {
	
	private T estado;

	public Memento(T estado) {
		this.estado = estado;
	}
	public T getSavedState(){
		return estado;
	}
	
	public static void main(String...s){
		
		Caretaker<Persona> caretaker = new Caretaker<Persona>();
		Persona p = new Persona();
		p.setNombre("Maxi");
		p.setNombre("Juan");
		
		caretaker.addMemento(p.saveToMemento());
		p.setNombre("Pedro");
		caretaker.addMemento(p.saveToMemento());
		
		Memento<Persona> m1 = caretaker.getMemento(0);
		Memento<Persona> m2 = caretaker.getMemento(1);
		
		System.out.println(m1.getSavedState().getNombre() );
		System.out.println(m2.getSavedState());
	}
	
}

interface RestoreMemento<T>{
	void restoreFromMemento(Memento<T> m);
	Memento<Persona> saveToMemento();
}

class Persona implements RestoreMemento<Persona>{
	private int id;
	private String nombre;
	
		
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void restoreFromMemento(Memento<Persona> m) {
		this.id = ((Persona)m.getSavedState()).id;
		this.nombre = ((Persona)m.getSavedState()).nombre;
	}
	
	public Memento<Persona> saveToMemento(){	
		return new Memento<Persona>(this);
	}
}

class Caretaker <T> {
	
	private ArrayList<Memento<T>> estado = new ArrayList<Memento<T>>();
	
	public void addMemento(Memento<T> m){
		estado.add(m);
	}
	public Memento<T> getMemento(int index){
		return estado.get(index);
	}
}
